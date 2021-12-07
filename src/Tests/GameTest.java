package Tests;


import Monopoly.Game;
import Monopoly.GameBoard;
import Monopoly.HumanPlayer;
import Monopoly.Player;
import org.junit.Test;


import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;
/**
 * Used to test the Game Class
 * @author Mohammad Gaffori 101082318
 */
public class GameTest {

    @Test
    public void getNumberPlayers() {
        Game game = new Game();
        game.setGameBoard("American");
        assertEquals(0,game.getNumberPlayers(),0.2);
    }

    /**
     * Also used to test setPlayers()
     */
    @Test
    public void getPlayer() {
        Game game = new Game();
        game.setGameBoard("American");

        Player[] player = new Player[1];
        player[0] = new HumanPlayer("Sethy", Color.BLUE, game);


        game.setPlayers(player);
        game.getPlayer(0);
        assertEquals(player[0] ,game.getPlayer(0));

    }

    @Test(expected = NullPointerException.class)
    public void getPlayerEmpty() {
        Game game = new Game();
        game.getPlayer(1);
    }


    /**
     * Also used to test getSquare()
     */
    @Test
    public void setGameBoard() {
        Game game = new Game();
        game.setGameBoard("American");

        GameBoard gameBoard = new GameBoard("American");
        assertEquals(gameBoard.getSquare(2).getName(), game.getSquare(2).getName());
    }


    @Test
    public void writeToFile(){
        Game game = new Game();
        game.setGameBoard("American");

        game.writeToFile("testFile");
        Path path = Paths.get("testFile");
        assertTrue(Files.exists(path)); //Test that file is created

    }

    @Override  //used to Override Equals() Method
    public boolean equals(Object o) {
        return getClass() == o.getClass();
    }
}