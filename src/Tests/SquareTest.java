package Tests;

import Monopoly.*;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Used to test the Square Class
 * @author Mohammad Gaffori 101082318
 */
public class SquareTest {

    Property property = new Property("Mediterranean Avenue", 60, Colours.ORANGE);
    Square square = new Property("Mediterranean Avenue", 60, Colours.ORANGE);
    ArrayList<Player> playersList = new ArrayList<>();

    @Test
    public void getName() {
        assertEquals("Mediterranean Avenue", property.getName());
    }

    @Test
    public void getPlayers() {
        assertEquals(playersList,square.getPlayers());
    }

    @Test
    public void addPlayer() {
        Game game = new Game();
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        square.addPlayer(player);
        assertNotNull(square.getPlayers());
        assertTrue(1 <=square.getPlayers().size());

    }

    @Test
    public void removePlayer() {
        Game game = new Game();
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        square.removePlayer(player);
        assertEquals(playersList, square.getPlayers());

    }

    // All the other methods were tested in the class PropertyTest & Utility test, since most were overridden

}