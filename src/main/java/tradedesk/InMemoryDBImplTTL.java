package tradedesk;

import java.util.*;

/**
 * Implementation of the `InMemoryDB` interface with support for timestamps and TTL.
 * Implementation of in memory db with the help of timestamps and TTL
 */
public class InMemoryDBImplTTL implements InMemoryDBTTL {

    private final Map<String, Map<String, Record>> database = new HashMap<>();

    private static class Record {
        String value;
        int timestamp;
        Integer ttl; // TTL can be null if not set

        Record(String value, int timestamp, Integer ttl) {
            this.value = value;
            this.timestamp = timestamp;
            this.ttl = ttl;
        }

        boolean isAlive(int currentTimestamp) {
            return ttl == null || (currentTimestamp < timestamp + ttl);
        }
    }

    @Override
    public void set(String key, String field, String value) {
        setAt(key, field, value, Integer.MAX_VALUE);
    }

    @Override
    public Optional<String> get(String key, String field) {
        return getAt(key, field, Integer.MAX_VALUE);
    }

    @Override
    public boolean delete(String key, String field) {
        return deleteAt(key, field, Integer.MAX_VALUE);
    }

    @Override
    public List<String> scan(String key) {
        return scanAt(key, Integer.MAX_VALUE);
    }

    @Override
    public List<String> scanByPrefix(String key, String prefix) {
        return scanByPrefixAt(key, prefix, Integer.MAX_VALUE);
    }

    @Override
    public void setAt(String key, String field, String value, int timestamp) {
        database.computeIfAbsent(key, k -> new HashMap<>()).put(field, new Record(value, timestamp, null));
    }

    @Override
    public void setAtWithTtl(String key, String field, String value, int timestamp, int ttl) {
        database.computeIfAbsent(key, k -> new HashMap<>()).put(field, new Record(value, timestamp, ttl));
    }

    @Override
    public boolean deleteAt(String key, String field, int timestamp) {
        Map<String, Record> record = database.get(key);
        if (record != null && record.containsKey(field)) {
            Record r = record.get(field);
            if (r.isAlive(timestamp)) {
                record.remove(field);
                if (record.isEmpty()) {
                    database.remove(key); // remove the key if no fields left
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<String> getAt(String key, String field, int timestamp) {
        Map<String, Record> record = database.get(key);
        if (record != null) {
            Record r = record.get(field);
            if (r != null && r.isAlive(timestamp)) {
                return Optional.of(r.value);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<String> scanAt(String key, int timestamp) {
        Map<String, Record> record = database.get(key);
        if (record == null) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Record> entry : record.entrySet()) {
            if (entry.getValue().isAlive(timestamp)) {
                result.add(entry.getKey() + "(" + entry.getValue().value + ")");
            }
        }
        Collections.sort(result);
        return result;
    }

    @Override
    public List<String> scanByPrefixAt(String key, String prefix, int timestamp) {
        Map<String, Record> record = database.get(key);
        if (record == null) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Record> entry : record.entrySet()) {
            if (entry.getKey().startsWith(prefix) && entry.getValue().isAlive(timestamp)) {
                result.add(entry.getKey() + "(" + entry.getValue().value + ")");
            }
        }
        Collections.sort(result);
        return result;
    }
}
