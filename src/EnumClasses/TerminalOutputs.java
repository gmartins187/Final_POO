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
    BYE("Bye!"),
    NO_USE(" is not used!"),
    UNKNOWN_KIND("Unknown note kind!"),
    INVALID_START("Invalid start date!"),
    INVALID_END("Invalid end date!"),
    TIME_TRAVELLING_FROM_STAR("The ending date must not precede the starting date!"),
    DOES_NOT_EXIST(" does not exist!"),
    UPDATED(" updated. It now has "),
    INVALID_DOC_DATE("Invalid document date!"),
    ALREADY_TAGGED("is already tagged with"),
    NO_TAGS_DEFINED("No tags defined yet!"),
    DELETED(" deleted."),
    TAGGED_WITH(" tagged with "),
    NO_TAGS("No tags."),
    REMOVED_TAG(" no longer tagged with "),
    NOT_TAGGED(" is not tagged with "),
    NO_LINKED_NOTES("No linked notes.");

    public final String output;

    TerminalOutputs(String command){
        this.output = command;
    }
}
