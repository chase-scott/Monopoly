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
    private int currentRent;

    public Rail(String name, double price, Colours colour) {
        super(name, price, colour);
    }

    public void handlePlayer(Player player) {
        if(this.getOwner()!=null){
            Player ownedBy = this.getOwner();
            ownedBy.getPropertyList();

            }
        }

}