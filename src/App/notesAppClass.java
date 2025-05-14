package App;
import java.util.HashMap;

import EnumClasses.*;
import Exceptions.*;
import Notes.*;


public class notesAppClass implements NotesApp{

    private static dateClass current;
    private final HashMap<String, Note> notes;


    public notesAppClass() {
        notes = new HashMap<>();
    }

    @Override
    public void createNote(String kind, String ID, String content, dateClass date) {
        if(!hasNote(ID)) {
            Note note = NotesTypes.CreateNote(kind, content, date);
            updateDate(date);
            notes.put(ID, note);
            System.out.println("Note " + ID + TerminalOutputs.CREATED.output + note.getLinks(notes) + " notes.");
        } else throw new ExistentID();
    }

    @Override
    public void updateDate(dateClass date) {
        current = date;
    }

    @Override
    public dateClass getCurrentDate() {
        return current;
    }


    @Override
    public boolean hasNote(String id) {
        return notes.containsKey(id);
    }
}
