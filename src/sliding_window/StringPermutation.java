package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    public static void main(String[] args) {
        System.out.println(findPermutation("odicf", "dc"));
    }

    public static boolean findPermutation(String str, String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int matched = 0;

        for (char patternChar: pattern.toCharArray()) {
            map.put(patternChar, map.getOrDefault(patternChar, 0) + 1);
        }

        for (int end = 0; end < str.length(); end++) {
            Character cur = str.charAt(end);

            if (map.containsKey(cur)) {
                map.put(cur, map.getOrDefault(cur, 0) - 1);
                if (map.get(cur) == 0) {
                    matched++;
                }
            }

            if (matched == map.size()) {
                return true;
            }

            if (map.size() >= pattern.length() - 1) {
                Character left = str.charAt(start);

                if (map.containsKey(left)) {
                    if (map.get(left) == 0) {
                        matched--;
                    }
                    map.put(left, map.get(left) + 1);
                }
            }
        }

        return false;
    }
}
