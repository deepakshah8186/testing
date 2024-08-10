//package com.example.TestProject;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.*;
//import java.util.Map.Entry;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//
//import mac.DataObject;
//import mac.DataStore;
//import mac.Employee;
//import mac.Photographer;
//import org.assertj.core.api.Assert;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//import factorypattern.Vehicle;
//import factorypattern.VehicleFactory;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.*;
//import java.util.stream.Collectors;
//
//import static java.util.stream.Collectors.toSet;
//
//@SpringBootTest
//public class CommonUtilsTest {
//  // practice coding
//
//    int i= 0;
//    private String openingBracket = "[{(";
//    private String closingBracket = "]})";
//
//    @Test
//    public void matchingBracketsPractice(){
//        String input = "{[(]}"; // it should match
//        Stack stack = new Stack();
//
//        for(int i=0;i<input.length();i++){
//            char current = input.charAt(i); // {
//
//            if(opening(current)) {
//                stack.add(current);
//            } else {
//                char seek = (char) stack.peek();
//                if(closing(current) && opening(seek)){
//                    stack.pop();
//                }
//            }
//        }
//
//        boolean check = stack.isEmpty();
//        System.out.println("If stack is empty ,then matching"+ check);
//    }
//
//    private boolean opening(char current) {
//        return openingBracket.indexOf(current) != -1;
//    }
//
//    private boolean closing(char current){
//        return closingBracket.indexOf(current) != -1;
//    }
//
//    @Test
//    public void squareOfTheSortedArray(){
//        int[] nums = {-1,-4, 0,3,10};
//        int[] squareArray = new int[nums.length];
//        Arrays.sort(nums);
//
//        for(int i=0;i<nums.length-1;i++){
//            squareArray[i] = nums[i] * nums[i];
//        }
//       // int[] myArray = Arrays.stream(nums).sorted().toArray();
//        System.out.println("testing" + squareArray);
//    }
//
//    @Test
//    public void bestTimeToBuyAndSellStock(){
//        int[] nums = {7,1,5,3,6,4}; int output = 5;
//        int max_profit = 0;
//        int min_value = Integer.MAX_VALUE;
//
//        for(int i=0;i<nums.length;i++){
//            int currentVal = nums[i];
//            if(currentVal < min_value){
//                min_value = currentVal;
//            } else {
//                int profit = currentVal - min_value;
//                max_profit = Math.max(max_profit, profit);
//            }
//        }
//
//        //Assert.assertEquals(output,max_profit);
//    }
//
//    @Test
//    public void maxSubarrayOneMoreTime(){
//        int[] nums = {-2,2,5,-11,6}; // {-2,1,-3,4,-1,2,1,-5,4}; int output = 6
////        int output = 7;
////
////        int max_sum = 0;
////        int current_max = 0;
////
////        for(int i=0;i<nums.length;i++){
////            int current = nums[i];
////            current_max= Math.max(current_max + current,current);
////            max_sum = Math.max(max_sum,current_max);
////        }
////
////        System.out.println("Testing max_sum" + max_sum);
//
//        int maxSubArrayBruteForce = maxSubArrayBruteForce(nums);
//        System.out.println("Testing brute force :" + maxSubArrayBruteForce);
//    }
//
//    public void NotTestedlongestSubstringOneMoreTimeNotested(){
//        String s = "abcabcbb";
//        int a_pointer = 0;
//        int b_pointer = 0;
//        HashSet<Character> set = new HashSet<>();
//        int max = Integer.MIN_VALUE;
//        while(b_pointer < s.length()){
//            if(!set.contains(s.charAt(b_pointer))){
//                set.add(s.charAt(b_pointer));
//                b_pointer++;
//                max = Math.max(max, set.size());
//            } else {
//                set.remove(s.charAt(a_pointer));
//                a_pointer++;
//            }
//
//        }
//        // return max;
//    }
//    public int maxSubArrayBruteForce(int[] nums) {
//
//        int n = nums.length;
//        int maximumSubArraySum = Integer.MIN_VALUE;
//
//
//        for (int left = 0; left < n; left++) {
//
//            int runningWindowSum = 0;
//
//            for (int right = left; right < n; right++) {
//                runningWindowSum += nums[right];
//
//                if (runningWindowSum > maximumSubArraySum) {
//                    maximumSubArraySum = runningWindowSum;
//                }
//            }
//        }
//
//        return maximumSubArraySum;
//    }
//
//    @Test
//    public void BinarySearch(){
//        // binary search is always done on sorted array.Linear search on unsorted
//        // arrays take O(n) time but binary search takes log(n) but is should be done on sorted arr
//        int[] nums = {-1,0,3,5,9,12}; int target = 8;
////        List<Integer> list = Arrays.asList(1,1,2);
////        String[] aar1 = {"est"};
//        int start=0;
//        int end= nums.length -1;
//
//        if(nums.length == 0){
//            // return -1;
//        }
//
//        while(start <= end){
//            int midPoint = start + (end -start)/2;
//            int current = nums[midPoint];
//            if(current == target){
//                int test = midPoint;
//            } else if(current > target){
//                end = midPoint - 1;
//                System.out.println("do something");
//            } else {
//                start = midPoint + 1;
//                System.out.println("do else");
//            }
//
//        }
//       // return -1;
//    }
//
//    @Test
//    public void testWordBreak() {
////        String s = "applepenapple";
////        List<String> wordDict = Arrays.asList("apple","pen");
////        Boolean output = true; String test = String.valueOf(output);
////        StringBuilder sb = new StringBuilder();
////        for(int i=0;i<s.length();i++){
////            char c = s.charAt(i);
////            output = true;
////            if(!wordDict.contains(sb.toString())){
////                output = false;
////                sb.append(c);
////            } else {
////                sb = new StringBuilder();
////                sb.append(c);
////                System.out.println("Testing");
////            }
////        }
////        System.out.println("output" + output);
//
//        String s = "applepenapple";
//        Set<String> wordDict = new HashSet<String>();
//        wordDict.add("apple");
//        wordDict.add("pen");
//
//        if (wordBreak(s, wordDict)) {
//            System.out.println("String can be segmented into words from dictionary.");
//        } else {
//            System.out.println("String cannot be segmented into words from dictionary.");
//        }
//
//    }
//
//    @Test
//    public static boolean wordBreak(String s, Set<String> wordDict) {
//        // Create an array to store the results of subproblems
//        boolean[] dp = new boolean[s.length() + 1];
//        dp[0] = true; // Empty string is always present in dictionary
//
//        // Process all substrings of the given string
//        for (int i = 1; i <= s.length(); i++) {
//            for (int j = 0; j < i; j++) {
//                // Check if the substring can be segmented and if the resulting
//                // substring is present in the dictionary
//                if (dp[j] && wordDict.contains(s.substring(j, i))) {
//                    dp[i] = true;
//                    break;
//                }
//            }
//        }
//
//        // Return the result for the entire string
//        return dp[s.length()];
//    }
//
//
//
//
//    @Test
//    public void reverseSubstringsBetweenEachPairs(){
//        // NOT working
//        String input = "(abcd)"; // "(u(love)i)"; int nums[] = {4,3,2}; String test[] = {"deep","pankaj"}; List<String> list = Arrays.asList("Me1","Me2"); char arr[] = input.toCharArray();
//        String expectedOutput = "iloveu";
//        // first thind ,decide if you want to use for loop or while loop.Here while loop looks better choice
//        int length = input.length();
//        int startIndex = 0;
//        StringBuilder sb = new StringBuilder();
//
//        while(startIndex < length){
//            char current = input.charAt(startIndex);
//            if(current == '('){
//                int indexOfClosingBracket = input.indexOf(")");
//                String subString = input.substring(startIndex+1,indexOfClosingBracket);
//                sb.append(subString).reverse();
//                startIndex = startIndex + indexOfClosingBracket;
//            }
//
//        }
//
//        System.out.println("Testing:"+ sb.toString());
//    }
//
//    @Test
//    public void reverseWordsInString(){
//
//        String input = " a    good     example   "; //   hello world   "; // sky is blue
//        String[] split = input.split(" ");
//        StringBuilder res = new StringBuilder();
//        int length = split.length;
//        for(int i=length-1;i>=0;i--){
//            if(split[i].length() == 0){
//                continue;
//            }
//            String current = split[i];
//            res.append(current);
//            res.append(" ");
//
//        }
//
//        String test = res.toString().trim();
//        System.out.println("Testing:" + test);
//        // return res.toString();
//    }
//    @Test
//    public void testCode() {
//        System.out.println("Test");
//        Gson gson = new Gson();
//        try{
//           FileReader reader = new FileReader("/Users/dshah10/IdeaProjects/iboss-decision-svc/app/src/test/resources/photographers1.json");
//            //Photographer dataObject = gson.fromJson(reader, Photographer.class);
//            // System.out.println("Name: " + dataObject.getName());
//            DataObject dataObject = gson.fromJson(reader, DataObject.class);
//            for (Photographer photographer : dataObject.getPhotographers()) {
//                System.out.println("ID: " + photographer.getName());
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        JsonParser parser = new JsonParser();
//        try {
//            JsonElement jsonData = parser.parse(new FileReader("/Users/dshah10/IdeaProjects/iboss-decision-svc/app/src/test/resources/photographers.json")); // /Users/dshah10/IdeaProjects/iboss-decision-svc/app/src/test/resources/photographers.json
//            JsonArray jsonArray = jsonData.getAsJsonArray();
//            for(int i=0;i<jsonArray.size();i++){
//                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
//                String name = jsonObject.get("name").getAsString();
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    @Test
//    public void threeSum(){
//        int[] nums = {-1,0,1,2,-1,-4};
//        Arrays.sort(nums);
//        List<List<Integer>> list = new LinkedList<>();
////        Input: nums = [-1,0,1,2,-1,-4]
////        Output: [[-1,-1,2],[-1,0,1]]
////        nums[i] + nums[j] + nums[k] == 0
//        for(int i=0;i<nums.length-2;i++){
//            if(i==0 || i>0 && nums[i] != nums[i-1]){
//                int low = i+ 1;
//                int high = nums.length -1;
//                int sum = 0-nums[i];
//
//                while(low<high){
//                    if(nums[low] + nums[high] == sum){
//                        list.add(Arrays.asList(nums[i] + nums[low]+ nums[high]));
//                        low++;
//                        high--;
//                    } else if(nums[low] + nums[high] > sum){
//                        high--;
//                    } else {
//                        low++;
//                    }
//                }
//            }
//        }
//
//        // return list;
//
//    }
//
//    @Test
//    public void countMaxFrequencies(){
//        List<Integer> list = Arrays.asList(1,2,2,2,5,5,10);
//        List<Integer> newList = list.stream()
//                        .sorted((p1,p2) -> p1.compareTo(p2))
//                .collect(Collectors.toList());
//
//        Collections.sort(list);
//        Map<Integer,Integer> map = new HashMap<>();
//
//        for(int i=0;i<list.size();i++){
//
//            int current = list.get(i);
//            if(!map.containsKey(current)) {
//                map.put(current, 1);
//            } else {
//                int count = map.get(current);
//                map.put(current,count + 1);
//
//            }
//        }
//
//        List<Integer> values = map.values().stream().collect(Collectors.toList());
//
//        int max = Integer.MIN_VALUE;
//        for(int j=0;j<values.size();j++){
//          int curr = values.get(j);
//          if(curr > max){
//              max = curr;
//          }
//        }
//
//        List<Integer> test = map.entrySet().stream()
//                .filter(x -> x.getValue() == 3)
//                .map(Entry::getKey)
//                .collect(Collectors.toList());
//
//        int maxFrequency = map.values().stream()
//                .mapToInt(z->z.intValue())
//                        .max().getAsInt();
//
//        System.out.println("List");
//    }
//
//    @Test
//    public void reverseParenthesis(){
//
//        String input =  "(u(love)i)";
//        char[] ar = input.toCharArray();
//        String reversedString = helper(ar);
//        System.out.println("Testing ::"+ reversedString);
//
//    }
//
//    private String helper(char[] s) {
//        StringBuilder sb = new StringBuilder();
//
//        while (i< s.length){
//            if(s[i] == ')'){
//                i++;
//                return sb.reverse().toString();
//            }
//            else if (s[i] == '('){
//                i++;
//                String st = helper(s);
//                sb.append(st);
//            } else {
//                sb.append(s[i]);
//                i++;
//            }
//        }
//
//        return sb.toString();
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    // charLimit higher than origin comment size.
//    private static final String OPENING_BRACKETS = "[{(";
//    private static final String CLOSING_BRACKETS = "]})";
//
//
//    @Test
//    public void countWords() { // TODO
//        String testing = "Count number of words";
//        String[] split = testing.split(" ");
//        int count = 0;
//        for(int i=0;i<split.length;i++){
//            count++;
//        }
//        System.out.println( count);
//    }
//
//    @Test
//    public void firstUniqueChar(){ // TODO
//        String test = "loveleetcode";
//        HashMap<Character,Integer> map = new HashMap<>();
//        for (int i=0;i<test.length();i++){
//            char current= test.charAt(i);
//            if(!map.containsKey(current)){
//                map.put(current,i);
//            } else {
//                map.put(current,-1); // invalidate
//            }
//        }
//        int min = 0;
//        for( char c:map.keySet()){
//            if(map.get(c) < -1 && map.get(c) <min )
//            min = map.get(c);
//        }
//    }
//
//    @Test
//    private static void reverse(){
//        List<Integer> list = Arrays.asList(1,2,3);
//        List<String> list1 = Arrays.asList("deepak","rahul");
//
//        int[] array = {1,2,3,4,5};
//        int maxIndex = array.length-1;
//        int halfIndex = array.length/2;
//        for(int i=0;i< halfIndex;i++){
//            int temp = array[i];
//            array[i] = array[maxIndex-i];
//            array[maxIndex-i] = temp;
//        }
//        System.out.println(Arrays.toString(array));
//    }
//
//    @Test
//    public void KthLargest(){
//        int[] nums = {3,2,1,5,6,4};
//        int k = 2; // 2nd largest number in the unsorted array,it should find the number 5
//  // Easy way to solve but complexity is higher
////        Arrays.sort(nums);
////        return nums[nums.length -k];
//    }
//    @Test
//    public void countChars(){
//        String input = "aabbbcc";
//        String output = ""; // ""a2b3c2";
//        int count = 1;
//
//        for (int i = 0; i < input.length() - 1; i++) {
//            char current = input.charAt(i);
//            char next = input.charAt(i + 1);
//
//            if (current == next) {
//                count++;
//            } else {
//                output += current + "" + count;
//                count = 1;
//            }
//        }
//        System.out.println("Print me" + output);
//    }
//
//    @Test
//    private static void twoSumUsingPointers() {
//        // when it is sorted
//        int[] nums = {2, 3,4,7, 11, 15};
//        int target = 9;
//        int a_pointer = 0;
//        int b_pointer = nums.length-1;
//        int[] results = new int[2];
//
//        while(a_pointer<b_pointer){
//            int sum = nums[a_pointer] + nums[b_pointer];
//            if(sum == target){
//                results[0] = a_pointer;
//                results[1] = b_pointer;
//                break;
//            } else if (sum > target) {
//                b_pointer--;
//            } else {
//                a_pointer++;
//            }
//        }
//
//        System.out.println("Testing :"+ results);
//    }
//
//    @Test
//    private static void twoSum() {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int[] results = new int[2];
//
//        for (int i = 0; i < nums.length; i++) {
//            int difference = target - nums[i];
//            if (map.containsKey(difference)) {
//                results[0] = i;
//                results[1] = map.get(difference);
//                // return results;
//            }
//            map.put(nums[i], i);
//        }
//        // return results;
//    }
//
//    @Test
//    private static void countWordsInHashMap(){
//        String[] tests = {"deepak","andrew","deepak","pankaj"}; // deepak 2 ,andrew 1,pankaj 1
//        HashMap<String,Integer> map = new HashMap<>();
//        for(int i=0;i<tests.length;i++){
//            String currentWord = tests[i];
//            if(!map.containsKey(currentWord)){
//                map.put(currentWord, 1);
//            } else {
//                int count = map.get(currentWord);
//                count = count + 1;
//                map.put(currentWord,count);
//            }
//        }
//    }
//
//    @Test
//    public void CountTestWordsOneMoreTime(){
//        String[] tests = {"deepak","andrew","deepak","pankaj"}; // deepak 2 ,andrew 1,pankaj 1
//    }
//
//    @Test
//    public static void testCheckSum() {
//        Scanner scanner = new Scanner(System.in);
//        int sum = 0;
//            String line = "5 1 9 5";
//            String[] parts = line.split(" ");
//            int min = Integer.MAX_VALUE;
//            int max = Integer.MIN_VALUE;
//            for (String part : parts) {
//                int num = Integer.parseInt(part);
//                if (num < min) {
//                    min = num;
//                }
//                if (num > max) {
//                    max = num;
//                }
//            }
//            sum += max - min;
//        System.out.println("Checksum: " + sum);
//    }
//    @Test
//    public static void employeeSorting(){
//        System.out.println("testing");
////        Comparator<Employee> employeeAgeComparator
////                = Comparator.comparingInt(Employee::getAge);
////        Arrays.sort(employees, employeeAgeComparator);
////
////        Comparator<Employee> employeeNameComparator
////                = Comparator.comparing(Employee::getName);
////
////        Comparator<Person> personNameComparator =
////                (a, b) -> a.getName().compareTo(b.getName());
//
//        TreeSet<Photographer> photographerSet = new TreeSet<Photographer>(Comparator.comparingInt(Photographer::getRate));
//
//    }
//
//    @Test
//    public void removeDuplicatesInSortedArray(){
//        int[] nums = {1, 1, 2, 2, 3, 4, 4, 4, 5}; // taken from gen AI
//        int j = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] != nums[i-1]) {
//                nums[j++] = nums[i];
//            }
//        }
//    }
//
//    @Test
//    public void isValid(){
//    String input = "{[]}";
//      //  Stack<Character> stack = new Stack<Character>();
////        for(int i=0;i<input.length();i++){
////            char current = input.charAt(i);
////            if(isOpeningBracket(current)){
////                stack.push(current);
////            } else {
////                if(!isMatching(current,stack.pop())){
////                    return false;
////                }
////            }
////        }
//    }
//    private boolean isMatching(Character current,Character pop) {
//        return OPENING_BRACKETS.indexOf(pop) == CLOSING_BRACKETS.indexOf(current);
//    }
//    private boolean isOpeningBracket(char current) {
//        return OPENING_BRACKETS.indexOf(current) != -1;
//    }
//
//    @Test
//    public static void photoApp(){
//        DataStore dataStore = new DataStore();
//
//        // Add photographers to the data store
//        dataStore.addPhotographer("John", "New York", 500, Arrays.asList("Wedding", "Corporate Events"));
//        dataStore.addPhotographer("Jessica", "New York", 800, Arrays.asList("Wedding", "Bridal Shower"));
//        dataStore.addPhotographer("Mike", "San Francisco", 600, Arrays.asList("Rehearsal dinner", "Birthday Parties"));
//        dataStore.addPhotographer("Anna", "Los Angeles", 1000, Arrays.asList("Wedding"));
//
//        // Search for photographers
//        List<Photographer> results = dataStore.searchPhotographers("New York", "Wedding", 700);
//        for (Photographer p : results) {
//            System.out.println("Name: " + p.getName() + ", Location: " + p.getLocation() + ", Rate: " + p.getRate());
//        }
//
//        // Get photographers sorted by rates
//        List<Photographer> sortedResults = dataStore.getPhotographersByRate();
//        for (Photographer p : sortedResults) {
//            System.out.println("Name: " + p.getName() + ", Location: " + p.getLocation() + ", Rate: " + p.getRate());
//        }
//    }
//
//    @Test
//    public static void readFiles(){
//
//
//
//        try {
//            List<List<String>> records = Files.readAllLines(Paths.get("Player.csv"))
//                    .stream()
//                    .map(line -> Arrays.asList(line.split(",")))
//                    .collect(Collectors.toList());
//        } catch(Exception ex){
//            System.out.println("Exception is:" + ex);
//        }
//    }
//
//    @Test
//    public static void checkSum1() {
//        String big = "5 1 9 5\n7 5 3\n2 4 6 8";
//        String[] split = big.split("\\n");
//        int sum = 0;
//        for (int j = 0; j < split.length; j++) {
//            String test = split[j];;
//
//            int max = Integer.MIN_VALUE;
//            int min = Integer.MAX_VALUE;
//
//            String[] arr = test.split(" ");
//            for (int i = 0; i < arr.length; i++) {
//                int num = Integer.parseInt(arr[i]);
//                if (num < min) {
//                    min = num;
//                }
//                if (num > max) {
//                    max = num;
//                }
//               // System.out.println("num =" + num);
//            }
//            sum = sum + (max - min);
//        }
//
//        // simple while loop
////        while(k>0){
////            WeatherData wData = tempQ.poll();
////            result.add(weatherData);
////            k--;
////
////        }
//        System.out.println("my sum="+ sum);
//    }
//
//    private static int[] readIntegers(){
//        Scanner scanner = new Scanner(System.in); // Reading
//        System.out.println("Enter list of integers");
//        String input = scanner.nextLine();
//        return null;
//    }
//
//    private static int findMIn(int[] arr){
//        int min = Integer.MAX_VALUE;
//        for(int i: arr){
//            int current = arr[i];
//            if(current < min){
//                min = current;
//            }
//        }
//        return min;
//    }
//
//    private List<String> getList(){
//        return null;
//    }
//
//    @Test
//    public void testJava8Stream(){
//        List<Employee> empList = new ArrayList<>();
//        empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
//        empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
//        empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
//        empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));
//
//        empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
//        empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
//        empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
//        empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
//        empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010));
//
//        // 1. get the employees by city
//        Map<String,List<Employee>> employeesByCity = new HashMap<>();
//
//        employeesByCity = empList.stream()
//                .collect(Collectors.groupingBy(Employee::getCity));
//        System.out.println("Employees group by city:" + employeesByCity);
//
//        // 2. grouo the employees by age
//        Map<Integer,List<Employee>> employeesByAge = new HashMap<>();
//
//        employeesByAge = empList.stream()
//                        .collect(Collectors.groupingBy(Employee::getAge));
//        System.out.println("Employees group by age:" + employeesByAge);
//
//        // 3. Find the count of male and female employees present in the organization
//        Map<String,Long> noOfMaleAndFemaleEmployees = empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
//        System.out.println("NoOfMale and Female employees ::"+ noOfMaleAndFemaleEmployees);
//
//        // 0. remove all duplicates from the list
//        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
//        Set<String> result = listWithDuplicates.stream().collect(toSet());
//
//        // 4. Print the names of all the departments in the organization
//        Stream<String> distinctDepts = empList.stream().map((Employee::getDeptName)).distinct();
//        distinctDepts.forEach(System.out::println);
//
//        // 5. Print employee details whose age is greater than 28
//        empList.stream().filter(x->x.getAge() > 28).collect(Collectors.toList());
//
//        // 6. Find max age of the employee
//        empList.stream().mapToInt(Employee::getAge).max(); // remember this is max inside employee else .mapToInt(x->x.intValue()).max()
//
//        // 7. print average of Male and Female employees
//        Map<String,Double> avgAge = empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
//
//        // 8. Print the number of employees in each department
//        Map<String,Long> countEmpByDept = empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
//        System.out.println("No of employees in each department");
//        for(Entry<String, Long> entry : countEmpByDept.entrySet())
//        {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
//
//        // 9. Find oldest employeeFind oldest employee
//        Optional<Employee> oldestEmp = empList.stream().max(Comparator.comparingInt(Employee::getAge));
//        Employee oldestEmployee = oldestEmp.get();
//        System.out.println("Oldest employee details:: \n" + oldestEmployee);
//
//        // 10. Find youngest female employee.
//        //can use anyMatch also
//        Optional<Employee> youngestEmp = empList.stream().filter(e -> e.getGender() == "F")
//                .min(Comparator.comparingInt(Employee::getAge));
//        Employee youngestEmployee = youngestEmp.get();
//        System.out.println("Youngest Female employee details:: \n" + youngestEmployee);
//
//       // 16. Find all employees who lives in ‘Blore’ city, sort them by their name and print the names of employees.
//        empList.stream().filter(e->e.getCity().equalsIgnoreCase("Blore"))
//                .sorted(Comparator.comparing(Employee::getName))
//                .forEach(e->System.out.println("Employing staying in Bangalore::" + e.getName()));
//       // 17. No of employees in the organisation
//       empList.stream().count();
//       // 18. Not needed
//
//    }
//}