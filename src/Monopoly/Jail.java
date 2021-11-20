package Monopoly;

import java.awt.*;

public class Jail extends Square {
    /**
     * Super constructor for a square
     *
     * if player lands here they are just "visiting"
     * players are sent here if they land on "go to jail"
     * @param name String, the name of the square
     */
    boolean inJail;
    public Jail(String name) {
        super(name);
    }
    public Player getOwner() {
        return null;
    }

    @Override
    public void squareAction(Player player) {
        if (player.isInJail()) {
            //return new GetOutOfJailOption(player);
        }
    }

    @Override
    public Color getColour() {
        return null;
    }
}
