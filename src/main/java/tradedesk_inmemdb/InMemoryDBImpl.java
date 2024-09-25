package tradedesk_inmemdb;

import java.util.*;

/**
 * Implementation of the `InMemoryDB` interface.
 */
public class InMemoryDBImpl implements InMemoryDB {

    private final Map<String, Map<String, String>> database = new HashMap<>();
    @Override
    public void set(String key, String field, String value) {
       database.computeIfAbsent(key,k->new HashMap<>()).put(field,value);
    }
    @Override
    public Optional<String> get(String key, String field) {
       return Optional.ofNullable(database.getOrDefault(key,Collections.emptyMap()).get(field));
    }
    @Override
    public boolean delete(String key, String field) {
        Map<String, String> record = database.get(key);
        if (record != null && record.containsKey(field)) {
            record.remove(field);
            if (record.isEmpty()) {
                database.remove(key); // remove the key if no fields left
            }
            return true;
        }
        return false;
    }
    @Override
    public List<String> scanByPrefix(String key, String prefix) {
        Map<String, String> record = database.get(key);

        if (record == null) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        record.forEach((field, value) -> {
            if (field.startsWith(prefix)) {
                result.add(field + "(" + value + ")");
            }
        });
        Collections.sort(result);
        return result;
    }

    @Override
    public List<String> scan(String key) {
        Map<String, String> record = database.get(key);
        if (record == null) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        record.forEach((field, value) -> result.add(field + "(" + value + ")"));
        Collections.sort(result);

        return result;

    }
}
