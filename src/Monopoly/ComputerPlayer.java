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

    @Override
    public synchronized void makeMove() {

        this.takingTurn = true;
        super.rollDice();

        //TODO buy square landed on, must override buySquare()

        //TODO build houses if it can, must override buildHouse()


        this.takingTurn = false;
        dice.setRolled(false);
        updateViews();
    }



}
