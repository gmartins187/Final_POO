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
    void addNonLiteratureNote(String kind, String id, String content, dateClass date);

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
}
