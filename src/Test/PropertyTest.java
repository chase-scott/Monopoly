package Test;

import Monopoly.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.awt.*;
import static org.junit.Assert.*;

/**
 * Used to test the Property Class.
 * @author Mohammad Gaffori 101082318
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    public void getOwner() {  // ***** Used to test setOwner() method Also ****roperty property = new Property("St. James Place", 180, Colours.ORANGE);
        Player player = new HumanPlayer("Sethster69", Color.BLUE);
        property.setOwner(player);
        assertEquals(player, property.getOwner());

        property.setOwner(null);
    }


    @Test
    public void checkIfAvailable() {
        assertTrue(property.checkIfAvailable()); //Since this Junit Test is computed in order, this is false at first

        Player player = new HumanPlayer("Sethster69", Color.BLUE);
        property.setOwner(player);
        assertFalse(property.checkIfAvailable());
    }

    @Test
    public void squareActionBankrupt() {   //Tests the behaviour of squareAction(), if the user becomes bankrupt
        Player player = new HumanPlayer("Emily", Color.RED);
        Player player2 = new HumanPlayer("Sethster", Color.BLUE);

        property.setOwner(player);
        player2.setMoney(2);

        property.squareAction(player2);

        assertTrue(player2.getBankruptcyStatus());

        property.setOwner(null);

    }

    @Test
    public void squareAction(){

    }

    @Test
    public void Clear() {
     Player player = new HumanPlayer("Emily", Color.RED);
     property.setOwner(player);

     assertEquals(player,property.getOwner());
     property.clear();

     assertTrue(property.checkIfAvailable());
    }

}