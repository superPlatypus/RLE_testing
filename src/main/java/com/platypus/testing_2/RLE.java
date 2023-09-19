package com.platypus.testing_2;

public class RLE {
    public String encode(String input) {
        if (input == null || input.isEmpty() || !input.matches("^[A-Z]+$")) {
            throw new IllegalArgumentException("Incorrect input");
        }

        StringBuilder encoded = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                encoded.append(count).append(input.charAt(i - 1));
                count = 1;
            }
        }

        encoded.append(count).append(input.charAt(input.length() - 1));

        return encoded.toString();
    }

    public String decode(String input) {
        if (input == null || input.isEmpty() || !input.matches("([1-9]*[A-Z])*")) {
//        if (input == null || input.isEmpty() || !input.matches("^[A-Z1-9]+$")) {
            throw new IllegalArgumentException("Incorrect input");
        }

        StringBuilder decoded = new StringBuilder();
        int i = 0;

        while (i < input.length()) {
            int count = 0;

            while (i < input.length() && Character.isDigit(input.charAt(i))) {
                count = count * 10 + Character.getNumericValue(input.charAt(i));
                i++;
            }

            if (i < input.length()) {
                char character = input.charAt(i);
                for (int j = 0; j < count - 1; j++) { // j < count !!!!!!
                    decoded.append(character);
                }
                i++;
            } else {
                throw new IllegalArgumentException("Invalid input format.");
            }
        }

        return decoded.toString();
    }


}
