package two_pointers;

import java.util.concurrent.TimeUnit;

public class RemoveElement {
    public static void main(String[] args) {
        long time = timer(() -> System.out.println(remove(new int[]{3, 2, 3, 6, 3, 10, 9, 3}, 3)));
        System.out.println(time);

        long time2 = timer(() -> System.out.println(removeHarder(new int[]{3, 2, 3, 6, 3, 10, 9, 3}, 3)));
        System.out.println(time2);
    }

    public static int remove(int[] arr, int key) {
        int length = arr.length;

        for (int j : arr) {
            if (j == key) {
                length--;
            }
        }

        return length;
    }

    public static int removeHarder(int[] arr, int key) {
        int nextElement = 0; // index of the next element which is not 'key'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextElement] = arr[i];
                nextElement++;
            }
        }

        return nextElement;
    }

    private static long timer(Runnable method) {
        long time = System.nanoTime();
        method.run();
        time = System.nanoTime() - time;
        return TimeUnit.NANOSECONDS.convert(time, TimeUnit.NANOSECONDS);
    }
}
