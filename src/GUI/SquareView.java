package GUI;

import Monopoly.Player;
import Monopoly.Property;
import Monopoly.Square;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author Chase Scott 101092194
 */
public class SquareView extends JPanel implements MonopolyView {

    private Square model;
    private JTextArea textArea = new JTextArea();

    public SquareView(Square square) {
        super();
        this.model = square;

        this.createLayout();
        this.model.addView(this);

    }

    private void createLayout() {
        this.setLayout(new GridLayout());
        this.add(textArea);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setPreferredSize(new Dimension( 100, 100)); //DELETE

        Font font = new Font("Arial", Font.BOLD, 12);
        this.textArea.setFont(font);
        this.textArea.setOpaque(false);
        this.textArea.setEditable(false);
        updateView();
    }

    @Override
    public void updateView() {
        this.textArea.setText(this.model.toString());
        this.repaint();
    }

    //TODO should paint the players that are on this square
    @Override
    protected void paintComponent(Graphics g) {
        if(model instanceof Property) {
            g.setColor(((Property) model).getColour());
            g.fillRect(0, (2*this.getHeight())/3, this.getWidth(), this.getHeight() / 3);
        }
        ArrayList<Player> playersHere = this.model.getPlayers();
        for (int i = 0; i < playersHere.size(); i++) {
            g.setColor(playersHere.get(i).getTokenColour());
            g.fillOval(i * 20, 0, 20, 20);
        }
    }
}
