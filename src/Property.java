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

    @Override
    public void squareAction(Player player) {
        if(ownedBy != null && ownedBy != player) {
            System.out.println(player.getName() + " pays $"  + rentRate * price + " to " + ownedBy.getName());

            double amountOwed = rentRate * price;

            //If player can't afford rent, give all of their money to player and make them bankrupt.
            if(player.getMoney() - amountOwed < 0) {
                ownedBy.setMoney(ownedBy.getMoney() + player.getMoney());
                player.setMoney(0);player.setBankrupt(true);
                System.out.println(player.getName() + " is bankrupt!");
            } else {
                player.setMoney(player.getMoney() - amountOwed);
                ownedBy.setMoney(ownedBy.getMoney() + amountOwed);
            }
        }
    }

}
