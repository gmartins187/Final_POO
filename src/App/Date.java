package App;
import Exceptions.*;

public interface Date {

    /**
     * Checks if the date is valid. in this case if is a year
     * of the calendar
     * @param day the day of the month
     * @param month the month of the year
     * @return true if the date is valid, false otherwise
     */
    boolean isValid(int day, int month);

    /**
     * Checks if the date is before the current date
     * @param day the day of the month
     * @param month the month of the year
     * @param year the year
     * @param current the current date
     * @return true if the date is before the current date, false otherwise
     */
    boolean isBefore(int day, int month, int year, dateClass current);

    /**
     * Updates the date
     * @param day the day of the month
     * @param month the month of the year
     * @param year the year
     */
    void updateDate(int day, int month, int year);

    /**
     * Checks if the date is valid and if it is before the current date
     * @param day the day of the month
     * @param month the month of the year
     * @param year the year
     * @param current the current date
     * @throws InvalidDate if the date is invalid
     * @throws TimeTravelling if the date is before the current date
     */
    void validityCheck(int day, int month, int year, dateClass current) throws InvalidDate, TimeTravelling;
}
