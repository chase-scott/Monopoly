package Tests;

import Monopoly.Empty;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class EmptyTest {

    @Test
    public void getColour() {
        Empty empty = new Empty("Empty");
        assertEquals(Color.WHITE, empty.getColour());
    }

    @Test
    public void getPrice() {
        Empty empty = new Empty("Empty");
        assertEquals(0,empty.getPrice(),0.2);
    }
}