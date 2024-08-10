package mac;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PhotographerController {

//    public static void main(String[] args) {
//        SpringApplication.run(PhotographerService.class, args);
//    }

    @GetMapping("/api/photographers/event/{eventType}")
    public List<Photographer> getPhotographersByEventType(@PathVariable String eventType) {
        List<Photographer> photographers = new ArrayList<>();
        try {
            // Read the JSON file
            BufferedReader reader = new BufferedReader(new FileReader("photographers.json"));
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            reader.close();

            // Parse the JSON data
            JSONArray photographerArray = new JSONArray(jsonString.toString());
            for (int i = 0; i < photographerArray.length(); i++) {
                JSONObject photographerObj = photographerArray.getJSONObject(i);
                int id = photographerObj.getInt("id");
                String name = photographerObj.getString("name");
                int age = photographerObj.getInt("age");
                String email = photographerObj.getString("email");
                String[] genres = photographerObj.getString("genres").split(",");
                String[] events = photographerObj.getString("events").split(",");
                for (String event : events) {
                    if (event.trim().equalsIgnoreCase(eventType)) {
                        // photographers.add(new Photographer(id, name, age, email, genres, events));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return photographers;
    }
}

//class Photographer {
//    private int id;
//    private String name;
//    private int age;
//    private String email;
//    private String[] genres;
//    private String[] events;
//
//    public Photographer(int id, String name, int age, String email, String[] genres, String[] events) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.email = email;
//        this.genres = genres;
//        this.events = events;
//    }
//
//    public String toString() {
//        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email
//                + ", Genres: " + String.join(", ", this.genres) + ", Events: " + String.join(", ", this.events);
//    }
//}
