import EnumClasses.*;
import App.*;
import Notes.*;
import java.util.Scanner;

/**
 * @author Andre Amante 70945 a.amante@campus.fct.unl
 * @author Guilherme Martins 71003 gh.martins@campus.fct.unl
 */

public class Main {

    public static final String CREATE = "create";
    public static final String READ = "read";
    public static final String UPDATE = "update";
    public static final String LINKS = "links";
    public static final String TAG = "tag";
    public static final String UNTAG = "untag";
    public static final String TAGS = "tags";
    public static final String TAGGED = "tagged";
    public static final String TRENDING = "trending";
    public static final String NOTES = "notes";
    public static final String DELETE = "delete";
    public static final String HELP = "help";
    public static final String EXIT = "exit";


    public static void main(String[] args) {
        Commands();
    }

    private static void Commands() {
        Scanner in = new Scanner(System.in);
        NotesApp app = new notesAppClass();
        String command;
        do{
            command = in.next();
            switch (command){
                case HELP -> System.out.println(TerminalOutputs.HELP.output);
                case CREATE -> createNote(app, in);
                case READ ->
                case UPDATE ->
                case LINKS ->
                case TAG ->
                case UNTAG ->
                case TAGS ->
                case TAGGED ->
                case TRENDING ->
                case NOTES ->
                case DELETE ->
                default ->
            }
        } while (!command.equalsIgnoreCase(EXIT));
        in.close();
    }

    private static void createNote(NotesApp app, Scanner in) {

    }
}
