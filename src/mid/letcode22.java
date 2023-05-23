package mid;

import java.util.ArrayList;
import java.util.List;

public class letcode22 {
    /*
    括号生成
    https://leetcode.cn/problems/generate-parentheses/
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 1) {
            res.add("()");
        } else {
            dfs("", n, n, res);
        }
        return res;
    }

    private void dfs(String str, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(str + "(", left - 1, right, res);
        }
        if (right > 0) {
            dfs(str + ")", left, right - 1, res);
        }
    }

    public static void main(String[] args) {
        letcode22 l = new letcode22();
        List<String> res = l.generateParenthesis(2);
        System.out.println(res);
    }
}