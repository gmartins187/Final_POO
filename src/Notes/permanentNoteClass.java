package Notes;

import App.*;

import java.time.LocalDate;
import java.util.*;


public class permanentNoteClass extends noteWithContentAbstractClass implements PermanentNote{

    private final List<LocalDate> updateDates = new ArrayList<>();
    private LocalDate date;

    private int theLastUpdateRound;

    /**
     * Constructor for the permanentNoteClass. Creates a new permanent note.
     * @param id the id of the note
     * @param content the content of the note
     * @param date the date of the note
     * @param notes the notes of the note
     */
    public permanentNoteClass(String id, String content, LocalDate date, HashMap<String, NoteWithContent> notes) {
        super(id, content);
        this.date = date;
        updateDates.addLast(date);
        computeLinks(notes, content);
        this.theLastUpdateRound = notesAppClass.round;
        notesAppClass.round++;
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
        updateDates.addLast(date);
        theLastUpdateRound = notesAppClass.round;
        notesAppClass.round++;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean isInThe(LocalDate startDate, LocalDate endDate) {
        return startDate.isBefore(this.date) && endDate.isAfter(this.date) ||
                startDate.isEqual(this.date) || endDate.isEqual(this.date);
    }

    @Override
    public int getUpdateRound(){
        return theLastUpdateRound;
    }
}
