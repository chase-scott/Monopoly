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
     * Buys the square that the player is on if it is a property or utility square.
     */
    public void buySquare() {
        if(Game.getSquare(getPosition()) instanceof Property) {
            if (((Property) Game.getSquare(getPosition())).checkIfAvailable())
                super.buySquare();
        } else if(Game.getSquare(getPosition()) instanceof Utility) {
            if (((Utility) Game.getSquare(getPosition())).checkIfAvailable())
                super.buySquare();
        }
    }

    @Override
    public synchronized void makeMove() {

        //handle jail scenario for AI
        jailLogic();

        //roll the dice and advance this AI player
        rollDice();
        //buy the square the AI is on if it can
        buySquare();
        //build a house on a random property that this AI owns
        if(!getPropertyList().isEmpty()) super.buildHouse((int) (Math.random() * getPropertyList().size()));
        updateViews();

        passTurn();
    }

}
