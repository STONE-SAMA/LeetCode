package mid;

public class letcode12 {
    /*
    整数转罗马数字
    https://leetcode.cn/problems/integer-to-roman/
    */
    public String intToRoman(int num) {
        StringBuffer res = new StringBuffer();
        // 超过1000的添加M
        int num_M = num / 1000;
        while (num_M>0){
            res.append("M");
            num_M--;
        }
        num = num % 1000;
        int num_bai = num / 100;//百位
        if (num_bai==9){
            res.append("CM");
        } else if (num_bai==4) {
            res.append("CD");
        } else if (num_bai<4) {
            while (num_bai>0){
                res.append("C");
                num_bai--;
            }
        }else {
            res.append("D");
            num_bai = num_bai - 5;
            while (num_bai>0){
                res.append("C");
                num_bai--;
            }
        }
        num = num % 100;
        int num_shi = num / 10;
        if (num_shi==9){
            res.append("XC");
        } else if (num_shi==4) {
            res.append("XL");
        } else if (num_shi<4) {
            while (num_shi>0){
                res.append("X");
                num_shi--;
            }
        }else {
            res.append("L");
            num_shi = num_shi - 5;
            while (num_shi>0){
                res.append("X");
                num_shi--;
            }
        }
        num = num % 10;
        if (num==9){
            res.append("IX");
        }else if(num==4){
            res.append("IV");
        }else if (num<4) {
            while (num>0){
                res.append("I");
                num--;
            }
        }else {
            res.append("V");
            num = num - 5;
            while (num>0){
                res.append("I");
                num--;
            }
        }
        return res.toString();
    }
}
