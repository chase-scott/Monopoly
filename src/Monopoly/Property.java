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

    private final double housePrice;
    private int builtHouses;

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

        this.housePrice = colour.getHousePrice();
        this.builtHouses = 0;
    }

    public double getPrice(){
        return price;
    }

    public double getHousePrice() {return housePrice;}

    public int getNumHouses() {
        return builtHouses;
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

            double amountOwed = rentRate * price * (builtHouses/2.0 + 1);

            JOptionPane.showMessageDialog(null, player.getName() + " pays $" + amountOwed + " to " + ownedBy.getName(), "Paid Rent!", JOptionPane.INFORMATION_MESSAGE);

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
     */
    public void addHouse(Player player) {
        //check that player owns colour set
        for(int i = 0; i < GameBoard.BOARD_SIZE; i++) {
            if(!(Game.getSquare(i) instanceof Property)) continue;
                if(((Property) Game.getSquare(i)).getOwner() != player && Game.getSquare(i).getColour() == this.colour) {
                       //System.out.println("MISSING A PROPERTY IN THIS SET");
                       return;
                }
        }
        if (builtHouses < 5) {
            int result;
            if(player instanceof HumanPlayer) {
                result = JOptionPane.showConfirmDialog(null, "Place a house on " + getName() +
                        " for $" + housePrice + "?", "Buy House", JOptionPane.YES_NO_OPTION);
            } else {
                result = JOptionPane.YES_OPTION;
            }
            if(result == JOptionPane.YES_OPTION) {
                player.setMoney(player.getMoney() - housePrice);
                player.updateViews();
                this.builtHouses += 1;
                updateViews();
            }
        }
    }

    /**
     * clears this property of the player who owns it
     */
    public void clear() {
        ownedBy = null;
        builtHouses = 0;
        updateViews();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nName: ").append(super.getName()).append("\nCost: $").append(price).append("\nRent: $").append(rentRate * price * (builtHouses/2.0 + 1)).append("\nOwned by: ");
        if(ownedBy == null) {
            sb.append("Nobody");
        } else{
            sb.append(ownedBy.getName());
        }
        return sb.toString();
    }
}
