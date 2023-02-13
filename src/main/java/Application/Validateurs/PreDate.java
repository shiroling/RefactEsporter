package Application.Validateurs;

import java.util.Date;

public class PreDate {
    private int day;
    private int month;
    private int year;

    public PreDate(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean estDateValide() {
        if (this.getDay() == 31) {
            if( this.getMonth() == 3 ||
                    this.getMonth() == 5 ||
                    this.getMonth() == 8 ||
                    this.getMonth() == 10) {
                return false;
            }
        }
        if(this.getMonth() == 1) {
            if(this.getDay() >= 29) {
                return false;
            }
        }

        return true;
    }

    public boolean estPassee() {
        return (this.toDate()).before(new Date(System.currentTimeMillis()));
    }

    @SuppressWarnings("deprecation")
    public Date toDate() {
        return new Date(year - 1900, month, day);
    }

    @SuppressWarnings("deprecation")
    public static String toStringDateFormatterEuropean(Date date) {
        int year = date.getYear() + 1900;
        int month = date.getMonth() + 1;
        int day = date.getDate();

        char buf[] = new char[10];
        formatDecimalInt(day, buf, 0, 2);
        buf[2] = '/';
        formatDecimalInt(month, buf, 3, 2);
        buf[5] = '/';
        formatDecimalInt(year, buf, 6, 4);

        return new String(buf);
    }

    private static void formatDecimalInt(int val, char[] buf, int offset, int len) {
        int charPos = offset + len;
        do {
            buf[--charPos] = (char)('0' + (val % 10));
            val /= 10;
        } while (charPos > offset);
    }

    @Override
    public String toString() {
        return "PreDate [day=" + day + ", month=" + month + ", year=" + year + "]";
    }
}
