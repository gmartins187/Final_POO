package Notes;
import App.dateClass;
import java.util.HashMap;

public interface Note {

    /**
     * @return date of the note
     */
    dateClass getDate();

    /**
     * @return content of the note
     */
    String getContent();

    /**
     * @return number of links in the note
     */
    int getLinks();

    /**
     *
     * @param notes
     */
    void addLinks(HashMap<String, Note> notes);
}