/**
 * Player class
 * @author Chase Scott 101092194
 * @author Amith Kumar Das Orko 101126245
 */
public class Player {

    private final String name;
    private double money;
    private int position;

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

    public void playerMove(){

    }
    public void propertiesOwned(){

    }
}
