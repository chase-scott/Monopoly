/**
 * enum for property colours
 * @author Chase Scott 101092194
 */
public enum Colours {
    TEAL(0.1), BROWN(0.2), PINK(0.2), ORANGE(0.3), BLUE(0.5), RED(0.1), YELLOW(0.4), GREEN(0.4);

    private final double rentRate;

    Colours(double rentRate) {
        this.rentRate = rentRate;
    }

    public double getRentRate() {
        return rentRate;
    }
}
