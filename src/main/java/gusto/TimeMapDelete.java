package gusto;

import java.util.Map;
import java.util.TreeMap;

public class TimeMapDelete {
    Map<String, TreeMap<String,Integer>> myMap;

//    public TimeMapDelete(Map<String, TreeMap<String, Integer>> myMap) {
//        this.myMap = myMap;
//    }

    public void set(String key,String val1,Integer val2){
//        TreeMap treeMap = new TreeMap();
//        if(treeMap.containsKey(val1)){
//            String value1 = (String) treeMap.get(val1);
//        }
//        treeMap.put(val1,val2);
        if(!myMap.containsKey(key)){
            TreeMap treeMap = new TreeMap();
            treeMap.put(val1,val2);
            myMap.put(key,treeMap);
        } else {
            TreeMap test = myMap.get(key);

        }
    }

    public static void main(String args[]){
        TimeMapDelete timeMapDelete = new TimeMapDelete();
        timeMapDelete.set("test","value1",1);


    }
}
