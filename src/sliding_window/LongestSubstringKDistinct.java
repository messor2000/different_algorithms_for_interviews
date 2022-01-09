package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static void main(String[] args) {
        System.out.println(findLength("araaci", 2));
    }

    public static int findLength(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int res = 0;

        for (int end = 0; end < str.length(); end++) {
            Character cur = str.charAt(end);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            if (map.size() > k) {
                while (map.size() > k) {
                    Character left = str.charAt(start);
                    map.put(left, map.get(left) -1);
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
