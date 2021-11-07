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
    private Dice dice;                  //the dice being used
    private int turnNumber = 0;         //the current turn
    private final GameBoard gameBoard;  //the game's board
  
    /**
     * Default constructor
     */
    public Game() {
        gameBoard = new GameBoard();
        dice = new Dice();
    }

    public int getNumberPlayers() {return players.length;}

    public Player getPlayer(int i) {return players[i];}

    public void setPlayers(Player[] players){this.players = players;}




    public void play() {
        for(int i = 0; i < 20; i++) {
            players[i % players.length].makeMove();
        }
    }



    /**
     * Process the commands of the player
     */
    private void processCommand() {
        boolean wantToQuit = false;

        /*
            case UNKNOWN:
                System.out.println("Unknown command.");
                break;

            case STATE:
                showState();
                break;

            case BUY:
                try {
                    players[turnNumber].buy((Property) gameBoard.getSquare(players[turnNumber].getPosition()));
                } catch(ClassCastException e) {
                    System.out.println("You are not on a property square!");
                }
                break;

            case PASS:
                if(dice.isRolled()) {
                    dice.setRolled(false);
                    do {
                        turnNumber++;
                        if (turnNumber >= players.length) turnNumber = 0;
                    } while (players[turnNumber].isBankrupt());

                    System.out.println(players[turnNumber].getName() + "'s turn.");
                    break;
                }
                System.out.println("You must roll before you can pass your turn!");
                break;

            case ROLL:
                if(!dice.isRolled()) {
                    players[turnNumber].playerMove(dice.roll());
                    System.out.println("You landed on " + gameBoard.getName(players[turnNumber].getPosition()));
                    gameBoard.getSquare(players[turnNumber].getPosition()).squareAction(players[turnNumber]); //Executes the action of the square that is landed on

                    //check for win state
                    int playersLost = 0;
                    for(Player p : players) {
                        if(p.isBankrupt()){
                            playersLost++;
                        }
                    }
                    if(playersLost == (players.length - 1)) {
                        for(Player p : players) {
                            if(!p.isBankrupt()) System.out.println(p.getName() + " wins the game!!!");
                            wantToQuit = true;
                            break;
                        }
                    }
                    //end check for win state

                } else {
                    System.out.println("You already rolled this turn");
                }
                break;

            case QUIT:
                wantToQuit = true;
                break;

        }

        return wantToQuit;
        */
    }


    public Square getSquare(int i) {
        return gameBoard.getSquare(i);
    }


}
