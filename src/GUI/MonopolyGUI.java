package GUI;

import Monopoly.Game;

import javax.swing.*;

/**
 * @version 1.0
 * @author Chase Scott 101092194
 */
public class MonopolyGUI extends JPanel {

    public MonopolyGUI(Game model) {
        super();

        JPanel playerPanel = this.generatePlayerPanel(model);





        JPanel propertyPanel = new JPanel();


        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(propertyPanel);
        this.add(playerPanel);


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
        for(int i=0; i<numPlayers; i++)
        {  PlayerView pv = new PlayerView(model.getPlayer(i));
            panel.add(pv);
        }
        return panel;
    }





}
