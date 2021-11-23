package Test;

import Monopoly.Dice;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Used to test the Dice Class.
 * @author Mohammad Gaffori 101082318
 */
public class DiceTest {

    @Test
    public void roll() {
        Dice dice = new Dice();
        int[] rollResult = dice.roll();
        assertNotEquals(0,rollResult[0] + rollResult[1]); // Ensures Dice value cannot be 0
        assertTrue(rollResult[0] + rollResult[1] <= 12);  //Ensures Dice Value is not any higher than 12

        //Need for the IF statement, if that is implemented
    }

    @Test
    public void isNotRolled() {
        Dice dice = new Dice();
        assertFalse(dice.isRolled());

    }

    @Test
    public void setRolled() {
        Dice dice = new Dice();
        dice.setRolled(true);
        assertTrue(dice.isRolled());
        dice.setRolled(false);
        assertFalse(dice.isRolled());
    }
}
