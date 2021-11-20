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

    private Square model;                           //this views model
    private JTextArea textArea = new JTextArea();   //this views description

    /**
     * Constructor for a SquareView
     *
     * @param model    Square, the model
     */
    public SquareView(Square model) {
        super();
        this.model = model;
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

        //paint players here
        ArrayList<Player> playersHere = this.model.getPlayers();
        for (int i = 0; i < playersHere.size(); i++) {
            g.setColor(playersHere.get(i).getTokenColour());
            g.fillOval(i * 20, 0, 20, 20);
        }

        //paint houses built
        for (int i = 0; i < Math.random()*4; i++) {
            if (model instanceof Property) {
                //black outline
                g.setColor(Color.BLACK);
                g.fillRect(2 + (i * 25), this.getHeight() - 15, 22, 11);
                g.fillPolygon(new int[]{(i*25), 12+(i*25), 25+(i*25)},new int[]{this.getHeight()-15,
                        this.getHeight()-34, this.getHeight()-15}, 3);
                //green interior
                g.setColor(new Color(0,204,0));
                g.fillRect(3 + (i * 25), this.getHeight() - 15, 20, 10);

                g.fillPolygon(new int[]{1 + (i*25), 12+(i*25), 24+(i*25)},new int[]{this.getHeight()-15,
                        this.getHeight()-32, this.getHeight()-15}, 3);
            }
        }

    }
}
