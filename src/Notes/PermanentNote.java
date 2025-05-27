package Notes;

import java.time.LocalDate;

public interface PermanentNote extends NoteWithContent{

    /**
     * modifies the date and stores date history.
     * @param date the date to set
     */
    void setDate(LocalDate date, int round);

    /**
     * gets the date of the note
     * @return the date
     */
    int getUpdateRound();
}
