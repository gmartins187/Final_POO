package App;
import Exceptions.*;

public class dateClass implements Date{

    private static int day;
    private static int month;
    private static int year;

    /**
     * Constructor for dateClass
     * @param day the day of the month
     * @param month the month of the year
     * @param year the year
     * @param currentDate the current date
     * @throws InvalidDate if the date is invalid
     * @throws TimeTravelling if the date is before the current date
     */
    public dateClass(int day, int month, int year, dateClass currentDate) throws InvalidDate, TimeTravelling {
        if(isValid(day, month)) {
            if(!isBefore(day, month, year, currentDate)) {
                dateClass.day = day;
                dateClass.month = month;
                dateClass.year = year;
            } else throw new TimeTravelling();
        } else throw new InvalidDate();
    }

    @Override
    public boolean isValid(int day, int month) {
        switch (month)
        {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return day <= 31;
            }
            case 4, 6, 9, 11 -> {
                return day <= 30;
            }
            case 2 -> {
                return day <= 28;
            }
            default -> {
                return false;
            }
        }

    }

    @Override
    public boolean isBefore(int day, int month, int year, dateClass currentDate) {
        if (currentDate != null) {
            if (currentDate.year < year) {
                return true;
            } else if (currentDate.year == year) {
                if (currentDate.month < month) {
                    return true;
                } else if (currentDate.month == month) {
                    return currentDate.day < day;
                }
            }
        }
        return false;
    }
}
