/**
 * A class for creating a command
 * @author Chase Scott 101092194
 */
public class Command {

    private final CommandWord commandWord;

    public Command(CommandWord commandWord) {
        this.commandWord = commandWord;
    }

    public CommandWord getCommandWord() {return commandWord;}

    public boolean isUnknown() {return (commandWord == CommandWord.UNKNOWN);}

}
