package General;

import java.util.Scanner;

public class ConcatenateCharacters {

    // Write a java program to concatenate characters. You are given N characters in a line and the task is to
    // join all the characters and print them in a single line

    // Method to concatenate characters and return as a single string
    public static String concatenateChars(char[] chars) {
        StringBuilder result = new StringBuilder();

        // Loop through the array of characters and append them to StringBuilder
        for (char ch : chars) {
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of characters
        System.out.print("Enter the number of characters: ");
        int N = scanner.nextInt();

        // Create an array to store the characters
        char[] characters = new char[N];

        // Input each character
        System.out.println("Enter " + N + " characters:");
        for (int i = 0; i < N; i++) {
            characters[i] = scanner.next().charAt(0);
        }

        // Concatenate the characters and print the result
        String result = concatenateChars(characters);
        System.out.println("Concatenated result: " + result);

        scanner.close();
    }
}

