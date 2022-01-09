package sliding_window;

public class MaximumSumSubarrayOfSizeK {
    public static void main(String[] args) {
        System.out.println(findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        int result = 0;
        int windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= k - 1) {
                result = Math.max(result, windowSum);// calculate the average
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return result;
    }
}
