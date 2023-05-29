package function;

public class MergeSort {
    /**
     * 归并排序
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    /**
     * 递归划分数组
     *
     * @param arr
     * @param start
     * @param end
     * @param temp
     */
    private static void mergeSort(int[] arr, int start, int end, int[] temp) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid, temp);
            mergeSort(arr, mid + 1, end, temp);
            mergeArray(arr, start, mid, end, temp);
        }
    }

    /**
     * 合并两个有序数组
     *
     * @param array
     * @param start
     * @param mid
     * @param end
     * @param temp
     */
    private static void mergeArray(int array[], int start, int mid, int end, int temp[]) {
        int i = start, j = mid + 1;//i为左数组的起点，j为右数组的起点
        int m = mid, n = end;//m为左数组的终点，n为右数组的终点
        int index = 0;//指向temp数组当前存放位置
        while (i <= m && j <= n) {//比较两数组的值
            if (array[i] < array[j]) {
                temp[index] = array[i];
                i++;
            } else {
                temp[index] = array[j];
                j++;
            }
            index++;
        }
        //插入比较后，数组中剩余的值
        while (i <= m) {
            temp[index] = array[i];
            i++;
            index++;
        }
        while (j <= n) {
            temp[index] = array[j];
            j++;
            index++;
        }
        //将temp数组中的值，拷贝到array数组的对应位置
        for (i = 0; i < index; i++) {
            array[start + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 4, 2, 1, 5, 7, 0, 9};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
