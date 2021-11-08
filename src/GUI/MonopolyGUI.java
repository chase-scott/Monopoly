package GUI;

import Monopoly.Game;
import Monopoly.GameBoard;

import javax.swing.*;

/**
 * @version 1.0
 * @author Chase Scott 101092194
 */
public class MonopolyGUI extends JPanel {

    public MonopolyGUI(Game model) {
        super();

        JPanel playerPanel = this.generatePlayerPanel(model);
        JPanel propertyPanel = this.generateBoardPanel();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //this.add(propertyPanel);
        this.add(new BoardLayout().getBoardLayout());
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

    private JPanel generateBoardPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        for(int i = 0; i < GameBoard.BOARD_SIZE/3; i++) {
            panel.add(new SquareView(Game.getSquare(i)));
        }


        return panel;
    }



}
