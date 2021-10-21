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

    public int currentRoll(){
        return dice1 + dice2;
    }

    public boolean isDouble(){
        return dice1 == dice2;
    }
}