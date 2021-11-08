package GUI;

import Monopoly.Game;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @author Chase Scott 101092194
 */
public class MonopolyGUI extends JPanel {

    public MonopolyGUI(Game model) {
        super();

        JPanel playerPanel = this.generatePlayerPanel(model);

        JPanel propertyPanel = this.generateBoardPanel(model);
        propertyPanel.setPreferredSize(new Dimension(800, 800)); //temporary

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

    private JPanel generateBoardPanel(Game model) {
        JPanel panel = new JPanel();

        panel.add(new SquareView(Game.getSquare(0)));
































        return panel;
    }



}
