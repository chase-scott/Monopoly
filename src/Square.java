/**
 * Abstract class for a game board square
 *
 * @author Chase Scott 101092194
 */
public abstract class Square {

    private final String name;

    /**
     * Super constructor for a square
     *
     * @param name  String, the name of the square
     */
    public Square(String name) {
        this.name = name;
    }

    public String getName() {return name;}

    /**
     * Abstract method for a square, to be implemented in child classes
     *
     * @param player    Player, the player on this square
     */
    public abstract void squareAction(Player player);

}
