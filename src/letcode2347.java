import java.util.*;

public class letcode2347 {
    /*
    最好的扑克手牌
    https://leetcode.cn/problems/best-poker-hand/
     */
    public String bestHand(int[] ranks, char[] suits) {

        boolean flag = true;
        for (char c : suits) {
            if (c != suits[0]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return "Flush";
        }
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < ranks.length; i++) {
            if (!map.containsKey(ranks[i])){
                map.put(ranks[i], 1);
            }else {
                map.put(ranks[i], map.get(ranks[i])+1);
            }
        }
        int max = map.get(ranks[0]);
        for (int value:map.values()){
            if (value>max){
                max = value;
            }
        }
        if (max >= 3){
            return "Three of a Kind";
        }else if (max == 2){
            return "Pair";
        }

        return "High Card";
    }

}
