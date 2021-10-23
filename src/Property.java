public class Property extends Square {

    private double price;
    private double rentRate;
    private Player ownedBy = null;
    private String colour;

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

    @Override
    public void squareAction(Player player) {
        System.out.println("Property Action"); //TODO
        if(ownedBy != null) {
            System.out.println(player.getName() + " pays $"  + rentRate * price);
            player.setMoney(player.getMoney() - rentRate * price);
            ownedBy.setMoney(ownedBy.getMoney() + rentRate * price);
        }


    }
}
