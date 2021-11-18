package Monopoly;

import java.util.ArrayList;

public class Rail extends Property{

    /**
     * Constructor for initializing a property square
     *
     * @param name   String, the name of the property
     * @param price  double, the price of the property
     * @param colour Colour, the colour of the property
     */
    private int amountOwed;

    public Rail(String name, double price, Colours colour, int amountOwed) {
        super(name, price, colour);
        this.amountOwed=amountOwed;
    }

    public void handlePlayer(Player player) {
        if(this.getOwner()!=null){
            int count=0;
            Player ownedBy = this.getOwner();
            //ownedBy.getPropertyList();
            if (count == 1){
                amountOwed = 25;	    }
            //take 25
            if (count == 2){
                amountOwed = 50;
            }
            // take 50
            if (count == 3){
                amountOwed = 100;
            }
            // take 100
            if (count == 4){
                amountOwed = 200;
            }
            player.setMoney(player.getMoney() - amountOwed);
            ownedBy.setMoney(ownedBy.getMoney() + amountOwed);
            ownedBy.updateViews();
            }
        }

}