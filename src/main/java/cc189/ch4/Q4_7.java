package cc189.ch4;

import java.util.*;

/**
 * Created by xu_xt on 10/10/18.
 */

// dependency graph, we could use topological sorting
public class Q4_7 {
    public List<String> buildOrder(List<String> projects, List<List<String>> dependencies) throws NoValidBuildException {
        if (projects == null || projects.size() == 0) {
            return projects;
        }
        // no dependencies
        if (dependencies == null || dependencies.size() == 0) {
            return projects;
        }
        // precaculate indegree
        Map<String, Integer> count = new HashMap<>();
        Map<String, List<String>> dMap = new HashMap<>();
        for (List<String> d : dependencies) {
            count.put(d.get(1), count.getOrDefault(d.get(1), 0) + 1);
            if (!dMap.containsKey(d.get(0))) {
                dMap.put(d.get(0), new ArrayList<>());
            }
            dMap.get(d.get(0)).add(d.get(1));
        }
        Queue<String> q = new LinkedList<>();
        for (String p : projects) {
            if (!dMap.containsKey(p)) {
                q.add(p);
            }
        }
        List<String> result = new ArrayList<>();
        while (!q.isEmpty()) {
            String p = q.poll();
            result.add(p);
            if (dMap.containsKey(p)) {
                for (String dp : dMap.get(p)) {
                    int dCount = count.get(dp) - 1;
                    if (dCount == 0) {
                        q.add(dp);
                    }
                    count.put(dp, dCount);
                }
            }
        }
        if (result.size() < projects.size()) {
            throw new NoValidBuildException();
        }
        return result;
    }
    class NoValidBuildException extends Exception{

    }
}


