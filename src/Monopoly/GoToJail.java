package Monopoly;

import java.awt.*;

public class GoToJail extends Square{
    /**
     * Super constructor for a square
     *
     * @param name String, the name of the square
     */
    public GoToJail(String name) {
        super(name);
    }

    @Override
    public void squareAction(Player player) {
        player.goToJail();
    }

    @Override
    public Color getColour() {
        return null;
    }
}
