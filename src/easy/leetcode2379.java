package easy;

public class leetcode2379 {
    /*
    得到 K 个黑块的最少涂色次数
    https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
     */
    public int minimumRecolors(String blocks, int k) {
        int[] arr = new int[blocks.length()];
        int mark = 0;
        for (int i=0;i<blocks.length();i++){
            if (blocks.charAt(i)=='W'){
                arr[i] = 0;
                mark++;
            }else {
                arr[i] = 1;
            }
        }
        if (k==blocks.length()){
            return mark;
        }
        int min = k;
        for (int i=0;i<=blocks.length()-k;i++){
            int count=0;
            for (int j=0;j<k;j++){
                if (arr[j+i]==0){
                    count++;
                }
            }
            if (min>count){
                min = count;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        leetcode2379 l = new leetcode2379();
//        int res = l.minimumRecolors("WBBWWBBWBW",7);
        int res = l.minimumRecolors("WWBBBWBBBBBWWBWWWB",16);//6
        System.out.println(res);
    }
}
