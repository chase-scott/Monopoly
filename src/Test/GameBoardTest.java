package Test;

import Monopoly.Colours;
import Monopoly.GameBoard;
import Monopoly.Property;
import Monopoly.Square;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Used to test the GameBoard Class.
 * @author Mohammad Gaffori 101082318
 */
public class GameBoardTest {


    @Override //Used to override Equals() compare method
    public boolean equals(Object o){
        return getClass() == o.getClass();
    }

    @Test
    public void getSquare() {
        GameBoard gameBoard = new GameBoard();

        Square[] squares = new Square[3];
        squares[0] = new Property("Oriental Avenue", 100, Colours.TEAL);
        squares[1] = new Property("Vermont Avenue", 100, Colours.TEAL);
        squares[2] = new Property("Connecticut Avenue", 120, Colours.TEAL);

        squares[0].equals(gameBoard.getSquare(3));
        assertNotEquals(squares[1], gameBoard.getSquare(3));
        squares[2].equals(gameBoard.getSquare(5));

    }
}