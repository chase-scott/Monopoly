package Monopoly;

import GUI.PlayerView;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Monopoly.Player class
 * @author Chase Scott 101092194
 * @author Amith Kumar Das Orko 101126245
 */
public class Player {

    private final String name;              //the name of the players
    private double money;                   //the player's money
    private List<Property> propertyList;    //the list of properties owned by the player
    private boolean takingTurn;             //indicates if this player is taking their turn
    private List<PlayerView> views;       //the views associated with this player
    private final Color tokenColour;        //this players token Colour
    private int position = 0;               //this players position
    private static Dice dice = new Dice();  //this players dice
    private boolean isBankrupt = false;     //whether this player is bankrupt or not

    /**
     * Constructor for a player
     *
     * @param name  String, the name of the player
     */
    public Player(String name, Color colour) {
        this.name = name;
        this.tokenColour = colour;
        this.money = 1500;
        this.takingTurn = false;
        this.propertyList = new ArrayList<>();
        this.views = new ArrayList<>();
        Game.getSquare(0).addPlayer(this);

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

    public boolean getDiceRolledStatus() {
        return dice.isRolled();
    }

    public boolean isTakingTurn() {
        return takingTurn;
    }

    public boolean getBankruptcyStatus() {return isBankrupt;}

    /**
     * Set's this player to bankrupt and relinquishes control of all their properties.
     */
    public void becomeBankrupt() {
        for (Property p : propertyList) {
            p.clear();
        }
        JOptionPane.showMessageDialog(null, name + " has gone bankrupt! :(", "Bankrupt", JOptionPane.INFORMATION_MESSAGE);
        this.isBankrupt = true;
        propertyList.clear();
        passTurn();
    }

    /**
     * Creates a vector of the names of each property in the property list
     * @return  Vector<String>, vector of the names of properties
     */
    public Vector<String> getPropertyList() {
        return propertyList.stream().map(Square::getName).collect(Collectors.toCollection(Vector::new));
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
        position = position + dice.roll();
        if(position >= GameBoard.BOARD_SIZE) money+=200;
        position = position % GameBoard.BOARD_SIZE;

        Game.getSquare(position).squareAction(this);
        Game.getSquare(position).addPlayer(this);
        updateViews();
        Game.getSquare(position).updateViews();
    }

    /**
     * Buys the square that the player is on if it is a property square.
     */
    public void buySquare() {

        Property propertyToBuy = (Property) Game.getSquare(position);

        if(money < propertyToBuy.getPrice()) {
            JOptionPane.showMessageDialog(null, "You can not afford this property!", "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        money -= propertyToBuy.getPrice();
        propertyList.add(propertyToBuy);
        propertyToBuy.setOwner(this);

        updateViews();
        Game.getSquare(position).updateViews();
    }

    /**
     * Builds a house on the currently selected square
     * @param selectedIndex int, the index of the property selected
     */
    public void buildHouse(int selectedIndex) {
        if(selectedIndex > -1) {


            //make sure player is building houses symmetrically
            for(Property p : propertyList) {
                if(propertyList.get(selectedIndex).getBuiltHouses() > p.getBuiltHouses()) {
                    JOptionPane.showMessageDialog(null, "You must build houses symmetrically!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            propertyList.get(selectedIndex).addHouse(this);
        }
    }

    /**
     * Informs the game class that this player is taking their turn, resumes when player clicks pass turn.
     */
    public synchronized void makeMove() {
        this.takingTurn = true;
        updateViews();

        try {
            this.wait();
        } catch (InterruptedException ignored) {}

        this.takingTurn = false;
        dice.setRolled(false);
        updateViews();
    }

    /**
     * Passes the turn
     */
    public synchronized void passTurn() {
        this.notify();
    }

}