package Test;

/**
 * Used to test the GameBoard Class.
 * @author Mohammad Gaffori 101082318
 */

import Monopoly.Colours;
import Monopoly.GameBoard;
import Monopoly.Property;
import Monopoly.Square;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameBoardTest {




    @Test
    public void getName() {
        GameBoard gameBoard = new GameBoard();
        Square square = new Property("Oriental Avenue", 100, Colours.TEAL);

        assertEquals(square.getName(), gameBoard.getName(3));
        assertNotEquals(square.getName(), gameBoard.getName(1));
    }


    @Override //Used to override Equals() compare method
    public boolean equals(Object o){
        if(getClass() == o.getClass()){
            return true;
        }
        else{
            return false;}
    }


    @Test
    public void getSquare() {
        GameBoard gameBoard = new GameBoard();

        Square[] squares = new Square[3];
        squares[0] = new Property("Oriental Avenue", 100, Colours.TEAL);
        squares[1] = new Property("Vermont Avenue", 100, Colours.TEAL);
        squares[2] = new Property("Connecticut Avenue", 120, Colours.TEAL);

        squares[0].equals(gameBoard.getSquare(3));
        assertFalse(squares[1].equals(gameBoard.getSquare(3)));
        squares[2].equals(gameBoard.getSquare(5));


    }
}