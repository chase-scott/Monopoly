package Monopoly;

import javax.swing.*;

/**
 * Roll and return value of the two dice
 * @author Amith Kumar Das Orko 101126245
 * @author Chase Scott 101092194
 */
public class Dice {

    private int[] dice;     //the game dice
    private boolean rolled; //whether the dice has been rolled this turn

    public Dice() {
        this.dice = new int[2];
        this.rolled = false;
    }

    /**
     * Rolls the dice once and returns the result
     *
     * @return  int, the result of the roll
     */
    public int[] roll(){

        dice[0] = (int) (Math.random() * 6 + 1);
        dice[1] = (int) (Math.random() * 6 + 1);

        if(dice[0] != dice[1]) rolled = true;

        //return dice;
        return new int[] {1,0};
    }

    public boolean isRolled() {return rolled;}

    public void setRolled(boolean isRolled) {this.rolled = isRolled;}

}