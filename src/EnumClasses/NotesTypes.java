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
        switch (kind){
            case LITERARY.NOTE_TYPE -> {
                return new literaryNoteClass(content, date);
            }
            case PERMANENT.NOTE_TYPE -> {
                return new permanentNoteClass(content, date);
            }
        }
    }
}
