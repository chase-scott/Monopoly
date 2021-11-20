package Monopoly;

import java.awt.*;

public class Utilities extends Square{
    /**
     * Super constructor for a square
     *
     * @param name String, the name of the square
     */
    private final int  price = 150;
    private int amountOwed;
    GameBoard gameBoard= new GameBoard();
    private Player ownedBy = null;


    public Utilities(String name,GameBoard gameBoard) {
        super(name);
        this.gameBoard=gameBoard;
    }

    public Player getOwner() {
        return ownedBy;
    }

    public void setOwner(Player currentPlayer){
        ownedBy = currentPlayer;
        //double playerMoney = currentPlayer.getMoney();
        //currentPlayer.setMoney(playerMoney-200);
    }

    @Override
    public void squareAction(Player player) {
        if(ownedBy != null && ownedBy != player) {
            int playerRoll = player.getDiceVal();
            Square u1 = gameBoard.getSquare(3);
            Square u2 = gameBoard.getSquare(17);
            if(((Utilities)u1).getOwner()==ownedBy && ((Utilities)u2).getOwner()==ownedBy ){
                amountOwed=10*playerRoll;
            }else{
                amountOwed=4*playerRoll;
            }
        }

    }

    @Override
    public Color getColour() {
        return null;
    }
}
