import java.io.*;
import java.nio.file.*;
import java.util.*;

public class mojaDwunastaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ścieżkę do pliku wejściowego:");
        String inputFilePath = scanner.nextLine();

        while (!Files.exists(Paths.get(inputFilePath))) {
            System.out.println("Plik wejściowy nie istnieje. Podaj poprawną ścieżkę:");
            inputFilePath = scanner.nextLine();
        }

        System.out.println("Podaj ścieżkę do pliku wyjściowego:");
        String outputFilePath = scanner.nextLine();

        try {
            Path inputPath = Paths.get(inputFilePath);
            List<String> lines = Files.readAllLines(inputPath);

            int lineCount = lines.size();

            System.out.println("Liczba linii w pliku: " + lineCount);

            String resultContent = "Nazwa pliku: " + inputFilePath + "\nLiczba linii: " + lineCount;

            Files.write(Paths.get(outputFilePath), resultContent.getBytes());

            System.out.println("Wynik zapisano do pliku: " + outputFilePath);
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas przetwarzania pliku: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
