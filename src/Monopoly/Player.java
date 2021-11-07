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
    private Color tokenColour;


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
     * Buys a property
     *
     * @param property  Property, the property to buy
     */
    public void buy(Property property) {
        if(property.checkIfAvailable()) {
            if(money < property.getPrice()) {
                System.out.println("You can not afford this property!");
                return;
            }
            System.out.println(name + " has just bought " + property.getName());
            money -= property.getPrice();
            propertyList.add(property);
            property.setOwner(this);
            return;
        }
        System.out.println("This property is already owned by " + property.getOwner().getName());
    }

    /**
     * Creates a string containing the properties owned by the player
     *
     * @return  String, the string of properties
     */
    private String propertiesOwned(){
        if(propertyList.isEmpty()){
            return "Player owns nothing";
        }
        StringBuilder info = new StringBuilder();
        for (Property p : propertyList) {info.append(p.getName()).append(", ");}
        return info.toString();
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



    @Override
    public String toString() {
        return "Name: " + name + "\nMoney: $" + money + "\nProperties owned: " + propertiesOwned();
    }





    public Color getTokenColour() {
        return tokenColour;
    }


    private void takeTurn() {
        System.out.println(name + " is taking turn");
    }



    public synchronized void makeMove() {
        this.takingTurn = true;
        updateViews();
        this.takeTurn();

        try {
            this.wait();
        } catch (InterruptedException ignored) {}

        this.takingTurn = false;
        updateViews();
    }

    public synchronized void finishMove() {
        this.notify();
    }
    public boolean isTakingTurn() {
        return takingTurn;
    }




}
