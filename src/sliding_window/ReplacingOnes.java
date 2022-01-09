package sliding_window;

public class ReplacingOnes {
    public static void main(String[] args) {
        System.out.println(findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
    }

    public static int findLength(int[] arr, int k) {
        int start = 0;
        int res = 0;
        int maxOnesCount = 0;

        for (int end = 0; end < arr.length; end++) {

            if (arr[end] == 1) {
                maxOnesCount++;
            }

            if (end - start - maxOnesCount + 1 > k) {
                if (arr[start] == 1) {
                    maxOnesCount--;
                }
                start++;
            }

            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
