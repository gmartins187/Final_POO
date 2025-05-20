package App;
import Exceptions.ExistentProblem;

import java.time.LocalDate;

public interface NotesApp {

    /**
     * Creates a new note.
     * @param kind kind of note
     * @param id unique identifier of the note
     * @param content content of the note
     * @param date date of the note
     * @throws ExistentProblem if the note already exists
     */
    void addPermanentNote(String kind, String id, String content, LocalDate date);

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
    void addLiteratureNote(String kind, String id, String content, LocalDate date, String workTitle, String authorName, LocalDate pubDate, String quote, String url);

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
    void updateNote(String id, LocalDate dateClass, String content);

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

    /**
     * Lists all the tags of a note.
     * @param id unique identifier of the note
     */
    void listTags(String id);

    /**
     * Lists all the notes tagged with tag.
     * @param tagId unique identifier of the tag
     */
    void listTaggedOn(String tagId);

    /**
     * Lists the most used tags.
     */
    void trending();

    /**
     * removes a note.
     * @param id unique identifier of the note
     */
    void remove(String id);

    /**
     * This method gets all the notes from a specific kind last edited between to specific dates
     * @param kind the kind of notes iterated
     * @param startDate the start date in the period
     * @param endDate the end date in the period
     */
    void getNotesFromTo(String kind, LocalDate startDate, LocalDate endDate);
}
