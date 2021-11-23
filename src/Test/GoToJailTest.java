package Test;

import Monopoly.GoToJail;
import Monopoly.Square;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class GoToJailTest {
    private Square goToJail = new GoToJail();

    @Test
    public void getColour() {
        assertEquals(Color.WHITE, goToJail.getColour());
    }

    @Test
    public void getPrice() {
        assertEquals(0, goToJail.getPrice(),0.2);
    }

}