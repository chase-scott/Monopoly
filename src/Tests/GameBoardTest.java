package Tests;

import Monopoly.Colours;
import Monopoly.GameBoard;
import Monopoly.Property;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Used to test the GameBoard class
 * @author Mohammad Gaffori 101082318
 */
public class GameBoardTest {

    @Test
    public void getSquare() {
        GameBoard gameBoard = new GameBoard("American");
        assertEquals(gameBoard.getSquare(8).getName(), "St. Charles Place");
    }

    @Override  //used to Override Equals() Method
    public boolean equals(Object o) {
        return getClass() == o.getClass();
    }
}