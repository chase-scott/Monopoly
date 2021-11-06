package GUI;

import Monopoly.Square;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class GUIsquares extends JPanel {
    private JLabel labelInfo;
    private Square square;
    int maxPlayer = 4;
    public JLabel[] labelPlayer = new JLabel[maxPlayer];

    public GUIsquares(Square square){
        this.square=square;
        setLayout(new OverlayLayout(this));
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        JPanel panelPlayer = new JPanel();
        panelPlayer.setLayout(new GridLayout(2, 4));
        panelPlayer.setOpaque(false);
        createPlayerLabels(panelPlayer);
        squareInfoGUI();
        add(panelPlayer);
        setPreferredSize(new Dimension(100,100));
        this.doLayout();
    }

    private void squareInfoGUI() {
        labelInfo = new JLabel();
        displayInfoSquare();
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new GridLayout(1, 1));
        panelInfo.add(labelInfo);
        add(panelInfo);
    }

    private void displayInfoSquare() {
    }

    private void createPlayerLabels(JPanel panelPlayer) {
        for (int i = 0; i < maxPlayer; i++) {
            labelPlayer[i] = new JLabel();
            panelPlayer.add(labelPlayer[i]);
        }
    }


}
