package easy;

public class leetcode2437 {
    /*
    有效时间的数目
    https://leetcode.cn/problems/number-of-valid-clock-times/
     */
    public int countTime(String time) {
        int hour = 1;
        int minute = 1;
        if (time.charAt(0) == '?' || time.charAt(1) == '?') {
            if (time.charAt(1) != '?') {
                if (time.charAt(1) < '4') {
                    hour = 3;
                } else {
                    hour = 2;
                }
            } else {
                if (time.charAt(0) == '?') {
                    hour = 24;
                } else {
                    if (time.charAt(0) == '2') {
                        hour = 4;
                    } else {
                        hour = 10;
                    }
                }
            }
        }
        if (time.charAt(3) == '?' && time.charAt(4) == '?') {
            minute = 60;
        } else if (time.charAt(3) == '?') {
            minute = 6;
        } else if (time.charAt(4) == '?') {
            minute = 10;
        }
        return hour * minute;
    }
}
