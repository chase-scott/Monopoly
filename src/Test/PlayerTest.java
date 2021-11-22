package Test;

import Monopoly.HumanPlayer;
import Monopoly.Player;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.awt.*;
import java.util.Vector;

import static org.junit.Assert.*;

/**
 * Used to test the Player Class.
 * @author Mohammad Gaffori 101082318
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlayerTest {



    @Test
    public void getName() {
        Player player = new HumanPlayer("Sethy", Color.BLUE);
        assertEquals("Sethy", player.getName());
        assertNotEquals("Colton", player.getName());
    }

    @Test
    public void getMoney() {
        Player player = new HumanPlayer("Sethy", Color.BLUE);
        assertEquals(1500, player.getMoney(),0.2);

    }

    @Test
    public void getTokenColour() {
        Player player = new HumanPlayer("Sethy", Color.BLUE);
        assertEquals(Color.BLUE, player.getTokenColour());
    }

    @Test
    public void getPosition() {
        Player player = new HumanPlayer("Sethy", Color.BLUE);
        assertEquals(0, player.getPosition());

    }

    @Test
    public void aGetDiceRolledStatus() {
        Player player = new HumanPlayer("Sethy", Color.BLUE);
        //assertFalse(player.getDiceRolledStatus());

        player.rollDice();
        //assertTrue(player.getDiceRolledStatus());

    }

    @Test
    public void getBankruptcyStatus() {  //*****Tests the method becomeBankrupt also
        Player player = new HumanPlayer("Sethy", Color.RED);
        assertFalse(player.getBankruptcyStatus());

        player.becomeBankrupt();
        assertTrue(player.getBankruptcyStatus());
    }

    @Test
    public void getPropertyList() {
        Player player = new HumanPlayer("Sethy", Color.BLUE);
        Vector<String> property = new Vector<>();
        assertEquals(property, player.getPropertyList());     /*Compares to another ArrayList of Property type that is empty
                                    to ensure  that they are equivalent
            */
    }

    @Test
    public void setMoney() {
        Player player = new HumanPlayer("Sethy", Color.BLUE);
        player.setMoney(123);
        assertEquals(123, player.getMoney(), 0.1);
    }


    @Test
    public void rollDice() {
        Player player = new HumanPlayer("Sethy", Color.BLUE);
        player.rollDice();
        //assertTrue(player.getDiceRolledStatus());
    }

    @Test
    public void buySquare() {
        Player player1 = new HumanPlayer("Sethy", Color.BLUE);
        player1.rollDice();
        player1.buySquare();
        assertNotNull(player1.getPropertyList());   //Tests that the Property List is not empty
        assertTrue(1 <= player1.getPropertyList().size() ); //Tests that the propertyList contains at least 1 item

    }
}