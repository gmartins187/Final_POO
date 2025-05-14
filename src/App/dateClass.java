package App;
import Exceptions.*;

public class dateClass implements Date{
    int day;
    int year;
    int month;

    int INVALID_DATE = 1;
    int PAST_DATE = 2;

    public dateClass(int day, int month, int year) throws InvalidDate{
        if(isValid(day, month, year)) {
            if(!isBefore(day, month, year)) {
                this.day = day;
                this.month = month;
                this.year = year;
            } else throw new InvalidDate(PAST_DATE);
        } else throw new InvalidDate(INVALID_DATE);

    }

    private boolean isValid(int day, int month, int year) {

    }

    public boolean isBefore(int day, int month, int year) {
        if (this.year < year) {
            return true;
        } else if (this.year == year) {
            if (this.month < month) {
                return true;
            } else if (this.month == month) {
                return this.day < day;
            }
        }
        return false;
    }
}
