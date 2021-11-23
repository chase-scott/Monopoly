package Test;

import Monopoly.ComputerPlayer;
import Monopoly.HumanPlayer;
import Monopoly.Player;
import Monopoly.Utility;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class UtilityTest {
    private Utility utility = new Utility("TrainStation", 300, "RAILROAD");
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
        utility.clear();

    }

    @Test
    public void getColour() {
        assertEquals(utility.getColour(),Color.WHITE);
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
        assertEquals(utility.getPrice(), 300, 0.2);
    }

}