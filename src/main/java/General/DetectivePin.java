package General;

import java.util.*;

public class DetectivePin {

    // Define the adjacency rules for each digit on the keypad
    private static final Map<Character, List<Character>> adjacentDigits = new HashMap<>();

    static {
        adjacentDigits.put('1', Arrays.asList('1', '2', '4'));
        adjacentDigits.put('2', Arrays.asList('1', '2', '3', '5'));
        adjacentDigits.put('3', Arrays.asList('2', '3', '6'));
        adjacentDigits.put('4', Arrays.asList('1', '4', '5', '7'));
        adjacentDigits.put('5', Arrays.asList('2', '4', '5', '6', '8'));
        adjacentDigits.put('6', Arrays.asList('3', '5', '6', '9'));
        adjacentDigits.put('7', Arrays.asList('4', '7', '8'));
        adjacentDigits.put('8', Arrays.asList('5', '7', '8', '9', '0'));
        adjacentDigits.put('9', Arrays.asList('6', '8', '9'));
        adjacentDigits.put('0', Arrays.asList('0', '8'));
    }

    // Method to generate all possible PINs by replacing each digit with its adjacent digits
    public static List<String> generatePossiblePins(String pin) {
        List<String> possiblePins = new ArrayList<>();
        generatePinsRecursive(pin, 0, new StringBuilder(), possiblePins);
        return possiblePins;
    }

    // Recursive method to generate PIN combinations
    private static void generatePinsRecursive(String pin, int index, StringBuilder current, List<String> possiblePins) {
        if (index == pin.length()) {
            possiblePins.add(current.toString());
            return;
        }

        char digit = pin.charAt(index);
        List<Character> adjacent = adjacentDigits.get(digit);

        // For each adjacent digit, try it and recurse
        for (char adj : adjacent) {
            current.append(adj);
            generatePinsRecursive(pin, index + 1, current, possiblePins);
            current.deleteCharAt(current.length() - 1);  // Backtrack to try another combination
        }
    }

    public static void main(String[] args) {
        // The PIN noted by the detective
        String originalPin = "1357";

        // Generate all possible PINs
        List<String> possiblePins = generatePossiblePins(originalPin);

        // Sort the list of possible PINs
        Collections.sort(possiblePins);

        // Print all possible PINs
        System.out.println("All possible PINs:");
        for (String pin : possiblePins) {
            System.out.println(pin);
        }
    }
}

