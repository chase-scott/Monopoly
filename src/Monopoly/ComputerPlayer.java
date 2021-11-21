package Monopoly;

import javax.swing.*;
import java.awt.*;

public class ComputerPlayer extends Player {

    /**
     * Constructor for an AI player
     *
     * @param name      String, the name of the player
     * @param colour    Color, the colour of the player
     */
    public ComputerPlayer(String name, Color colour) {
        super(name, colour);
    }

    /**
     * Buys the square that the player is on if it is a property square.
     */
    public void buySquare() {
        if(Game.getSquare(getPosition()) instanceof Property) {
            Property propertyToBuy = (Property) Game.getSquare(getPosition());

            if (getMoney() < propertyToBuy.getPrice()) {
                return;
            }
            setMoney(getMoney() - propertyToBuy.getPrice());
            addProperty(propertyToBuy);
            propertyToBuy.setOwner(this);

            updateViews();
            Game.getSquare(getPosition()).updateViews();
        }
    }



    @Override
    public synchronized void makeMove() {


        rollDice();

        //TODO buy square landed on, must override buySquare()
        buySquare();

        //TODO build houses if it can, must override buildHouse()


        updateViews();
    }



}
