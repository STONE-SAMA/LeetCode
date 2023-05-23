package easy;

public class letcode14 {
    /*
    最长公共前缀
    https://leetcode.cn/problems/longest-common-prefix/
     */
    public String longestCommonPrefix(String[] strs) {
        int index = -1;
        int min = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
            }
        }
        for (int i = 0; i < min; i++) {
            char c = strs[0].charAt(i);
            for (int j=1;j< strs.length;j++){
                if (strs[j].charAt(i)!=c){
                    return strs[0].substring(0,index+1);
                }
            }
            index=i;
        }
        return strs[0].substring(0,index+1);
    }
}
