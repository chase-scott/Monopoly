package Monopoly;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class UtilityTest {
    private Utility utility = new Utility("WaterWorks", 300);
    Player player = new HumanPlayer("Sethster69", Color.BLUE);
    Player player2 = new ComputerPlayer("Sethster69420", Color.RED);

    @Test
    public void checkIfAvailable() {
        assertTrue(utility.checkIfAvailable());

    }

    @Test
    public void checkIfNotAvailable() {   //also used to test setOwner()
        utility.setOwner(player);
        assertFalse(utility.checkIfAvailable());

    }


    @Test
    public void squareAction() {
    }

    @Test
    public void getColour() {
    }

    @Test
    public void clear() {
        utility.setOwner(player2);
        assertFalse(utility.checkIfAvailable());

        utility.clear();
        assertTrue(utility.checkIfAvailable());
    }

    @Test
    public void getPrice() {
    }

    @Test
    public void toString1() {
    }
}