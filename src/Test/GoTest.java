package Test;

/**
 * Used to test the Go Class.
 * @author Mohammad Gaffori 101082318
 */

import Monopoly.Colours;
import Monopoly.Go;
import Monopoly.Property;
import Monopoly.Square;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoTest {



    @Test
    public void toString1() {
        Square square = new Property("\n\nOriental Avenue", 100, Colours.TEAL);
        Go go = new Go("Oriental Avenue");

        assertEquals(square.getName(), go.toString());

    }
}