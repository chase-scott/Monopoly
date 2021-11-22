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
    BROWN(0.1, 50, new Color(125, 70, 11)),
    TEAL(0.15, 50, new Color(0, 128, 128)),
    PINK(0.15, 100, new Color(255,192,203)),
    ORANGE(0.2, 100, new Color(255,165,0)),
    RED(0.2, 150, new Color(255, 0, 0)),
    YELLOW(0.3, 150, new Color(255,255,0)),
    GREEN(0.3, 200, new Color(34,139,34)),
    BLUE(0.4, 200, new Color(0,0,255));

    private final double rentRate;  //rent rate associated with the colour
    private final Color colour;     //Color associated with the colour
    private final double housePrice;//cost of the house of the property

    Colours(double rentRate, double housePrice,Color colour) {
        this.rentRate = rentRate;
        this.colour = colour;
        this.housePrice = housePrice;
    }

    public double getRentRate() {
        return rentRate;
    }

    public double getHousePrice() { return housePrice; }

    public Color getColour() {return colour;}
}
