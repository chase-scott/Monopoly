package Monopoly;

import GUI.SquareView;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Abstract class for a game board square
 *
 * @author Chase Scott 101092194
 */
public abstract class Square {

    private List<SquareView> views;
    private final String name;
    private List<Player> players;

    /**
     * Super constructor for a square
     *
     * @param name  String, the name of the square
     */
    public Square(String name) {
        this.name = name;
        views = new ArrayList<>();
        players = new ArrayList<>();

    }

    public String getName() {return name;}

    /**
     * Abstract method for a square, to be implemented in child classes
     *
     * @param player    Monopoly.Player, the player on this square
     */
    public abstract void squareAction(Player player);

    /**
     * Abstract method for getting the colour of a square
     *
     * @return  Color, the colour of the square
     */
    public abstract Color getColour();

    /**
     * Adds a monopoly view
     * @param view  MonopolyView, the view
     */
    public void addView(SquareView view) {
        views.add(view);
    }

    /**
     * Updates each view.
     */
    protected synchronized void updateViews() {
        views.forEach(SquareView::updateView);
    }

    public ArrayList<Player> getPlayers() {
        return (ArrayList<Player>) players;
    }

    public void addPlayer(Player player) { players.add(player);}

    public void removePlayer(Player player) {
        players.remove(player);
    }

}
