package Monopoly;

import javax.swing.*;

/**
 * Monopoly.Game class for Monopoly
 *
 * @author Chase Scott 101092194
 * @author Mohammad Gaffori 101082318
 * @author Amith Kumar Das Orko 101126245
 */
public class Game {

    private Player[] players;           //array of players in the game
    private int turnNumber = -1;         //the current turn, start at turn -1
    private static final GameBoard gameBoard = new GameBoard();  //the game's board

    /**
     * Default constructor
     */
    public Game() {

    }

    public int getNumberPlayers() {return players.length;}

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
            if(players[turnNumber % players.length].getBankruptcyStatus()) {turnNumber++; continue;}
            players[turnNumber % players.length].makeMove();

            //CHECK WIN STATE
            for(Player p : players) {
                if(p.getBankruptcyStatus()) bankruptPlayers++;
            }
            if(bankruptPlayers == players.length - 1) {

                for(Player p : players){
                    if (!p.getBankruptcyStatus()) {
                        JOptionPane.showMessageDialog(null, p.getName() + " has won the game!!!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
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
    public static Square getSquare(int i) {
        return gameBoard.getSquare(i);
    }

}
