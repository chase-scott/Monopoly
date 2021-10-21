/**
 * Game class
 * @author Amith Kumar Das Orko 101126245
 */
public class Game {

    private Square[] properties;
    private Player[] players;
    private Parser parser;
    private int turnNumber = 0;
    Dice dice = new Dice();
    private double rentRate = 0;
    private double blueRentRate = 0.3;
    private double redRentRate = 0.1;
    private double pinkRentRate = 0.2;
    private double brownRentRate = 0.2;

    private String noColor= "NO COLOR";
    private String red= "RED";
    private String blue= "BLUE";
    private String pink= "PINK";
    private String brown= "BROWN";

    public Game() {
        createBoard();
        parser = new Parser();

    }


    /**
     * Initialize the board for the game
     */
    private void createBoard() {
        properties = new Square[12];
        properties[0] = new Property("Go", 0, rentRate, noColor);
        properties[1] = new Property("Mediterranean Avenue", 60, blueRentRate, blue);
        properties[2] = new Property("Baltic Avenue", 60, blueRentRate, blue);

        properties[3] = new Property("Oriental Avenue", 100, redRentRate, red);
        properties[4] = new Property("Vermont Avenue", 100, redRentRate, red);
        properties[5] = new Property("Connecticut Avenue", 120, redRentRate, red);

        properties[6] = new Property("St. Charles Place", 140, brownRentRate, brown);

        properties[7] = new Property("Income Tax", 0, rentRate, noColor);

        properties[8] = new Property("States Avenue", 140, brownRentRate, brown);
        properties[9] = new Property("Virginia Avenue", 160, brownRentRate, brown);

        properties[10] = new Property("Park Place", 350, pinkRentRate, pink);
        properties[11] = new Property("Boardwalk", 400, pinkRentRate, pink);

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
