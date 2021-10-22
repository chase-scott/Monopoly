/**
 * Game class
 * @author Amith Kumar Das Orko 101126245
 * @author Mohammad Gaffori 101082318
 * @author Chase Scott 101092194
 */
public class Game {

    private Square[] properties;
    private Player[] players;
    private Parser parser;
    private GameBoard gameBoard;
    private int turnNumber = 0;
    Dice dice = new Dice();


    public Game() {
        gameBoard.createBoard();
        parser = new Parser();

    }


    public void play() {

        players = parser.getPlayers();
        boolean finished = false;
        System.out.println(players[turnNumber % players.length].getName() + "'s turn.");

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
                //buy a property
                break;

            case PASS:
                turnNumber++;
                System.out.println(players[turnNumber % players.length].getName() + "'s turn.");
                break;

            case HELP:
                showHelp();
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

    private void rollAgain(){
        if(dice.isDouble()){
            dice.roll();
        }
    }

    private void showHelp() {
        System.out.println("LIST OF COMMANDS");
        parser.showCommands();
    }

    private void showState() {

    }




    public static void main(String[] args) {
        Game game = new Game();
        game.play();

    }


}
