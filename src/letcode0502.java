public class letcode0502 {
    /*
    面试题 05.02. 二进制数转字符串
    https://leetcode.cn/problems/bianry-number-to-string-lcci/
     */
    public String printBin(double num) {
        StringBuffer res = new StringBuffer("0.");
        while (res.length()<32 && num!=0){
            num *= 2;
            if (num>=1){
                res.append(1);
                num -= 1;
            }else {
                res.append(0);
            }
        }
        if (num==0){
            return res.toString();
        }else {
            return "ERROR";
        }
    }
}
