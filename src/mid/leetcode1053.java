package mid;

public class leetcode1053 {
    /*
    交换一次的先前排列
    https://leetcode.cn/problems/previous-permutation-with-one-swap/
     */
    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        int i = len - 2;
        for (; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                break;
            }
        }
        if (i == -1) {
            return arr;
        }

        int j = i + 1;
        int mark = arr[j];
        int index = j;
        for (; j < len; j++) {
            if (mark <= arr[j] && arr[j] < arr[i]) {
                mark = arr[j];
                index = j;
            }
        }

        if (mark > arr[i + 1]) {
            arr[index] = arr[i];
            arr[i] = mark;
        } else {
            int temp = arr[i + 1];
            arr[i + 1] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        leetcode1053 l = new leetcode1053();
//        int[] arr = {3, 1, 1, 3};
        int[] arr = {1, 1, 5};
        int[] res = l.prevPermOpt1(arr);
        System.out.println(res);

    }

}
