package App;
import Exceptions.*;

public interface Date {

    /**
     * Checks if the date is valid. in this case if is a year of the calendar
     * @return true if the date is valid, false otherwise
     */
    boolean isValid();

    /**
     * Checks if the date is before the current date
     * @param date the date to check
     */
    boolean isBefore(dateClass date);

    /**
     * Gets the day of the date
     * @return the day of the date
     */
    int getDay();

    /**
     * Gets the month of the date
     * @return the month of the date
     */
    int getMonth();

    /**
     * Gets the year of the date
     * @return the year of the date
     */
    int getYear();
}
