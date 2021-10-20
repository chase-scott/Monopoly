public enum CommandWord {

    STATE("state"), BUY("buy"), PASS("pass"), HELP("help"), QUIT("quit"), UNKNOWN("?");

    private final String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    @Override
    public String toString() {
        return commandString;
    }

}
