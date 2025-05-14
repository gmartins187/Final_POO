package App;
import EnumClasses.NotesTypes;
import Exceptions.ExistentID;
import Notes.*;
import java.util.HashMap;

public class notesAppClass implements NotesApp{

    private final HashMap<String, Note> notes;


    public notesAppClass() {
        notes = new HashMap<>();
    }

    @Override
    public void createNote(String kind, String id, String content, dateClass date) {
        if(hasNote(id)) {
            Note note = NotesTypes.CreateNote(kind, content, date);
            notes.put(id, note);
        } throw new ExistentID();
    }


    @Override
    public boolean hasNote(String id) {
        return notes.containsKey(id);
    }


}
