package Test;

import Monopoly.Empty;
import Monopoly.Square;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Used to test the Empty Class.
 * @author Mohammad Gaffori 101082318
 */

public class EmptyTest {

    Square Empty = new Empty("Baltic Avenue");
    @Test
    public void getColour() {
        assertEquals(Color.WHITE,Empty.getColour());
    }

    @Test
    public void getPrice() {
        assertEquals(0,Empty.getPrice(),0.2);
    }
}