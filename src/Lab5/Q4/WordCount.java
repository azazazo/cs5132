package Lab5.Q4;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordCount {
    private HashMap<String, Integer> dictionary;

    // Populates the dictionary by reading the text in the file called filename
    // All words are stored in lowercase with no punctuation or spaces
    // Hint: Use regex to remove the punctuation from all words
    public WordCount(String filename) {
        // Complete the code below this comment
        try {
            String content = Files.readString(Paths.get(filename));
            content = content.toLowerCase().replaceAll("[^a-z ]", "");
            dictionary = new HashMap<>();
            for (String word : content.split(" ")) {
                if (!dictionary.containsKey(word)) dictionary.put(word, 1);
                else dictionary.put(word, dictionary.get(word) + 1);
            }
        } catch (Exception ignored) {
            System.out.printf("womp %s\n", ignored.getMessage());
        }
    }

    // Returns the count for a given word
    // If the word cannot be found, return 0
    public int getCount(String word) {
        // Complete the code below this comment
        if (!dictionary.containsKey(word)) return 0;
        return dictionary.get(word);
    }

    // Returns true if the dictionary has the word, false otherwise
    public boolean hasWord(String word) {
        // Complete the code below this comment
        return dictionary.containsKey(word);
    }

    // Returns the word with the maximum count in the dictionary
    public String getWordWithMaxCount() {
        // Complete the code below this comment
        return Collections.max(dictionary.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    // Returns an ArrayList of Strings of all unique words in the story.
    public ArrayList<String> getAllUniqueWords() {
        // Complete the code below this comment
        return new ArrayList<>(dictionary.keySet().stream().sorted().toList());
    }

    @Override
    public String toString() {
        return dictionary.toString();
    }
}
