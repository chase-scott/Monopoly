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
    private void updateViews() {
        views.forEach(MonopolyView::updateView);
    }


    private void rollDice() {
        System.out.println(name + " is taking their turn");
        do {
            position = (position + dice.roll()) % GameBoard.BOARD_SIZE;
            System.out.println(name + " is on tile " + position + "\n");
        } while(!dice.isRolled());
        dice.setRolled(false);

    }

    //TODO make this buy the property this player is on
    public void buySquare() {
        System.out.println("Player buys + " + Game.getSquare(position).getName());

    }

    public synchronized void makeMove() {
        this.takingTurn = true;
        updateViews();
        this.rollDice();

        try {
            this.wait();
        } catch (InterruptedException ignored) {}

        this.takingTurn = false;
        updateViews();
    }

    public synchronized void passTurn() {
        this.notify();
    }
    public boolean isTakingTurn() {
        return takingTurn;
    }




}