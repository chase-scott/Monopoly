package Monopoly;

import java.awt.*;
import java.util.ArrayList;

public class Rail extends Square{

    /**
     * Super constructor for a square
     *
     * @param name String, the name of the square
     */
    GameBoard gameBoard= new GameBoard();
    private final int  price = 200;
    private int amountOwed;
    private Player ownedBy = null;
    public Rail(String name, GameBoard gameBoard) {
        super(name);
        this.gameBoard = gameBoard;
    }

    public Player getOwner() {
        return ownedBy;
    }

    public void setOwner(Player currentPlayer){
        ownedBy = currentPlayer;
        //double playerMoney = currentPlayer.getMoney();
        //currentPlayer.setMoney(playerMoney-200);
    }

    public boolean checkIfAvailable(){
        return getOwner() == null;
    }

    @Override
    public void squareAction(Player player) {
        if(ownedBy != null && ownedBy != player) {
            int count = 0;
            for (int i = 11; i < 27; i=i+14){
                Square railSquare = gameBoard.getSquare(i);

                if(((Rail)railSquare).getOwner()==ownedBy){
                    count++;
                }
            }
            if (count == 1){
                amountOwed = 5;	    }

            if (count == 2){
                amountOwed = 100;
            }

            // take 200
            if (player.getMoney() - amountOwed < 0) {
                ownedBy.setMoney(ownedBy.getMoney() + player.getMoney());
                player.setMoney(0);
                player.becomeBankrupt();
            } else {
                player.setMoney(player.getMoney() - amountOwed);
                ownedBy.setMoney(ownedBy.getMoney() + amountOwed);
            }
            ownedBy.updateViews();
        }
    }

    @Override
    public Color getColour() {
        return null;
    }
}