package cc189.ch8;

import java.util.*;

/**
 * Created by xu_xt on 10/17/18.
 */
public class Q8_4 {
    public List<List<Integer>> powerSet(List<Integer> list) {
        List<List<Integer>> results = new ArrayList<>();
        if (list == null) {
            return results;
        }
        if (list.size() == 0) {
            results.add(new ArrayList<>());
        }
        Collections.sort(list);
        subset(list, results, new ArrayList<>(), 0);
        return results;
    }

    private void subset(List<Integer> list, List<List<Integer>> results, List<Integer> subset, int startIndex) {
        results.add(new ArrayList<>(subset));
        for (int i = startIndex; i < list.size(); i++) {
            if (i > startIndex && list.get(i) == list.get(i - 1)) {
                continue;
            }
            subset.add(list.get(i));
            subset(list, results, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
