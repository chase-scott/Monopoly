package Test;

import Monopoly.ComputerPlayer;
import Monopoly.HumanPlayer;
import Monopoly.Player;
import Monopoly.Utility;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Used to test the Utility  Class.
 * @author Mohammad Gaffori 101082318
 */

public class UtilityTest {
    private Utility utility = new Utility("TrainStation", 300, "RAILROAD");
    private Utility waterworks = new Utility("TrainStation", 300, "UTILITY");
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

    @Test
    public void getSquareActionRailroad(){
        utility.setOwner(player);
        utility.squareAction(player2);
        assertEquals(1450, player2.getMoney(),0.2);
    }

    @Test
    public void getSquareActionUtility(){
        waterworks.setOwner(player);
        player2.setMoney(1500);
        player2.rollDice();
        waterworks.squareAction(player2);
        assertEquals((1500 - (4 * (player2.getDice().rollResult()))), player2.getMoney(),0.2);
    }

    @Test
    public void getSquareActionBankrupt(){
        utility.setOwner(player);
        player2.setMoney(1);
        utility.squareAction(player2);
        assertTrue(player2.getBankruptcyStatus());
    }


}