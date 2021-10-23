import java.util.*;

/**
 * Player class
 * @author Chase Scott 101092194
 * @author Amith Kumar Das Orko 101126245
 */
public class Player {

    private final String name;
    private double money;
    private int position;
    private List<Property> propertyList;

    public Player(String name) {
        this.name = name;
        this.money = 1500;
        this.position = 0;
        this.propertyList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }
    public int getPosition() { return position; }

    public void setMoney(double money) {
        this.money = money;
    }

    public void playerMove(int rollResult){
        int BOARD_SIZE = 23;
        position += rollResult;
        if(position >= BOARD_SIZE) {
            position -= BOARD_SIZE;
            money += 200;
            System.out.println("+$200 for passing GO");
        }
    }

    //TODO buy method

    public void buy(Property property) {
        if(property.checkIfAvailable()) {
            System.out.println(name + " has just bought " + property.getName());
            money -= property.getPrice();
            propertyList.add(property);
            property.setOwner(this);
            return;
        }

        System.out.println("This property is already owned by " + property.getOwner());

    }



    private String propertiesOwned(){
        if(propertyList.isEmpty()){
            return "Player owns nothing";
        }
        StringBuilder info = new StringBuilder();
        for (Property p : propertyList) {info.append(p.getName()).append(", ");}
        return info.toString();
    }

    @Override
    public String toString() {
        return "Name = " + name + "\nMoney: $" + money + "\nProperties owned: " + propertiesOwned();
    }
}
