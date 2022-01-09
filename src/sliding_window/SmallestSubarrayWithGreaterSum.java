package sliding_window;

public class SmallestSubarrayWithGreaterSum {
    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
    }

    public static int findMinSubArray(int S, int[] arr) {
        int start = 0;
        int sum = 0;
        int min = 19999999;

        if (arr[start] > S) {
            return 1;
        }

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            while (sum >= S) {
                sum -= arr[start];
                min = Math.min(min, end - start +1);
                start++;
            }
        }

        return min;
    }
}
