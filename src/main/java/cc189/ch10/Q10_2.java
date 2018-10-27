package cc189.ch10;

import java.util.*;

/**
 * Created by xu_xt on 10/24/18.
 */
// Brute force: pick one string at a time, scan the rest of the string to find all the anagrams. O(n^2 * k) time where n is the number of strings and k is the average length of string
// Sort by length O(nlogn), pick one string, keep a pointer to the last anagram, scan the rest, if a following string is an anagram, swap with the string next the the last anagram, update the pointer. Worst case O(n^2k)
// keep a hash map of “root” strings and its list of anagram, scan through the array and update the map. O(nklogk) time O(n) space
public class Q10_2 {
    public List<List<String>> groupAnagram(String[] words) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String root = new String(chars);
            if(!groups.containsKey(root)) {
                groups.put(root, new ArrayList<>());
            }
            groups.get(root).add(word);
        }
        List<List<String>> results = new ArrayList<>();
        for (List<String> list : groups.values()) {
            results.add(list);
        }
        return results;
    }
}
