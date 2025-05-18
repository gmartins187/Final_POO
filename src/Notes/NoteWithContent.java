package Notes;
import App.dateClass;
import java.util.HashMap;

public interface NoteWithContent {

    /**
     * @return the content of the note
     */
    String getContent();

    /**
     * update content of the note
     * @param content the content to set
     * @param notes the hashmap with all the notes to link
     */
    void setContent(String content, HashMap<String, NoteWithContent> notes);


    /**
     * @return number of links in the note
     */
    int getLinks();

    /**
     * computes the links in the note
     * @param content the content of the note
     * @param notes the hashmap with all the notes to link
     */
    void computeLinks(HashMap<String, NoteWithContent> notes, String content);

    /**
     * iterates the number of links in the note
     */
    void iterateLinks();

    /**
     * @param tagId the tag id
     * @return if the note has the tag
     */
    boolean hasTag(String tagId);

    /**
     * Adds a tag to the note
     * @param referenceNoteClass the tag to add
     */
    void addTag(referenceNoteClass referenceNoteClass);

    /**
     * Removes a tag from the note
     * @param tag the tag to remove
     */
    void removeTag(referenceNoteClass tag);

    /**
     * @return if the note has tags of the note
     */
    boolean hasTags();

    /**
     * Lists all the tags of the note
     */
    void listTags();

    /**
     * @return if contains a link to the note
     */
    boolean containsNote(String id);

    /**
     * remove note
     */
    void removeLink(String id);

    /**
     * This method sets a new date
     * @param date the new date set
     */
    void setDate(dateClass date);
}