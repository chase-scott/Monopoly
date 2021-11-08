package Monopoly;

import javax.swing.*;

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
    private final String colour;

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
        this.colour = colour.name();
    }

    public int getPrice(){
        return (int)price;
    }

    public String getColour(){
        return colour;
    }

    public int getRent(){
        return (int)(rentRate * price);
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
            //System.out.println(player.getName() + " pays $" + rentRate * price + " to " + ownedBy.getName());
            JOptionPane.showMessageDialog(null, player.getName() + " pays $" + rentRate * price + " to " + ownedBy.getName(), "Paid Rent!", JOptionPane.INFORMATION_MESSAGE);

            double amountOwed = rentRate * price;

            //If player can't afford rent, give all of their money to player and make them bankrupt.
            if (player.getMoney() - amountOwed < 0) {
                ownedBy.setMoney(ownedBy.getMoney() + player.getMoney());
                player.setMoney(0);
                System.out.println(player.getName() + " is bankrupt!");
                player.becomeBankrupt();
            } else {
                player.setMoney(player.getMoney() - amountOwed);
                ownedBy.setMoney(ownedBy.getMoney() + amountOwed);
            }
            ownedBy.updateViews();
        }
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
