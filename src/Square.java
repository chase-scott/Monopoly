/**
 * Square class
 * @author Amith Kumar Das Orko 101126245
 */
public abstract class Square implements Comparable<Square>{

    private final String name;
    private int index;

    public Square(String name) {
        this.name = name;
    }

    public String getName(Player currentPlayer) {return name;}



}
