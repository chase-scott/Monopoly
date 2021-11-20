package Monopoly;

import javax.swing.*;
import java.awt.*;

/**
 * A property square
 *
 * @author Chase Scott 101092194
 * @author Amith Kumar Das Orko 101126245
 */
public class Property extends Square {

    private final double price;
    private final double rentRate;
    private Player ownedBy = null;
    private final Color colour;

    private int builtHouses; //TEST

    /**
     * Constructor for initializing a property square
     *
     * @param name      String, the name of the property
     * @param price     double, the price of the property
     * @param colour    Colour, the colour of the property
     */
    public Property(String name, double price, Colours colour) {
        super(name);
        this.price = price;
        this.rentRate = colour.getRentRate();
        this.colour = colour.getColour();
        this.builtHouses = 0;
    }

    public int getPrice(){
        return (int)price;
    }

    @Override
    public Color getColour(){
        return colour;
    }

    public Player getOwner() {
        return ownedBy;
    }

    public void setOwner(Player currentPlayer){
        ownedBy = currentPlayer;
    }

    /**
     * Checks if the property is currently owned by a player
     *
     * @return  boolean, if the property is owned
     */
    public boolean checkIfAvailable(){
        return getOwner() == null;
    }

    /**
     * Implements the square action for a property
     *
     * @param player    Monopoly.Player, the player on this square
     */
    @Override
    public void squareAction(Player player) {
        if(ownedBy != null && ownedBy != player) {
            JOptionPane.showMessageDialog(null, player.getName() + " pays $" + rentRate * price + " to " + ownedBy.getName(), "Paid Rent!", JOptionPane.INFORMATION_MESSAGE);

            double amountOwed = rentRate * price;

            if (player.getMoney() - amountOwed < 0) {
                ownedBy.setMoney(ownedBy.getMoney() + player.getMoney());
                player.setMoney(0);
                player.becomeBankrupt();
            } else {
                player.setMoney(player.getMoney() - amountOwed);
                ownedBy.setMoney(ownedBy.getMoney() + amountOwed);
            }
            ownedBy.updateViews();
        }
    }

    /**
     * Add a house to this property
     * TODO add game logic to this, increase rent of property etc.
     */
    public void addHouse() {
        if (builtHouses < 4) {
            this.builtHouses += 1;
            updateViews();
            JOptionPane.showMessageDialog(null, "Built house on " + this.getName());
        }
    }

    /**
     * Get the number of built houses on this property
     *
     * @return
     */
    public int getNumHouses() {
        return builtHouses;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nName: ").append(super.getName()).append("\nCost: $").append(price).append("\nRent: $").append(rentRate * price).append("\nOwned by: ");
        if(ownedBy == null) {
            sb.append("Nobody");
        } else{
            sb.append(ownedBy.getName());
        }
        return sb.toString();
    }
}
