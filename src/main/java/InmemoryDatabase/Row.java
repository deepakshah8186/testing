package InmemoryDatabase;

import java.util.Map;

public class Row {
    private Map<String, Object> values;

    public Row(Map<String, Object> values) {
        this.values = values;
    }

    public Object getColumnValue(String column) {
        return values.get(column);
    }

    public Map<String, Object> getValues() {
        return values;
    }

    public void setColumnValue(String column, Object value) {
        values.put(column, value);
    }



    @Override
    public String toString() {
        return values.toString();
    }
}

