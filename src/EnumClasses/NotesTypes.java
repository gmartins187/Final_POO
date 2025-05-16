package EnumClasses;
import App.dateClass;
import Notes.*;
import java.util.HashMap;


public enum NotesTypes {

    REFERENCE("reference"),
    PERMANENT("permanent");

    private final String NOTE_TYPE;

    NotesTypes(String noteType) {
        NOTE_TYPE = noteType;
    }

    public static Note createNonLiteratureNote(String kind, String content, dateClass date, HashMap<String, Note> notes) {
        if(kind.equalsIgnoreCase(REFERENCE.NOTE_TYPE)){
            return new referenceNoteClass(content, date, notes);
        } else if(kind.equalsIgnoreCase(PERMANENT.NOTE_TYPE)){
            return new permanentNoteClass(content, date, notes);
        }
        else return null;
    }

    public static Note createLiteratureNote(String kind, String content, dateClass date, HashMap<String, Note> notes, String workTitle, String authorName, dateClass pubDate, String quote, String url) {
        return new literaryNoteClass(content, date, notes, workTitle, authorName, pubDate, quote, url);
    }
}
