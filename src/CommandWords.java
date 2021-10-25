import java.util.*;

/**
 * Map of command words with their corresponding string
 * @author Chase Scott 101092194
 */
public class CommandWords {

    private HashMap<String, CommandWord> commands; //hashmap of CommandWord and their string equivalents

    /**
     * Default constructor
     */
    public CommandWords() {
        commands = new HashMap<>();
        for(CommandWord c : CommandWord.values()) {
            if(c != CommandWord.UNKNOWN) {
                commands.put(c.toString(), c);
            }
        }
    }

    /**
     * Gets the command word given a command word string
     *
     * @param commandWord   String, the command word
     * @return  CommandWord, the command word
     */
    public CommandWord getCommandWord(String commandWord) {
        CommandWord command = commands.get(commandWord);
        return Objects.requireNonNullElse(command, CommandWord.UNKNOWN);
    }

    /**
     * Checks if the given string matches a valid command
     *
     * @param command   String, the command
     * @return  boolean, if it is a valid command
     */
    public boolean isCommand(String command) { return commands.containsKey(command); }

    /**
     * Prints a list of all valid commands
     */
    public void showAll() {
        for(String c : commands.keySet()) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

}
