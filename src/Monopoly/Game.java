package Monopoly;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;

/**
 * Monopoly.Game class for Monopoly
 *
 * @author Chase Scott 101092194
 * @author Mohammad Gaffori 101082318
 * @author Amith Kumar Das Orko 101126245
 */
public class Game implements Serializable {

    private Player[] players;           //array of players in the game
    private int turnNumber;         //the current turn, start at turn -1
    private GameBoard gameBoard;  //the game's board

    /**
     * Default constructor
     */
    public Game() {
        turnNumber = -1;
        gameBoard = new GameBoard(GameBoard.VERSIONS[0]); //defaults to american version
    }

    public int getNumberPlayers() {
        try { return players.length;
        } catch (NullPointerException e) { return 0; }
    }

    public Player getPlayer(int i) {return players[i];}

    public void setPlayers(Player[] players){this.players = players;}

    /**
     * Begins the game loop. Once a player has passed their turn, increment turn number.
     * Then check for win state, if game is over, display win message and quit.
     */
    public void play() {

        int bankruptPlayers = 0;

        while(true) {
            turnNumber++;
            if(players[turnNumber % players.length].getBankruptcyStatus()) {continue;}
            players[turnNumber % players.length].makeMove();

            //CHECK WIN STATE
            for(Player p : players) {
                if(p.getBankruptcyStatus()) bankruptPlayers++;
            }
            if(bankruptPlayers == players.length - 1) {

                for(Player p : players){
                    if (!p.getBankruptcyStatus()) {
                        p.showMessage(p.getName() + " has won the game!!!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                System.exit(0);
            }

            bankruptPlayers = 0;
        }
    }

    /**
     * Get the square at location i in the gameboard
     *
     * @param i int, location on the board
     * @return  Square, the square
     */
    public Square getSquare(int i) {
        return gameBoard.getSquare(i);
    }

    public void setGameBoard(String version) {
        gameBoard = new GameBoard(version);
    }


    //SAVE LOGIC//

    public void writeToFile(String fileName) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));

            objectOutputStream.writeObject(this);

            objectOutputStream.close();

        } catch (IOException ignored){}

    }

    public void readFile(String fileName) {

        Game loadedGame = null;

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            loadedGame = (Game) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        assert loadedGame != null;

        players = new Player[loadedGame.players.length];
        System.arraycopy(loadedGame.players, 0, players, 0, loadedGame.players.length);
        //clear player views
        Arrays.asList(players).forEach(Player::clearViews);

        //rebuild board
        gameBoard = loadedGame.gameBoard;
        //clear square views
        for(int i = 0; i < GameBoard.BOARD_SIZE; i++) {
            getSquare(i).clearViews();
        }
        turnNumber = loadedGame.turnNumber - 1;

    }

}
