package App;
import java.util.HashMap;

import EnumClasses.*;
import Exceptions.*;
import Notes.*;


public class notesAppClass implements NotesApp{

    private final HashMap<String, NoteWithContent> notes;
    private dateClass currentDate;


    /**
     * Constructor for the notesAppClass. Creates a new HashMap to store the notes.
     */
    public notesAppClass() {
        notes = new HashMap<>();
    }

    @Override
    public void addPermanentNote(String kind, String ID, String content, dateClass date) throws ExistentID, TimeTravelling{
        if(!notes.containsKey(ID)) {
            if(date.isValid()) {
                if (!date.isBefore(currentDate)) {

                    notes.put(ID, new permanentNoteClass(ID, content, date, notes));
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

                            notes.put(ID, new literaryNoteClass(ID, content, date, notes, workTitle, authorName, pubDate, quote, url));
                            currentDate = new dateClass(date.getDay(), date.getMonth(), date.getYear());

                            System.out.println("Note " + ID + TerminalOutputs.CREATED.output + notes.get(ID).getLinks() + " notes.");
                        } else throw new TimeTravelToTheFuture();
                    } else throw new TimeTravelling();
                } else throw new InvalidDocDate();
            } else throw new InvalidDate();
        } else throw new ExistentID();
    }

    @Override
    public void getContent(String ID) throws DoesNotExist{
        if(notes.containsKey(ID)){
            NoteWithContent note = notes.get(ID);
            System.out.println(note.getContent() + " " + note.getLinks() + " links.");
        } else throw new DoesNotExist();
    }

    @Override
    public void updateNote(String id, dateClass date, String content) throws TimeTravelling, InvalidDate, DoesNotExist{
        if(date.isValid()){
            if(notes.containsKey(id)){
                if(date.isAfter(currentDate)){
                    NoteWithContent note = notes.get(id);
                    note.setContent(content, notes);
                    note.setDate(date);
                    currentDate = new dateClass(date.getDay(), date.getMonth(), date.getYear());
                    System.out.println("Note " + id + TerminalOutputs.UPDATED.output + notes.get(id).getLinks() + " links.");
                } else throw new TimeTravelling();
            } else throw new DoesNotExist();
        } else throw new InvalidDate();
    }

    @Override
    public void listLinks(String id) throws DoesNotExist, NoLinkedNotes{
        if(notes.containsKey(id)){
            if (notes.get(id).getLinks() > 0){
                NoteWithContent note = notes.get(id);
                note.iterateLinks();
            } else throw new NoLinkedNotes();
        } else throw new DoesNotExist();
    }
}
