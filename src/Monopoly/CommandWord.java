package Monopoly;

/**
 * Enumeration of command words for game.
 * @author Chase Scott 101092194
 */
public enum CommandWord {

    /**
     * The commands for the game monopoly
     */
    ROLL("roll"), STATE("state"), BUY("buy"), PASS("pass"),
    HELP("help"), QUIT("quit"), UNKNOWN("?");


    private final String commandString; //the string associated with the command

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    @Override
    public String toString() {
        return commandString;
    }

}
