import App.*;
import App.notesAppClass;
import EnumClasses.TerminalOutputs;
import Exceptions.*;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

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
        NotesApp app = new notesAppClass();
        String command = readCommand(in);
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
                case TRENDING -> trending(app);
                case NOTES -> timeSpaceNote(app, in);
                case DELETE -> removeNote(app, in);
                default -> System.out.println(TerminalOutputs.UNKNOWN.output);
            }
            command = readCommand(in);
        }
        System.out.println(TerminalOutputs.BYE.output);
        in.close();
    }


    /**
     * This method reads the next command in the notes app
     * @param in the scanner that read the command
     * @return return the command in string
     */
    public static String readCommand(Scanner in){
        return in.next().toLowerCase();
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
    private static void createNote(NotesApp app, Scanner in) {
        String kind = in.next();
        if(kind.equalsIgnoreCase(LITERATURE)) createLiteratureNote(app, in, kind);
        else createPermanentNote(app, in, kind);
    }

    /**
     * This method is responsible for creating a literature note.
     * @param app the notes app
     * @param in the scanner
     */
    private static void createPermanentNote(NotesApp app, Scanner in, String kind) {
        String ID = "";
        try {
            int year = in.nextInt();
            int month = in.nextInt();
            int day = in.nextInt();
            in.nextLine();
            ID = readStringWithoutSpace(in);
            String content = readStringWithoutSpace(in);

            app.addPermanentNote(kind, ID, content, LocalDate.of(year, month, day));
        } catch(DateTimeException e){
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
    private static void createLiteratureNote(NotesApp app, Scanner in, String kind) {
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

            LocalDate date;
            try {
                date = LocalDate.of(year, month, day);
            } catch (DateTimeException e) {
                System.out.println(TerminalOutputs.INVALID_DATE.output); return;}

            LocalDate pubDate;
            try {
                pubDate = LocalDate.of(pubYear, pubMonth, pubDay);
            } catch (DateTimeException e) {
                System.out.println(TerminalOutputs.INVALID_DOC_DATE.output); return;}

            app.addLiteratureNote(kind, ID, content, date, workTitle, authorName, pubDate, quote, url);
        } catch (TimeTravelling e) {System.out.println(TerminalOutputs.TIME_TRAVEL.output);
        } catch (TimeTravelToTheFuture e) {System.out.println(TerminalOutputs.TIME_TRAVEL_FUTURE.output);
        } catch (ExistentProblem e) {System.out.println(ID + TerminalOutputs.ALREADY_EXISTS.output);}
    }

    /**
     * This method is responsible for getting the content of a note.
     * @param app the notes app
     * @param in the scanner
     */
    private static void getContent(NotesApp app, Scanner in) {
        String ID = "";
        try{
            ID = readStringWithoutSpace(in);
            app.getContent(ID);
        } catch (DoesNotExist e) {
            System.out.println("Note " + ID + TerminalOutputs.DOES_NOT_EXIST.output);
        }
    }

    /**
     * This method is responsible for updating a note.
     * @param app the notes app
     * @param in the scanner
     */
    private static void updateNote(NotesApp app, Scanner in) {
        String ID = "";
        try{
            ID = readStringWithoutSpace(in);
            int year = in.nextInt();
            int month = in.nextInt();
            int day = in.nextInt(); in.nextLine();
            String content = readStringWithoutSpace(in);

            app.updateNote(ID, LocalDate.of(year, month, day), content);
        } catch (DateTimeException e){
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
    private static void listLinks(NotesApp app, Scanner in){
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
    private static void tagNote(NotesApp app, Scanner in) {
        String Id = "";
        String tagId = "";
        try{
            Id = readStringWithoutSpace(in);
            tagId = readStringWithoutSpace(in);

            app.newTagNote(Id, tagId);
        } catch (DoesNotExist e){
            System.out.println("Note " + Id + TerminalOutputs.DOES_NOT_EXIST.output);
        } catch (ExistentProblem e){
            System.out.println("Note " + Id + TerminalOutputs.ALREADY_TAGGED.output + tagId + "!");
        }
    }

    /**
     * This method is responsible for untagging a note.
     * @param app the notes app
     * @param in the scanner
     */
    private static void untagNote(NotesApp app, Scanner in) {
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
    private static void listTags(NotesApp app, Scanner in) {
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
    private static void taggedOn(NotesApp app, Scanner in) {
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
     */
    private static void trending(NotesApp app) {
        try{
            app.trending();
        } catch (NoTagsDefined e){
            System.out.println(TerminalOutputs.NO_TAGS_DEFINED.output);
        }
    }

    /**
     * This method returns all the notes that were created in
     * a respective time space (from a start date to an end date)
     * @param app the notes app
     * @param in the scanner
     */
    private static void timeSpaceNote(NotesApp app, Scanner in) {
        String kind = readStringWithoutSpace(in);
        LocalDate startDate;
        LocalDate endDate;

        try{
            startDate = LocalDate.of(in.nextInt(), in.nextInt(), in.nextInt());
        } catch (DateTimeException e){
            System.out.println(TerminalOutputs.INVALID_START.output);
            in.nextLine(); in.nextLine();
            return;
        }
        try{
            endDate = LocalDate.of(in.nextInt(), in.nextInt(), in.nextInt());
        } catch (DateTimeException e){
            System.out.println(TerminalOutputs.INVALID_END.output);
            in.nextLine();
            return;
        }
        try{
            app.getNotesFromTo(kind, startDate, endDate);
        } catch (UnknownKind e){
            System.out.println(TerminalOutputs.UNKNOWN_KIND.output);
        } catch (TimeTravelling e){
            System.out.println(TerminalOutputs.TIME_TRAVELLING_FROM_STAR.output);
        } catch (NoNotes e){
            System.out.println(TerminalOutputs.NO_NOTES_IN_THIS_TIME.output);
        }
    }

    /**
     * This method removes a note.
     * @param app the notes app
     * @param in the scanner
     */
    private static void removeNote(NotesApp app, Scanner in) {
        String id = "";
        try{
            id = readStringWithoutSpace(in);

            app.remove(id);
        } catch (DoesNotExist e){
            System.out.println("Note " + id + TerminalOutputs.DOES_NOT_EXIST.output);
        }
    }
}