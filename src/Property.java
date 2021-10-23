/**
 * Property class
 * @author Amith Kumar Das Orko 101126245
 */
public class Property extends Square {

    private double price;
    private double rentRate;
    private Player ownedBy = null;
    private String colors;

    public Property(String name, double price, double rentRate, String colors) {
        super(name);
        this.rentRate = rentRate;
        this.price = price;
        this.colors=colors;
    }
    public int getPrice(){
        return (int)price;
    }
    public String getColors(){
        return colors;
    }
    public void setColors(String c){
        colors=c;
    }

    public int getRent(){
        return (int)(rentRate * price);
    }
    public Player getOwner() {
        return ownedBy;
    }

    public void setOwner(Player currentPlayer){
        ownedBy = currentPlayer;
        System.out.println(currentPlayer + " now owns this property ");
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
