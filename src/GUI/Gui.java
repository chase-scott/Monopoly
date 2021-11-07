package GUI;
import java.awt.*;
import java.util.ArrayList;

import Monopoly.Dice;
import Monopoly.Game;
import Monopoly.GameBoard;

import javax.swing.*;

/**
 * @version 1.0
 * @author Chase Scott 101092194
 * @author Amith Kumar Das Orko 101126245
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    public Gui() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        try {
            //Setup the Layout
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            GridBagLayout thisLayout = new GridBagLayout();
            thisLayout.rowWeights = new double[] { 0.2, 0.2, 0.2, 0.2, 0.2,
                    0.2, 0.2, 0.2, 0.2 };
            thisLayout.columnWeights = new double[] { 0.2, 0.2, 0.2, 0.2, 0.2,
                    0.2, 0.2, 0.2, 0.2 };
            frame.getContentPane().setLayout(thisLayout);

            //Default Grid values
            int gridX = 0;
            int gridY = 0;
            //Add Panels for Each of the four sides
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < 8; i++) {
                    JPanel tempPanel = new JPanel();
                    switch(j)
                    {
                        case 0://Top Spaces
                            gridX = i;
                            gridY = 0;
                            break;
                        case 1://Left Spaces
                            gridX = 0;
                            gridY = i;
                            break;
                        case 2://Right Spaces
                            gridX = 7;
                            gridY = i;
                            break;
                        case 3://Bottom Spaces
                            gridX = i;
                            gridY = 7;
                            break;
                    }
                    frame.getContentPane().add(tempPanel,
                            new GridBagConstraints(gridX,// XGridSpot
                                    gridY,// YGridSpot
                                    1,// XGridSpaces
                                    1,// YGridSpaces
                                    0.0, 0.0, GridBagConstraints.CENTER,
                                    GridBagConstraints.BOTH,//Fill
                                    new Insets(0, 0, 0, 0), 0, 0));
                    tempPanel.setBorder(BorderFactory
                            .createLineBorder(Color.BLACK));

                }
            }

            {// Main Inner Area Notice Starts at (1,1) and takes up 7x7
                JPanel innerPanel = new JPanel();
                frame.getContentPane().add(
                        innerPanel,
                        new GridBagConstraints(1,
                                1,
                                7,
                                7,
                                0.0, 0.0,
                                GridBagConstraints.CENTER,
                                GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
            }
            frame.pack();
            frame.setSize(300, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }


        frame.add(panel);
        frame.setSize(400,400);
        frame.setVisible(true);




    }
    public static void main(String args[]) {
        Gui gui = new Gui();

    }
}