package EnumClasses;

public enum TerminalOutputs {

    HELP(""" 
        create - creates a new note
        read - reads a note
        update - updates a note
        links - lists all links in a note
        tag - tags a note
        untag - untags a note
        tags - lists all tags in alphabetical order
        tagged - lists all notes with a specific tag
        trending - lists the most popular tags
        notes - lists all notes of a given type last edited within a given time interval
        delete - deletes a note
        help - shows the available commands
        exit - terminates the execution of the program"""),

    CREATED(" created successfully with links to "),
    INVALID_DATE("Invalid date!"),
    TIME_TRAVEL("No time travelling!"),
    TIME_TRAVEL_FUTURE("No time travelling to the future!"),
    ALREADY_EXISTS(" already exists!"),
    UNKNOWN("Unknown command. Type help to see available commands."),
    UNKNOWN_COMMAND("Unknown command!"),
    BYE("Bye!"),
    INVALID_DOC_DATE("Invalid document date!");

    public final String output;

    TerminalOutputs(String command){
        this.output = command;
    }
}
