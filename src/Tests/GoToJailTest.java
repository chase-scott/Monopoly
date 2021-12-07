package Tests;

import Monopoly.*;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class GoToJailTest {
    private Square goToJail = new GoToJail();

    @Test
    public void squareAction() {
        Game game = new Game();
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        goToJail.squareAction(player);
        assertTrue(player.isInJail());
    }

    @Test
    public void getColour() {
        assertEquals(Color.WHITE, goToJail.getColour());
    }

    @Test
    public void getPrice() {
        assertEquals(0, goToJail.getPrice(),0.2);
    }

}