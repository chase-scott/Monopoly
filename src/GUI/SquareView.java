package GUI;

import Monopoly.Player;
import Monopoly.Square;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author Chase Scott 101092194
 */
public class SquareView extends JPanel implements MonopolyView {

    private Square model;                           //this views model
    private JTextArea textArea = new JTextArea();   //this views description

    /**
     * Constructor for a SquareView
     *
     * @param square    Square, the model
     */
    public SquareView(Square square) {
        super();
        this.model = square;
        this.createLayout();
        this.model.addView(this);

    }

    /**
     * Create the layout for a SquareView panel
     */
    private void createLayout() {
        this.setLayout(new GridLayout());
        this.add(textArea);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setPreferredSize(new Dimension( 125, 125)); //DELETE

        Font font = new Font("Arial", Font.BOLD, 12);
        this.textArea.setFont(font);
        this.textArea.setOpaque(false);
        this.textArea.setEditable(false);
        updateView();
    }

    /**
     * Updates the view of this panel
     */
    @Override
    public void updateView() {
        this.textArea.setText(this.model.toString());
        this.repaint();
    }

    /**
     * Paints the colour and tokens on this view
     * @param g Graphics, the graphics
     */
    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(this.getBackground());
        g.fillRect(0, 0, this.getWidth(), (2*this.getHeight()) / 3);
        g.setColor(model.getColour());
        g.fillRect(0, (2*this.getHeight())/3, this.getWidth(), this.getHeight() / 3);

        ArrayList<Player> playersHere = this.model.getPlayers();
        for (int i = 0; i < playersHere.size(); i++) {
            g.setColor(playersHere.get(i).getTokenColour());
            g.fillOval(i * 20, 0, 20, 20);
        }
    }
}
