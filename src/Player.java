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

    public void setMoney(int money) {
        this.money = money;
    }

    public void playerMove(int rollResult){
        position += rollResult;

    }
    public void propertiesOwned(){

    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        for (Property p : propertyList) {info.append(p.getName()).append(", ");}

        return "Name = " + name + "\nMoney: $" + money + "\nProperties owned: " + info;
    }
}
