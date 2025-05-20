package Notes;

import java.time.LocalDate;

public interface PermanentNote {

    /**
     * modifies the date and stores date history.
     * @param date the date to set
     */
    void setDate(LocalDate date);
}
