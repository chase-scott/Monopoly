package Monopoly;

import java.awt.*;

/**
 * An empty square
 * Used for squares that have no effect when the player lands on them
 *
 * @author Chase Scott 101092194
 */
public class Empty extends Square {

    public Empty(String name) {
        super(name);
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

    /**
     * The go square action, currently does nothing
     *
     * @param player    Monopoly.Player, the player on this square
     */
    @Override
    public void squareAction(Player player) {
        //do nothing
    }

    @Override
    public String toString() {
        return "\n\n" + super.getName();
    }
}