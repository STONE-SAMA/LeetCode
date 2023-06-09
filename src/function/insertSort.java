package function;

import java.util.Arrays;

public class insertSort {
    /**
     * 插入排序
     *
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {
//        int[] arr = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (temp > arr[j]) {
                    break;
                } else {
                    arr[j + 1] = arr[j];
                }
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 6, 4, 9, 2, 7, 0, 8, 5};
        int[] res = insertSort(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.printf(res[i] + " ");
        }
        System.out.println();
        System.out.println("finish");
    }
}
