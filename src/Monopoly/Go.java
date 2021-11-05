package Monopoly;

/**
 * A Monopoly.Go square
 *
 * @author Chase Scott 101092194
 */
public class Go extends Square {

    public Go(String name) {
        super(name);
    }

    /**
     * The go square action, currently does nothing
     *
     * @param player    Monopoly.Player, the player on this square
     */
    @Override
    public void squareAction(Player player) {
        //do nothing
    }
}
