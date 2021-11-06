package GUI;

import Monopoly.Player;
import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @author Chase Scott 101092194
 */
public class PlayerView extends JPanel implements MonopolyView {

    private JLabel money = new JLabel("$1500");
    private JButton buyProperty = new JButton("Buy Property");
    private JButton passTurn = new JButton("Pass");
    private JList<String> ownedProperties = new JList<>();
    private Player model;

    public PlayerView(Player player) {
        super();
        this.model = player;

        this.layoutView();
        //CREATE TEST LISTENERS //TODO make these their own controller classes
        buyProperty.addActionListener(e -> {
            model.setMoney(model.getMoney() - 100);
            updateView();
        });




        //CREATE LISTENERS
        this.model.addMonopolyView(this);
    }

    private void layoutView()
    {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder(this.model.getName()));

        this.money.setFont(new Font("Arial", Font.BOLD, 12));
        this.buyProperty.setFont(new Font("Arial", Font.BOLD, 12));
        this.passTurn.setFont(new Font("Arial", Font.BOLD, 12));
        this.ownedProperties.setFont(new Font("Arial", Font.BOLD, 12));

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
    public void updateView() {
        this.money.setText("$" + this.model.getMoney());
        this.ownedProperties.setListData(this.model.getPropertyList());


    }
}
