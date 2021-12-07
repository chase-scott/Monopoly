package Tests;

import Monopoly.Empty;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
/**
 * Used to test the used to test the Empty Class, which is used
 * for squares that have no effect when the player lands on them
 * @author Mohammad Gaffori 101082318
 */
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