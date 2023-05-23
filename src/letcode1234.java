
import java.util.ArrayList;
import java.util.Arrays;

public class letcode1234 {
    /*
    替换子串得到平衡字符串
    https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
     */
    public int balancedString(String s) {
        String str = "QWER";
        int[] arr = {0,0,0,0};
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='Q'){
                arr[0]++;
            } else if (s.charAt(i)=='W') {
                arr[1]++;
            } else if (s.charAt(i)=='E') {
                arr[2]++;
            }else {
                arr[3]++;
            }
        }
        //最多字符数量
        int max = Math.max(arr[0],arr[1]);
        max = Math.max(max,arr[2]);
        max = Math.max(max,arr[3]);

        if (max==s.length()/4){
            return 0;
        }

        int index = 0;
        for (;index<4;index++){
            if (arr[index]==max){
                break;
            }
        }
        //最多的字符
        Character c = str.charAt(index);

        int num = max - s.length()/4;//需要在字串中找到的最多字符的数量

        int left=0;//首个最多字符的位置
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==c){
                left=i;
                break;
            }
        }
        int[] distance = new int[max-1];
        int count = 0;
        for (int i=left+1;i<s.length();i++){
            if (s.charAt(i)==c){
                distance[count] = i-left-1;
                count++;
                left=i;
            }
        }
        int i=0;
        int min = 0;
        while (i!=num-1){
            min+=distance[i];
            i++;
        }
        for (int j=i-1;j<max-num*2+2;j++){
            int temp=0;
            int flag=0;
            while (flag!=num-1){
                temp+=distance[j+flag];
                flag++;
            }
            if (temp<min){
                min=temp;
            }
        }

        return min+num;
    }

    public static void main(String[] args) {
        letcode1234 l = new letcode1234();
//        int res = l.balancedString("QQWE");
//        int res = l.balancedString("WWEQERQWQWWRWWERQWEQ");
        int res = l.balancedString("WQWRQQQW");
        System.out.println(res);
    }
}
