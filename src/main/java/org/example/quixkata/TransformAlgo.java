package org.example.quixkata;

public class TransformAlgo {

    static String transformNumberToString(int number) {

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
