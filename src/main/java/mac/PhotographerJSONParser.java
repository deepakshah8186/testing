package mac;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PhotographerJSONParser {

    public static void main(String[] args) {
        try {
            // Read the JSON file
            BufferedReader reader = new BufferedReader(new FileReader("/Users/dshah10/IdeaProjects/iboss-decision-svc/app/src/test/resources/photographers.json"));
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            reader.close();

            // Parse the JSON data
            JSONArray photographerArray = new JSONArray(jsonString.toString());
            List<Photographer> photographers = new ArrayList<>();
            for (int i = 0; i < photographerArray.length(); i++) {
                JSONObject photographerObj = photographerArray.getJSONObject(i);
                int id = photographerObj.getInt("id");
                String[] genres = photographerObj.getString("genres").split(",");
               // photographers.add(new Photographer(id, name, age, email, genres));
            }

            // Print the parsed data
            for (Photographer photographer : photographers) {
                System.out.println(photographer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

