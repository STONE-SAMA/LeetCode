package easy;

public class leetcode27 {
    /*
    移除元素
    https://leetcode.cn/problems/remove-element/
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;//左指针
        int j = nums.length - 1;//右指针
        int count = 0;
        while (i <= j) {
            if (nums[i] == val) {
                count++;
                while (nums[j]==val&&j>i){
                    j--;
                    count++;
                }
                nums[i]=nums[j];
                nums[j]=val;
                j--;
            }
            i++;
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        leetcode27 l = new leetcode27();
        int res = l.removeElement(new int[]{3, 2, 2, 3},3);
//        int res = l.removeElement(new int[]{1},1);
        System.out.println(res);
    }
}
