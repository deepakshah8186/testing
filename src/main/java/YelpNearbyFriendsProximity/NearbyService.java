package YelpNearbyFriendsProximity;

import java.util.ArrayList;
import java.util.List;

public class NearbyService {
    private List<Place> places;

    public NearbyService() {
        this.places = new ArrayList<>();
    }

    public void addPlace(Place place) {
        places.add(place);
    }

    public List<Place> findNearbyPlaces(Location userLocation, double radius) {
        List<Place> nearbyPlaces = new ArrayList<>();
        for (Place place : places) {
            if (userLocation.distanceTo(place.getLocation()) <= radius) {
                nearbyPlaces.add(place);
            }
        }
        return nearbyPlaces;
    }
}

