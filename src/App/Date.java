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

    /**
     * Checks if the date is after the current date
     * @param currentDate the current date
     * @return true if the date is after the current date, false otherwise
     */
    boolean isAfter(dateClass currentDate);

    /**
     * is the date in between from the start date and the end date
     * @param startDate the start date
     * @param endDate the end date
     * @return a bool that tells if it occurs in between these two dates
     */
    boolean isDateInBetween(dateClass startDate, dateClass endDate);
}
