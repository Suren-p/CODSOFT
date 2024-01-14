import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text or provide a file path:");

        String input = scanner.nextLine();

        if (input.trim().isEmpty()) {
            System.out.println("Input is empty. Exiting...");
            return;
        }

        String text;
        if (input.startsWith("file:")) {

            String filePath = input.substring(5).trim();
            text = readFile(filePath);
        } else {
            text = input;
        }

   
        String[] words = text.split("[\\s\\p{Punct}]+");

    
        int wordCount = 0;

      
        String[] stopWords = {"the", "and", "is", "in", "to"};

    
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
 
            if (!isStopWord(word, stopWords)) {
                wordCount++;

              
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        
        System.out.println("Total number of words: " + wordCount);

      
        System.out.println("Number of unique words: " + wordFrequency.size());
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
        }

     
        scanner.close();
    }

    private static String readFile(String filePath) {
       
        try {
            return new String(Files.readAllBytes(new File(filePath).toPath()));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return "";
        }
    }

    private static boolean isStopWord(String word, String[] stopWords) {
       
        for (String stopWord : stopWords) {
            if (word.equalsIgnoreCase(stopWord)) {
                return true;
            }
        }
        return false;
    }
}
