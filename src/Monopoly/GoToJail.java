package Monopoly;

import java.awt.*;

public class GoToJail extends Square{
    /**
     * A GoToJail square
     *
     * if player lands here they are sent to jail
     * must stay there for three turns or until player rolls doubles
     * or pays 50 dollar fine
     *
     *  @author Chase Scott 101092194
     *  @author Amith Kumar Das Orko 101126245
     */
    public GoToJail(String name) {
        super(name);
    }

    @Override
    public void squareAction(Player player) {
        player.goToJail();
    }

    @Override
    public Color getColour() {
        return null;
    }
}
