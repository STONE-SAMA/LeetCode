package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode40 {

    List<List<Integer>> lists = new ArrayList<>();
    int[] candidates;
    int target;

    /**
     * 组合总和 II
     * https://leetcode.cn/problems/combination-sum-ii/
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        if (candidates.length == 0) {
            return lists;
        }
        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        process(0, 0, list);
        return lists;
    }

    private void process(int start, int sum, List<Integer> list) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            lists.add(new ArrayList<>(list));
        }
        for (int i = start; i < candidates.length; i++) {
            if (i - 1 >= start && candidates[i - 1] == candidates[i]) {
                continue;
            }
            list.add(candidates[i]);
            process(i + 1, sum + candidates[i], list);
            list.remove(list.size() - 1);
        }
    }
}
