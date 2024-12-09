package org.example.quixkata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(NumberTransformationBatchService batchService) {
        return args -> {
            String inputFilePath = "src/main/resources/input.txt";
            String outputFilePath = "src/main/resources/output.txt";
            batchService.transformNumbersInFile(inputFilePath, outputFilePath);
        };
    }
}