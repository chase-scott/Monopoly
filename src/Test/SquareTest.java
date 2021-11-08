package Test;

import Monopoly.Colours;
import Monopoly.Player;
import Monopoly.Property;
import Monopoly.Square;
import org.junit.Test;
import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Test the methods that are found in the Square class
 *   @author Mohammad Gaffori 1010823818
 */
public class SquareTest {

    Square square = new Property("Mediterranean Avenue", 60, Colours.ORANGE);
    ArrayList<Player> playersList = new ArrayList<>();
    Player player = new Player("Sethster999", Color.ORANGE);

    @Test
    public void getName() {
        assertEquals("Mediterranean Avenue", square.getName());
    }

    @Test
    public void getPlayers() {

        assertEquals(playersList,square.getPlayers());

    }

    @Test
    public void addPlayer() {

        square.addPlayer(player);
        assertNotNull(square.getPlayers());
        assertTrue(1 <=square.getPlayers().size());

    }

    @Test
    public void removePlayer() {
        square.removePlayer(player);
        assertEquals(playersList, square.getPlayers());

    }
}