import java.util.Scanner;

/**
 * Parser for reading command line input
 * @author Chase Scott 10192194
 */
public class Parser {

    private CommandWords commands;
    private Scanner reader;

    public Parser()
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {

        String commandInput;
        System.out.print(">> ");

        commandInput = reader.nextLine();

        return new Command(commands.getCommandWord(commandInput));

    }

    public void showCommands()
    {
        commands.showAll();
    }

}
