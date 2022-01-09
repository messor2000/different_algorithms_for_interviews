package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
    public static void main(String[] args) {
        System.out.println(findLength("abccde"));
    }

    public static int findLength(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int res = 0;

        for (int end = 0; end < str.length(); end++) {
            Character rightChar = str.charAt(end);

            if (map.containsKey(rightChar)) {
                start = Math.max(start, map.get(rightChar) + 1);
            }

            map.put(rightChar, end);
            res = Math.max(res, end - start +1);
        }
        return res;
    }
}
