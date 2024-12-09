package org.example.quixkata;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transform")
public class FBQController {


    @GetMapping("/{number}")
    public ResponseEntity<String> transformNumber(@PathVariable int number) {
        String result = transformNumberToString(number);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private String transformNumberToString(int number) {

        StringBuilder result = new StringBuilder();

        if (number % 3 == 0) result.append("FOO");
        if (number % 5 == 0) result.append("BAR");

        String numStr = String.valueOf(number);
        for (char c : numStr.toCharArray()) {
            if (c == '3') result.append("FOO");
            if (c == '5') result.append("BAR");
            if (c == '7') result.append("QUIX");
        }

        // Return result or the number as a string
        return !result.isEmpty() ? result.toString() : numStr;

    }
}