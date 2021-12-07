package Tests;

import Monopoly.Dice;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Used to test the Dice Class
 * @author Mohammad Gaffori 101082318
 */
public class DiceTest {

    @Test
    public void isRolled() {
        Dice dice = new Dice();
        dice.roll();
        dice.roll();
        assertTrue(dice.isRolled());
    }

    @Test
    public void setRolled() {
        Dice dice = new Dice();
        dice.setRolled(true);
        assertTrue(dice.isRolled());

        dice.setRolled(false);
        assertFalse(dice.isRolled());
    }

    @Test
    public void rollResult() {
        Dice dice = new Dice();
        dice.roll();
        assertNotEquals(0,dice.rollResult()); // Ensures Dice value cannot be 0
        assertTrue(dice.rollResult() <= 12);
    }

    @Test
    public void isDouble() {
        Dice dice = new Dice();
        dice.roll();
        if (dice.getDice1() == dice.getDice2()){
            assertTrue(dice.isDouble());
        }else{assertFalse(dice.isDouble());
        }
    }
}