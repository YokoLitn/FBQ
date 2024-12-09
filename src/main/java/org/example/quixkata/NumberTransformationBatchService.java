package org.example.quixkata;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class NumberTransformationBatchService {
    private final FBQService fbqService;

    public NumberTransformationBatchService(FBQService fbqService) {
        this.fbqService = fbqService;
    }

    public void transformNumbersInFile(String inputFilePath, String outputFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line.trim());
                String transformedNumber = fbqService.transformNumberToString(number);
                writer.write(transformedNumber);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}