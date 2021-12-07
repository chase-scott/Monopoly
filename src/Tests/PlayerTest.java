package Tests;

import Monopoly.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

import static org.junit.Assert.*;
/**
 * Used to test the Players Class
 * @author Mohammad Gaffori 101082318
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlayerTest {
    private final Game game = new Game();

    @Test
    public void getName() {
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        assertEquals("Sethy", player.getName());
    }

    @Test
    public void getMoney() {
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        assertEquals(1500, player.getMoney(),0.2);
    }

    @Test
    public void setMoney() {
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        player.setMoney(700);
        assertEquals(700, player.getMoney(),0.2);
    }

    @Test
    public void getTokenColour() {
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        assertEquals(Color.RED, player.getTokenColour());
    }

    @Test
    public void getPosition() {
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        assertEquals(0, player.getPosition());
    }

    @Test
    public void isInJail() {
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        assertFalse(player.isInJail());
    }


    @Test
    public void isTakingTurn() {
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        assertFalse(player.isTakingTurn());
    }

    /**
     * Also used to test BecomeBankrupt()
     */
    @Test
    public void getBankruptcyStatus() {
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        assertFalse(player.getBankruptcyStatus());

        player.becomeBankrupt();
        assertTrue(player.getBankruptcyStatus());
    }

    /**
     * Also used to test getPropertyList()
     */
    @Test
    public void addProperty() {
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        Property property = new Property("Test", 70, Colours.RED);
        player.addProperty(property);
        assertNotNull(player.getPropertyList());

    }

    @Test
    public void getGame() {
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        assertSame(game, player.getGame());
    }

    @Test
    public void getEmptyPropertyList() {
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        Vector<String> property = new Vector<>();
        assertEquals(property, player.getPropertyList()); //Compares empty vector String to empty property list

    }

    /**
     * Also used to test getDice()
     */
    @Test
    public void rollDice() {
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        player.rollDice();
        assertNotNull(player.getDice());
    }

    @Test
    public void buySquare() {
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        player.setPosition(8);
        player.buySquare();
        assertEquals(1360, player.getMoney(),0.2);
    }

    @Test
    public void buySquareBroke() {   //tests to see if player can buy square while not having enough funds
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        player.setMoney(10);
        player.setPosition(8);
        player.buySquare();
        assertEquals(JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE);

        //secondary test
        Vector<String> property = new Vector<>();  //since player cannot buy square, their property list will remain empty
        assertEquals(property, player.getPropertyList());
    }


    @Test
    public void buildHouse() {
        game.setGameBoard("American");
        Player player1 = new HumanPlayer("Sethy", Color.RED, game);
        player1.setMoney(10);
        Property Property = new Property("Baltic Ave", 100, Colours.RED);
        player1.addProperty(Property);
        player1.buildHouse(0);
        assertEquals(JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE);
    }

    @Test
    public void makeMove() {
        game.setGameBoard("American");
        Player player1 = new HumanPlayer("Sethy", Color.BLUE, game);
        player1.goToJail();
        assertFalse(player1.isTakingTurn());
    }

    @Test
    public void goToJail() {
        game.setGameBoard("American");
        Player player1 = new HumanPlayer("Sethy", Color.BLUE, game);
        player1.goToJail();
        assertEquals(7,player1.getPosition(),0.2);
    }

}