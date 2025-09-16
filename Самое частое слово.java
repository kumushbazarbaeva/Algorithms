import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.useDelimiter("\\A").next();
        
        String[] words = text.split("\\s+");
        
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        
        int maxFrequency = Collections.max(frequencyMap.values());
        
        List<String> mostFrequentWords = frequencyMap.entrySet().stream()
            .filter(entry -> entry.getValue() == maxFrequency)
            .map(Map.Entry::getKey)
            .sorted()
            .collect(Collectors.toList());
        
        System.out.println(mostFrequentWords.get(0));
    }
}
