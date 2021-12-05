package GUI;

import javax.swing.*;
import Monopoly.*;
import java.awt.*;
import java.util.Objects;

/**
 * @version 1.0
 * @author Chase Scott 101092194
 */
public class MonopolyFrame extends JFrame {

    public final static Color[] PLAYER_COLOURS = {Color.RED, Color.ORANGE, Color.YELLOW,
            Color.GREEN, Color.BLUE, Color.CYAN, Color.PINK, Color.MAGENTA};    //The colours of the player's tokens

    private final Game model;

    /**
     * Constructor for the monopoly frame
     *
     * @param model Game, the model
     */
    public MonopolyFrame(Game model) {
        super("Monopoly");

        this.model = model;
        startMenu();

        if(model.getNumberPlayers() == 0) {
            chooseVersion();
            model.setPlayers(generateWelcome());
        }
        this.generateMenuBar();

        JPanel contents = new MonopolyGUI(model);
        this.setContentPane(contents);
        this.setMinimumSize(new Dimension((1000 + model.getNumberPlayers()*100), 1300));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void chooseVersion() {

        String returnValue = (String) JOptionPane.showInputDialog(null,
                    "Select the Version", "Monopoly",
                    JOptionPane.QUESTION_MESSAGE, null, GameBoard.VERSIONS, 0);

        if(returnValue == null) System.exit(0);

        model.setGameBoard(returnValue);

    }

    private void startMenu() {

        Object[] buttons = {"New Game", "Load Game"};

        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("monopolyIcon.png")));
        int returnValue = JOptionPane.showOptionDialog(null, "Welcome to Monopoly!",
                "Monopoly", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icon, buttons, buttons[0]);

        if(returnValue == -1) System.exit(0);
        if(returnValue == 1) loadGame();

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
                    players[i] = new ComputerPlayer("AI Player " + (counter + 1), PLAYER_COLOURS[i], model);
                    counter++;
                } else {
                    players[i] = new HumanPlayer(((JTextField) inputs[j]).getText(), PLAYER_COLOURS[i], model);
                }
            }
        }

        return players;
    }

    private void generateMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem item;
        item = new JMenuItem("Save");
        item.addActionListener(e -> saveGame());
        fileMenu.add(item);
        item = new JMenuItem("Load");
        item.addActionListener(e -> loadGame());
        fileMenu.add(item);

    }

    private void saveGame() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a file to save");
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            model.writeToFile(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void loadGame() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a file to load");
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            model.readFile(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }


    public static void main(String[] args) {
        new MonopolyFrame(new Game());

    }

}