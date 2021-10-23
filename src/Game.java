public class Game {

    private Player[] players;
    Dice dice = new Dice();
    private Parser parser;
    private int turnNumber = 0;
    private final GameBoard gameBoard;

    public Game() {
        gameBoard = new GameBoard();
        parser = new Parser();
    }

    /**
     * Starts the gameplay loop.
     */
    public void play() {

        players = parser.getPlayers();
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
                    players[turnNumber].buy((Property) gameBoard.getSquare(players[turnNumber].getPosition())); //TODO
                } catch(ClassCastException e) {
                    System.out.println("You are not on a property square!");
                }
                break;

            case PASS:
                dice.setRolled(false);
                turnNumber++;
                if(turnNumber >= players.length) turnNumber = 0;
                if(players[turnNumber].getMoney() == 0) turnNumber++; //If player is bankrupt, skip turn
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
                } else {
                    System.out.println("You already rolled this turn");
                }
                break;

            case QUIT:
                wantToQuit = true;
                break;

        }

        return wantToQuit;
    }

    private void showHelp() {
        System.out.println("LIST OF COMMANDS");
        parser.showCommands();
    }

    private void showState() {
        System.out.println(players[turnNumber].toString());
        System.out.println("You are on " + gameBoard.getName(players[turnNumber].getPosition()));
    }




    public static void main(String[] args) {
        Game game = new Game();
        game.play();

    }

}
