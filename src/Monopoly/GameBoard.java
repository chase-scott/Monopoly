package Monopoly;

/**
 * Creates and initializes the game board.
 *
 * @author Mohammad Gaffori 101082318
 * @author Chase Scott 101092194
 */
public class GameBoard {

    private Square[] squares; //Array of squares that comprise the board
    public final static int BOARD_SIZE = 28;    //Size of the board

    /**
     * Default constructor
     */
    public GameBoard() {
        createBoard();
    }

    /**
     * Initializes the game board.
     */
    private void createBoard() {
        squares = new Square[BOARD_SIZE];

        squares[0] = new Go("GO");

        squares[1] = new Property("Mediterranean Avenue", 60, Colours.BROWN);
        squares[2] = new Property("Baltic Avenue", 60, Colours.BROWN);

        squares[3] = new Utilities("Electric Company",this);

        squares[4] = new Property("Oriental Avenue", 100, Colours.TEAL);
        squares[5] = new Property("Vermont Avenue", 100, Colours.TEAL);
        squares[6] = new Property("Connecticut Avenue", 120, Colours.TEAL);

        squares[7] = new Jail("JAIL");

        squares[8] = new Property("St. Charles Place", 140, Colours.PINK);
        squares[9] = new Property("States Avenue", 140, Colours.PINK);
        squares[10] = new Property("Virginia Avenue", 160, Colours.PINK);

        squares[11] = new Rail("Pennsylvania Railroad",this);
        //squares[11] = new Property("St. James Place", 180, Colours.ORANGE);
        squares[12] = new Property("Tennessee Avenue", 180, Colours.ORANGE);
        squares[13] = new Property("New York Avenue", 200, Colours.ORANGE);

        squares[14] = new Go("FREE PARKING");

        squares[15] = new Property("Kentucky Avenue", 220, Colours.RED);
        squares[16] = new Property("Indiana Avenue", 220, Colours.RED);
        //squares[17] = new Property("Illinois Avenue", 240, Colours.RED);
        squares[17] =new Utilities("Water Works ",this);

        squares[18] = new Property("Atlantic Avenue", 260, Colours.YELLOW);
        squares[19] = new Property("Ventnor Avenue", 260, Colours.YELLOW);
        squares[20] = new Property("Marvin Gardens", 280, Colours.YELLOW);

        squares[21] = new GoToJail("GO TO JAIL");

        squares[22] = new Property("Pacific Avenue", 300, Colours.GREEN);
        squares[23] = new Property("North Carolina Ave.", 300, Colours.GREEN);
        squares[24] = new Property("Pennsylvania Ave.", 320, Colours.GREEN);

        squares[25] = new Rail("B. & O. Railroad ",this);

        squares[26] = new Property("Park Place", 350, Colours.BLUE);
        squares[27] = new Property("Boardwalk", 400, Colours.BLUE);


    }



    /**
     * Acquires the square in a given position
     *
     * @param position  int, the position of the square
     * @return  Monopoly.Square, the square
     */
    public Square getSquare(int position) {return squares[position];}

}
