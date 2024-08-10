package dums;

import mac.DataStore;
import mac.Photographer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PhotographerService {
    public List<Photographer> getPhotographers(){
        DataStore dataStore = new DataStore();
        dataStore.addPhotographer("John", "New York", 500, Arrays.asList("Wedding", "Corporate Events"));
        dataStore.addPhotographer("Jessica", "New York", 800, Arrays.asList("Wedding", "Bridal Shower"));
        dataStore.addPhotographer("Mike", "San Francisco", 600, Arrays.asList("Rehearsal dinner", "Birthday Parties"));
        dataStore.addPhotographer("Anna", "Los Angeles", 1000, Arrays.asList("Wedding"));

        return dataStore.getPhotographersByRate();
    }
}
