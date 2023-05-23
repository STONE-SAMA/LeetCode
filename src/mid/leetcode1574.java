package mid;

public class leetcode1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        for (; left < len - 1; left++) {
            if (arr[left] > arr[left + 1]) {
                break;
            }
        }
        if (left == right) {
            return 0;
        }
        for (; right > 0; right--) {
            if (arr[right] < arr[right - 1]) {
                break;
            }
        }
        int mark = left;
        boolean flag_left = false;
        boolean flag_right = false;
        while (arr[mark] > arr[right]) {
            mark--;
            if (mark < 0) {
                flag_left = true;
                break;
            }
        }
        int temp = right;
        while (arr[left] > arr[temp]) {
            temp++;
            if (temp > len - 1) {
                flag_right = true;
                break;
            }
        }

        int res = Math.max(left + 1, len - right);
        if (!flag_left) {
            res = Math.max(res, mark + 1 + len - right);
        }
        if (!flag_right) {
            res = Math.max(res, left + 1 + len - temp);
        }
        left--;
        right++;
        while (true) {
            if (left < 0 || right >= len) {
                return len - res;
            }
            if (arr[left] <= arr[right]) {
                break;
            } else {
                right++;
            }
        }
        return Math.min(len - res, right - left - 1);
    }


    public static void main(String[] args) {
        leetcode1574 l = new leetcode1574();
//        int res = l.findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 3, 5});
//        int res = l.findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 0, 7, 8, 9});
        int res = l.findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1});
        System.out.println(res);
    }
}
