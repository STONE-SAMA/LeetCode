package mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode2337 {
    /**
     * 移动片段得到字符串
     * https://leetcode.cn/problems/move-pieces-to-obtain-a-string/
     *
     * @param start
     * @param target
     * @return
     */
    public boolean canChange(String start, String target) {
        if (!start.replaceAll("_", "").equals(target.replaceAll("_", ""))) {
            return false;
        }
        Queue<Integer> start_L = new LinkedList<>();
        Queue<Integer> start_R = new LinkedList<>();
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == '_') {
                continue;
            }
            if (start.charAt(i) == 'L') {
                start_L.add(i);
            } else {
                start_R.add(i);
            }
        }
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == '_') {
                continue;
            }
            if (target.charAt(i) == 'L') {
                if (i > start_L.remove()) {
                    return false;
                }
            } else {
                if (i < start_R.remove()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        leetcode2337 l = new leetcode2337();
        String start = "_L__R__R_";
        String target = "L______RR";
        boolean res = l.canChange(start, target);
        System.out.println(res);
    }
}
