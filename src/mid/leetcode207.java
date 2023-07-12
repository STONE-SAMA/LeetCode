package mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class leetcode207 {
    /**
     * 课程表
     * https://leetcode.cn/problems/course-schedule
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);
        for (int i = 0; i < numCourses; i++)
            if (!dfs(adjacency, flags, i))
                return false;
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1)
            return false;
        if (flags[i] == -1)
            return true;
        flags[i] = 1;
        for (Integer j : adjacency.get(i))
            if (!dfs(adjacency, flags, j))
                return false;
        flags[i] = -1;
        return true;
    }
}
