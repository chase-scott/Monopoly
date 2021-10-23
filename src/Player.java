import java.util.ArrayList;

/**
 * Player class
 * @author Chase Scott 101092194
 * @author Amith Kumar Das Orko 101126245
 */
public class Player {

    private final String name;
    private double money;
    private int position;
    private ArrayList<Property> properties = new ArrayList<Property>();


    public Player(String name) {
        this.name = name;
        this.money = 1500;
        position = 0;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }
    public int getPosition() { return position; }

    public void setMoney(int money) {
        this.money = money;
    }

    public void playerMove(int diceRoll){
        position += diceRoll;

        //given that the board has 12 squares
        if(position>=12){ //reaches starting point
            money += 200;
            position = position % 12;
        }
    }
    public void propertiesOwned(){
        if(properties.isEmpty()){
            System.out.println("Player owns nothing");
        }
        for(Property property : properties){
            System.out.println(property);
        }
    }
    public void addRent(int rentReceivig){
        money += rentReceivig;
        System.out.println("Received rent $"+rentReceivig);
    }
    public void giveRent(int rent, Player rentToPlayer){
        if(money>rent){
            money-=rent;
            rentToPlayer.addRent(rent);
            System.out.println("Pay rent $"+rent+" to "+ rentToPlayer);
        }

    }

}
