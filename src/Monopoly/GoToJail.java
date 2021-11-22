package Monopoly;

import java.awt.*;

public class GoToJail extends Square {
    /**
     * Super constructor for a square
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

    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public void setOwner(Player player) {

    }

    @Override
    public String toString() {
        return "\n\n" + super.getName();
    }
}
