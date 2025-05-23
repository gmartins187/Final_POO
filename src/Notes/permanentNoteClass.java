package Notes;

import java.time.LocalDate;
import java.util.*;


public class permanentNoteClass extends noteWithContentAbstractClass implements PermanentNote{

    private final List<LocalDate> updateDates = new ArrayList<>();
    private LocalDate date;

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
    }

    @Override
    public void setDate(LocalDate date){
        this.date = date;
        updateDates.addLast(date);
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean isDateInBetween(LocalDate startDate, LocalDate endDate) {
        return startDate.isBefore(this.date) && endDate.isAfter(this.date);
    }
}
