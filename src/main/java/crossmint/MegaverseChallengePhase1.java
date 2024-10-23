package crossmint;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

public class MegaverseChallengePhase1 {
    private static final String API_URL = "https://challenge.crossmint.com/api/polyanets";
    private static final String GOAL_MAP_URL = "https://challenge.crossmint.com/api/map/";
    private static  final int GRID_SIZE = 30;
    private static final String CANDIDATE_ID = "84c5079a-469e-467e-89c7-0f929b32c1c0";

    private static final HttpClient client = HttpClient.newHttpClient();

    public static void main(String[] args) throws Exception {
        try {
            createPolyCross(GRID_SIZE);
            // deletePolyCross(GRID_SIZE);
            String goalMap = fetchGoalMap();
            System.out.println("Goal Map Data: " + goalMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createPolyCross(int gridSize) throws Exception {
        int[][] polyPositions = {
                {2, 2}, {2, 8},
                {3, 3}, {3, 7},
                {4, 4}, {4, 6},
                {5, 5},
                {6, 4}, {6, 6},
                {7, 3}, {7, 7},
                {8, 2}, {8, 8}
        };

        // Loop through the defined positions and create POLYanets
        for (int[] position : polyPositions) {
            int row = position[0];
            int column = position[1];
            mintPOLYanet(row, column);
        }
    }

    public static void deletePolyCross(int gridSize) throws Exception {
        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize; x++) {
                    try {
                        deletePOLYanet(x, y);
                        // Pause for 500 milliseconds
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.err.println("Interrupted: " + e.getMessage());
                    }
            }
        }
    }

    public static void deletePOLYanet(int row, int column) throws Exception {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("row", row);
        requestBody.put("column", column);
        requestBody.put("candidateId", CANDIDATE_ID);  // Add your candidate ID to the request

        // Convert the payload to JSON string using Jackson's ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(requestBody);

        // Create the DELETE request with the JSON payload in the body
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .method("DELETE", BodyPublishers.ofString(json))  // Use .method() to send DELETE with body
                .build();

        // Send the DELETE request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Handle the response and print the result
        if (response.statusCode() == 200) {
            System.out.println("POLYanet deleted successfully at (" + row + ", " + column + ")");
        } else {
            System.out.println("Error deleting POLYanet at (" + row + ", " + column + "): " + response.body());
        }
    }

    public static void mintPOLYanet(int x, int y) throws Exception {
        // Prepare the request payload
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("row", y);
        requestBody.put("column", x);
        requestBody.put("candidateId", CANDIDATE_ID);  // Add your candidate ID to the request

        // Convert the payload to JSON string using Jackson's ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(requestBody);

        // Create and send the POST request to mint a POLYanet
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL +  "?candidateId=" + CANDIDATE_ID))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            System.out.println("POLYanet minted successfully at (" + x + ", " + y + ")");
        } else {
            System.out.println("Error minting POLYanet at (" + x + ", " + y + "): " + response.body());
        }
    }

    public static String fetchGoalMap() throws Exception {
        String requestUrl = GOAL_MAP_URL  + CANDIDATE_ID + "/goal";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();  // Return the goal map data as JSON string
        } else {
            throw new Exception("Failed to fetch goal map: " + response.body());
        }
    }
}

