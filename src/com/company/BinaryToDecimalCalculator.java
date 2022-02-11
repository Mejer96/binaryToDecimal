package com.company;

import java.util.Scanner;

public class BinaryToDecimalCalculator {

    public static String receiveBinaryNumber() {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String userInput = null;

        System.out.println("Please enter the binary number you would like to convert to decimal:");

        while (loop) {
            System.out.print(">");
            userInput = scanner.nextLine();

            if (validateBinaryNumber(userInput)) {
                loop = false;
            }
        }
        return userInput;
    }

    public static boolean validateBinaryNumber(String binaryNumber) {
        char[] binaryNumberChars = binaryNumber.toCharArray();
        boolean inputIsValid = false;

        for (int i = 0; i < binaryNumberChars.length; i++) {
            if (binaryNumberChars[i] == '1' || binaryNumberChars[i] == '0') {
                inputIsValid = true;
            } else {
                System.out.println("Invalid input. Input must be ones and zeros");
                break;
            }
        }
        return inputIsValid;
    }

    public static void convertBinaryToDecimals(String binaryNumberToConvert) {
        char[] binaryNumberAsCharArray = binaryNumberToConvert.toCharArray();
        int counter = 0;
        
        for (int i = 0; i < binaryNumberAsCharArray.length; i++) {
            counter += Character.getNumericValue(binaryNumberAsCharArray[i]) * calculatePowerOf(binaryNumberAsCharArray.length - (i + 1));
        }
        System.out.println(counter);
    }

    public static int calculatePowerOf(int exponent) {
        int result = 1;
        // returns one if exponent = 0, due some math magic that dictates that a base number with the exponent of zero equals one.
        if (exponent != 0) {
            for (int i = 0; i < exponent; i++) {
                result *= 2;
            }
        }
        return result;
    }
}

