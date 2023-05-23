public class letcode1247 {
    /*
    交换字符使得字符串相同
    https://leetcode.cn/problems/minimum-swaps-to-make-strings-equal/
     */
    public int minimumSwap(String s1, String s2) {
        int count = 0;
        int xy=0,yx=0;
        for (int i=0;i<s1.length();i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1!=c2){
                if (c1=='x'){
                    xy+=1;
                }else {
                    yx+=1;
                }
            }
        }
        count += xy/2 + yx/2;
        if (xy%2!=yx%2){
            return -1;
        }else if (xy%2!=0){
            count += 2;
        }
        return count;
    }

    public static void main(String[] args) {
        letcode1247 l = new letcode1247();
        l.minimumSwap("xx","yy");
    }
}
