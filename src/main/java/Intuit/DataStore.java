package Intuit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DataStore {
    Map<String, Photographer> photographerMap;
    TreeSet<Photographer> photographerSet; // Treeset is part of binary tree and hence searching becomes easier

    public DataStore() {
        photographerMap = new HashMap<String, Photographer>();
        photographerSet = new TreeSet<Photographer>(Comparator.comparingInt(Photographer::getRate));
    }

    public void addPhotographer(String name, String location, int rate, List<String> types) {
        Photographer p = new Photographer(name, location, rate, types);
        photographerMap.put(name, p);
        photographerSet.add(p);
    }

    public List<Photographer> searchPhotographers(String location, String eventType, int budget) {
        List<Photographer> results = new ArrayList<Photographer>();
        for(Photographer p : photographerMap.values()) { // photgrapherMap.values() gives you all the values of the photographer
            if(p.location.equals(location) && p.eventTypes.contains(eventType) && p.rate <= budget) {
                results.add(p);
            }
        }
        return results;
    }

    public List<Photographer> getPhotographersByRate() {
        List<Photographer> results = new ArrayList<>();
        for(Photographer p : photographerSet) {
            results.add(p);
        }
        return results;
    }

//    public List<Photographer> getMyphotgraohers(){
//        List<Photographer> list = new ArrayList<>();
//        for(Photographer p: photographerMap.values()){
//            if(p.location.equalsIgnoreCase(location) && p.eventTypes.contains(eventType) && p.rate <= rate){
//                list.add(photographer){
//
//                }
//            }
//
//        }
//        return null;
//    }
}
