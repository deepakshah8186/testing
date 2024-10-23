package crossmint;

import java.util.HashMap;
import java.util.Map;

public class Soloon extends Entity {
    private static final String API_URL = "https://challenge.crossmint.com/api/soloons";
    private String color;

    public Soloon(int row, int column, String candidateId, String color) {
        super(row, column, candidateId);
        this.color = color;
    }

    @Override
    public void placeEntity() throws Exception {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("row", this.row);
        requestBody.put("column", this.column);
        requestBody.put("color", this.color);
        requestBody.put("candidateId", this.candidateId);
        sendRequest(API_URL, requestBody);
    }
}
