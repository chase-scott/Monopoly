package Monopoly;

import java.awt.*;
import java.io.Serializable;

/**
 * HumanPlayer class.
 * Used to distinguish from AI player
 *
 * @author Chase Scott 101092194
 */
public class HumanPlayer extends Player implements Serializable {

    /**
     * Constructor for a human player
     *
     * @param name      String, the name of the player
     * @param colour    Color, the colour of the player
     */
    public HumanPlayer(String name, Color colour) {
        super(name, colour);
    }


}
