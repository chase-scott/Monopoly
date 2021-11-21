package Monopoly;

import java.awt.*;

public class Jail extends Square {

    /**
     * A Jail square
     * if player lands here they are just "visiting"
     *  @author Chase Scott 101092194
     *  @author Amith Kumar Das Orko 101126245
     */
    boolean inJail;
    public Jail(String name) {
        super(name);
    }
    public Player getOwner() {
        return null;
    }

    /**
     * The go square action, currently does nothing
     *
     * @param player    Monopoly.Player, the player on this square
     */
    @Override
    public void squareAction(Player player) {
        if (player.isInJail()) {
            if(player.payOutOfJail()){
                //nothing happens ig this is pointless
            }
        }
    }

    @Override
    public Color getColour() {
        return null;
    }
}
