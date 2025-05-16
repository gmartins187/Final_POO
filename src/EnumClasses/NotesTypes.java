package EnumClasses;
import App.dateClass;
import Notes.*;
import java.util.HashMap;


public enum NotesTypes {

    LITERARY("literary"),
    PERMANENT("permanent");

    private final String NOTE_TYPE;

    NotesTypes(String noteType) {
        NOTE_TYPE = noteType;
    }

    public static Note CreateNote(String kind, String content, dateClass date, HashMap<String, Note> notes) {
        if(kind.equalsIgnoreCase(LITERARY.NOTE_TYPE)){
            return new literaryNoteClass(content, date, notes);
        } else if(kind.equalsIgnoreCase(PERMANENT.NOTE_TYPE)){
            return new permanentNoteClass(content, date, notes);
        }
        else return null;
    }
}
