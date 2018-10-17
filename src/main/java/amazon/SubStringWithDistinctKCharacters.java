package amazon;

import java.util.*;

public class SubStringWithDistinctKCharacters {
    public List<String> distinctKSubString(String s, int k) {
        if (s == null || s.length() < k) {
            return new ArrayList<>();
        }
        int n = s.length();
        int start = 0;
        Set<String> set = new HashSet<>();
        Map<Character, Integer> map  = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                for (int j = start; j < map.get(c); j++) {
                    map.remove(s.charAt(j));
                }
                start = map.get(c) + 1;
                map.put(c, i);
            } else {
                map.put(c, i);
            }
            if (map.size() == k) {
                set.add(s.substring(start, i + 1));
                map.remove(s.charAt(start));
                start++;
            }
        }
        List<String> result = new ArrayList<>(set);
        return result;
    }

    public static void main(String[] args) {
        SubStringWithDistinctKCharacters s = new SubStringWithDistinctKCharacters();
        for (String str : s.distinctKSubString("awaglknagawunagwkwagl", 4)) {
            System.out.println(str);
        }

    }
}
