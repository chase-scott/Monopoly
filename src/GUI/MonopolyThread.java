package GUI;

import Monopoly.Game;

public class MonopolyThread implements Runnable {
    private Game model;

    public MonopolyThread(Game game) {
        super();
        this.model = game;
    }

    public void run() {
        this.model.play();
    }

}
