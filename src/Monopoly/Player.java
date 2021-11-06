package Monopoly;

import GUI.MonopolyView;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Monopoly.Player class
 * @author Chase Scott 101092194
 * @author Amith Kumar Das Orko 101126245
 */
public class Player {

    private final String name;              //the name of the players
    private double money;                   //the player's money
    private int position;                   //the player's current position
    private List<Property> propertyList;    //the list of properties owned by the player
    private boolean isBankrupt;             //the bankruptcy status of the player
    private List<MonopolyView> views;

    /**
     * Constructor for a player
     *
     * @param name  String, the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.money = 1500;
        this.position = 0;
        this.isBankrupt = false;
        this.propertyList = new ArrayList<>();
        this.views = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public int getPosition() { return position; }

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
    
    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    /**
     * Moves the player by the given roll result
     *
     * @param rollResult    int, the result of the roll
     */
    public void playerMove(int rollResult){
        int BOARD_SIZE = 23;
        position += rollResult;
        if(position >= BOARD_SIZE) {
            position -= BOARD_SIZE;
            money += 200;
            System.out.println("+$200 for passing GO");
        }
    }

    /**
     * Buys a property
     *
     * @param property  Monopoly.Property, the property to buy
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
            return "Monopoly.Player owns nothing";
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
    }

    /**
     * Updates each view.
     */
    private void updateViews() {
        for(MonopolyView v : views) {
            v.updateView();
        }
    }



    @Override
    public String toString() {
        return "Name: " + name + "\nMoney: $" + money + "\nProperties owned: " + propertiesOwned();
    }

}
