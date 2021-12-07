package Monopoly;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.InputStream;
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
    public final static String[] VERSIONS= {"American", "Canadian", "British"};
    public static String CURRENCY_SIGN = null;

    /**
     * Default constructor
     */
    public GameBoard(String version) {
        try {
            createBoard(version);
        } catch (Exception e) {
            System.out.println("failed to load versions.xml");
        }
    }

    /**
     * Initializes the game board.
     */
    private void createBoard(String version) throws Exception {

        //this will be function input
        InputStream f = GameBoard.class.getResourceAsStream("versions.xml");
        ArrayList<Square> board = new ArrayList<>();

        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser s = spf.newSAXParser();

        DefaultHandler dh = new DefaultHandler() {

            private boolean correctVersion = false;
            private boolean done = false;
            private String name = "";
            private String type = "";
            private double price = 0.0;
            private int colour = 0;

            StringBuilder elementValue = new StringBuilder();

          public void startElement(String u, String ln, String qName, Attributes a) {

              if(qName.equals(version)) {
                  correctVersion = true;
              } else {
                  elementValue = new StringBuilder();
              }
          }

          public void endElement(String url, String localName, String qName) {

              if(correctVersion && !done) {
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
                      case "currency":
                          CURRENCY_SIGN = elementValue.toString();
                          break;
                  }
                  if(qName.equals(version)) done = true;
              }
          }

          public void characters(char[] ch, int start, int length) {
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
