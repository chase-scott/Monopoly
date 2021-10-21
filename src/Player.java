/**
 * Player abstract class
 * @author Chase Scott 101092194
 */
public class Player {

    private final String name;
    private double money;

    public Player(String name) {
        this.name = name;
        this.money = 1500;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
