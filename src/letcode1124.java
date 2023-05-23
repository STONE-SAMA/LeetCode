import java.util.HashMap;
import java.util.Map;

public class letcode1124 {
    /*
    表现良好的最长时间段
    https://leetcode.cn/problems/longest-well-performing-interval/
     */
    public int longestWPI(int[] hours){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int s = 0, res = 0;
        for (int i=0;i< hours.length;i++){
            s += hours[i] > 8 ? 1 : -1;
            if (s>0){
                res = Math.max(res, i+1);
            }else {
                if (map.containsKey(s-1)){
                    res = Math.max(res, i-map.get(s-1));
                }
            }
            if (!map.containsKey(s)){
                map.put(s, i);
            }
        }
        return res;
    }

    //超时
    public int longestWPI_old(int[] hours) {
        int count = 0;
        for (int i=0;i< hours.length;i++){//得到工作表中劳累天数的总数
            if (hours[i]>8){
                count++;
            }
        }
        if (count==0){
            return 0;
        }
        int temp = 2*count-1;
        while (temp>1){
            for (int i=0;i<=hours.length-temp;i++){
                int flag = 0;
                for (int j=0;j<temp;j++){
                    if (hours[i+j]>8){
                        flag++;
                    }
                }
                if (flag>temp/2){
                    return temp;
                }
            }
            temp--;
        }
        return 1;
    }

    public static void main(String[] args) {
        letcode1124 l = new letcode1124();
        int[] hours = {9,9,6,0,6,6,9};
        int res = l.longestWPI(hours);
        System.out.println(res);
    }
}
