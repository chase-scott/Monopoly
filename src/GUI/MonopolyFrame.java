package GUI;

import javax.swing.*;
import Monopoly.*;
import java.awt.*;

/**
 * @version 1.0
 * @author Chase Scott 101092194
 */
public class MonopolyFrame extends JFrame {

    public final static Color[] PLAYER_COLOURS = {Color.RED, Color.ORANGE, Color.YELLOW,
            Color.GREEN, Color.BLUE, Color.CYAN, Color.PINK, Color.MAGENTA};    //The colours of the player's tokens

    /**
     * Constructor for the monopoly frame
     *
     * @param model Game, the model
     */
    public MonopolyFrame(Game model) {
        super("Monopoly");

        model.setPlayers(generateWelcome());

        JPanel contents = new MonopolyGUI(model);
        this.setContentPane(contents);
        this.setMinimumSize(new Dimension((900 + model.getNumberPlayers()*150), 1300));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Displays the prompt for how many players and their names, then compiles them into an array of Players.
     * @return  Player[],   the array of players
     */
    private Player[] generateWelcome() {
        int numPlayers = 0;
        int counter = 0;
        try {
            numPlayers = (int) JOptionPane.showInputDialog(null,
                    "Select the number of\nplayers you would like.", "Monopoly",
                    JOptionPane.QUESTION_MESSAGE, null, new Object[]{2, 3, 4, 5, 6, 7, 8}, 0);
        } catch (NullPointerException e) {System.exit(0);}

        Object[] inputs = new Object[2 * numPlayers];
        for (int i = 0; i < inputs.length; i += 2) {
            inputs[i] = "Player " + (counter + 1);
            inputs[i + 1] = new JTextField();
            counter++;
        }

        JOptionPane.showConfirmDialog(null, inputs, "Input Player Names.", JOptionPane.OK_CANCEL_OPTION);

        Player[] players = new Player[numPlayers];
        counter = 0;

        for (int i = 0, j = 1; i < numPlayers; i++, j+=2) {
            if(inputs[j] instanceof JTextField) {
                if(((JTextField) inputs[j]).getText().isEmpty()) {
                    players[i] = new ComputerPlayer("Computer Player " + (counter + 1), PLAYER_COLOURS[i]);
                    counter++;
                } else {
                    players[i] = new HumanPlayer(((JTextField) inputs[j]).getText(), PLAYER_COLOURS[i]);
                }

            }
        }

        return players;

    }

    public static void main(String[] args) {
        Game game = new Game();
        MonopolyFrame monopolyWindow = new MonopolyFrame(game);

    }

}