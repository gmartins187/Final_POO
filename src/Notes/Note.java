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
     * @param notes list of all notes
     * @return kind of the note
     */
    int getLinks(HashMap<String, Note> notes);
}
