package GUI;

import Monopoly.Player;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @author Chase Scott 101092194
 */
public class PlayerView extends JPanel implements MonopolyView {

    private JLabel money;
    private JButton buyProperty = new JButton("Buy Property");
    private JButton passTurn = new JButton("Pass");
    private JList<String> ownedProperties = new JList<>();
    private Player model;

    public PlayerView(Player player) {
        super();
        this.model = player;
        money = new JLabel(String.valueOf(player.getMoney()));
        this.createLayout();

        //trying to get pass turn to work

        this.passTurn.addActionListener(new passTurnController());
        this.buyProperty.addActionListener(new BuyPropertyController());





        this.model.addMonopolyView(this);
    }

    private void createLayout() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder(this.model.getName()));

        Font font = new Font("Arial", Font.BOLD, 12);
        this.money.setFont(font);
        this.buyProperty.setFont(font);
        this.passTurn.setFont(font);
        this.ownedProperties.setFont(font);

        this.ownedProperties.setVisible(true);
        JScrollPane propertyScrollList = new JScrollPane(this.ownedProperties);
        propertyScrollList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        propertyScrollList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.25;
        c.weighty = 0.0;
        c.fill = GridBagConstraints.BOTH;
        this.add(this.money, c);
        c.gridx = 0;
        c.gridy++;
        c.weighty = 0.75;
        c.gridwidth = 4;
        this.add(propertyScrollList, c);
        c.gridy++;
        c.gridwidth = 2;
        c.weighty = 0.0;
        this.add(this.buyProperty, c);
        c.gridx++;
        c.weighty = 0.0;
        this.add(this.passTurn, c);

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(this.getBackground());
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(model.getTokenColour());
        Insets insets = this.getInsets();
        g.fillOval(this.getWidth() - insets.right - 20, insets.top - 8, 20, 20);

        this.paintComponents(g);
    }

    @Override
    public void updateView() {
        this.money.setText("$" + this.model.getMoney());
        this.ownedProperties.setListData(this.model.getPropertyList());

        passTurn.setEnabled(model.isTakingTurn());
        buyProperty.setEnabled(model.isTakingTurn());

    }


    private class passTurnController implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.passTurn();
        }
    }

    private class BuyPropertyController implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.buySquare();
        }
    }




}