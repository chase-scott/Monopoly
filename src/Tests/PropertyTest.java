package Tests;

import Monopoly.*;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
/**
 * Used to test the Property Class
 * @author Mohammad Gaffori 101082318
 */
public class PropertyTest {

    Property property = new Property("Mediterranean Avenue", 60, Colours.ORANGE);

    @Test
    public void getPrice() {
        assertEquals(60, property.getPrice(),0.2);
    }

    @Test
    public void getHousePrice(){
        assertEquals(100, property.getHousePrice(),0.2);
    }

    @Test
    public void getNumHouses(){
        assertEquals(0, property.getNumHouses());
    }
    @Test
    public void getColour() {
        Colours orange= Colours.ORANGE;
        Colours red = Colours.RED;
        assertEquals(orange.getColour(), property.getColour());
        assertNotEquals(red.getColour(), property.getColour());
    }

    @Test
    public void getAOwnerNull() {

        assertNull(property.getOwner());
    }

    @Test
    public void getOwner() {  //Used to also Test setOwner()
        Game game = new Game();
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        property.setOwner(player);
        assertEquals(player, property.getOwner());

        property.setOwner(null);
        assertNull(property.getOwner());
    }

    @Test
    public void checkIfAvailable() {
        Game game = new Game();
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        assertTrue(property.checkIfAvailable()); //Since this Junit Test is computed in order, this is false at first

        property.setOwner(player);
        assertFalse(property.checkIfAvailable());
    }

    @Test
    public void squareAction() {
        Game game = new Game();
        game.setGameBoard("American");
        Player player = new HumanPlayer("Emily", Color.RED, game);
        Player player2 = new HumanPlayer("Sethster", Color.BLUE, game);

        property.setOwner(player);
        player2.setMoney(2);

        property.squareAction(player2);

        assertTrue(player2.getBankruptcyStatus());

        property.setOwner(null);
    }


    @Test
    public void clear() {
        Game game = new Game();
        game.setGameBoard("American");
        Player player = new HumanPlayer("Sethy", Color.RED, game);
        property.setOwner(player);

        assertEquals(player,property.getOwner());
        property.clear();

        assertTrue(property.checkIfAvailable());
    }
}