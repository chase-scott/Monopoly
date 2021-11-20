package Monopoly;

import java.awt.*;

public class Utilities extends Square{
    /**
     * Super constructor for a square
     *
     * @param name String, the name of the square
     */
    private final int  price = 150;
    private static Dice dice = new Dice();
    private int amountOwed;
    GameBoard gameBoard= new GameBoard();
    private Player ownedBy = null;
    public Utilities(String name, Dice dice,GameBoard gameBoard) {
        super(name);
        this.gameBoard=gameBoard;
        this.dice=dice;
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
            int playerRoll = dice.roll();
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
