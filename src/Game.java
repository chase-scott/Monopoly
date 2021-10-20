public class Game {

    public Parser parser;

    public Game() {
        //createBoard();
        parser = new Parser();
    }

    public void play() {

        boolean finished = false;
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
                //get the current state of the board
                break;

            case BUY:
                //buy a property
                break;

            case PASS:
                //pass a players turn
                break;

            case HELP:
                showHelp();
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




    public static void main(String[] args) {
        Game game = new Game();
        game.play();

    }


}
