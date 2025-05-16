package App;
import java.util.HashMap;

import EnumClasses.*;
import Exceptions.*;
import Notes.*;


public class notesAppClass implements NotesApp{

    private final HashMap<String, Note> notes;
    private dateClass currentDate;


    /**
     * Constructor for the notesAppClass. Creates a new HashMap to store the notes.
     */
    public notesAppClass() {
        notes = new HashMap<>();
    }

    @Override
    public void addNonLiteratureNote(String kind, String ID, String content, dateClass date) throws ExistentID, TimeTravelling{
        if(!notes.containsKey(ID)) {
            if(date.isValid()) {
                if (!date.isBefore(currentDate)) {
                    notes.put(ID, NotesTypes.createNonLiteratureNote(kind, content, date, notes));
                    currentDate = new dateClass(date.getDay(), date.getMonth(), date.getYear());
                    System.out.println("Note " + ID + TerminalOutputs.CREATED.output + notes.get(ID).getLinks() + " notes.");
                } else throw new TimeTravelling();
            } else throw new InvalidDate();
        } else throw new ExistentID();
    }

    @Override
    public void addLiteratureNote(String kind, String ID, String content, dateClass date, String workTitle, String authorName, dateClass pubDate, String quote, String url)
            throws ExistentID, TimeTravelling, InvalidDate, InvalidDocDate, TimeTravelToTheFuture{
        if(!notes.containsKey(ID)) {
            if(date.isValid()) {
                if(pubDate.isValid()){
                    if (!date.isBefore(currentDate)) {
                        if (!pubDate.isAfter(currentDate)) {

                            notes.put(ID, NotesTypes.createLiteratureNote(kind, content, date, notes, workTitle, authorName, pubDate, quote, url));
                            currentDate = new dateClass(date.getDay(), date.getMonth(), date.getYear());

                            System.out.println("Note " + ID + TerminalOutputs.CREATED.output + notes.get(ID).getLinks() + " notes.");
                        } else throw new TimeTravelToTheFuture();
                    } else throw new TimeTravelling();
                } else throw new InvalidDocDate();
            } else throw new InvalidDate();
        } else throw new ExistentID();
    }
}
