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
        exit - terminates the execution of the program
        """),
    BYE("Bye!");

    public final String output;

    TerminalOutputs(String command){
        this.output = command;
    }
}
