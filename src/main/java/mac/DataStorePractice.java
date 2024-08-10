package mac;

import java.util.*;

public class DataStorePractice {
    public Map<String,Photographer> map;
   TreeSet<Photographer> photographersByRate;

   DataStorePractice(){
       this.map = new HashMap<>();
       this.photographersByRate = new TreeSet<>(Comparator.comparing(Photographer::getRate));
   }

   public void addPhotographer(String name, String place, int rate, String event){
       Photographer p = new Photographer(name,place,rate,Arrays.asList(event));
       map.put(name,p);
       photographersByRate.add(p);
    }

    public Photographer findPhotoGrapher(String name,int rate){
//       Photographer photgrapher = new Photographer();
       for(Photographer value:map.values()){
           if(value.getName() == name && value.getRate() == rate){
               return value;
           }
       }
        return null;
    }

    public List<Photographer> getPhotoGraphersByRate(){
        List<Photographer> list = new ArrayList<>();
       for(Photographer p:photographersByRate){
           list.add(p);
       }
        return list;
    }

}
