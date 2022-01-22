package two_pointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class PairWithTargetSum {
    public static void main(String[] args) {
        long time = timer(() -> System.out.println(Arrays.toString(searchSimple(new int[]{1, 2, 3, 4, 6}, 6))));
        System.out.println(time);
        long time2 = timer(() -> System.out.println(Arrays.toString(searchHarder(new int[]{1, 2, 3, 4, 6}, 6))));
        System.out.println(time2);
        long time3 = timer(() -> System.out.println(Arrays.toString(searchWithHasTable(new int[]{1, 2, 3, 4, 6}, 6))));
        System.out.println(time3);
    }

    public static int[] searchSimple(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] searchHarder(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == target) {
                return new int[]{left, right}; // found the pair
            }

            if (target > currentSum) {
                left++; // we need a pair with a bigger sum
            } else {
                right--; // we need a pair with a smaller sum
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] searchWithHasTable(int[] arr, int target) {
        HashMap<Integer, Integer> nums = new HashMap<>(); // to store numbers and their indices
        for (int i = 0; i < arr.length; i++) {
            if (nums.containsKey(target - arr[i])) {
                return new int[]{nums.get(target - arr[i]), i};
            } else {
                nums.put(arr[i], i); // put the number and its index in the map
            }
        }
        return new int[]{-1, -1}; // pair not found
    }

    private static long timer(Runnable method) {
        long time = System.nanoTime();
        method.run();
        time = System.nanoTime() - time;
        return TimeUnit.NANOSECONDS.convert(time, TimeUnit.NANOSECONDS);
    }
}
