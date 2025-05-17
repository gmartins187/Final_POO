package Notes;

public interface ReferenceNote {

    /**
     * Inserts a note which is tagged on.
     * @param note the note with content
     * @param noteId the id of the note
     */
    void insertNote(String noteId, NoteWithContent note);

    /**
     * Iterates through all the notes tagged on.
     */
    void iterateNotesTaggedOn();

    /**
     * Gets the number of notes that this tag is tagged on.
     */
    int getNumTags();
}
