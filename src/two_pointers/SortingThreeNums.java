package two_pointers;

import java.util.Arrays;

public class SortingThreeNums {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        sort(arr);
        System.out.print(Arrays.toString(arr));

        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        sort(arr);
        System.out.print(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int first = 0;
        int last = arr.length - 1;

        for (int i = 0; i <= last;) {
            if (arr[i] == 0) {
                swap(arr, i, first);
                first++;
                i++;
            } else if (arr[i] == 2) {
                swap(arr, i, last);
                last--;
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
