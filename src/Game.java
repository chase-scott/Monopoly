public class Game {

    private Square[] properties;
    private Player[] players;
    public Parser parser;

    public Game() {
        createBoard();
        parser = new Parser();
    }

    /**
     * Initialize the board for the game
     */
    private void createBoard() {
        properties = new Square[12];
        properties[0] = new Property("Go", 0);
        properties[1] = new Property("Mediterranean Avenue", 60);
        properties[2] = new Property("Baltic Avenue", 60);

        properties[3] = new Property("Oriental Avenue", 100);
        properties[4] = new Property("Vermont Avenue", 100);
        properties[5] = new Property("Connecticut Avenue", 120);

        properties[6] = new Property("St. Charles Place", 140);

        properties[7] = new Property("Income Tax", 0);

        properties[8] = new Property("States Avenue", 140);
        properties[9] = new Property("Virginia Avenue", 160);

        properties[10] = new Property("Park Place", 350);
        properties[11] = new Property("Boardwalk", 400);

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
                showState();
                break;

            case BUY:
                //buy a property
                break;

            case PASS:


                System.out.println();
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

    private void showState() {

    }




    public static void main(String[] args) {
        Game game = new Game();
        game.play();

    }


}
