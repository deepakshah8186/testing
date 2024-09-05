//import org.apache.commons.collections.map.HashedMap;
//
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//public class HashMapGusto {
//
//    Map<String, Map<String,String>> map = new HashMap<>();
//
//    Map<String,Integer> add(String key,String key1,String value){
//        map.computeIfAbsent(key,k-> new HashMap<>()).put(key1,value);
//        return null;
//    }
//
//    Map<String,String> get(String key,String timestamp,String value){
//       Map record = map.get(key);
//
//        // record - key1,values
//
//        String value2 = (String) record.get(timestamp);
//
//       //  Map<String, Map<String,String>> map
//       // a ,  kvs.add(7:30, 10)
//        // a ,kvs.add(8:00,20)
//        //  kvs.get('a') // returns 20
//
////        for(Map.Entry<String,String> entry : record.entrySet()){
//////
//////       }
//
////        // At 7:00 AM, we initialize the key value store
////        kvs = new KeyValueStore()
////
////        // At 7:30 AM, we add an entry for the key 'a'
////        kvs.add('a', 10)
////
////        // At 8:00 AM, we update the entry for the key 'a'
////        kvs.add('a', 20)
////
////        // At 8:30 AM, we ask for the current value of the key 'a'
////        kvs.get('a') // returns 20
////
////// At 8:35 AM, we ask what the value was for the key 'a' at 7:35 AM
////        kvs.get_at_effective_date('a', DateTime.parse('7:35 AM')) // returns 10
//
////       String value = String.valueOf(record.values().stream()
////               .filter(x-> x==timestamp)
////               .findAny());
//
//
//               //.map(HashMapGusto::getDate) // Comprator - based on sorting
//
////       for(Map.Entry<String,String> entry : record.entrySet()){
////
////       }
//    }
//}
