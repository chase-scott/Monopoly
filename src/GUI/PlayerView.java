package GUI;

import Monopoly.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @version 1.0
 * @author Chase Scott 101092194
 */
public class PlayerView extends JPanel implements MonopolyView {

    private JLabel money;                                               //this players money
    private JButton buyProperty = new JButton("Buy Property");      //button to buy property
    private JButton passTurn = new JButton("Pass");                 //button to pass the turn
    private JButton rollDice = new JButton("Roll");                 //button to roll the dice
    private JList<String> ownedProperties = new JList<>();              //list of owned properties
    private Player model;                                               //the model associated with this view

    /**
     * Constructor for a player view
     *
     * @param model    Player, the model
     */
    public PlayerView(Player model) {
        super();
        this.model = model;
        money = new JLabel(String.valueOf(model.getMoney()));
        this.createLayout();

        //add controllers
        this.passTurn.addActionListener(new PassTurnController());
        this.buyProperty.addActionListener(new BuyPropertyController());
        this.rollDice.addActionListener(new RollDiceController());
        this.ownedProperties.addMouseListener(new BuildHouseController());

        this.model.addMonopolyView(this);
    }

    /**
     * Create the layout for a PlayerView panel
     */
    private void createLayout() {
        this.setPreferredSize(new Dimension(450,200));
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder(this.model.getName()));

        Font font = new Font("Arial", Font.BOLD, 12);
        this.money.setFont(font);
        this.buyProperty.setFont(font);
        this.passTurn.setFont(font);
        this.rollDice.setFont(font);
        this.ownedProperties.setFont(font);
        this.ownedProperties.setVisible(true);
        this.ownedProperties.setSelectionMode(0);

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

        if(model instanceof HumanPlayer) {
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
    }

    /**
     * Paints the component
     *
     * @param g Graphics, the graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(this.getBackground());
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(model.getTokenColour());
        Insets insets = this.getInsets();
        g.fillOval(this.getWidth() - insets.right - 20, insets.top - 8, 20, 20);

        this.paintComponents(g);
    }

    /**
     * Updates this components view
     */
    @Override
    public void updateView() {
        this.money.setText("$" + this.model.getMoney());
        this.ownedProperties.setListData(this.model.getPropertyList());

        passTurn.setEnabled(model.getDice().isRolled() && model.isTakingTurn());
        rollDice.setEnabled(!model.getDice().isRolled() && model.isTakingTurn());
        ownedProperties.setEnabled(model.isTakingTurn());


        if(Game.getSquare(model.getPosition()) instanceof Property) {
            buyProperty.setEnabled(model.isTakingTurn() && ((Property) Game.getSquare(model.getPosition())).checkIfAvailable());
        } else if (Game.getSquare(model.getPosition()) instanceof Utility) {
            buyProperty.setEnabled(model.isTakingTurn() && ((Utility) Game.getSquare(model.getPosition())).checkIfAvailable());
        } else {buyProperty.setEnabled(false);}
    }

    /**
     * passTurnController class
     */
    private class PassTurnController implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.passTurn();
        }
    }

    /**
     * rollDiceController class
     */
    private class RollDiceController implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.rollDice();
        }
    }

    /**
     * buyPropertyController class
     */
    private class BuyPropertyController implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
                model.buySquare();
        }
    }

    /**
     * BuildHouseController class
     */
    private class BuildHouseController implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            model.buildHouse(ownedProperties.getSelectedIndex());
        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    }





}