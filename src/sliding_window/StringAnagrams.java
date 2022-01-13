package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {
    public static void main(String[] args) {
        System.out.println(findStringAnagrams("abbcabc", "abc"));
    }

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
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
                resultIndices.add(end);
            }

            if (end >= pattern.length() - 1) {
                Character left = str.charAt(start++);

                if (map.containsKey(left)) {
                    if (map.get(left) == 0) {
                        matched--;
                    }
                    map.put(left, map.get(left) + 1);

                }
            }
        }

        return resultIndices;
    }
}
