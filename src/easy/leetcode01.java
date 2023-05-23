package easy;

import java.util.Arrays;

public class leetcode01 {
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;

        int[] list = new int[len];
        for (int i = 0; i < len; i++) {
            list[i] = nums[i];
        }
//        quick_sort_recursive(list, 0, len-1);
        quicksort(list, 0, len - 1);
        int left = 0;
        int right = len - 1;
        while ((list[left] + list[right]) != target) {
            if ((list[left] + list[right]) > target) {
                right--;
            } else {
                left++;
            }
        }
        int ans1 = list[left];
        int ans2 = list[right];
        ans1 = index(nums, ans1);
        ans2 = index(nums, ans2);

        int[] out = new int[]{ans1, ans2};
        return out;

    }

    private static void quick_sort_recursive(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int mid = arr[end];
        int left = start, right = end - 1;
        while (left < right) {
            while (arr[left] <= mid && left < right)
                left++;
            while (arr[right] >= mid && left < right)
                right--;
            swap(arr, left, right);
        }
        if (arr[left] >= arr[end])
            swap(arr, left, end);
        else
            left++;
        quick_sort_recursive(arr, start, left - 1);
        quick_sort_recursive(arr, left + 1, end);
    }

    public static void quicksort(int[] list, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int key = begin;
        int left = begin;
        int right = end - 1;
        while (left < right) {
            while (left < right && list[left] <= list[key]) {
                left++;
            }
            while (right > left && list[right] >= list[key]) {
                right--;
            }
            swap(list, right, left);
        }
        swap(list, key, right);
        quicksort(list, begin, right - 1);
        quicksort(list, left + 1, end);
        return;
    }

    public static void swap(int[] list, int left, int right) {
        int temp = list[right];
        list[right] = list[left];
        list[left] = temp;
    }

    public static int index(int[] list, int out) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == out) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 18;
        int[] out = twoSum(nums, target);
        System.out.println(out);
//        int[] arr = new int[]{5,8,3,1,10,6,4};
//        quick_sort_recursive(arr,0, arr.length-1);
//        System.out.println(arr);
    }
}
