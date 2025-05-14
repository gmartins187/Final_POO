package EnumClasses;
import App.dateClass;
import Notes.*;


public enum NotesTypes {

    LITERARY("literary"),
    PERMANENT("permanent");

    private final String NOTE_TYPE;

    NotesTypes(String noteType) {
        NOTE_TYPE = noteType;
    }
    public static Note CreateNote(String kind, String content, dateClass date) {
        if(kind.equalsIgnoreCase(LITERARY.NOTE_TYPE)){
            return new literaryNoteClass(content, date);
        } else return new permanentNoteClass(content, date);
    }
}
