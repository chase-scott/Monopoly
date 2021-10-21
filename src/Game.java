public class Game {

    private Square[] properties;
    private Player[] players;
    private Parser parser;
    private int turnNumber = 0;
    Dice dice = new Dice();
    private double rentRate = 0.2;

    public Game() {
        createBoard();
        parser = new Parser();

    }

    /**
     * Initialize the board for the game
     */
    private void createBoard() {
        properties = new Square[12];
        properties[0] = new Property("Go", 0, rentRate);
        properties[1] = new Property("Mediterranean Avenue", 60, rentRate);
        properties[2] = new Property("Baltic Avenue", 60, rentRate);

        properties[3] = new Property("Oriental Avenue", 100, rentRate);
        properties[4] = new Property("Vermont Avenue", 100, rentRate);
        properties[5] = new Property("Connecticut Avenue", 120, rentRate);

        properties[6] = new Property("St. Charles Place", 140, rentRate);

        properties[7] = new Property("Income Tax", 0, rentRate);

        properties[8] = new Property("States Avenue", 140, rentRate);
        properties[9] = new Property("Virginia Avenue", 160, rentRate);

        properties[10] = new Property("Park Place", 350, rentRate);
        properties[11] = new Property("Boardwalk", 400, rentRate);

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
