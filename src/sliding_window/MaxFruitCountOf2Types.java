package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {
    public static void main(String[] args) {
        System.out.println(findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
    }

    public static int findLength(char[] arr) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int res = 0;

        for (int end = 0; end < arr.length; end++) {
            Character cur = arr[end];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            if (map.size() > 2) {
                while (map.size() > 2) {
                    Character left = arr[start];
                    map.put(left, map.get(left) - 1);
                    if (map.get(left) == 0) {
                        map.remove(left);
                    }
                    start++;
                }
            }
            res = Math.max(res, end - start +1);
        }
        return res;
    }
}
