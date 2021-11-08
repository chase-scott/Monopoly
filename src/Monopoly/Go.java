package Monopoly;

public class Go extends Square {

    public Go(String name) {
        super(name);
    }


    @Override
    public void squareAction(Player player) {

    }

    @Override
    public String toString() {
        return "\n\n" + super.getName();
    }

}
