/**
 * Created by Thiloshon on 12-Nov-16.
 */
public class Date {
    int year;
    int month;
    int day;
    int hour;
    int minute;

    public Date newDate(int day, int hour, int minute, int month, int year) throws Exception {
        if (year < 0 || month < 0 || day < 0 || minute < 0 || hour < 0 || month > 12 || minute > 60 || hour > 24 || day > 31) {
            throw new Exception("Incorrect Date Exception");

        }
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            throw new Exception("Incorrect Date Exception");
        }
        if (month == 2 && day > 29) {
            throw new Exception("Incorrect Date Exception");
        }

        return new Date(day, hour, minute, month, year);

    }

    public Date(int day, int hour, int minnute, int month, int year) {
        //if (day > 31) return;
        this.day = day;
        this.hour = hour;
        this.minute = minnute;
        this.month = month;
        this.year = year;
    }

    int compare(Date date) {

        int value1 = year * 100000000 + month * 1000000 + day * 10000 + hour * 100 + minute;
        int value2 = date.year * 100000000 + date.month * 1000000 + date.day * 10000 + date.hour * 100 + date.minute;
        if (value1 > value2) {
            return 1;
        } else if (value1 < value2)
            return -1;
        return 0;
    }

    /*Date difference(){



    }*/

}
