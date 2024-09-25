package InmemoryDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDatabase {
    private Map<String, Table> tables;
    public InMemoryDatabase() {
        this.tables = new HashMap<>();
    }
    // Create a new table
    public void createTable(String tableName, List<String> columns) {
        if (!tables.containsKey(tableName)) {
            tables.put(tableName, new Table(tableName, columns));
        } else {
            throw new RuntimeException("Table already exists!");
        }
    }
    private Table getTable(String tableName) {
        if (!tables.containsKey(tableName)) {
            throw new RuntimeException("Table not found!");
        }
        return tables.get(tableName);
    }
    // Insert a row into a table
    public void insertRow(String tableName, String primaryKey, Row row) {
        Table table = getTable(tableName);
        table.insert(primaryKey, row);
    }

    // Select a row from a table
    public Row selectRow(String tableName, String primaryKey) {
        Table table = getTable(tableName);
        return table.select(primaryKey);
    }

    // Update a row in a table
    public void updateRow(String tableName, String primaryKey, Row row) {
        Table table = getTable(tableName);
        table.update(primaryKey, row);
    }

    // Delete a row from a table
    public void deleteRow(String tableName, String primaryKey) {
        Table table = getTable(tableName);
        table.delete(primaryKey);
    }

    // Fetch a table from the database

}

