package Test;

import Monopoly.Colours;
import Monopoly.Empty;
import Monopoly.Property;
import Monopoly.Square;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Used to test the Go Class.
 * @author Mohammad Gaffori 101082318
 */
public class GoTest {

    @Test
    public void toString1() {
        Square square = new Property("\n\nOriental Avenue", 100, Colours.TEAL);
        Empty go = new Empty("Oriental Avenue");

        assertEquals(square.getName(), go.toString());

    }
}