import java.io.*;
import java.nio.file.*;
import java.util.*;

public class mojaTrzynastaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path inputPath = null;
        Path outputPath;

        while (true) {
            System.out.print("Podaj ścieżkę do pliku wejściowego: ");
            String inputFilePath = scanner.nextLine();
            inputPath = Paths.get(inputFilePath);

            if (Files.exists(inputPath)) {
                break;
            } else {
                System.out.println("Plik nie istnieje. Spróbuj ponownie.");
            }
        }

        System.out.print("Podaj ścieżkę do pliku wyjściowego: ");
        String outputFilePath = scanner.nextLine();
        outputPath = Paths.get(outputFilePath);

        try {
            String content = Files.readString(inputPath);
            String[] words = content.split("\\s+");

            int totalWords = 0;
            Map<String, Integer> wordCounts = new TreeMap<>();

            for (String word : words) {
                if (!word.isBlank()) {
                    word = word.toLowerCase().replaceAll("[^a-zA-Z0-9ąćęłńóśźżĄĆĘŁŃÓŚŹŻ]", "");
                    if (!word.isEmpty()) {
                        totalWords++;
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }

            System.out.println("Liczba słów w pliku: " + totalWords);
            System.out.println("Wystąpienia słów:");
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
                writer.write("Nazwa pliku wejściowego: " + inputPath.getFileName() + "\n");
                writer.write("Liczba słów: " + totalWords + "\n");
                writer.write("Wystąpienia słów:\n");
                for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
                }
            }

            System.out.println("Dane zapisano do pliku: " + outputPath.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas przetwarzania pliku: " + e.getMessage());
        }
    }
}
