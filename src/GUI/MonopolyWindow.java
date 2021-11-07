package GUI;

import javax.swing.*;
import Monopoly.*;

/**
 * @version 1.0
 * @author Chase Scott 101092194
 */
public class MonopolyWindow extends JFrame {

    public MonopolyWindow(Game model) {
        super("Monopoly");
        //JPanel contents = new MonopolyGUI(model);
       // this.setContentPane(contents);
        this.setSize(800, 700);
        this.setVisible(true);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

}
