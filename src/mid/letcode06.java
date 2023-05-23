package mid;

import java.util.ArrayList;
import java.util.List;

public class letcode06 {
    /*
    N 字形变换
    https://leetcode.cn/problems/zigzag-conversion/
     */
    public String convert(String s, int numRows) {
        StringBuffer res = new StringBuffer();
        int distance = 2 * numRows - 2;
        if (distance < 2) {
            return s;
        }
        int num = s.length() / distance + 1;
//        num = s.length() % distance == 0 ? num : num + 1;
        List<Integer> arrList = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            int flag = i;
            if (flag > s.length()) {
                break;
            }
            for (int j = 0; j <= num; j++) {
                int temp = j * distance;
                if (temp - i >= 0 && temp - i < s.length()) {
                    if (!arrList.contains(temp - i)) {
                        arrList.add(temp - i);
                        res.append(s.charAt(temp - i));
                    }
                }
                if (temp + i < s.length()) {
                    if (!arrList.contains(temp + i)) {
                        arrList.add(temp + i);
                        res.append(s.charAt(temp + i));
                    }
                } else {
                    break;
                }
            }
        }

//        for (int index : arrList){
//            res.append(s.charAt(index));
//        }

        return res.toString();
    }

    public static void main(String[] args) {
        letcode06 l = new letcode06();

//        String str = "PAYPALISHIRING";
//        int raws = 3;

        String str = "ABCDE";
        int raws = 4;

        String res = l.convert(str, raws);
        System.out.println(res);
    }
}
