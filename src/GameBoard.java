/**
 * Class to Symbolize Game Board
 * @author Mohammad Gaffori | 101082318
 */
public class GameBoard {

    private Square[] properties;

    private void createBoard() {
        properties = new Square[19];

        properties[0] = new Property("Go", 0, 0);

        properties[1] = new Property("Mediterranean Avenue", 60,2);
        properties[2] = new Property("Baltic Avenue", 60,4);

        properties[3] = new Property("Oriental Avenue", 100);
        properties[4] = new Property("Vermont Avenue", 100);
        properties[5] = new Property("Connecticut Avenue", 120);

        properties[6] = new Property("St. Charles Place", 140);
        properties[7] = new Property("States Avenue", 140);
        properties[8] = new Property("Virginia Avenue", 140);

        properties[9] = new Property("St. James Place", 140);
        properties[10] = new Property("Tennessee Avenue", 140);
        properties[11] = new Property("New York Avenue", 140);

        properties[12] = new Property("Kentucky Avenue", 140);
        properties[13] = new Property("Indiana Avenue", 140);
        properties[14] = new Property("Illinois Avenue", 140);

        properties[15] = new Property("Atlantic Avenue", 140);
        properties[16] = new Property("Ventnor Avenue", 140);
        properties[17] = new Property("Marvin Gardens", 140);

        properties[18] = new Property("Atlantic Avenue", 140);
        properties[19] = new Property("Ventnor Avenue", 140);
        properties[20] = new Property("Marvin Gardens", 140);

        properties[21] = new Property("Atlantic Avenue", 140);
        properties[22] = new Property("Ventnor Avenue", 140);


    }



}
