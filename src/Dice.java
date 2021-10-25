/**
 * Roll and return value of the two dice
 * @author Amith Kumar Das Orko 101126245
 */
public class Dice {

    private int[] dice;
    private boolean rolled;

    public Dice() {
        this.dice = new int[2];
        this.rolled = false;
    }


    public int roll(){

        dice[0] = (int) (Math.random() * 6 + 1);
        dice[1] = (int) (Math.random() * 6 + 1);
        System.out.println("Rolled a " + dice[0] + " and " + dice[1]);

        if(dice[0] == dice[1]) {
            System.out.println("You rolled DOUBLE!");
        } else {
            rolled = true;
        }
        return (dice[0] + dice[1]);

    }

    public int[] getDice() {return dice;}

    public boolean isRolled() {return rolled;}

    public void setRolled(boolean isRolled) {this.rolled = isRolled;}


}
