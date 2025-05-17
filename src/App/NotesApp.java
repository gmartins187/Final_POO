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
    void addPermanentNote(String kind, String id, String content, dateClass date);

    /**
     * Creates a new literature note.
     * @param kind kind of note
     * @param id unique identifier of the note
     * @param content content of the note
     * @param date date of the note
     * @param workTitle title of the work
     * @param authorName name of the author
     * @param pubDate publication date of the work
     * @param quote quote from the work
     * @param url url of the work
     */
    void addLiteratureNote(String kind, String id, String content, dateClass date, String workTitle, String authorName, dateClass pubDate, String quote, String url);

    /**
     * Gets the content of a note.
     * @param id unique identifier of the note
     */
    void getContent(String id);

    /**
     * Updates a note content.
     * @param id unique identifier of the note
     * @param content content of the note
     * @param dateClass date of the note
     */
    void updateNote(String id, dateClass dateClass, String content);

    /**
     * Lists all the links of a note.
     * @param id unique identifier of the note
     */
    void listLinks(String id);

    /**
     * Tags a note.
     * @param id unique identifier of the note
     * @param tagId unique identifier of the tag
     */
    void newTagNote(String id, String tagId);

    /**
     * Removes a tag from a note.
     * @param id unique identifier of the note
     * @param tagId unique identifier of the tag
     */
    void untagNote(String id, String tagId);
}
