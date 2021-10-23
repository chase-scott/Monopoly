public class GameBoard {


    private Square[] squares;

    public GameBoard() {
        createBoard();
    }

    private void createBoard() {
        squares = new Square[23];

        squares[0] = new Property("Go", 0, Colours.NONE);

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

    }

    public String getName(int position) {return squares[position].getName();}






}
