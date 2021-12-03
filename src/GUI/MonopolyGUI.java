package GUI;

import Monopoly.Game;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * @version 1.0
 * @author Chase Scott 101092194
 */
public class MonopolyGUI extends JPanel {

    public MonopolyGUI(Game model) {
        super();

        JPanel playerPanel = this.generatePlayerPanel(model);
        JPanel propertyPanel = this.generateBoardPanel(model);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(propertyPanel);
        this.add(playerPanel);

        Thread thread = new Thread(new MonopolyThread(model));
        thread.start();
    }

    /**
     * Generates the panel that contains the player information
     *
     * @param model Game, the model
     * @return  JPanel, the player panel
     */
    private JPanel generatePlayerPanel(Game model) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        int numPlayers = model.getNumberPlayers();
        for(int i = 0; i < numPlayers; i++)
        {  PlayerView view = new PlayerView(model.getPlayer(i));
            panel.add(view);
        }
        return panel;
    }

    /**
     * Generates the panel that contains the game board
     *
     * @return  JPanel, the game board panel
     */
    private JPanel generateBoardPanel(Game model) {
        JPanel panel = new JPanel();

        panel.setPreferredSize(new Dimension(1000, 1000));
        panel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setPreferredSize(new Dimension(1000, 125));
        for(int i = 0; i < 8; i++) {
            topPanel.add(new SquareView(model.getSquare(i)));
        }

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(6, 1));
        rightPanel.setPreferredSize(new Dimension(150, 750));
        for(int i = 8; i < 14; i++) {
            rightPanel.add(new SquareView(model.getSquare(i)));
        }

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.setPreferredSize(new Dimension(1000, 125));
        for(int i = 21; i > 13; i--) {
            bottomPanel.add(new SquareView(model.getSquare(i)));
        }

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(6, 1));
        leftPanel.setPreferredSize(new Dimension(150, 750));
        for (int i = 27; i > 21; i--) {
            leftPanel.add(new SquareView(model.getSquare(i)));
        }

        //Add monopolyLogo
        ImageIcon monopolyLogo = new ImageIcon(Objects.requireNonNull(getClass().getResource("monopolyLogo.png")));
        JLabel centerPanel = new JLabel(monopolyLogo, JLabel.CENTER);
        centerPanel.setPreferredSize(new Dimension(750,750));

        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(rightPanel, BorderLayout.LINE_END);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        panel.add(leftPanel, BorderLayout.LINE_START);


        return panel;
    }



}
