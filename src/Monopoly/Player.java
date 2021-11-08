package Monopoly;

import GUI.MonopolyView;

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
    private boolean takingTurn;
    private List<MonopolyView> views;
    private final Color tokenColour;
    private int position = 0;
    private static Dice dice = new Dice();
    private boolean isBankrupt = false;


    /**
     * Constructor for a player
     *
     * @param name  String, the name of the player
     */
    public Player(String name, Color color) {
        this.name = name;
        this.tokenColour = color;
        this.money = 1500;
        this.takingTurn = false;
        this.propertyList = new ArrayList<>();
        this.views = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
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

    public void becomeBankrupt() {
        for (Property p : propertyList) {
            p.setOwner(null);
        }
        this.isBankrupt = true;
        propertyList.clear();
    }

    public boolean getBankruptcyStatus() {return isBankrupt;}

    /**
     * Creates a vector of the names of each property in the property list
     * @return  Vector<String>, vector of the names of properties
     */
    public Vector<String> getPropertyList() {
        return propertyList.stream().map(Square::getName).collect(Collectors.toCollection(Vector::new));
    }

    public void setMoney(double money) {
        this.money = money;
    }


    /**
     * Adds a monopoly view
     * @param view  MonopolyView, the view
     */
    public void addMonopolyView(MonopolyView view) {
        views.add(view);
        this.updateViews();
    }

    /**
     * Updates each view.
     */
    public void updateViews() {
        views.forEach(MonopolyView::updateView);
    }


    public void rollDice() {
        position = (position + dice.roll()) % GameBoard.BOARD_SIZE;
        System.out.println(name + " is on tile " + Game.getSquare(position).getName() + "\n");
        Game.getSquare(position).squareAction(this);
        updateViews();

    }

    //TODO make this buy the property this player is on
    public void buySquare() {

        Property propertyToBuy = (Property) Game.getSquare(position);

        if(money < propertyToBuy.getPrice()) {
            System.out.println("You can not afford this property!");
            return;
        }
        System.out.println(name + " has just bought " + propertyToBuy.getName());
        money -= propertyToBuy.getPrice();


        propertyList.add(propertyToBuy);
        propertyToBuy.setOwner(this);

        updateViews();
    }

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

    public synchronized void passTurn() {
        this.notify();
    }
    public boolean isTakingTurn() {
        return takingTurn;
    }




}