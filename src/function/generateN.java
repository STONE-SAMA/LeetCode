package function;

import java.util.ArrayList;
import java.util.List;

public class generateN {
    //生成n个括号对

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private static void generate(List<String> res, String current, int left, int right, int max) {
        if (current.length() == max * 2) {
            res.add(current);
            return;
        }

        if (left < max) {
            generate(res, current + "(", left + 1, right, max);
        }
        if (right < left) {
            generate(res, current + ")", left, right + 1, max);
        }

    }

    public static void main(String[] args) {
        List<String> lists = generateParenthesis(3);
        for (String s:lists){
            System.out.println(s);
        }

    }

}
