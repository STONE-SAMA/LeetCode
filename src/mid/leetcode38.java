package mid;

import java.util.*;

public class leetcode38 {
    /*
    外观数列
    https://leetcode.cn/problems/count-and-say/
     */
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            ArrayList<HashMap<Character, Integer>> arrayList = new ArrayList<>();
            char temp = str.charAt(0);
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == temp) {
                    count++;
                    if (j == str.length() - 1) {
                        HashMap<Character, Integer> map = new HashMap<>();
                        map.put(temp, count);
                        arrayList.add(map);
                    }
                } else {
                    HashMap<Character, Integer> map = new HashMap<>();
                    map.put(temp, count);
                    arrayList.add(map);
                    temp = c;
                    count = 1;
                    if (j == str.length() - 1) {
                        HashMap<Character, Integer> hashMap = new HashMap<>();
                        hashMap.put(temp, count);
                        arrayList.add(hashMap);
                    }
                }
            }
            String string = "";
            for (int x = 0; x < arrayList.size(); x++) {
                HashMap<Character, Integer> map = arrayList.get(x);
                for (int value : map.values()) {
                    string += value;
                }
                for (Character key : map.keySet()) {
                    string += key;
                }
            }
            str = string;
        }
        return str;
    }

    public static void main(String[] args) {
        leetcode38 l = new leetcode38();
        String res = l.countAndSay(1);
        System.out.println(res);
    }
}
