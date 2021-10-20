/**
 * Player class
 * @author Chase Scott 101092194
 */
public abstract class Player {

    private final String name;
    private int money;

    public Player(String name) {
        this.name = name;
        this.money = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
