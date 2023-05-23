package mid;

public class leetcode1041 {
    /*
    困于环中的机器人
    https://leetcode.cn/problems/robot-bounded-in-circle/
     */
    public boolean isRobotBounded(String instructions) {
        int k = 0;
        int[] dist = new int[4];
        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            if (c == 'L') {
                k = (k + 1) % 4;
            } else if (c == 'R') {
                k = (k + 3) % 4;
            } else {
                dist[k]++;
            }
        }
        if (k != 0) {
            return true;
        } else if (dist[0] == dist[2] && dist[1] == dist[3]) {
            return true;
        } else {
            return false;
        }
    }
}
