package General;


import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {
    public int firstUniqChar(String s) {
        // HashMap to store character counts
        Map<Character, Integer> countMap = new HashMap<>();

        // First pass: Count occurrences of each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // Second pass: Find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (countMap.get(s.charAt(i)) == 1) {
                return i; // Return the index of the first non-repeating character
            }
        }

        return -1; // If no non-repeating character found, return -1
    }

    public static void main(String[] args) {
        FirstUniqueChar solution = new FirstUniqueChar();

        String test1 = "leetcode";
        String test2 = "loveleetcode";
        String test3 = "aabb";

        System.out.println("First unique character index in 'leetcode': " + solution.firstUniqChar(test1)); // Output: 0
        System.out.println("First unique character index in 'loveleetcode': " + solution.firstUniqChar(test2)); // Output: 2
        System.out.println("First unique character index in 'aabb': " + solution.firstUniqChar(test3)); // Output: -1
    }
}

