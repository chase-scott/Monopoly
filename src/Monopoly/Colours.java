package Monopoly;

import java.awt.*;

/**
 * enum for property colours
 * @author Chase Scott 101092194
 */
public enum Colours {
    /**
     * All the colours for the game board
     */
    TEAL(0.1, new Color(0, 128, 128)), BROWN(0.1, new Color(125, 70, 11)),
    PINK(0.2, new Color(255,192,203)), ORANGE(0.3, new Color(255,165,0)),
    BLUE(0.5, new Color	(0,0,255)), RED(0.1, new Color(255, 0, 0)),
    YELLOW(0.4, new Color(255,255,0)), GREEN(0.4, new Color(34,139,34));

    private final double rentRate;  //rent rate associated with the colour
    private final Color colour;     //Color associated with the colour

    Colours(double rentRate, Color colour) {
        this.rentRate = rentRate;
        this.colour = colour;
    }

    public double getRentRate() {
        return rentRate;
    }

    public Color getColour() {return colour;}
}
