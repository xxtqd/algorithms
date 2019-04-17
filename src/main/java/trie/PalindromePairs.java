package trie;

import java.util.*;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2) {
            return result;
        }
        int n = words.length;
        Node root = new Node();
        for (int i = 0; i < n; i++) {
            addWord(root, words[i], i);
        }
        for (int i = 0; i < n; i++) {
            searchWord(root, words[i], i, result);
        }
        return result;
    }

    private void addWord(Node root, String word, int index) {
        Node current = root;
        if (isPalindrome(word)) {
            current.palindromeAfter.add(index);
        }
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (!current.children.containsKey(c)) {
                current.children.put(c, new Node());
            }
            current = current.children.get(c);
            if (isPalindrome(word.substring(0, i))) {
                current.palindromeAfter.add(index);
            }
        }
        current.endHere.add(index);
    }

    private void searchWord(Node root, String word, int index, List<List<Integer>> result) {
        Node current = root;
        for(int i = 0; i < word.length(); i++) {
            String rest = word.substring(i);
            if (isPalindrome(rest)) {
                for (int j : current.endHere) {
                    if (j != index) {
                        result.add(Arrays.asList(new Integer[]{index, j}));
                    }
                }
            }
            current = current.children.get(word.charAt(i));
            if (current == null) {
                break;
            }
        }
        if (current != null) {
            for (int j : current.palindromeAfter) {
                if (j != index) {
                    result.add(Arrays.asList(new Integer[]{index, j}));
                }
            }
        }
    }

    class Node {
        List<Integer> palindromeAfter;
        List<Integer> endHere;
        Map<Character, Node> children;
        Node() {
            palindromeAfter = new ArrayList<>();
            endHere = new ArrayList<>();
            children = new HashMap<>();
        }
    }
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePairs pp = new PalindromePairs();
        pp.palindromePairs(new String[]{"a", ""});
    }
}
