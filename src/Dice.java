/**
 * Roll and return value of the two dice
 */
public class Dice {
    private int dice1;
    private int dice2;

    public int roll(){
        System.out.println("Press space bar to roll");

        dice1 = (int) (Math.random() * 6 + 1);
        dice2 = (int) (Math.random() * 6 + 1);

        System.out.println("Rolled a " + dice1 + " and " + dice2);
        return dice1 + dice2;
    }

    /**
     * @return the value of the dice
     */
    public int rollValue(){
        return dice1 + dice2;
    }

    /**
     * Check if the dice rolls doubles
     */
    public boolean isDouble(){
        if(dice1 == dice2) {
            return true;
        }
        return false;
    }
    /**
     * Check if the dice rolls triples
     */
    public boolean isTriple(){
        if(dice1 == dice2 && isDouble()) {
            return true;
        }
        return false;
    }

}