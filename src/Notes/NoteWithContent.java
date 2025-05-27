package Notes;

import java.time.LocalDate;
import java.util.HashMap;

public interface NoteWithContent extends Note{

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
    void listLinks();

    /**
     * @param tagId the tag id
     * @return if the note has the tag
     */
    boolean containsTag(String tagId);

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
    void setDate(LocalDate date, int round);

    /**
     * @return the date from an instance
     */
    LocalDate getDate();

    /**
     * This method computes if the date of the note is after the start date and before the end date
     * @param startDate the start date
     * @param endDate the end date
     * @return true if the date is in between
     */
    boolean isInThe(LocalDate startDate, LocalDate endDate);

    /**
     * @return the number of tags
     */
    int getTags();

    /**
     * Removes a certain Char from a String in a specified index
     * @param i the index of the character to remove
     */
    void remove(int i);

    /**
     * @return the id of the note
     */
    String getId();

    /**
     * Gets the last update round of the note
     * @return the last update round
     */
    int getUpdateRound();
}