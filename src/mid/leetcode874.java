package mid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode874 {
    /**
     * 模拟行走机器人
     * https://leetcode.cn/problems/walking-robot-simulation/
     *
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < obstacles.length; i++) {
            Set<Integer> set;
            if (map.containsKey(obstacles[i][0])) {
                set = map.get(obstacles[i][0]);
            } else {
                set = new HashSet<>();
            }
            set.add(obstacles[i][1]);
            map.put(obstacles[i][0], set);
        }
        int x = 0, y = 0;
        int direction = 0;//0北（上）1东（右）2南（下）3西（左）
        int max = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                direction = (direction + 3) % 4;
            } else if (commands[i] == -1) {
                direction = (direction + 5) % 4;
            } else {
                int step = commands[i];
                int target_x;
                int target_y;
                if (direction == 0) {
                    target_x = x;
                    target_y = y + step;
                    for (int j = 1; j <= step; j++) {
                        if (map.containsKey(x)) {
                            Set<Integer> set = map.get(x);
                            if (set.contains(y + j)) {
                                target_y = y + j - 1;
                                break;
                            }
                        }
                    }
                } else if (direction == 1) {
                    target_x = x + step;
                    target_y = y;
                    for (int j = 1; j <= step; j++) {
                        if (map.containsKey(x + j)) {
                            Set<Integer> set = map.get(x + j);
                            if (set.contains(y)) {
                                target_x = x + j - 1;
                                break;
                            }
                        }
                    }
                } else if (direction == 2) {
                    target_x = x;
                    target_y = y - step;
                    for (int j = 1; j <= step; j++) {
                        if (map.containsKey(x)) {
                            Set<Integer> set = map.get(x);
                            if (set.contains(y - j)) {
                                target_y = y - j + 1;
                                break;
                            }
                        }
                    }
                } else {
                    target_x = x - step;
                    target_y = y;
                    for (int j = 1; j <= step; j++) {
                        if (map.containsKey(x - j)) {
                            Set<Integer> set = map.get(x - j);
                            if (set.contains(y)) {
                                target_x = x - j + 1;
                                break;
                            }
                        }
                    }
                }
                x = target_x;
                y = target_y;
                max = Math.max(max, x * x + y * y);
            }
        }
        return max;
    }
}
