package Monopoly;

import java.awt.*;

/**
 * GoToJail Class.
 * Sends the player to jail when they land on it
 *
 * @author Chase Scott 101092194
 */
public class GoToJail extends Square {
    /**
     * Constructor for a GoToJail square
     */
    public GoToJail() {
        super("Go to Jail");
    }

    @Override
    public void squareAction(Player player) {
        player.goToJail();
    }

    @Override
    public Color getColour() {
        return Color.WHITE;
    }

    @Override
    public void clear() {
        //do nothing
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public void setOwner(Player player) {
        //do nothing
    }

    @Override
    public String toString() {
        return "\n\n" + super.getName();
    }
}
