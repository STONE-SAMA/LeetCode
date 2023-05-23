package easy;

import java.util.HashMap;

public class letcode13 {
    /*
    罗马数字转整数
    https://leetcode.cn/problems/roman-to-integer/
     */
    public int romanToInt(String s) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int res = map.get(s.charAt(len - 1));
        int index = len - 2;
        while (index >= 0) {
            int now = map.get(s.charAt(index));
            int right = map.get(s.charAt(index + 1));
            if (now >= right) {
                res += now;
            } else {
                res -= now;
            }
            index--;
        }
        return res;
    }

    public static void main(String[] args) {
        letcode13 l = new letcode13();
        int res = l.romanToInt("III");
        System.out.println(res);
    }
}
