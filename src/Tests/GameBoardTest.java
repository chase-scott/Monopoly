package Tests;

import Monopoly.Colours;
import Monopoly.GameBoard;
import Monopoly.Property;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
/**
 * Used to test the GameBoard class
 * @author Mohammad Gaffori 101082318
 */
public class GameBoardTest {

    @Test
    public void getSquare() {
        GameBoard gameBoard = new GameBoard("American");
        Property property = new Property("St. Charles Place",140, Colours.PINK);
        gameBoard.getSquare(8).equals(property);
    }

    @Override  //used to Override Equals() Method
    public boolean equals(Object o) {
        if (getClass() == o.getClass()) {
            return true;
        } else {
            return false;
        }
    }
}