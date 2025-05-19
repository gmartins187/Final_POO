package App;
import Exceptions.*;

public class dateClass implements Date{

    private final int day;
    private final int month;
    private final int year;

    /**
     * Constructor for dateClass
     * @param day the day of the month
     * @param month the month of the year
     * @param year the year
     * @throws InvalidDate if the date is invalid
     * @throws TimeTravelling if the date is before the current date
     */
    public dateClass(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public int getDay() {
        return day;
    }

    @Override
    public int getMonth() {
        return month;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public boolean isAfter(dateClass currentDate) {
        if(currentDate != null) {
            if (year > currentDate.year) {
                return true;
            } else if (year == currentDate.year) {
                if (month > currentDate.month) {
                    return true;
                } else if (month == currentDate.month) {
                    return day > currentDate.day;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isDateInBetween(dateClass startDate, dateClass endDate) {
        return this.isAfter(startDate) && this.isBefore(endDate);
    }


    @Override
    public boolean isValid() {
        switch (month){
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return day <= 31;
            }
            case 4, 6, 9, 11 -> {
                return day <= 30;
            }
            case 2 -> {
                if (year % 4 == 0) {
                    return day <= 29;
                } else {
                    return day <= 28;
                }
            }
            default -> {
                return false;
            }
        }
    }

    @Override
    public boolean isBefore(dateClass current) {
        if(current != null) {
            if (year < current.year) {
                return true;
            } else if (year == current.year) {
                if (month < current.month) {
                    return true;
                } else if (month == current.month) {
                    return day < current.day;
                }
            }
        }
        return false;
    }
}
