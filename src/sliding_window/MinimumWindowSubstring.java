package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(findSubstring("aabdec", "abc"));
    }

    public static String findSubstring(String str, String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int matched = 0;
        int minLength = str.length() + 1;
        int subStrStart = 0;

        for (char patternChar: pattern.toCharArray()) {
            map.put(patternChar, map.getOrDefault(patternChar, 0) + 1);
        }

        // try to extend the range [windowStart, windowEnd]
        for (int end = 0; end < str.length(); end++) {
            Character cur = str.charAt(end);

            if (map.containsKey(cur)) {
                map.put(cur, map.getOrDefault(cur, 0) - 1);
                // count every matching of a character
                if (map.get(cur) >= 0) {
                    matched++;
                }
            }

            // shrink the window if we can, finish as soon as we remove a matched character
            while (matched == pattern.length()) {
                if (minLength > end - start + 1) {
                    minLength = end - start + 1;
                    subStrStart = start;
                }

                char leftChar = str.charAt(start++);
                if (map.containsKey(leftChar)) {
                    // note that we could have redundant matching characters, therefore we'll decrement the
                    // matched count only when a useful occurrence of a matched character is going out of the window
                    if (map.get(leftChar) == 0) {
                        matched--;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }

        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    }
}
