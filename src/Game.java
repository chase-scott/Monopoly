/**
 * Game class for Monopoly
 *
 * @author Chase Scott 101092194
 * @author Mohammad Gaffori 101082318
 * @author Amith Kumar Das Orko 101126245
 */
public class Game {

    private Player[] players;           //array of players in the game
    private Dice dice;                  //the dice being used
    private Parser parser;              //the input parser
    private int turnNumber = 0;         //the current turn
    private final GameBoard gameBoard;  //the game's board
  
    /**
     * Default constructor
     */
    public Game() {
        gameBoard = new GameBoard();
        parser = new Parser();
        dice = new Dice();
    }

    /**
     * Starts the gameplay loop.
     */
    public void play() {

        printWelcome();
        boolean finished = false;
        System.out.println(players[turnNumber].getName() + "'s turn.");

        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

    }

    /**
     * Process the commands of the player
     *
     * @param command   Command, the players command
     * @return  boolean, if the player wants to quit
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandword = command.getCommandWord();

        switch(commandword) {
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
                dice.setRolled(false);

                do {
                    turnNumber++;
                    if(turnNumber >= players.length) turnNumber = 0;
                } while (players[turnNumber].isBankrupt());

                System.out.println(players[turnNumber].getName() + "'s turn.");
                break;

            case HELP:
                showHelp();
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

            case ROLL:
                dice.roll();
                dice.rollValue();
                break;
        }

        return wantToQuit;
    }


    /**
     * Prints the help information
     */
    private void showHelp() {
        System.out.println("LIST OF COMMANDS");
        parser.showCommands();
    }

    /**
     * prints the state of the current player
     */
    private void showState() {
        System.out.println(players[turnNumber].toString());
        System.out.println("You are on " + gameBoard.getName(players[turnNumber].getPosition()));
    }

    /**
     * Prints the welcome information for the game
     */
    private void printWelcome() {
        System.out.println("\t\t\t--WELCOME TO MONOPOLY--");
        System.out.println("Monopoly is a multi-player economic-themed board game.");
        System.out.println("Be the last player not bankrupt to win! Good luck!");
        System.out.println("If you need help, type " + CommandWord.HELP + " for a list of commands!\n");
        players = parser.getPlayers();
        System.out.println();
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.play();

    }

}
