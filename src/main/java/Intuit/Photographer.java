package Intuit;

import java.util.List;
import lombok.Data;

@Data
public
class Photographer {
    String name;
    String location;
    int rate;
    List<String> eventTypes;

    public Photographer(String name, String location, int rate, List<String> eventTypes) {
        this.name = name;
        this.location = location;
        this.rate = rate;
        this.eventTypes = eventTypes;
    }

    // getters and setters
}
