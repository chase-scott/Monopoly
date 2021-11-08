package Monopoly;

import java.awt.*;

/**
 * A Go square
 *
 * @author Chase Scott 101092194
 */
public class Go extends Square {

    public Go(String name) {
        super(name);
    }

    @Override
    public Color getColour() {
        return Color.WHITE;
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