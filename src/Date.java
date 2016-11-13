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

    int[] difference(Date date) {

        int value1 = year * 525600;

        if (month > 1) {
            value1 += 44640;
            if (month > 2) {
                value1 += 40320;
                if (month > 3) {
                    value1 += 44640;
                    if (month > 4) {
                        value1 += 43200;
                        if (month > 5) {
                            value1 += 44640;
                            if (month > 6) {
                                value1 += 43200;
                                if (month > 7) {
                                    value1 += 44640;
                                    if (month > 8) {
                                        value1 += 44640;
                                        if (month > 9) {
                                            value1 += 43200;
                                            if (month > 10) {
                                                value1 += 44640;
                                                if (month > 11) {
                                                    value1 += 44640;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        /*switch (month){
            case 2: value1+=44640;
                break;
            case 3: value1+=40320;
                break;
            case 4: value1+=44640;
                break;
            case 5: value1+=43200;
                break;
            case 6: value1+=44640;
                break;
            case 7: value1+=43200;
                break;
            case 8: value1+=44640;
                break;
            case 9: value1+=44640;
                break;
            case 10: value1+=43200;
                break;
            case 11: value1+=44640;
                break;
            case 12: value1+=44640;
                break;
        }*/

        value1 += day * 1440;
        value1 += hour * 60;
        value1 += minute;

        java.util.Date datdfsade = new java.util.Date();


        int value2 = date.year * 525600;

        if (date.month > 1) {
            value2 += 44640;
            if (date.month > 2) {
                value2 += 40320;
                if (date.month > 3) {
                    value2 += 44640;
                    if (date.month > 4) {
                        value2 += 43200;
                        if (date.month > 5) {
                            value2 += 44640;
                            if (date.month > 6) {
                                value2 += 43200;
                                if (date.month > 7) {
                                    value2 += 44640;
                                    if (date.month > 8) {
                                        value2 += 44640;
                                        if (date.month > 9) {
                                            value2 += 43200;
                                            if (date.month > 10) {
                                                value2 += 44640;
                                                if (date.month > 11) {
                                                    value2 += 44640;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        value2 += date.day * 1440;
        value2 += date.hour * 60;
        value2 += date.minute;

        int diff = Math.abs(value1 - value2);

        int day = diff / 1440;
        int hour = (diff % 1440) / 60;

        int[] ans = new int[2];
        ans[0] = day;
        ans[1] = hour;

        return ans;

    }

}
