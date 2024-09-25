package InmemoryDatabase;

import InmemoryDatabase.Row;

import java.util.*;

public class Table {
    private String tableName;
    private List<String> columns;
    private Map<String, Row> data; // In-memory storage where the key is a primary key

    public Table(String tableName, List<String> columns) {
        this.tableName = tableName;
        this.columns = new ArrayList<>(columns);
        this.data = new HashMap<>();
    }

    public String getTableName() {
        return tableName;
    }
    public List<String> getColumns() {
        return columns;
    }
    // Insert a new row into the table
    public void insert(String primaryKey, Row row) {
        if (!data.containsKey(primaryKey)) {
            data.put(primaryKey, row);
        } else {
            throw new RuntimeException("Duplicate key error!");
        }
    }
    // Read a row from the table
    public Row select(String primaryKey) {
        return data.get(primaryKey);
    }

    // Update a row in the table
    public void update(String primaryKey, Row updatedRow) {
        if (data.containsKey(primaryKey)) {
            data.put(primaryKey, updatedRow);
        } else {
            throw new RuntimeException("Row not found!");
        }
    }

    // Delete a row from the table
    public void delete(String primaryKey) {
        if (data.containsKey(primaryKey)) {
            data.remove(primaryKey);
        } else {
            throw new RuntimeException("Row not found!");
        }
    }

    // Select all rows
    public List<Row> selectAll() {
        return new ArrayList<>(data.values());
    }
}
