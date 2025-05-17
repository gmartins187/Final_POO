package Notes;

import App.dateClass;

import java.util.HashMap;

public class referenceNoteClass extends abstractNoteClass implements ReferenceNote{

    public referenceNoteClass(String id, HashMap<String, NoteWithContent> notes) {
        super(id);
    }
}
