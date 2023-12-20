package LongWord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LongestWordAnalyzer {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/LongWord/romeo_and_juliet.txt"))) {
            String line;
            String longestWord = "";

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }

            try (FileWriter writer = new FileWriter("src/LongWord/longest_word.txt")) {
                writer.write(longestWord);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
