package gusto;

import java.util.HashMap;
import java.util.Map;

public class KeyValueStoreNormal {
    private Map<String, Integer> store;

    public KeyValueStoreNormal() {
        store = new HashMap<>();
    }

    // Add or update an entry in the key-value store
    public void add(String key, int value) {
        store.put(key, value);
    }

    // Get the current value for a key
    public Integer get(String key) {
        return store.get(key);
    }

    // Delete an entry from the key-value store
    public void delete(String key) {
        store.remove(key);
    }

    public static void main(String[] args) {
        KeyValueStoreNormal kvs = new KeyValueStoreNormal();

        // Testing the basic key-value store
        kvs.add("a", 10);
        kvs.add("b", 15);
        kvs.add("a", 20);

        System.out.println(kvs.get("a")); // Should return 20
        System.out.println(kvs.get("b")); // Should return 15

        kvs.delete("a");
        System.out.println(kvs.get("a")); // Should return null
    }
}
