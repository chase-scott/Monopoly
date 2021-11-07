package GUI;

import Monopoly.Player;
import Monopoly.Square;
import javax.swing.*;
import java.awt.*;

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

        Font font = new Font("Arial", Font.BOLD, 12);
        this.textArea.setFont(font);
        this.textArea.setOpaque(false);
        this.textArea.setEditable(false);
    }

    @Override
    public void updateView() {
        this.textArea.setText(this.model.getName());
        this.repaint();
    }

    //TODO should paint the players that are on this square
    @Override
    protected void paintComponent(Graphics g) {

    }
}
