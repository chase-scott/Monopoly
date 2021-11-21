package Monopoly;

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
        if(Game.getSquare(getPosition()) instanceof Property) super.buySquare();
    }

    @Override
    public synchronized void makeMove() {
        //roll the dice and advance this AI player
        rollDice();
        //buy the square the AI is on if it can
        buySquare();
        //build a house on a random property that this AI owns
        if(!getPropertyList().isEmpty()) super.buildHouse((int) (Math.random() * getPropertyList().size()));
        updateViews();
    }

}
