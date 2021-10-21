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

    /**
     * Get the players in the game.
     * @return  Player[], the array of players
     */
    public Player[] getPlayers() {

        String commandInput;
        System.out.println("Enter how many players will be playing.");
        System.out.print(">> ");
        int n = Integer.parseInt(reader.nextLine());


        Player[] players = new Player[n];
        for(int i = 0; i < n; i++) {
            System.out.print("Enter player " + (i + 1) + "'s name: ");
            players[i] = new Player(reader.nextLine());
        }

        return players;
    }


    /**
     * Command loop for the game's basic commands
     * @return  Command, the command inputted
     */
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
