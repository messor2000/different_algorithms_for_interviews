package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2));
        System.out.println(findLength("abbcb", 1));
        System.out.println(findLength("abccde", 1));
    }
    public static int findLength(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int res = 0;
        int maxRepeatLetterCount = 0;

        for (int end = 0; end < str.length(); end++) {
            Character rightChar = str.charAt(end);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, map.get(rightChar));

            if (end - start - maxRepeatLetterCount + 1 > k) {
                char left = str.charAt(start);
                map.put(left, map.getOrDefault(left, 0) + 1);
                start++;
            }

            res = Math.max(res, end - start +1);
        }
        return res;
    }
}
