package mid;

import java.util.ArrayList;
import java.util.List;

public class leetcode970 {
    /*
    强整数
    https://leetcode.cn/problems/powerful-integers/
     */
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> list = new ArrayList<>();
        if (x == 1 && y == 1) {
            if (bound>=2) {
                list.add(2);
            }
            return list;
        }
        for (int i = 0; i < bound; i++) {
            if (Math.pow(x, i) > bound)
                break;
            for (int j = 0; j < bound; j++) {
                int temp = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (temp <= bound && !list.contains(temp)) {
                    list.add(temp);
                }
                if (temp > bound || y==1)
                    break;
            }
            if (x==1)
                break;
        }
        return list;
    }

    public static void main(String[] args) {
        leetcode970 l = new leetcode970();
        List<Integer> res = l.powerfulIntegers(1, 2, 10);
        System.out.println(res);
    }
}
