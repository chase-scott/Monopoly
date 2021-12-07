package Tests;

/**
 * Used to test the Colours Eum
 * @author Mohammad Gaffori 101082318
 */

import Monopoly.Colours;

import java.awt.*;

import static org.junit.Assert.*;

public class ColoursTest {

    private static final double Delta = 0.2; // Constant used for the assertEquals() Method

    @org.junit.Test
    public void getRentRate() {
        Colours color= Colours.RED;
        assertEquals(0.2, color.getRentRate(), Delta);
    }

    @org.junit.Test
    public void getHousePrice() {
        Colours color= Colours.TEAL;
        assertNotEquals(80, color.getHousePrice(), Delta);
        assertEquals(50,color.getHousePrice(),Delta);
    }

    @org.junit.Test
    public void getColour() {
        Colours color= Colours.RED;
        assertEquals(Color.RED, color.getColour());
    }

    @org.junit.Test
    public void matchColourNull() {
        Colours color= Colours.RED;
        assertNull(color.matchColour((255)));
    }

    @org.junit.Test
    public void matchColour() {
        Colours color= Colours.RED;
        assertEquals(Colours.RED,color.matchColour(-65536));
    }
}