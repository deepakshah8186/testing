package crossmint;

import java.util.HashMap;
import java.util.Map;

public class Cometh extends Entity {
    private static final String API_URL = "https://challenge.crossmint.com/api/comeths";
    private String direction;

    public Cometh(int row, int column, String candidateId, String direction) {
        super(row, column, candidateId);
        this.direction = direction;
    }

    @Override
    public void placeEntity() throws Exception {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("row", this.row);
        requestBody.put("column", this.column);
        requestBody.put("direction", this.direction);
        requestBody.put("candidateId", this.candidateId);
        sendRequest(API_URL, requestBody);
    }
}
