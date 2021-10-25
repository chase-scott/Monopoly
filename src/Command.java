/**
 * A class for creating a command
 * @author Chase Scott 101092194
 */
public class Command {

    private final CommandWord commandWord; //the command word

    /**
     *Constructor for a CommandWord
     *
     * @param commandWord   CommandWord, the command word
     */
    public Command(CommandWord commandWord) {
        this.commandWord = commandWord;
    }

    public CommandWord getCommandWord() {return commandWord;}

    /**
     * Checks if the CommandWord is a valid command
     *
     * @return  boolean, if it is a valid command
     */
    public boolean isUnknown() {return (commandWord == CommandWord.UNKNOWN);}

}
