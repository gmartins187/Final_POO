package Notes;
import App.*;

import java.util.ArrayList;
import java.util.HashMap;


public class permanentNoteClass extends noteWithContentAbstractClass implements PermanentNote{

    private final ArrayList<dateClass> updateDates = new ArrayList<>();
    private dateClass date;

    /**
     * Constructor for the permanentNoteClass. Creates a new permanent note.
     * @param id the id of the note
     * @param content the content of the note
     * @param date the date of the note
     * @param notes the notes of the note
     */
    public permanentNoteClass(String id, String content, dateClass date, HashMap<String, NoteWithContent> notes) {
        super(id, content, notes);
        this.date = date;
        computeLinks(notes, content);
        updateDates.addLast(date);
    }

    @Override
    public void setDate(dateClass date){
        this.date = date;
        updateDates.addLast(date);
    }
}
