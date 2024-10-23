package crossmint;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public abstract class Entity {
    protected int row;
    protected int column;
    protected String candidateId;
    protected static final HttpClient client = HttpClient.newHttpClient();

    public Entity(int row, int column, String candidateId) {
        this.row = row;
        this.column = column;
        this.candidateId = candidateId;
    }

    // Abstract method that all entities must implement to specify how to place themselves
    public abstract void placeEntity() throws Exception;

    // Common method to send HTTP request
    protected void sendRequest(String apiUrl, Map<String, Object> requestBody) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(requestBody);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            System.out.println(this.getClass().getSimpleName() + " placed successfully at (" + row + ", " + column + ")");
        } else {
            System.out.println("Error placing " + this.getClass().getSimpleName() + " at (" + row + ", " + column + "): " + response.body());
        }
    }
}
