package App;
import Exceptions.ExistentID;

public interface NotesApp {

    /**
     * Creates a new note.
     * @param kind kind of note
     * @param id unique identifier of the note
     * @param content content of the note
     * @param date date of the note
     * @throws ExistentID if the note already exists
     */
    void createNote(String kind, String id, String content, dateClass date);

    /**
     * if note with ID exists
     * @param id unique identifier of the note
     * @return true if the note exists, false otherwise
     */
    boolean hasNote(String id);
}
