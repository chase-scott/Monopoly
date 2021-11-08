package Monopoly;

import java.awt.*;

public class Go extends Square {

    public Go(String name) {
        super(name);
    }


    @Override
    public void squareAction(Player player) {

    }

    @Override
    public Color getColour() {
        return Color.WHITE;
    }

    @Override
    public String toString() {
        return "\n\n" + super.getName();
    }

}
