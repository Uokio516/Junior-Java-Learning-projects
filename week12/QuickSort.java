import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7, 9, 4, 3, 2, 1};
        System.out.println("原本的陣列: " + Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println("跑完後的陣列: " + Arrays.toString(arr));
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
