package Doc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentNumberValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введите путь к входному файлу
        System.out.print("Введите путь к входному файлу: ");
        String inputFilePath = scanner.nextLine();

        String validOutputFilePath = "src/Doc/valid_documents.txt";
        String invalidOutputFilePath = "src/Doc/invalid_documents.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             FileWriter validWriter = new FileWriter(validOutputFilePath);
             FileWriter invalidWriter = new FileWriter(invalidOutputFilePath)) {

            String line;
            Pattern docnumPattern = Pattern.compile("^(docnum)[a-zA-Z0-9]{9}$");
            Pattern contractPattern = Pattern.compile("^(contract)[a-zA-Z0-9]{7}$");

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                Matcher docnumMatcher = docnumPattern.matcher(line);
                Matcher contractMatcher = contractPattern.matcher(line);

                if ((line.length() == 15 && docnumMatcher.matches()) || (line.length() == 15 && contractMatcher.matches())) {
                    validWriter.write(line + "\n");
                } else {
                    invalidWriter.write(line + " - Неверный формат номера документа\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
