package Monopoly;

import GUI.MonopolyView;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Abstract class for a game board square
 *
 * @author Chase Scott 101092194
 */
public abstract class Square {

    private List<MonopolyView> views;
    private final String name;
    ArrayList<Player> players;

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
     * Adds a monopoly view
     * @param view  MonopolyView, the view
     */
    public void addView(MonopolyView view) {
        views.add(view);
    }

    /**
     * Updates each view.
     */
    protected synchronized void updateViews() {
        views.forEach(MonopolyView::updateView);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) { players.add(player);}

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public abstract Color getColour();




}
