package gusto;

import java.time.LocalDateTime;
import java.util.*;

public class KeyValueStore {
    private Map<String, TreeMap<LocalDateTime, Integer>> store;

    public KeyValueStore() {
        store = new HashMap<>();
    }

    // Add or update an entry in the key-value store with a timestamp
    public void add(String key, int value) {
        LocalDateTime now = LocalDateTime.now();
        store.putIfAbsent(key, new TreeMap<>());
        store.get(key).put(now, value);
    }

    // Get the current value for a key
    public Integer get(String key) {
        TreeMap<LocalDateTime, Integer> history = store.get(key);
        if (history == null || history.isEmpty()) {
            return null;
        }
        return history.lastEntry().getValue();
    }

    // Delete an entry from the key-value store
    public void delete(String key) {
        store.remove(key);
    }

    // Get the value for a key at a specific date and time
    public Integer getAtEffectiveDate(String key, LocalDateTime dateTime) {
        TreeMap<LocalDateTime, Integer> history = store.get(key);
        if (history == null || history.isEmpty()) {
            return null;
        }

        Map.Entry<LocalDateTime, Integer> entry = history.floorEntry(dateTime);
        return entry != null ? entry.getValue() : null;
    }

    public static void main(String[] args) {
        KeyValueStore kvs = new KeyValueStore();

        // Simulating different times
        LocalDateTime t1 = LocalDateTime.parse("2023-09-03T07:30:00");
        LocalDateTime t2 = LocalDateTime.parse("2023-09-03T08:00:00");
        LocalDateTime t3 = LocalDateTime.parse("2023-09-03T08:35:00");

        kvs.add("a", 10);
        // Simulate time delay or use time inputs like t1, t2 in a real system

        kvs.add("a", 20);

        System.out.println(kvs.get("a")); // Should return 20

        // Check the value of 'a' at t1
        System.out.println(kvs.getAtEffectiveDate("a", t1)); // Should return 10

        // Check the value of 'a' at t2
        System.out.println(kvs.getAtEffectiveDate("a", t2)); // Should return 20

        // Check the value of 'a' at t3 (after the last update)
        System.out.println(kvs.getAtEffectiveDate("a", t3)); // Should return 20
    }
}
