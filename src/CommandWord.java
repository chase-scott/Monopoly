/**
 * Enumeration of command words for game.
 * @author Chase Scott 101092194
 */
public enum CommandWord {

    ROLL("roll"), STATE("state"), BUY("buy"), PASS("pass"),
    HELP("help"), QUIT("quit"), BUILD("build"), UNKNOWN("?");

    private final String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    @Override
    public String toString() {
        return commandString;
    }

}
