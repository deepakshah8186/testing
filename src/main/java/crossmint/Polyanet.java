package crossmint;

import java.util.HashMap;
import java.util.Map;

public class Polyanet extends Entity {
    private static final String API_URL = "https://challenge.crossmint.com/api/polyanets";

    public Polyanet(int row, int column, String candidateId) {
        super(row, column, candidateId);
    }

    @Override
    public void placeEntity() throws Exception {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("row", this.row);
        requestBody.put("column", this.column);
        requestBody.put("candidateId", this.candidateId);
        sendRequest(API_URL, requestBody);
    }
}
