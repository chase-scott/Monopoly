package Monopoly;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Creates and initializes the game board.
 *
 * @author Mohammad Gaffori 101082318
 * @author Chase Scott 101092194
 */
public class GameBoard implements Serializable {

    private Square[] squares; //Array of squares that comprise the board
    public final static int BOARD_SIZE = 28;    //Size of the board
    public final static String[] VERSIONS= {"American", "Canadian"};

    /**
     * Default constructor
     */
    public GameBoard() {
        try {
            createBoardFromXML();
        } catch (Exception e) {System.out.println("ERROR");}
        //createBoard();
    }

    /**
     * Initializes the game board.
     */
    private void createBoard() {
        squares = new Square[BOARD_SIZE];

        squares[0] = new Empty("GO");

        squares[1] = new Property("Mediterranean Ave.", 60, Colours.BROWN);
        squares[2] = new Property("Baltic Avenue", 60, Colours.BROWN);

        squares[3] = new Utility("Reading Railroad", 150, Utility.RAILROAD);

        squares[4] = new Property("Oriental Avenue", 100, Colours.TEAL);
        squares[5] = new Property("Vermont Avenue", 100, Colours.TEAL);
        squares[6] = new Property("Connecticut Ave.", 120, Colours.TEAL);

        squares[7] = new Empty("Jail");

        squares[8] = new Property("St. Charles Place", 140, Colours.PINK);
        squares[9] = new Property("States Avenue", 140, Colours.PINK);
        squares[10] = new Property("Virginia Avenue", 160, Colours.PINK);

        squares[11] = new Utility("Electric Company", 150, Utility.UTILITY);
        squares[12] = new Property("Tennessee Avenue", 180, Colours.ORANGE);
        squares[13] = new Property("New York Avenue", 200, Colours.ORANGE);

        squares[14] = new Empty("FREE PARKING");

        squares[15] = new Property("Kentucky Avenue", 220, Colours.RED);
        squares[16] = new Property("Indiana Avenue", 220, Colours.RED);
        squares[17] = new Utility("B. & O. Railroad", 150, Utility.RAILROAD);

        squares[18] = new Property("Atlantic Avenue", 260, Colours.YELLOW);
        squares[19] = new Property("Ventnor Avenue", 260, Colours.YELLOW);
        squares[20] = new Property("Marvin Gardens", 280, Colours.YELLOW);

        squares[21] = new GoToJail();

        squares[22] = new Property("Pacific Avenue", 300, Colours.GREEN);
        squares[23] = new Property("North Carolina Ave.", 300, Colours.GREEN);
        squares[24] = new Property("Pennsylvania Ave.", 320, Colours.GREEN);

        squares[25] = new Utility("Water Works", 150, Utility.UTILITY);

        squares[26] = new Property("Park Place", 350, Colours.BLUE);
        squares[27] = new Property("Boardwalk", 400, Colours.BLUE);


    }

    private void createBoardFromXML() throws Exception {

        //squares = new Square[BOARD_SIZE];
        File f = new File("src/versions.xml");
        ArrayList<Square> board = new ArrayList<>();

        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser s = spf.newSAXParser();

        DefaultHandler dh = new DefaultHandler() {

            private String name = "";
            private String type = "";
            private double price = 0.0;
            private int colour = 0;


            StringBuilder elementValue = new StringBuilder();

          public void startElement(String u, String ln, String qName, Attributes a) {
              //System.out.println("START: " + qName);
              elementValue = new StringBuilder();
          }

          public void endElement(String url, String localNAme, String qName) {
              //System.out.println("END: " + qName);
              switch (qName) {
                  case "name":
                      this.name = elementValue.toString();
                      break;
                  case "price":
                      this.price = Integer.parseInt(elementValue.toString());
                      break;
                  case "colour":
                      this.colour = Integer.parseInt(elementValue.toString());
                      break;
                  case "type":
                      this.type = elementValue.toString();
                      break;
                  case "Property":
                      board.add(new Property(name, price, Objects.requireNonNull(Colours.matchColour(colour))));
                      break;
                  case "Utility":
                      board.add(new Utility(name, price, type));
                      break;
                  case "Empty":
                      board.add(new Empty(name));
                      break;
                  case "GoToJail":
                      board.add(new GoToJail());
                      break;
              }
          }

          public void characters(char[] ch, int start, int length) {
              //System.out.println("CHARS: " + new String(ch, start, length));
              if (elementValue == null) {
                  elementValue = new StringBuilder();
              } else {
                  elementValue.append(ch, start, length);
              }
          }

        };
        s.parse(f, dh);

        squares = board.toArray(new Square[0]);

    }



    /**
     * Acquires the square in a given position
     *
     * @param position  int, the position of the square
     * @return  Monopoly.Square, the square
     */
    public Square getSquare(int position) {return squares[position];}

}
