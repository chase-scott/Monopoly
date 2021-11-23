package Test;

import Monopoly.*;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

import static org.junit.Assert.*;

public class ComputerPlayerTest {
    Player player = new ComputerPlayer("Sethster", Color.RED);

    @Test
    public void getName() {
        assertEquals("Sethster", player.getName());
        assertNotEquals("Colton", player.getName());
    }

    @Test
    public void getMoney() {
        assertEquals(1500, player.getMoney(),0.2);

    }

    @Test
    public void getTokenColour() {
        assertNotEquals(Color.BLUE, player.getTokenColour());
        assertEquals(Color.RED,player.getTokenColour());
    }

    @Test
    public void getPosition() {
        assertEquals(0, player.getPosition());

    }

    @Test
    public void getBankruptcyStatus() {  //*****Tests the method becomeBankrupt also
        assertFalse(player.getBankruptcyStatus());

        player.becomeBankrupt();
        assertTrue(player.getBankruptcyStatus());
    }

    @Test
    public void getPropertyList() {
        Vector<String> property = new Vector<>();
        assertEquals(property, player.getPropertyList());     /*Compares to another ArrayList of Property type that is empty
                                    to ensure  that they are equivalent
            */
    }

    @Test
    public void setMoney() {
        player.setMoney(123);
        assertEquals(123, player.getMoney(), 0.1);
    }


    @Test
    public void buildHouse(){
        Player player1 = new ComputerPlayer("Sethy", Color.BLUE);
        player1.setMoney(10);
        Property Property = new Property("Baltic Ave", 100, Colours.RED);
        player1.addProperty(Property);
        player1.buildHouse(0);
        assertEquals(JOptionPane.WARNING_MESSAGE, JOptionPane.WARNING_MESSAGE);

    }

    @Test
    public void goToJail(){
        Player player1 = new HumanPlayer("Sethy", Color.BLUE);
        player1.goToJail();
        assertEquals(7,player1.getPosition(),0.2);
    }


    @Test
    public void buySquare() {
        Player player1 = new HumanPlayer("Sethy", Color.BLUE);
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
    public void buySquareBroke() {
        Player player1 = new HumanPlayer("Sethy", Color.BLUE);
        player1.setMoney(0);
        player1.rollDice();
        if (!player1.isInJail()) {
            player1.buySquare();
            Vector<String> propertylist = new Vector<>();
            assertEquals(propertylist, player1.getPropertyList());   //Tests that the Property List is not empty
            assertFalse(1 <= player1.getPropertyList().size());
        }else{
            assertTrue(player1.isInJail());
        }
    }

    @Test
    public void makeMoveInJail() {
        player.goToJail();
        player.makeMove();
        assertFalse(player.isInJail());
    }

    @Test
    public void makeMoveInJailNoMoney(){
        Player player1 = new ComputerPlayer("Halo",Color.RED);
        player1.setMoney(10);
        player1.goToJail();
        player1.makeMove();
        if (!player1.getDice().isDouble()) {
            assertTrue(player1.isInJail());
        }else{
            assertFalse(player1.isInJail());
        }
    }

    @Test
    public void makeMoveForProperty(){
        Player player2 = new ComputerPlayer("Colton",Color.RED);
        player2.makeMove();
        if(!player2.isInJail()) {
            assertNotNull(player2.getPropertyList());
        }else{
            assertNull(player2.getPropertyList());
        }
    }
}