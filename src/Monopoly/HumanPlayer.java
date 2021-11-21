package Monopoly;

import javax.swing.*;
import java.awt.*;

public class HumanPlayer extends Player {

    /**
     * Constructor for a human player
     *
     * @param name      String, the name of the player
     * @param colour    Color, the colour of the player
     */
    public HumanPlayer(String name, Color colour) {
        super(name, colour);
    }

    /**
     * Buys the square that the player is on if it is a property square.
     */
    public void buySquare() {
        if(Game.getSquare(getPosition()) instanceof Property) {
            Property propertyToBuy = (Property) Game.getSquare(getPosition());

            if (getMoney() < propertyToBuy.getPrice()) {
                JOptionPane.showMessageDialog(null, "You can not afford this property!", "Warning",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            setMoney(getMoney() - propertyToBuy.getPrice());
            addProperty(propertyToBuy);
            propertyToBuy.setOwner(this);

            updateViews();
            Game.getSquare(getPosition()).updateViews();
        }
    }





}
