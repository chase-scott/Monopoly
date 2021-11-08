package GUI;

import Monopoly.Game;

import java.awt.*;
import javax.swing.*;


/**
 * @version 1.0
 * @author Chase Scott 101092194
 * @author Amith Kumar Das Orko 101126245
 */
public class BoardLayout extends JPanel {

    public BoardLayout() {

        super();
        this.setPreferredSize(new Dimension(1000, 1000));
        this.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setPreferredSize(new Dimension(1000, 125));
        for(int i = 0; i < 8; i++) {
            topPanel.add(new SquareView(Game.getSquare(i)));
        }

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(6, 1));
        rightPanel.setPreferredSize(new Dimension(150, 750));
        for(int i = 8; i < 14; i++) {
            rightPanel.add(new SquareView(Game.getSquare(i)));
        }

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.setPreferredSize(new Dimension(1000, 125));
        for(int i = 21; i > 13; i--) {
            bottomPanel.add(new SquareView(Game.getSquare(i)));
        }

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(6, 1));
        leftPanel.setPreferredSize(new Dimension(150, 750));
        for (int i = 27; i > 21; i--) {
            leftPanel.add(new SquareView(Game.getSquare(i)));
        }

        this.add(topPanel, BorderLayout.NORTH);
        this.add(rightPanel, BorderLayout.LINE_END);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.add(leftPanel, BorderLayout.LINE_START);

    }

    public JPanel getBoardLayout() {
        return this;
    }
}
