public class Property extends Square {

    private final double price;
    private final double rentRate;
    private Player ownedBy = null;
    private final String colour;

    public Property(String name, double price, Colours colour) {
        super(name);
        this.price = price;
        this.rentRate = colour.getRentRate();
        this.colour = colour.name();
    }
    public int getPrice(){
        return (int)price;
    }
    public String getColour(){
        return colour;
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
        return getOwner() == null;
    }

    @Override //TODO bankruptcy handling
    public void squareAction(Player player) {
        if(ownedBy != null) {
            System.out.println(player.getName() + " pays $"  + rentRate * price + " to " + ownedBy.getName());
            player.setMoney(player.getMoney() - rentRate * price);
            ownedBy.setMoney(ownedBy.getMoney() + rentRate * price);
        }
    }

}
