import EnumClasses.*;
import App.*;
import Exceptions.*;
import java.util.Scanner;

//tags not Working

/**
 * @author Andre Amante 70945 a.amante@campus.fct.unl
 * @author Guilherme Martins 71003 gh.martins@campus.fct.unl
 */

public class Main {

    private static final String CREATE = "create";
    private static final String READ = "read";
    private static final String UPDATE = "update";
    private static final String LINKS = "links";
    private static final String TAG = "tag";
    private static final String UNTAG = "untag";
    private static final String TAGS = "tags";
    private static final String TAGGED = "tagged";
    private static final String TRENDING = "trending";
    private static final String NOTES = "notes";
    private static final String DELETE = "delete";
    private static final String HELP = "help";
    private static final String EXIT = "exit";

    private static final String LITERATURE = "literature";


    public static void main(String[] args) {
        Commands();
    }

    /**
     * This method is responsible for the command line interface of the application.
     * It reads the commands from the user and executes the corresponding methods.
     */
    private static void Commands() {
        Scanner in = new Scanner(System.in);
        notesAppClass app = new notesAppClass();
        String command = in.next();
        do{
            switch (command){
                case HELP -> System.out.println(TerminalOutputs.HELP.output);
                case CREATE -> createNote(app, in);
                case READ -> getContent(app, in);
                //case UPDATE ->
                //case LINKS ->
                //case TAG ->
                //case UNTAG ->
                //case TAGS ->
                //case TAGGED ->
                //case TRENDING ->
                //case NOTES ->
                //case DELETE ->
                default -> System.out.println(TerminalOutputs.UNKNOWN.output);
            }
            command = in.next();
        } while (!command.equalsIgnoreCase(EXIT));
        System.out.print(TerminalOutputs.BYE.output);
        in.close();
    }

    public static String readStringWithoutSpace(Scanner in){
        String str = in.nextLine();
        return str.trim();
    }

    /**
     * This method is responsible for creating a note.
     * @param app the notes app
     * @param in the scanner
     */
    private static void createNote(notesAppClass app, Scanner in) {
        String kind = in.next();
        if(!kind.equalsIgnoreCase(LITERATURE)) createNormalNote(app, in, kind);
        else createLiteratureNote(app, in, kind);
    }

    /**
     * This method is responsible for creating a literature note.
     * @param app the notes app
     * @param in the scanner
     */
    private static void createNormalNote(notesAppClass app, Scanner in, String kind) {
        String ID = "";
        try {
            int year = in.nextInt();
            int month = in.nextInt();
            int day = in.nextInt();
            in.nextLine();
            ID = readStringWithoutSpace(in);
            String content = readStringWithoutSpace(in);

            app.addNonLiteratureNote(kind, ID, content, new dateClass(day, month, year));
        } catch(InvalidDate e){
            System.out.println(TerminalOutputs.INVALID_DATE.output);
        } catch (TimeTravelling e) {
            System.out.println(TerminalOutputs.TIME_TRAVEL.output);
        } catch (ExistentID e) {
            System.out.println(ID + TerminalOutputs.ALREADY_EXISTS.output);
        }
    }

    /**
     * This method is responsible for creating a permanent or reference note.
     * @param app the notes app
     * @param in the scanner
     */
    private static void createLiteratureNote(notesAppClass app, Scanner in, String kind) {
        String ID = "";
        try {
            int year = in.nextInt();
            int month = in.nextInt();
            int day = in.nextInt(); in.nextLine();
            ID = readStringWithoutSpace(in);
            String content = readStringWithoutSpace(in);
            String workTitle = readStringWithoutSpace(in);
            String authorName = readStringWithoutSpace(in);
            int pubYear = in.nextInt();
            int pubMonth = in.nextInt();
            int pubDay = in.nextInt(); in.nextLine();
            String url = readStringWithoutSpace(in);
            String quote = readStringWithoutSpace(in);

            dateClass date = new dateClass(day, month, year);
            dateClass pubDate = new dateClass(pubDay, pubMonth, pubYear);

            app.addLiteratureNote(kind, ID, content, date, workTitle, authorName, pubDate, quote, url);
        } catch(InvalidDate e) {System.out.println(TerminalOutputs.INVALID_DATE.output);
        } catch (InvalidDocDate e){System.out.println(TerminalOutputs.INVALID_DOC_DATE.output);
        } catch (TimeTravelling e) {System.out.println(TerminalOutputs.TIME_TRAVEL.output);
        } catch (ExistentID e) {System.out.println(ID + TerminalOutputs.ALREADY_EXISTS.output);
        } catch (TimeTravelToTheFuture e) {System.out.println(TerminalOutputs.TIME_TRAVEL_FUTURE.output);}
    }

    private static void getContent(notesAppClass app, Scanner in) {
        String ID = "";
        try{
            ID = readStringWithoutSpace(in);
            app.getContent(ID);
        } catch (DoesNotExist e){
            System.out.println("Note " + ID + TerminalOutputs.DOES_NOT_EXIST.output);
        }
    }
}