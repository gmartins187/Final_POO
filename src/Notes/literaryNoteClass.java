package Notes;
import App.*;

import java.util.HashMap;

public class literaryNoteClass extends noteAbstractClass implements LiteraryNote{

    public literaryNoteClass(String content, dateClass date, HashMap<String, Note> notes) {
        super(date, content, notes);
    }
}
