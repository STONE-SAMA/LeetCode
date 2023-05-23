public class letcode2335 {
    /*
    装满杯子需要的最短总时长
    https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/
     */
    public int fillCups(int[] amount) {
        int cold = amount[0];
        int warm = amount[1];
        int hot = amount[2];
        int count = 0;
        while (cold>0||warm>0||hot>0){
            if (cold>=warm&&cold>=hot){//冷水杯数最多
                if (Math.max(warm,hot)>0) {
                    if (warm >= hot) {
                        warm--;
                    } else {
                        hot--;
                    }
                }
                cold--;
                count++;
            } else if (warm>=cold&&warm>=hot) {//温水杯数最多
                if (Math.max(cold,hot)>0) {
                    if (cold >= hot) {
                        cold--;
                    } else {
                        hot--;
                    }
                }
                warm--;
                count++;
            }else {//热水杯数最多
                if (Math.max(cold,warm)>0) {
                    if (cold >= warm) {
                        cold--;
                    } else {
                        warm--;
                    }
                }
                hot--;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        letcode2335 l = new letcode2335();
        int[] arr = {1,4,2};
        System.out.println(l.fillCups(arr));
    }
}
