package Tests;

import Monopoly.*;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class UtilityTest {

    private Utility utility = new Utility("TrainStation", 300, "RAILROAD");
    private Utility waterworks = new Utility("TrainStation", 300, "UTILITY");

    @Test
    public void checkIfAvailable() {
        assertTrue(utility.checkIfAvailable());
    }

    @Test
    public void checkIfNotAvailable() {   //also used to test setOwner()
        Game game = new Game();
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        utility.setOwner(player);
        assertFalse(utility.checkIfAvailable());
        utility.clear();
    }

    @Test
    public void getSquareActionRailroad(){
        Game game = new Game();
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        Player player2 = new ComputerPlayer("Sethster69420", Color.RED, game);
        utility.setOwner(player);
        utility.squareAction(player2);
        assertEquals(1450, player2.getMoney(),0.2);
    }

    @Test
    public void getSquareActionUtility(){
        Game game = new Game();
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        Player player2 = new ComputerPlayer("Sethster69420", Color.RED, game);

        waterworks.setOwner(player);
        player2.setMoney(1500);
        player2.rollDice();
        waterworks.squareAction(player2);
        assertEquals((1500 - (4 * (player2.getDice().rollResult()))), player2.getMoney(),0.2);
    }

    @Test
    public void getSquareActionBankrupt(){
        Game game = new Game();
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        Player player2 = new ComputerPlayer("Sethster69420", Color.RED, game);

        utility.setOwner(player);
        player2.setMoney(1);
        utility.squareAction(player2);
        assertTrue(player2.getBankruptcyStatus());
    }

    @Test
    public void getColour() {
        assertEquals(utility.getColour(),Color.WHITE);
    }

    @Test
    public void clear() {
        Game game = new Game();
        game.setGameBoard("American");
        Player player2 = new HumanPlayer("Sethy", Color.RED, game);

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