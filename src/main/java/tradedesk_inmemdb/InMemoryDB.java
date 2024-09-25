package tradedesk_inmemdb;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * tradedesk.InMemoryDB interface.
 */
public interface InMemoryDB {

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
}
