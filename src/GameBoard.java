/**
 * Class to Symbolize Game Board
 * @author Mohammad Gaffori | 101082318
 */
public class GameBoard {

    private Square[] properties;

    private String teal = "teal";
    private String brown = "brown";
    private String pink = "pink";
    private String orange = "orange";
    private String blue = "blue";
    private String red = "red";
    private String yellow = "yellow";
    private String green = "green";



    public void createBoard() {
        properties = new Square[21];

        properties[0] = new Property("Go", 0, 0, "No Color");

        properties[1] = new Property("Mediterranean Avenue", 60,2, brown);
        properties[2] = new Property("Baltic Avenue", 60,4, brown);

        properties[3] = new Property("Oriental Avenue", 100,6, teal);
        properties[4] = new Property("Vermont Avenue", 100, 6, teal);
        properties[5] = new Property("Connecticut Avenue", 120, 8, teal);

        properties[6] = new Property("St. Charles Place", 140, 10, pink);
        properties[7] = new Property("States Avenue", 140, 10, pink );
        properties[8] = new Property("Virginia Avenue", 160, 12, pink);

        properties[9] = new Property("St. James Place", 180,14, orange);
        properties[10] = new Property("Tennessee Avenue", 180, 14, orange);
        properties[11] = new Property("New York Avenue", 200,16, orange);

        properties[12] = new Property("Kentucky Avenue", 220,18, red);
        properties[13] = new Property("Indiana Avenue", 220, 18, red);
        properties[14] = new Property("Illinois Avenue", 240,20, red);

        properties[15] = new Property("Atlantic Avenue", 260,22, yellow);
        properties[16] = new Property("Ventnor Avenue", 260, 22, yellow);
        properties[17] = new Property("Marvin Gardens", 280, 24, yellow);

        properties[18] = new Property("Atlantic Avenue", 300,26, green);
        properties[19] = new Property("Ventnor Avenue", 300,26, green);
        properties[20] = new Property("Marvin Gardens", 320, 28, green);

        properties[21] = new Property("Atlantic Avenue", 350, 35, blue);
        properties[22] = new Property("Ventnor Avenue", 400, 50, blue );


    }



}
