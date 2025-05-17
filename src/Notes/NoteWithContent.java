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
     * modifies the date
     * @param date the date to set
     */
    void setDate(dateClass date);


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
}