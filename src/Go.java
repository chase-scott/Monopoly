public class Go extends Square {

    public Go(String name) {
        super(name);
    }

    @Override
    public void squareAction(Player player) {
        System.out.println("Landed on GO! +$200");
    }
}
