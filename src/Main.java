import App.*;
import EnumClasses.*;
import Exceptions.*;
import java.util.Scanner;

//Notes method is not done. 19/06 start testing to finish the project as soon as possible

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
        while (!command.equalsIgnoreCase(EXIT)){
            switch (command){
                case HELP -> System.out.println(TerminalOutputs.HELP.output);
                case CREATE -> createNote(app, in);
                case READ -> getContent(app, in);
                case UPDATE -> updateNote(app, in);
                case LINKS -> listLinks(app, in);
                case TAG -> tagNote(app, in);
                case UNTAG -> untagNote(app,in);
                case TAGS -> listTags(app, in);
                case TAGGED -> taggedOn(app, in);
                case TRENDING -> trending(app, in);
                case NOTES -> timeSpaceNote(app, in);
                case DELETE -> removeNote(app, in);
                default -> System.out.println(TerminalOutputs.UNKNOWN.output);
            }
            command = in.next();
        }
        System.out.println(TerminalOutputs.BYE.output);
        in.close();
    }


    /**
     * This method is responsible for reading a string from the scanner and removing any leading or trailing spaces.
     * @param in the scanner
     * @return the string without leading or trailing spaces
     */
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
        if(kind.equalsIgnoreCase(LITERATURE)) createLiteratureNote(app, in, kind);
        else createPermanentNote(app, in, kind);
    }

    /**
     * This method is responsible for creating a literature note.
     * @param app the notes app
     * @param in the scanner
     */
    private static void createPermanentNote(notesAppClass app, Scanner in, String kind) {
        String ID = "";
        try {
            int year = in.nextInt();
            int month = in.nextInt();
            int day = in.nextInt();
            in.nextLine();
            ID = readStringWithoutSpace(in);
            String content = null;
            content = readStringWithoutSpace(in);

            app.addPermanentNote(kind, ID, content, new dateClass(day, month, year));
        } catch(InvalidDate e){
            System.out.println(TerminalOutputs.INVALID_DATE.output);
        } catch (TimeTravelling e) {
            System.out.println(TerminalOutputs.TIME_TRAVEL.output);
        } catch (ExistentProblem e) {
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
        } catch (ExistentProblem e) {System.out.println(ID + TerminalOutputs.ALREADY_EXISTS.output);
        } catch (TimeTravelToTheFuture e) {System.out.println(TerminalOutputs.TIME_TRAVEL_FUTURE.output);}
    }

    /**
     * This method is responsible for getting the content of a note.
     * @param app the notes app
     * @param in the scanner
     */
    private static void getContent(notesAppClass app, Scanner in) {
        String ID = "";
        try{
            ID = readStringWithoutSpace(in);
            app.getContent(ID);
        } catch (DoesNotExist e){
            System.out.println("Note " + ID + TerminalOutputs.DOES_NOT_EXIST.output);
        }
    }

    /**
     * This method is responsible for updating a note.
     * @param app the notes app
     * @param in the scanner
     */
    private static void updateNote(notesAppClass app, Scanner in) {
        String ID = "";
        try{
            ID = readStringWithoutSpace(in);
            int year = in.nextInt();
            int month = in.nextInt();
            int day = in.nextInt(); in.nextLine();
            String content = readStringWithoutSpace(in);

            app.updateNote(ID, new dateClass(day, month, year), content);
        } catch (InvalidDate e){
            System.out.println(TerminalOutputs.INVALID_DATE.output);
        } catch (DoesNotExist e){
            System.out.println("Note " + ID + TerminalOutputs.DOES_NOT_EXIST.output);
        } catch (TimeTravelling e){
            System.out.println(TerminalOutputs.TIME_TRAVEL.output);
        }
    }

    /**
     * this method list all the links in the note
     * @param app the notes app
     * @param in the scanner
     */
    private static void listLinks(notesAppClass app, Scanner in){
        String ID = "";
        try{
            ID = readStringWithoutSpace(in);

            app.listLinks(ID);
        } catch (DoesNotExist e){
            System.out.println("Note " + ID + TerminalOutputs.DOES_NOT_EXIST.output);
        } catch (NoNotes e){
            System.out.println(TerminalOutputs.NO_LINKED_NOTES.output);
        }
    }

    /**
     * This method is responsible for tagging a note.
     * @param app the notes app
     * @param in the scanner
     */
    private static void tagNote(notesAppClass app, Scanner in) {
        String Id = "";
        String tagId = "";
        try{
            Id = readStringWithoutSpace(in);in.next();
            tagId = readStringWithoutSpace(in);

            app.newTagNote(Id, tagId);
        } catch (DoesNotExist e){
            System.out.println("Note " + Id + TerminalOutputs.DOES_NOT_EXIST.output);
        } catch (ExistentProblem e){
            System.out.println("Note on " + Id + TerminalOutputs.ALREADY_TAGGED.output + tagId + "!");
        }
    }

    /**
     * This method is responsible for untagging a note.
     * @param app the notes app
     * @param in the scanner
     */
    private static void untagNote(notesAppClass app, Scanner in) {
        String id = "";
        String tagId = "";
        try{
            id = readStringWithoutSpace(in);
            tagId = readStringWithoutSpace(in);

            app.untagNote(id, tagId);
        } catch (DoesNotExist e){
            System.out.println("Note " + id + TerminalOutputs.DOES_NOT_EXIST.output);
        } catch (ExistentProblem e){
            System.out.println("Note on " + id + TerminalOutputs.NOT_TAGGED.output + tagId + "!");
        }
    }

    /**
     * This method is responsible for listing all the tags in the notes app.
     * @param app the notes app
     * @param in the scanner
     */
    private static void listTags(notesAppClass app, Scanner in) {
        String id = "";
        try{
            id = readStringWithoutSpace(in);

            app.listTags(id);
        } catch (DoesNotExist e){
            System.out.println("Note " + id + TerminalOutputs.DOES_NOT_EXIST.output);
        } catch (NoNotes e){
            System.out.println(TerminalOutputs.NO_TAGS.output);
        }
    }

    /**
     * This method is responsible for listing all the notes tagged with a tag.
     * @param app the notes app
     * @param in the scanner
     */
    private static void taggedOn(notesAppClass app, Scanner in) {
        String tagId = "";
        try{
            tagId = readStringWithoutSpace(in);

            app.listTaggedOn(tagId);
        } catch (ExistentProblem e){
            System.out.println("Tag " + tagId + TerminalOutputs.NO_USE.output);
        }
    }

    /**
     * This method is responsible for listing all the trending notes.
     * @param app the notes app
     * @param in the scanner
     */
    private static void trending(notesAppClass app, Scanner in) {
        try{
            app.trending();
        } catch (DoesNotExist e){
            System.out.println(TerminalOutputs.NO_TAGS_DEFINED.output);
        }
    }

    /**
     * This method removes a note.
     * @param app the notes app
     * @param in the scanner
     */
    private static void removeNote(notesAppClass app, Scanner in) {
        String id = "";
        try{
            id = readStringWithoutSpace(in);

            app.remove(id);
        } catch (DoesNotExist e){
            System.out.println("Note " + id + TerminalOutputs.DOES_NOT_EXIST.output);
        }
    }

    private static void timeSpaceNote(notesAppClass app, Scanner in) {
        try{
            String kind = readStringWithoutSpace(in);
            int startYear = in.nextInt();
            int startMonth = in.nextInt();
            int startDay = in.nextInt();
            int endYear = in.nextInt();
            int endMonth = in.nextInt();
            int endDay  = in.nextInt();

            dateClass startDate = new dateClass(startDay, startMonth, startYear);
            dateClass endDate = new dateClass(endDay, endMonth, endYear);

            app.getNotesFromTo(kind, startDate, endDate);
        } catch (UnknownKind e){
            System.out.println(TerminalOutputs.UNKNOWN_KIND.output);
        } catch (InvalidStartDate e){
            System.out.println(TerminalOutputs.INVALID_START.output);
        } catch (InvalidEndDate e){
            System.out.println(TerminalOutputs.INVALID_END.output);
        } catch (TimeTravelling e){
            System.out.println(TerminalOutputs.TIME_TRAVELLING_FROM_STAR.output);
        }
    }
}