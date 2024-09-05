package tusto;

import java.util.*;

public class TimeMap {

    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> treeMap = map.get(key);
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        return entry != null ? entry.getValue() : "";
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));  // Output: "bar"
        System.out.println(timeMap.get("foo", 3));  // Output: "bar"
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));  // Output: "bar2"
        System.out.println(timeMap.get("foo", 5));  // Output: "bar2"

        Map<Character, List<String>> groupedWords = new HashMap<>();
        List<String> words = List.of("apple", "banana", "apricot", "blueberry", "cherry");

        for (String word : words) {
            // Get the first letter of the word
            char firstLetter = word.charAt(0);

            // Compute the value for the first letter if absent, and add the word to the list
            groupedWords.computeIfAbsent(firstLetter, k -> new ArrayList<>()).add(word);
        }

        // Print the grouped words
        groupedWords.forEach((key, value) -> System.out.println(key + ": " + value));

        Map<Character,List<String>> myMap = new HashMap<>();
        for(String word:words){
            char firstLetter = word.charAt(0);
//            if(!myMap.containsKey(firstLetter)){
//                List list = new ArrayList();
//                list.add(word);
//                myMap.put(firstLetter,list);
//            } else {
//                myMap.get(firstLetter).add(word);
//            }
            myMap.computeIfAbsent(firstLetter,k->new ArrayList<>()).add(word);

        }
        System.out.println("Testing");
        myMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
// See gusto Glassdoor
// Do word break ,add tag to substring
// Time based key value store * payroll calculation * design a restaurant calendar management service
