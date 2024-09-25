package InmemoryDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDatabaseDemo {

    public static void main(String[] args) {
        InMemoryDatabase db = new InMemoryDatabase();

        // Create a "users" table
        db.createTable("users", List.of("id", "name", "email"));

        // Insert rows
        Map<String, Object> row1 = new HashMap<>();
        row1.put("id", 1);
        row1.put("name", "Alice");
        row1.put("email", "alice@example.com");

        db.insertRow("users", "1", new Row(row1));
        // db.updateRow("users", "2", new Row(row2));
        // db.deleteRow("users", "1");

        Map<String, Object> row2 = new HashMap<>();
        row2.put("id", 2);
        row2.put("name", "Bob");
        row2.put("email", "bob@example.com");

        db.insertRow("users", "2", new Row(row2));

        // Select and display rows
        System.out.println("User with ID 1: " + db.selectRow("users", "1"));
        System.out.println("User with ID 2: " + db.selectRow("users", "2"));

        // Update a row
        row2.put("email", "newbob@example.com");
        db.updateRow("users", "2", new Row(row2));
        System.out.println("Updated User with ID 2: " + db.selectRow("users", "2"));

        // Delete a row
        db.deleteRow("users", "1");
        System.out.println("All users after deletion: " + db.selectRow("users", "1"));
    }
}

