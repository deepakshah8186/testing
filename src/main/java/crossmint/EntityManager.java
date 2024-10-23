package crossmint;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EntityManager {
    private static final String API_GOAL_URL = "https://challenge.crossmint.com/api/map/";
    private String candidateId;

    public EntityManager(String candidateId) {
        this.candidateId = candidateId;
    }

    // Fetch the goal map from the API
    public String fetchGoalMap() throws Exception {
        String goalUrl = API_GOAL_URL + candidateId + "/goal";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(goalUrl))
                .GET()
                .build();

        HttpResponse<String> response = Entity.client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new Exception("Failed to fetch goal map: " + response.body());
        }
    }

    // Parse the goal map and place the respective entities
    public void parseAndPlaceEntities(String goalMap) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode grid = objectMapper.readTree(goalMap).get("goal");

        for (int row = 0; row < grid.size(); row++) {
            for (int column = 0; column < grid.get(row).size(); column++) {
                String entity = grid.get(row).get(column).asText();
                Thread.sleep(500);
                switch (entity) {
                    case "POLYANET":
                        new Polyanet(row, column, candidateId).placeEntity();
                        break;
                    case "RED_SOLOON":
                        new Soloon(row, column, candidateId, "red").placeEntity();
                        break;
                    case "BLUE_SOLOON":
                        new Soloon(row, column, candidateId, "blue").placeEntity();
                        break;
                    case "WHITE_SOLOON":
                        new Soloon(row, column, candidateId, "white").placeEntity();
                        break;
                    case "PURPLE_SOLOON":
                        new Soloon(row, column, candidateId, "purple").placeEntity();
                        break;
                    case "UP_COMETH":
                        new Cometh(row, column, candidateId, "up").placeEntity();
                        break;
                    case "DOWN_COMETH":
                        new Cometh(row, column, candidateId, "down").placeEntity();
                        break;
                    case "LEFT_COMETH":
                        new Cometh(row, column, candidateId, "left").placeEntity();
                        break;
                    case "RIGHT_COMETH":
                        new Cometh(row, column, candidateId, "right").placeEntity();
                        break;
                    default:
                        break;
                }
            }
        }
    }
}

