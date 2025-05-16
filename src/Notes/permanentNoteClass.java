package Notes;
import App.*;

import java.util.HashMap;


public class permanentNoteClass extends noteAbstractClass implements PermanentNote{

    public permanentNoteClass(String content, dateClass date, HashMap<String, Note> notes) {
        super(date, content, notes);
    }
}
