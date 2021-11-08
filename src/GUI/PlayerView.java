package GUI;

import Monopoly.Game;
import Monopoly.Player;
import Monopoly.Property;

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
    private JButton rollDice = new JButton("Roll");
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
        this.rollDice.addActionListener(new rollDiceController());





        this.model.addMonopolyView(this);
    }

    private void createLayout() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder(this.model.getName()));

        Font font = new Font("Arial", Font.BOLD, 12);
        this.money.setFont(font);
        this.buyProperty.setFont(font);
        this.passTurn.setFont(font);
        this.rollDice.setFont(font);
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


        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 3;
        c.weighty = 0.75;
        c.gridx = 0;
        c.gridy = 1;
        this.add(propertyScrollList, c);


        c.gridwidth = 1;
        c.weighty = 0;
        c.weightx = 0.3;
        c.gridx = 0;
        c.gridy = 2;
        this.add(this.rollDice, c);

        c.weightx = 0.3;
        c.gridx = 1;
        c.gridy = 2;
        this.add(this.buyProperty, c);

        c.weightx = 0.3;
        c.gridx = 2;
        c.gridy = 2;
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

        passTurn.setEnabled(model.getDiceRolledStatus() && model.isTakingTurn());
        rollDice.setEnabled(!model.getDiceRolledStatus() && model.isTakingTurn());
        if(Game.getSquare(model.getPosition()) instanceof Property) {
            buyProperty.setEnabled(model.isTakingTurn() && ((Property) Game.getSquare(model.getPosition())).checkIfAvailable());
        } else {buyProperty.setEnabled(false);}
    }


    private class passTurnController implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.passTurn();
        }
    }

    private class rollDiceController implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.rollDice();
        }
    }



    private class BuyPropertyController implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.buySquare();
        }
    }




}