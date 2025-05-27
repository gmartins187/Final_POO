package Notes;

public interface ReferenceNote extends Note{

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

    /**
     * Checks if the note contains a specific note.
     * @param id the id of the note
     * @return true if the note contains the note, false otherwise
     */
    boolean containsNote(String id);

    /**
     * Removes a link to a note.
     * @param id the id of the note
     */
    void removeLink(String id);

    /**
     * Gets the id of the reference note
     * @return
     */
    int getTheRound();
}
