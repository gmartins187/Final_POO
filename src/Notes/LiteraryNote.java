package Notes;

import java.time.LocalDate;

public interface LiteraryNote extends NoteWithContent{

    /**
     * modifies the date
     * @param date the date to set
     */
    void setDate(LocalDate date);
}
