package Monopoly;

/**
 * Monopoly.Game class for Monopoly
 *
 * @author Chase Scott 101092194
 * @author Mohammad Gaffori 101082318
 * @author Amith Kumar Das Orko 101126245
 */
public class Game {

    private Player[] players;           //array of players in the game
    private int turnNumber = 0;         //the current turn
    private static final GameBoard gameBoard = new GameBoard();  //the game's board

    /**
     * Default constructor
     */
    public Game() {

    }

    public int getNumberPlayers() {return players.length;}

    public Player getPlayer(int i) {return players[i];}

    public void setPlayers(Player[] players){this.players = players;}




    public void play() {
        for(int i = 0; i < 20; i++) {
            players[i % players.length].makeMove();
        }
    }


    public static Square getSquare(int i) {
        return gameBoard.getSquare(i);
    }


}
