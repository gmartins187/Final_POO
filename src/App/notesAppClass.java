package App;
import Notes.*;
import java.util.HashMap;

public class notesAppClass implements NotesApp{

    private final HashMap<String, Note> notes;

    public notesAppClass() {
        notes = new HashMap<>();
    }
}
