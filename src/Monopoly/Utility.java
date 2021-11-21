package Monopoly;

import java.awt.*;

public class Utility extends Square {

    private Player ownedBy = null;

    /**
     * Super constructor for a square
     *
     * @param name String, the name of the square
     */
    public Utility(String name) {
        super(name);
    }

    /**
     * Checks if the property is currently owned by a player
     *
     * @return  boolean, if the property is owned
     */
    public boolean checkIfAvailable(){
        return ownedBy == null;
    }

    @Override
    public void squareAction(Player player) {

    }

    @Override
    public Color getColour() { return Color.WHITE; }

    @Override
    public String toString() {
        return "\n\n" + super.getName();
    }
}
