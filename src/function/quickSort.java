package function;

public class quickSort {
    int[] nums;

    private void swap(int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private void quickSort(int start, int end) {
        if (start >= end)
            return;
        int base = nums[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (right > left && nums[right] >= base) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= base) {
                left++;
            }
            nums[right] = nums[left];
//            swap(left, right);
        }
        nums[left] = base;
        quickSort(start, left - 1);
        quickSort(right + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 6, 4, 9, 2, 7, 0, 8, 5};
        quickSort q = new quickSort();
        q.nums = arr;
        q.quickSort(0, arr.length - 1);
        System.out.println("");
    }
}
