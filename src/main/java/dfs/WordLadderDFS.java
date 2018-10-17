package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadderDFS {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        int n = dict.size();
        List<String> str = new ArrayList<>();
        for (String s : dict) {
            if (!s.equals(start) && !s.equals(end)) {
                str.add(s);
            }
        }
        boolean[] visited = new boolean[str.size()];
        int count = helper(start, end, visited, str, 1);
        return count == Integer.MAX_VALUE ? 0 :  count;
    }

    private int helper(String start, String end, boolean[] visited, List<String> s, int count) {
        if (oneLetterAway(start, end)) {
            return ++count;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < s.size(); i++) {
            if (!visited[i] && oneLetterAway(start, s.get(i))) {
                visited[i] = true;
                result = Math.min(result, helper(s.get(i), end, visited, s, ++count));
                count--;
                visited[i] = false;
            }
        }
        return result;
    }

    private boolean oneLetterAway (String original, String target) {
        int i = 0, j = 0;
        int n = original.length();
        int m = target.length();
        if (n != m){
            return false;
        }
        while (i < n && j < m && original.charAt(i) == target.charAt(j)) {
            i++;
            j++;
        }
        if (i == n && j == m) {
            return false;
        }
        StringBuilder a = new StringBuilder();
        a.append(original.substring(0, i));
        a.append(original.substring(i + 1, n));
        StringBuilder b = new StringBuilder();
        b.append(target.substring(0, j));
        b.append(target.substring(j + 1, m));
        return a.toString().equals(b.toString());
    }

    public static void main(String[] args) {
        WordLadderDFS wl = new WordLadderDFS();
        Set<String> set = new HashSet<>();
        set.add("ts");
        set.add("sc");
        set.add("ph");
        set.add("ca");
        set.add("jr");
        set.add("hf");
        set.add("to");
        set.add("if");
        set.add("ha");
        set.add("is");
        set.add("io");
        set.add("cf");
        set.add("ta");
        wl.ladderLength("ta", "if", set);
    }
}