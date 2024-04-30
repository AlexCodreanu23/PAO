package task2;
import java.util.*;

public class WordCountDictionary implements WordCounter {
    private Map<String, Integer> wordCounts;

    public WordCountDictionary() {
        wordCounts = new HashMap<>();
    }

    @Override
    public void parse(String text) {
        String[] words = text.split("\\s+");
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }
    }

    @Override
    public int getCount(String word) {
        return wordCounts.getOrDefault(word, 0);
    }

    @Override
    public SortedSet<String> getUniqueWords() {
        return new TreeSet<>(wordCounts.keySet());
    }

    @Override
    public void printWordCounts() {
        TreeMap<String, Integer> sortedByCount = new TreeMap<>((a, b) -> wordCounts.get(b).compareTo(wordCounts.get(a)));
        sortedByCount.putAll(wordCounts);
        sortedByCount.forEach((word, count) -> System.out.println(word + ": " + count));
    }

    @Override
    public void reset() {
        wordCounts.clear();
    }
}
