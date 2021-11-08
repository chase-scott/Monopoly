package Monopoly;

/**
 * Creates and initializes the game board.
 *
 * @author Mohammad Gaffori 101082318
 * @author Chase Scott 101092194
 */
public class GameBoard {

    private Square[] squares; //Array of squares that comprise the board
    public final static int BOARD_SIZE = 28;

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

        squares[3] = new Property("Oriental Avenue", 100, Colours.TEAL);
        squares[4] = new Property("Vermont Avenue", 100, Colours.TEAL);
        squares[5] = new Property("Connecticut Avenue", 120, Colours.TEAL);

        squares[6] = new Property("St. Charles Place", 140, Colours.PINK);
        squares[7] = new Property("States Avenue", 140, Colours.PINK);
        squares[8] = new Property("Virginia Avenue", 160, Colours.PINK);

        squares[9] = new Property("St. James Place", 180, Colours.ORANGE);
        squares[10] = new Property("Tennessee Avenue", 180, Colours.ORANGE);
        squares[11] = new Property("New York Avenue", 200, Colours.ORANGE);

        squares[12] = new Property("Kentucky Avenue", 220, Colours.RED);
        squares[13] = new Property("Indiana Avenue", 220, Colours.RED);
        squares[14] = new Property("Illinois Avenue", 240, Colours.RED);

        squares[15] = new Property("Atlantic Avenue", 260, Colours.YELLOW);
        squares[16] = new Property("Ventnor Avenue", 260, Colours.YELLOW);
        squares[17] = new Property("Marvin Gardens", 280, Colours.YELLOW);

        squares[18] = new Property("Pacific Avenue", 300, Colours.GREEN);
        squares[19] = new Property("North Carolina Avenue", 300, Colours.GREEN);
        squares[20] = new Property("Pennsylvania Avenue", 320, Colours.GREEN);

        squares[21] = new Property("Park Place", 350, Colours.BLUE);
        squares[22] = new Property("Boardwalk", 400, Colours.BLUE);

        squares[23] = new Go("EMPTY SQUARE");
        squares[24] = new Go("EMPTY SQUARE");
        squares[25] = new Go("EMPTY SQUARE");
        squares[26] = new Go("EMPTY SQUARE");
        squares[27] = new Go("EMPTY SQUARE");








    }

    /**
     * Acquires the name of a square given a position
     *
     * @param position  int, the position of the square
     * @return  String, the name of the square
     */
    public String getName(int position) {return squares[position].getName();}

    /**
     * Acquires the square in a given position
     *
     * @param position  int, the position of the square
     * @return  Monopoly.Square, the square
     */
    public Square getSquare(int position) {return squares[position];}

}
