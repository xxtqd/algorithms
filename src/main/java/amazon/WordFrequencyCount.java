package amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordFrequencyCount {
    public String[] getWords(String s, String[] exclude){
        if (s == null) {
            return null;
        }
        Set<String> excludeSet = new HashSet<>();
        for (String word : exclude){
            excludeSet.add(word.toLowerCase());
        }
        String[] words = s.split("[^a-zA-Z]");
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words){
            word = word.toLowerCase();
            if(!excludeSet.contains(word)){
                if(!countMap.containsKey(word)){
                    countMap.put(word, 0);
                }
                countMap.put(word, countMap.get(word) + 1);
            }
        }
        int count = 0;
        int max = 0;
        for (String word : countMap.keySet()){
            if (countMap.get(word) > max){
                max = countMap.get(word);
                count = 1;
            } else if (countMap.get(word) == max) {
                count++;
            }
        }
        String[] results = new String[count];
        int i = 0;
        for (String word : countMap.keySet()) {
            if(countMap.get(word) == max){
                results[i++] = word;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        WordFrequencyCount wcf = new WordFrequencyCount();
        String s = "Jack and Jil went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.";
        String[] exclude = new String[]{"and", "he", "the", "to", "is", "Jack", "Jill"};
        String[] results = wcf.getWords(s, exclude);
        for(String word : results){
            System.out.println(word);
        }

    }
}