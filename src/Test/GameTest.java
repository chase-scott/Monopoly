package Test;

import Monopoly.Game;
import Monopoly.GameBoard;
import Monopoly.HumanPlayer;
import Monopoly.Player;
import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;

/**
 * Used to test the Game Class.
 * @author Mohammad Gaffori 101082318
 */
public class GameTest {

    @Test(expected = NullPointerException.class)
    public void getNumberPlayersEmpty() {
        Game game = new Game();
        game.getNumberPlayers();
    }

    @Test
    public void getNumberPlayers() {
        Player[] player = new Player[3];

        Game game = new Game();
        game.setPlayers(player);
        assertEquals(3, game.getNumberPlayers());


    }

    @Test(expected = NullPointerException.class)
    public void getPlayerEmpty() {
        Game game = new Game();
        game.getPlayer(1);
    }

    @Test
    public void GetPlayers() {  //Also Tests setPlayers()
        Player[] player = new Player[1];
        player[0] = new HumanPlayer("Sethster999", Color.RED);

        Game game = new Game();
        game.setPlayers(player);
        assertEquals(player[0] ,game.getPlayer(0) );
    }


    @Override  //used to Override Equals() Method
    public boolean equals(Object o){
        return getClass() == o.getClass();
    }

    @Test
    public void getSquare() {

        Game game = new Game();
        GameBoard gameBoard = new GameBoard();

        //gameBoard.getSquare(1).equals(Game.getSquare(1));

    }

}