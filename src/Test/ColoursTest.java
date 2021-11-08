package Test;

import Monopoly.Colours;
import java.awt.*;
import static org.junit.Assert.*;

/**
 * Used to test the Colours Class.
 * @author Mohammad Gaffori 101082318
 */
public class ColoursTest {

    private static final double Delta = 1e-15; // Constant used for the assertEquals() Method

    @org.junit.Test
    public void getRentRate() {
        Colours color= Colours.RED;
        assertEquals(0.1, color.getRentRate(), Delta);

    }

    @org.junit.Test
    public void getFalseRentRate() {
        Colours color= Colours.TEAL;
        assertNotEquals(0.9, color.getRentRate(), Delta);

    }

    @org.junit.Test
    public void getColour() {
        Colours color= Colours.RED;
        assertEquals(Color.RED, color.getColour());
    }

    @org.junit.Test
    public void getFalseColour() {
        Colours color= Colours.ORANGE;
        assertNotEquals(Color.MAGENTA, color.getColour());
    }

}