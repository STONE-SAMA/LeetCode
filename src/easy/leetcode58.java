package easy;

public class leetcode58 {
    /**
     * 最后一个单词的长度
     * https://leetcode.cn/problems/length-of-last-word
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s.length() == 1) {
            return 1;
        }
        String[] str = s.split(" ");
        for (int i= str.length;i>0;i--){
            if(str[i-1].length()!=0){
                return str[i-1].length();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        leetcode58 l = new leetcode58();
        int i = l.lengthOfLastWord("   fly me   to   the moon  ");
        System.out.println(i);
    }
}
