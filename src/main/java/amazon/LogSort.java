package amazon;

import java.util.*;

public class LogSort {
    /**
     * @param logs: the logs
     * @return: the log after sorting
     */
    public String[] logSort(String[] logs) {
        if(logs == null || logs.length == 0) {
            return logs;
        }
        int n = logs.length;
        String[] results = new String[n];
        List<String> letters = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String log = logs[i];
            // split id and content
            int index = log.indexOf(" ");
            String id = log.substring(0, index);
            String content = log.substring(index, log.length());
            map.put(content, i);
            if (content.length() > 0 && content.charAt(1) >= '0' && content.charAt(1) <= '9'){
                numbers.add(log);
            } else {
                letters.add(content);
            }
        }
        Collections.sort(letters);
        int i = 0;
        for(String content : letters) {
            int index = map.get(content);
            results[i] = logs[index];
            i++;
        }
        for (String log : numbers) {
            results[i] = log;
            i++;
        }
        return results;
    }
}
