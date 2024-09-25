package tradedesk_inmemdb;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * InMemoryDB interface.
 */
public interface InMemoryDBTTL {

    /**
     * Should insert a field-value pair to the record
     * associated with key.
     * If the field in the record already exists, replace the
     * existing value with the specified value.
     * If the record does not exist, create a new one.
     */
    default void set(String key, String field, String value) {
        // default implementation
    }

    /**
     * Should return the value contained within field of the
     * record associated with key.
     * If the record or the field doesn't exist, should return
     * Optional.empty().
     */
    default Optional<String> get(String key, String field) {
        // default implementation
        return Optional.empty();
    }

    /**
     * Should remove the field from the record associated with
     * key.
     * Returns true if the field was successfully deleted, and
     * false if the key or the field do not exist in the
     * database.
     */
    default boolean delete(String key, String field) {
        // default implementation
        return false;
    }

    /**
     * Should return a list of strings representing the fields of a
     * record associated with key.
     * The returned list should be in the following format
     * ["<field1>(<value1>)", "<field2>(<value2>)", ...], where
     * fields are sorted
     * [lexicographically](keyword://lexicographical-order-for-
     * strings).
     * If the specified record does not exist, returns an empty
     * list.
     */
    default List<String> scan(String key) {
        // default implementation
        return Collections.emptyList();
    }

    /**
     * Should return a list of strings representing some fields of
     * a record associated with key.
     * Specifically, only fields that start with prefix should be
     * included.
     * The returned list should be in the same format as in the
     * scan operation with fields sorted in
     * [lexicographical](keyword://lexicographical-order-for-
     * strings) order.
     */
    default List<String> scanByPrefix(String key, String prefix) {
        // default implementation
        return Collections.emptyList();
    }

    /**
     * Should insert a field-value pair or updates the value of
     * the field in the record associated with key.
     */
    default void setAt(String key, String field, String value, int timestamp) {
        // default implementation
    }

    /**
     * Should insert a field-value pair or update the value of
     * the field in the record associated with key.
     * Also sets its Time-To-Live starting at timestamp to be
     * ttl.
     * The ttl is the amount of time that this field-value
     * pair should exist in the database, meaning it will be
     * available during this interval:
     * [timestamp, timestamp + ttl).
     */
    default void setAtWithTtl(String key, String field, String value, int timestamp, int ttl) {
        // default implementation
    }

    /**
     * The same as delete, but with timestamp of the operation
     * specified.
     * Should return true if the field existed and was
     * successfully deleted and false if the key didn't exist.
     */
    default boolean deleteAt(String key, String field, int timestamp) {
        // default implementation
        return false;
    }

    /**
     * The same as get, but with timestamp of the operation
     * specified.
     */
    default Optional<String> getAt(String key, String field, int timestamp) {
        // default implementation
        return Optional.empty();
    }

    /**
     * The same as scan, but with timestamp of the operation
     * specified.
     */
    default List<String> scanAt(String key, int timestamp) {
        // default implementation
        return Collections.emptyList();
    }

    /**
     * The same as scanByPrefix, but with timestamp of the
     * operation specified.
     */
    default List<String> scanByPrefixAt(String key, String prefix, int timestamp) {
        // default implementation
        return Collections.emptyList();
    }
}
