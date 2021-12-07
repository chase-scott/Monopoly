package Tests;

import Monopoly.ComputerPlayer;
import Monopoly.Game;
import Monopoly.Player;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ComputerPlayerTest {
    private final Game game = new Game();

    @Test
    public void buySquare() {
        game.setGameBoard("American");
        Player player1 = new ComputerPlayer("Sethy", Color.RED, game);
        player1.rollDice();
        if (!player1.isInJail()) {
            player1.buySquare();
            assertNotNull(player1.getPropertyList());   //Tests that the Property List is not empty
            assertTrue(1 <= player1.getPropertyList().size() );
        }else{
            assertTrue(player1.isInJail());
        }

    }

    @Test
    public void makeMoveForProperty() {
        game.setGameBoard("American");
        Player player2 = new ComputerPlayer("Colton",Color.RED,game);
        player2.makeMove();
        if(!player2.isInJail()) {
            assertNotNull(player2.getPropertyList());
        }else{
            assertNull(player2.getPropertyList());
        }
    }

}
