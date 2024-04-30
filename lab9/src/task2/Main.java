package task2;

public class Main {
    public static void main(String[] args) {
        WordCountDictionary wordCounter = new WordCountDictionary();

        String text = "Lorem ipsum dolor sit amet,  consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore Lorem magna aliqua. Eu tincidunt tortor aliquam nulla facilisi cras fermentum. In est ante in nibh mauris cursus. Facilisis magna etiam tempor orci eu. Sed sed risus pretium quam vulputate dignissim suspendisse in. Interdum velit laoreet id donec ultrices tincidunt arcu non";
        wordCounter.parse(text);

        System.out.println("Count for 'Lorem': " + wordCounter.getCount("Lorem"));
        System.out.println("Count for 'ipsum': " + wordCounter.getCount("ipsum"));
        System.out.println("Unique words: " + wordCounter.getUniqueWords());
        System.out.println("Word counts in descending order:");
        wordCounter.printWordCounts();

    }
}