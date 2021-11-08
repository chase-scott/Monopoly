package Monopoly;

import java.util.Scanner;

/**
 * Monopoly.Parser for reading command line input
 * @author Chase Scott 10192194
 */
public class Parser {

    private CommandWords commands;  //map of all valid commands
    private Scanner reader;         //user input reader

    /**
     * Default constructor
     */
    public Parser()
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * Get the players in the game.
     * @return  Monopoly.Player[], the array of players
     */
    public Player[] getPlayers() {

        System.out.println("Enter how many players will be playing.");
        int numberOfPlayers;

        while(true) {
            try {
                System.out.print(">> ");
                numberOfPlayers = Integer.parseInt(reader.nextLine());
                if(numberOfPlayers <= 1 || numberOfPlayers > 8) {
                    System.out.println("Must be between 1 and 8 players!");
                    continue;
                }
                break;
            } catch(NumberFormatException e) {
                System.out.println("PLease input a valid integer!");
            }
        }

        Player[] players = new Player[numberOfPlayers];
        for(int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + "'s name: ");
            players[i] = new Player(reader.nextLine());
        }

        return players;
    }


    /**
     * Monopoly.Command loop for the game's basic commands
     * @return  Monopoly.Command, the command inputted
     */
    public Command getCommand() {

        String commandInput;
        System.out.print(">> ");

        commandInput = reader.nextLine();

        return new Command(commands.getCommandWord(commandInput));

    }

    /**
     * Prints a list of all commands.
     */
    public void showCommands()
    {
        commands.showAll();
    }

}