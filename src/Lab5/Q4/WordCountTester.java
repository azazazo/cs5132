package Lab5.Q4;

public class WordCountTester {
    public static void main(String[] args) {
        WordCount dict = new WordCount("./src/Lab5/Q4/story.txt");
        System.out.println(dict.getAllUniqueWords());
        System.out.println(dict.getCount("was"));
        System.out.println(dict.getCount("ron"));
        System.out.println(dict.getWordWithMaxCount());
        System.out.println(dict.hasWord("harry"));
        System.out.println(dict.hasWord("hermione"));
        System.out.println(dict);
    }
}
