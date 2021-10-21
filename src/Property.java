public class Property extends Square {

    private double price;
    private double rentRate;
    private Player ownedBy = null;

    public Property(String name, double price, double rentRate) {
        super(name);
        this.rentRate = rentRate;
        this.price = price;
    }
    public int getPrice(){
        return (int)price;
    }

    public int getRent(){
        return (int)(rentRate * price);
    }
    public Player getOwner() {
        return ownedBy;
    }

    public void setOwner(Player currentPlayer){
        ownedBy = currentPlayer;
    }

    public boolean checkIfAvailable(){
        if(getOwner() == null){
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Square o) {
        return 0;
    }
}
