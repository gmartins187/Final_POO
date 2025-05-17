package Notes;

import App.dateClass;

import java.util.HashMap;

public class referenceNoteClass extends abstractNoteClass implements ReferenceNote{

    HashMap<String, NoteWithContent> notesTaggedOn;

    public referenceNoteClass(String id) {
        super(id);
    }
}
