package cc189.ch8;

import java.util.*;

/**
 * Created by xu_xt on 10/19/18.
 */
public class Q8_8 {
    public List<String> permutationWithDup(String s) {
        List<String> results = new ArrayList<>();
        if (s == null) {
            return results;
        }
        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[s.length()];
        dfs(chars, visited, results, new StringBuilder());
        return results;
    }
    private void dfs(char[] chars, boolean[] visited, List<String> results, StringBuilder subset) {
        if (subset.length() == chars.length) {
            results.add(subset.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                subset.append(chars[i]);
                dfs(chars, visited, results, subset);
                subset.deleteCharAt(subset.length() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Q8_8 q = new Q8_8();
        List<String> result = q.permutationWithDup("aab");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
