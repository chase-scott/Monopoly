import java.util.*;

public class CommandWords {

    private HashMap<String, CommandWord> commands;

    public CommandWords() {
        commands = new HashMap<>();
        for(CommandWord c : CommandWord.values()) {
            if(c != CommandWord.UNKNOWN) {
                commands.put(c.toString(), c);
            }
        }
    }

    public CommandWord getCommandWord(String commandWord) {
        CommandWord command = commands.get(commandWord);
        return Objects.requireNonNullElse(command, CommandWord.UNKNOWN);
    }

    public boolean isCommand(String command) { return commands.containsKey(command); }

    public void showAll() {
        for(String c : commands.keySet()) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

}
