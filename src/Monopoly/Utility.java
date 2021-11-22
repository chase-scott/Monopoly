package Monopoly;

import javax.swing.*;
import java.awt.*;

public class Utility extends Square {

    private Player ownedBy = null;
    private final double price;
    private String type; //false for utility, true for railroad

    public static final String RAILROAD = "RAILROAD";
    public static final String UTILITY = "UTILITY";

    /**
     * Super constructor for a square
     *
     * @param name String, the name of the square
     */
    public Utility(String name, double price, String type) {
        super(name);
        this.price = price;
        this.type = type;
    }

    /**
     * Checks if the property is currently owned by a player
     *
     * @return  boolean, if the property is owned
     */
    public boolean checkIfAvailable(){
        return ownedBy == null;
    }

    public void setOwner(Player currentPlayer){
        ownedBy = currentPlayer;
    }

    @Override
    public void squareAction(Player player) {
        if(ownedBy != null && ownedBy != player) {

            //check utility owners
            double amountOwed;

            if (type.equals("RAILROAD")) {
                if (ownedBy.getPropertyList().contains("Reading Railroad") && ownedBy.getPropertyList().contains("B. & O. Railroad")) {
                    amountOwed = 0.8 * price;
                } else {
                    amountOwed = 0.6 * price;
                }
            } else if(type.equals("UTILITY")) {
                if (ownedBy.getPropertyList().contains("Electric Company") && ownedBy.getPropertyList().contains("Water Works")) {
                    amountOwed = 0.4 * price;
                } else {
                    amountOwed = 0.2 * price;
                }
            } else {return;}

            JOptionPane.showMessageDialog(null, player.getName() + " pays $" + amountOwed + " to " + ownedBy.getName(), "Paid Utility!", JOptionPane.INFORMATION_MESSAGE);

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

    @Override
    public Color getColour() { return Color.WHITE; }

    @Override
    public void clear() {
            ownedBy = null;
            updateViews();
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nName: ").append(super.getName()).append("\nCost: $").append(price).append("\nOwned by: ");
        if(ownedBy == null) {
            sb.append("Nobody");
        } else{
            sb.append(ownedBy.getName());
        }
        return sb.toString();
    }
}
