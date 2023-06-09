package function;

public class selectSort {
    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 6, 4, 9, 2, 7, 0, 8, 5};
        int[] res = selectSort(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.printf(res[i] + " ");
        }
        System.out.println();
        System.out.println("finish");
    }
}
