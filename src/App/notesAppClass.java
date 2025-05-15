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
    public void createNote(String kind, String ID, String content, dateClass date) throws ExistentID, TimeTravelling{
        if(!notes.containsKey(ID)) {
            if(date.isValid()) {
                if (!date.isBefore(currentDate)) {
                    notes.put(ID, NotesTypes.CreateNote(kind, content, date));
                    currentDate = new dateClass(date.getDay(), date.getMonth(), date.getYear());
                    System.out.println("Note " + ID + TerminalOutputs.CREATED.output + notes.get(ID).getLinks(notes) + " notes.");
                } else throw new TimeTravelling();
            } else throw new InvalidDate();
        } else throw new ExistentID();
    }
}
