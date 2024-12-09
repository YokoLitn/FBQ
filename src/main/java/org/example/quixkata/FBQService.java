package org.example.quixkata;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class FBQService {
    public void transformNumbersInFile(String inputFilePath, String outputFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line.trim());
                String transformedNumber = transformNumberToString(number);
                writer.write(transformedNumber);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erreur"+e);
        }
    }

    String transformNumberToString(int number) {

        StringBuilder res = new StringBuilder();

        if (number % 3 == 0) res.append("FOO");
        if (number % 5 == 0) res.append("BAR");


        String res2 = String.valueOf(number);
        for (char c : res2.toCharArray()) {
            if (c == '7') res.append("QUIX");
            if (c == '5') res.append("BAR");
            if (c == '3') res.append("FOO");
        }

        return !res.isEmpty() ? res.toString() : res2;
    }
}