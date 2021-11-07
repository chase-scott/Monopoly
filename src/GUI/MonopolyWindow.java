package GUI;

import javax.swing.*;
import Monopoly.*;

import java.awt.*;

/**
 * @version 1.0
 * @author Chase Scott 101092194
 */
public class MonopolyWindow extends JFrame {

    public final static Color[] PLAYER_COLOURS = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN, Color.PINK, Color.MAGENTA};

    public MonopolyWindow(Game model) {
        super("Monopoly");

        model.setPlayers(generateWelcome());

        JPanel contents = new MonopolyGUI(model);
        this.setContentPane(contents);
        this.setSize(1500, 1200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    /**
     * Displays the prompt for how many players and their names, then compiles them into an array of Players.
     * @return  Player[],   the array of players
     */
    private Player[] generateWelcome() {
        int numPlayers = 0;
        try {
            numPlayers = (int) JOptionPane.showInputDialog(null,
                    "Select the number of\nplayers you would like.", "Monopoly",
                    JOptionPane.QUESTION_MESSAGE, null, new Object[]{2, 3, 4, 5, 6, 7, 8}, 0);
        } catch (NullPointerException e) {System.exit(0);}

        Object[] inputs = new Object[2 * numPlayers];
        for (int i = 0; i < inputs.length; i += 2) {
            inputs[i] = "Name";
            inputs[i + 1] = new JTextField();
        }

        JOptionPane.showConfirmDialog(null, inputs, "Input Player Names.", JOptionPane.OK_CANCEL_OPTION);

        Player[] players = new Player[numPlayers];

        for (int i = 0, j = 1; i < numPlayers; i++, j+=2) {
            if(inputs[j] instanceof JTextField) {
                if(((JTextField) inputs[j]).getText().isEmpty()) {
                    players[i] = new Player("No name given.", PLAYER_COLOURS[i]);
                } else {
                    players[i] = new Player(((JTextField) inputs[j]).getText(), PLAYER_COLOURS[i]);
                }

            }
        }

        return players;

    }
}
