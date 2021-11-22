package Monopoly;

import GUI.PlayerView;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Player class
 * @author Chase Scott 101092194
 * @author Amith Kumar Das Orko 101126245
 */
public abstract class Player {

    private final String name;              //the name of the players
    private double money;                   //the player's money
    private List<Square> propertyList;    //the list of properties owned by the player
    private List<PlayerView> views;       //the views associated with this player
    private final Color tokenColour;        //this players token Colour
    private int position = 0;               //this players position
    private boolean isBankrupt = false;     //whether this player is bankrupt or not
    private boolean takingTurn;             //indicates if this player is taking their turn
    private Dice dice = new Dice();  //this players dice

    //TEST
    private int doubles;
    private boolean inJail;

    /**
     * Constructor for a player
     *
     * @param name      String, the name of the player
     * @param colour    Color, the colour of the player
     */
    public Player(String name, Color colour) {
        this.name = name;
        this.tokenColour = colour;
        this.money = 1500;
        this.takingTurn = false;
        this.propertyList = new ArrayList<>();
        this.views = new ArrayList<>();
        Game.getSquare(0).addPlayer(this);

        ///TEST
        this.doubles = 0;
        this.inJail = false;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Color getTokenColour() {
        return tokenColour;
    }

    public int getPosition() {
        return position;
    }

    public boolean getDiceRolledStatus() {return dice.isRolled();}

    public boolean isTakingTurn() {
        return takingTurn;
    }

    public boolean getBankruptcyStatus() {return isBankrupt;}

    public void addProperty(Square square) {
        propertyList.add(square);
    }

    /**
     * Creates a vector of the names of each property in the property list
     * @return  Vector<String>, vector of the names of properties
     */
    public Vector<String> getPropertyList() {
        return propertyList.stream().map(Square::getName).collect(Collectors.toCollection(Vector::new));
    }

    /**
     * Set's this player to bankrupt and relinquishes control of all their properties.
     */
    public void becomeBankrupt() {
        for (Square p : propertyList) {
            p.clear();
        }
        JOptionPane.showMessageDialog(null, name + " has gone bankrupt! :(", "Bankrupt", JOptionPane.INFORMATION_MESSAGE);
        this.isBankrupt = true;
        propertyList.clear();
        passTurn();
    }

    /**
     * Adds a monopoly view
     * @param view  MonopolyView, the view
     */
    public void addMonopolyView(PlayerView view) {
        views.add(view);
        this.updateViews();
    }

    /**
     * Updates each view.
     */
    public void updateViews() {
        views.forEach(PlayerView::updateView);
    }


    /**
     * rolls the dice and moves the player by the result
     */
    public void rollDice() {
        Game.getSquare(position).removePlayer(this);
        Game.getSquare(position).updateViews();

        int[] roll = dice.roll();

        if(roll[0] == roll[1]) doubles++;
        if(doubles == 1) {
            goToJail();
            return;
        }
        position = position + roll[0] + roll[1];
        if(position >= GameBoard.BOARD_SIZE) money+=200;
        position = position % GameBoard.BOARD_SIZE;

        Game.getSquare(position).addPlayer(this);
        Game.getSquare(position).updateViews();
        JOptionPane.showMessageDialog(null, "Rolled a " + roll[0] + " and " + roll[1],
                "Dice Roll Result", JOptionPane.INFORMATION_MESSAGE);
        Game.getSquare(position).squareAction(this);
        updateViews();
    }

    /**
     * Buys the square that the player is on square.
     * The button is only on when square is a buy-able square, so no need to check.
     */
    public void buySquare() {

        Square squareToBuy = Game.getSquare(getPosition());

        if (money < squareToBuy.getPrice()) {
            if(this instanceof HumanPlayer)
            JOptionPane.showMessageDialog(null, "You can not afford this property!", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        money -= squareToBuy.getPrice();
        addProperty(Game.getSquare(getPosition()));
        squareToBuy.setOwner(this);

        updateViews();
        Game.getSquare(getPosition()).updateViews();
    }

    /**
     * Builds a house on the currently selected square
     * @param selectedIndex int, the index of the property selected
     */
    public void buildHouse(int selectedIndex) {

        if(selectedIndex > -1) {
            if(propertyList.get(selectedIndex) instanceof Property) {
                Property propertyToBuildOn = ((Property) propertyList.get(selectedIndex));

                //check if player has enough money
                if (money < propertyToBuildOn.getHousePrice()) {
                    if (this instanceof HumanPlayer)
                        JOptionPane.showMessageDialog(null, "You can not afford to build here!", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    return;
                }
                //make sure player is building houses symmetrically
                for (Square p : propertyList) {
                    if(p instanceof Property) {
                        if (propertyToBuildOn.getNumHouses() > ((Property)p).getNumHouses() && propertyToBuildOn.getColour() == p.getColour()) {
                            if (this instanceof HumanPlayer)
                                JOptionPane.showMessageDialog(null, "You must build houses symmetrically!", "Warning",
                                        JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }
                }
                propertyToBuildOn.addHouse(this);
            }
        }
    }

    /**
     * Informs the game class that this player is taking their turn, resumes when player clicks pass turn.
     */
    public synchronized void makeMove() {
        this.takingTurn = true;
        updateViews();

        if(inJail) {
            int answer = JOptionPane.showOptionDialog(null, "Pay $50 or roll?", "Jail", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"PAY", "ROLL"}, 0);
            if(answer == 0) {
                money -= 50;
                inJail = false;
                updateViews();
            } else {
                if((int)(Math.random() * 6 + 1) == (int)(Math.random() * 6 + 1)) {
                    JOptionPane.showMessageDialog(null, "You rolled double! OUT OF JAIL!!!");
                    inJail = false;
                } else {
                    JOptionPane.showMessageDialog(null, "You did NOT roll double...");
                }
            }
        }

        try {
            if(!inJail) this.wait();
        } catch (InterruptedException ignored) {}

        this.takingTurn = false;
        dice.setRolled(false);
        updateViews();
    }

    /**
     * Passes the turn
     */
    public synchronized void passTurn() {
        doubles = 0;
        this.notify();
    }

    private void goToJail() {
        Game.getSquare(position).removePlayer(this);
        Game.getSquare(position).updateViews();
        position = 7;
        Game.getSquare(position).addPlayer(this);
        Game.getSquare(position).updateViews();
        this.inJail = true;
        JOptionPane.showMessageDialog(null, name + " rolled too many doubles... off to jail!");
        passTurn();
    }







}