package GUI;

import Monopoly.Game;

/**
 * Creates a thread for the monopoly GUI
 * Necessary so the game doesn't freeze
 * @author Chase Scott 101092194
 */
public class MonopolyThread implements Runnable {
    private Game model;

    public MonopolyThread(Game game) {
        super();
        this.model = game;
    }

    /**
     * Starts the game loop thread.
     */
    @Override
    public void run() {
        model.play();
    }

}
