package mid;

import java.util.*;

public class letcode17 {
    /*
    电话号码的字母组合
    https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int len = digits.length();
        if (len == 0) {
            return res;
        }
        Map<Character, String[]> map = new HashMap<>();
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});

        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            String[] str = map.get(digits.charAt(i));
            queue = queue_concat(queue, str);
        }

        for (String s : queue) {
            res.add(s);
        }

        return res;
    }

    private Queue<String> queue_concat(Queue<String> queue, String[] letters) {
        if (queue.size() == 0) {
            // 队列为0时，将第一个号码的字符放入队列
            for (String letter : letters) {
                queue.add(letter);
            }
        } else {
            // 出列拼接字符
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                String s = queue.poll();// 队首字符
                for (String letter : letters) {
                    queue.add(s + letter);
                }
            }
        }

        return queue;
    }

    public static void main(String[] args) {
        letcode17 l = new letcode17();
//        l.letterCombinations("");
        System.out.println(l.letterCombinations("2"));
    }
}
