package Notes;

import App.dateClass;

import java.util.HashMap;

public class referenceNoteClass extends noteAbstractClass implements ReferenceNote{

    public referenceNoteClass(String content, dateClass date, HashMap<String, Note> notes) {
        super(date, content, notes);
    }
}
