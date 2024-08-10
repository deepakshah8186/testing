package com.example.TestProject;

import com.google.gson.*;
import dumm.Emp;
import dumm.EmpRateComparator;
import factorypattern.Vehicle;
import factorypattern.VehicleFactory;
import mac.DataObject;
import mac.DataStore;
import mac.Employee;
import mac.Photographer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

@SpringBootTest
class TestProjectApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	void kthSmallestElementInATree(){
		// https://www.youtube.com/watch?v=C6r1fDKAW_o&t=92s
	}
	// tree traversal techniques https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
	// Binary tree vs BST ( traverse tree in order )  In a BST, the values of the nodes are ordered so that
	// the left child's value is always smaller than the parent node's value, and the right child's value is always larger.
	// see 2 images from savinnyt interview folder
	// validate BST
	// practice system design and drawing https://excalidraw.com/#room=280d57c7fbc2609cd1c8,l-3sd9sESYiEs7_diH6blg
	// check chat gpt for binary tree : most common coding interview questions on binary tree java.
	// valid bst good video https://www.youtube.com/watch?v=9btwHI_84DM










































	@Test
	public void tesSingleList(){
//		* Create your own single linked list class with two methods
//* 1 - To add new elements in the list
//				* 2 - To find the middle element of the list
//				* Constraints - Do not use size to keep track of number of elements added to the list to determine middle
//				* Constraints - Do not use any java collection APIs
//*
//* Example: If there are even number of elements then find middle method should return second middle. i.e. if list has 1- >2->3->4 , then in this case 2 and 3 are in the middle, please return 3.
//				*
//* Please ask clarifying questions, please take help as needed
	}















































	@Test
	public void solution() {
		int[] A = {23,333,33,30,0,505};

		for(int i=0;i<A.length;i++){

			int val = A[i];
			String current = String.valueOf(val);

		}
	}














	@Test
	public void findSmallestMissingPositive(){
		int[] nums = {3, 4, -1, 1,1};
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<nums.length;i++){
			set.add(nums[i]);
		}
		int missingNumber = 1;
		while (set.contains(missingNumber)) {
			missingNumber++;
		}

		System.out.println("Testing: "+ missingNumber);
	}








































	@Test
	public void longestConsecutiveSequence(){
//		Example 1:
//		Input: nums = [100,4,200,1,3,2]
//		Output: 4
//		Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//		Example 2:
//		Input: nums = [0,3,7,2,5,8,4,6,0,1]
//		Output: 9
//		The array needs to be sorted
//		We will need to iterate through the sorted array.
//				Make sure that the duplicate elements are skipped in order to avoid the errors in the subsequences. Eg. for the testcase [1,2,0,1], the sorted array would be [0,1,1,2]. if we dont ignore the duplicates, they would break the consecutive sequence into [0,1] and [1,2].
//		Check the differences in the consecutive elements
//		Make sure to remember or store the maximum length of the sequence.

		int[] nums = {100,101,4,1,3,2}; // 1,2,3,4,100,200
		Arrays.sort(nums);
		int count = 1;int maxi = 1;
		for(int i=0;i<nums.length -1;i++){
			if(nums[i] == nums[i+1]){ // remove duplicates
				continue;
			}
			if(nums[i] - nums[i+1] == -1){
				count ++;//checking consecutive elements
			} else {
				maxi = Math.max(maxi,count);//storing maximum length of the sequence
				count = 1;
			}
		}
		maxi = Math.max(maxi,count); // for last check,count is left
	}
















































	@Test
	public void mergeSortedArraysStream(){
		int[] nums1 = {1, 2, 3, 0, 0, 0};
		int[] nums2 = {2, 5, 6};
		int[] mergedArray = mergeAndSortArraysUsingStream(nums1, nums2);

		System.out.println("Merged and Sorted Array: " + Arrays.toString(mergedArray));
	}

	public static int[] mergeAndSortArraysUsingStream(int[] nums1, int[] nums2) {
		return IntStream.concat(
						Arrays.stream(nums1).filter(num -> num != 0), // Filter out zeros from nums1
						Arrays.stream(nums2)
				)
				.sorted()
				.toArray();
	}


	@Test
	public void maxSubarrayContiguos(){
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int max_sum = 0;
		int current_sum = 0;

		for(int i=0;i<nums.length;i++){
			current_sum = Math.max(current_sum,nums[i] + current_sum);
			max_sum = Math.max(current_sum,max_sum);

		}
	}

	@Test
	public void groupedAnagrams(){
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	}

	@Test
	public void isAnagram(){
		String s = "anagram";
		String t = "nagaram";

		int[] char_counts = new int[26];
		for(int i=0;i<s.length();i++){

			int char_count_s = char_counts[s.charAt(i) - 'a']++;
			int char_count_t = char_counts[t.charAt(i) - 'a']--;
			System.out.println("Testing char_count_s" + char_count_s);
			System.out.println("Testing char_count_t" + char_count_t);

			for(int count: char_counts){
				if(count != 0){
					// return false;
				}
			}
		}

	}

	@Test
	public void validAnagram(){
		String s = "anagram";
		String t = "nagaram";
		char[] arr = s.toCharArray();
		char[] arrT = t.toCharArray();
		Arrays.sort(arr);
		Arrays.sort(arrT);

		// check their length
		// for(int i=0;)
	}

	@Test
	public void longestSusbtringwithOuteRepetition(){
		String s = "abcabcbb"; int output = 3; // abc

		int a_pointer = 0;
		int b_pointer = 0;

		HashSet<Character> set = new HashSet<>();
		int max = Integer.MIN_VALUE;
		while(b_pointer<s.length()){
			if(!set.contains(s.charAt(b_pointer))){
				set.add(s.charAt(b_pointer));
				b_pointer++;
				max = Math.max(max,set.size());
			} else {
				set.remove(s.charAt(a_pointer));
				a_pointer++;
			}
		}

		System.out.println("Testing: " + max);


	}

	@Test
	public void reverseWordsInAStringOneMoreTime(){
		String s = " a    good     example   ";

		String[] input = s.strip().split(" ");
//		int length = input.length()-1;
		StringBuilder sb = new StringBuilder();
//
		for(int i=input.length -1;i>=0; i--){
			if(input[i].equals("")){
				continue;
			}
			String splitString = input[i].strip();
			sb.append(" ");
			sb.append(splitString);
		}
		System.out.println("Testing "+ sb);
	}


	@Test
	public void removeDuplicatesFromSortedArray(){
		int[] nums = {1, 1, 2, 2, 3, 4, 4, 4, 5};

	//	int newLength = removeDuplicates(nums);
		int newLength = 2;
		System.out.println("Length of array after removing duplicates: " + newLength);
		System.out.print("Array after removing duplicates: ");
		for (int i = 0; i < newLength; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int uniqueIndex = 1; // Index to place the next unique element

		// int[] nums1 = new int[nums.length];
		for(int i=1;i<nums.length;i++){ // it is important to note that i and uniqueindex needs to be 1
			if(nums[i] != nums[i-1]) { // this need to be i-1
				nums[uniqueIndex++] = nums[i];
			}
		}

		return uniqueIndex;
	}




	@Test
	public void palindromeOneMoreTime1(){
		String sb = "a man, a plan, a canal: panama"; // amanaplanacanalpanama
		boolean output = true;
		String reverse = "amanaplanacanalpanama";
		int a_pointer = 0;

		boolean isPalindrome = true;
		StringBuilder s = new StringBuilder();

		for(int i=0;i<sb.length();i++){
			char current = sb.charAt(i);
			if(Character.isLetterOrDigit(current)){
				s.append(current);
			}
		}

		sb = s.toString();
		int b_pointer = sb.length()-1;

		while(a_pointer < b_pointer){
			if(sb.charAt(a_pointer) == sb.charAt(b_pointer)){
				a_pointer++;
				b_pointer--;
			} else {
				isPalindrome = false;
			}
		}

		System.out.println("Testing" + isPalindrome);
	}

	@Test
	public void validPalindromeByDeletingOneCharacter(){
		String input = "abcad";
		int a_pointer = 0;
		int b_pointer = input.length()-1;
		boolean isPalindromeAfterRemovingOneChar = true;

		while(a_pointer <= b_pointer){
			if(input.charAt(a_pointer) != input.charAt(b_pointer)){
				// return false;
				isPalindromeAfterRemovingOneChar =  validPalindromeHelperMethod(input,a_pointer+1,b_pointer) || validPalindromeHelperMethod(input,a_pointer,b_pointer-1);
				break;
			} else {
				a_pointer++;
				b_pointer--;
			}
		}

		System.out.println("Testing if possible:" + isPalindromeAfterRemovingOneChar);

	}

	public boolean validPalindromeHelperMethod(String sb,int a_pointer,int b_pointer){

		while(a_pointer <= b_pointer){
			if(sb.charAt(a_pointer) != sb.charAt(b_pointer)){
				return false;
			} else {
				a_pointer++;
				b_pointer--;
			}
		}

		return true;
	}


























	@Test
	public void testSqlQueryInterviewQuestions() {
		// top 10 sql interview questions https://www.youtube.com/watch?v=ZML_EJrBhnY&t=156s
		// volatile vs transient - volatile keyword is a modifier that ensures that an attribute's value is always the same when read from all threads
		// Java's transient keyword is used to denote that a field is not to be serialized, whereas JPA's @Transient annotation is used to indicate that a field is not to be persisted in the database,
		// delete from cars where model_id not in (select min(model_id) from cars group by model_name,brancd
	}





	@Test
	public void sortEmployeesBasedonTheirRatesJava8StreamWay(){
		// top 10 sql interview questions https://www.youtube.com/watch?v=ZML_EJrBhnY&t=156s
		// volatile vs transient
		List<Emp> list = getEmps();
// you have to use sorted function. you need to tell sorted function that whether it is going to do based on rate,salary
		List<Emp> sortedList1= list.stream()
				.sorted((e1,e2)-> e1.getRate().compareTo(e2.getRate())).collect(Collectors.toList());// avoid this
		List<Emp> sortedList = list.stream()
				.sorted(Comparator.comparing(Emp::getRate)).collect(Collectors.toList());
		sortedList1.forEach(e->System.out.println(e));
		sortedList.forEach(e->System.out.println(e));
		// if you use priority queue,you dont have to call sort method explicitly
		PriorityQueue<Emp> queue = new PriorityQueue<>(Comparator.comparing(Emp::getRate));
		queue.addAll(list);
		// after comparator - you can call sort() or max() or min() to get employee	// max rate employee
		Optional<Emp> emp = list.stream().max(Comparator.comparingDouble(Emp::getRate));
	}// ask chat gpt to Write a java code to sort employee array list based on their rates
	@Test
	public void sortEmployeesBasedonTheirRates(){
		List<Emp> list = getEmps();
		Collections.sort(list,new EmpRateComparator());
		list.forEach(e->System.out.println(e));	}
	@Test
	public void testMergedEmployeeBasedOnTheRatesUsingJavaStreams(){
		// grouping by is like merging
		List<Emp> list = getEmps();
		Map<Double,List<Emp>> map = new HashMap<>();
		Map<Double, List<Emp>> mergedMapByRate = list.stream().collect(Collectors.groupingBy(Emp::getRate));
		// good trick to get key and emp
		mergedMapByRate.forEach((key,emp)->
				{
					System.out.println("key :" + key);System.out.println("emp :" + emp);
				});
		// How many 80$ rate is there
		Map<Double, Long> mergedRateCount = list.stream().
				collect(Collectors.groupingBy((Emp::getRate),Collectors.counting()));}
	// ask chat gpt to Write a java code to merge employee array list based on their rates
	@Test
	public void testMergedEmployeeBasedOnTheRates(){
		List<Emp> list = getEmps();Map<Double,List<Emp>> map = new HashMap<>();
		for(int i=0;i< list.size();i++){
			Emp current = list.get(i);
			if(!map.containsKey(current.getRate())){
				List<Emp> list1 = new ArrayList<>();
				list1.add(current);
				map.put(current.getRate(),list1);
			} else {
				double key = current.getRate();
				List<Emp> existing = map.get(key);
				existing.add(current);
				map.put(key,existing);
			}}// print the rate and the employee
		for(Map.Entry entry:map.entrySet()){
			double rate = (double) entry.getKey();
			List<Emp> empList = (List<Emp>) entry.getValue();
			System.out.println("Rate ::" + rate);
			System.out.println("Emplist ::" + empList.toString());
		}

		// Better than Hashmap is priority queue
       // if you use priority queue,you dont have to call sort method explicitly
		PriorityQueue<Emp> queue = new PriorityQueue<>(Comparator.comparing(Emp::getRate));
		queue.addAll(list);
		// Use a HashMap to group employees by their rates
		Map<Double, List<Emp>> mergedEmployees = new HashMap<>();

		// Process the priority queue and group employees by their rates
		while (!queue.isEmpty()) {
			Emp emp = queue.poll();
			mergedEmployees.computeIfAbsent(emp.getRate(), k -> new ArrayList<>()).add(emp);
		}

		// good design question link - maja aa gaya vending machine problem from chat gpt padh kar
		// https://medium.com/javarevisited/25-software-design-interview-questions-to-crack-any-programming-and-technical-interviews-4b8237942db0
		// question to chat gpt 1. Can you please design the Vending Machine in Java?
		// Please design URL Shortening service like goo.gl or bit.ly
		// Please design Yelp or Nearby Friends in java from chat gpt

		// design ( jordon has no life - youtube ) ,arpit bhayani youtube , concept and coding by shrayansh
		// wats app messenger( Gaurav Sen ), done
		// newsfeed, https://www.youtube.com/watch?v=QmX2NPkJTKg
		// proximily services-yellow pages(list of restaurant) - https://www.youtube.com/watch?v=M4lR_Va97cQ done
		// order service(uber eats) https://www.youtube.com/watch?v=uBn03yKnlT4 ( very nice simpla order mgt video )
		// uber taxi, https://www.youtube.com/watch?v=umWABit-wbk&t=343s and https://www.youtube.com/watch?v=R_agd5qZ26Y
		// payment processing - https://www.youtube.com/watch?v=olfaBgJrUBI - check chat gpt with" What are the examples of payment gateway in United states".
		//  - ask chat gpt "Which payment gateway Intuit uses ? Intuit uses its own payment processing service.Adyen for UK
		// tinder - https://www.youtube.com/watch?v=tndzLznxq40https://www.youtube.com/watch?v=tndzLznxq40 - done

		// string palindrome ,string matching with pattern,linkedlist ( reversed the list and how to sort the list , how to detect the cycle, delete the nth node )
		// priority queue(min heap ,max heap,comparator) - word count - highest count ( equivalent of using map) - first top 3 ,highest count,pattern ( trai data structure )
		// stack,trai (node - > a to z) (search),tree (min nodes,max nodes,depth(based cond )
		// for lucid chart diagram https://app.diagrams.net/ or https://lucid.app/lucidchart/41129344-21f6-4384-91b7-fa9b30ce7fa2/edit?invitationId=inv_37001956-21fa-4de4-9df7-46fb780142ac&page=0_0#
	}

	private List<Emp> getEmps() {
		Emp employee1 = new Emp("Deepak",80.0);
		Emp employee2 = new Emp("Rahul",60.0);
		Emp employee3 = new Emp("Pankaj",60.0);
		Emp employee4 = new Emp("Lan",80.0);
		Emp employee5 = new Emp("Rahul",50.0);

		List<Emp> list = Arrays.asList(employee1,employee2,employee3,employee4,employee5);
		return list;
	}

	@Test
	public void mergeSortedArrays(){

	int nums1[] = {1,2,3,0,0,0};
	int nums2[] = {2,5,6};
	int m=3;
	int n=3;
	merge(nums1,m,nums2,n);
	// print nums1
		Arrays.stream(nums1).forEach(System.out::println);
		Arrays.stream(nums1).forEach(e->System.out.println("my element :" + e));
	// check the video on https://www.youtube.com/watch?v=0H6038ldSyg&t=391s

	}

	public void merge(int[] nums1,int m,int[] nums2 ,int n){
		int i = m-1;
		int j = n-1;
		int k = m + n -1;

		while(j>=0){
			if(i>=0 && nums1[i] > nums2[j]){
				nums1[k] = nums1[i]; // 3 > 2 , {1,2,3,3,5,6 }
				k--;
				i--;
			} else {
				nums1[k] = nums2[j]; // 3 > 6 ,{1,2,3,0,0,6} : 3 > 5 , {1,2,3,0,5,6} : 2> 2 { 1,2,2,3,5,6}
				k--;
				j--;

			}
		}
	}

	@Test
	public void mergeSortedArraysBestWay(){

		int nums1[] = {1,2,3,0,0,0};
		int nums2[] = {2,5,6};
		int m=3;
		int n=3;
		mergeBestWay(nums1,m,nums2,n);
		// print nums1
		Arrays.stream(nums1).forEach(System.out::println);
		Arrays.stream(nums1).forEach(e->System.out.println("my element :" + e));
		// check the video on https://www.youtube.com/watch?v=0H6038ldSyg&t=391s

	}

	public void mergeBestWay(int[] nums1,int m,int[] nums2 ,int n){
		int i = m-1;
		int j = n-1;
		int k = m + n -1;

		while(j>=0){
			if(i>=0 && nums1[i] > nums2[j]){
				nums1[k] = nums1[i]; // 3 > 2 , {1,2,3,3,5,6 }
				k--;
				i--;
			} else {
				nums1[k] = nums2[j]; // 3 > 6 ,{1,2,3,0,0,6} : 3 > 5 , {1,2,3,0,5,6} : 2> 2 { 1,2,2,3,5,6}
				k--;
				j--;

			}
		}
	}

    @Test
    public void MaxValueAndIndexinArray(){
        int[] result = new int[2];
        int[] array = {3, 5, 7, 2, 18, 6, 4, 10, 1, 9};

        int max= Integer.MIN_VALUE;
        int index = 0;
        for(int i=0;i<array.length;i++){
            max = Math.max(max,array[i]);
            index = i; // THIS IS WRONG. DONT DO IT
        }

        System.out.println("My Maximum value: " + max);
        System.out.println("My index value: " + index);
        result = findMaxValueAndIndex(array);

        System.out.println("Maximum value: " + result[0]);
        System.out.println("Index of maximum value: " + result[1]);
    }

    public static int[] findMaxValueAndIndex(int[] array) {
       if(array == null || array.length == 0){
           throw new IllegalArgumentException();
       }

       int index= 0;
       int max = Integer.MIN_VALUE;
       for(int i=0;i<array.length;i++){
           int current = array[i];
           if(current > max){
               max= current;
               index= i;
           }
       }
       return new int[]{max,index};
    }

	@Test
	public void testCode1(){
		System.out.println("Testing junits");
		// login to chat gpt with hiiamdeepak2001@gmail.com. https://chatgpt.com/c/65250407-d567-4b4e-b3ca-4a6335d581bd
		// design patterns . factory vs builder patterns
		// Can you give example of factory vs builder pattern in Java. Check the key differences

		// Can you please give me top 5 Design patterns java interview questions . Singleton,Object factory,Observer pattern, and builder pattern

		// Factory Pattern: Abstracts the process of object creation and allows subclasses to alter the type of objects that will be created.
		VehicleFactory vehicleFactory = new VehicleFactory();

		Vehicle car = vehicleFactory.getVehicle("car");
		car.drive();

		Vehicle bike = vehicleFactory.getVehicle("bike");
		bike.drive();

	}

	//        System.out.println("Testing.");
//        Gson gson = new Gson();
//        try {
//            FileReader reader = new FileReader("C:\\Users\\deepa\\AppData\\Local\\Temp\\13e8e371-505b-490a-8285-df1f9ddf8d65_demo.zip.d65\\demo\\Test.json");
//
//            DataObject dataObject = gson.fromJson(reader,DataObject.class);
//            System.out.println("Dataobject " + dataObject.getPhotographers());
//
//            for(Photographer photographer:dataObject.getPhotographers()){
//
//                String name = photographer.getName();
//                String location = photographer.getLocation();
//                List<String> list = photographer.getEventTypes();
//            }
//
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
	public static List<List<Integer>> threeSum1(){
		int[] nums = {-1,0,1,2,-4}; // {-1,0,1,2,-1,-4}; // youtube by Nick White
		// https://www.youtube.com/watch?v=qJSPYnS35SE
		Arrays.sort(nums);

		List<List<Integer>> myList = new ArrayList<>();

		for(int i=0;i<nums.length-2;i++){
			if(i==0 || (i>0 && nums[i] != nums[i-1])){
				int low = i+1;
				int high = nums.length-1;
				int sum = 0-nums[i];

				while (low < high){
					if(nums[low]+nums[high] == sum){
						// found the list
						myList.add(Arrays.asList(nums[low],nums[high],nums[i]));
						low++;
						high++;
					} else if(nums[low] + nums[high] > sum){
						high--;
					} else {
						low++;
					}
				}
			}
		}

		System.out.println("Print myList :"+myList);

		return myList;
	}

	public static boolean wordBreak(String s, List < String > wordDict) {
		Set< String > wordDictSet = new HashSet< >(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				String subString = s.substring(j, i);
				if (dp[j] && wordDictSet.contains(subString)) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}


	public static void codeForPhotographerSet(){
		// TreeSet<Photographer> photoGrapherSet = new TreeSet<>(Comparator.comparingInt(Photographer::getRate))
	}


	public static void counMxFrequenciesOneMoretime(){
		List<Integer> list = Arrays.asList(1,5,6,5,10,2,2,9);
		Collections.sort(list);
		// List<Photographer> list = new ArrayList<>();
		System.out.println("Testing"+ list.toString());
		Map<Integer,Integer> map = new HashMap<>();


		for(int i=0;i<list.size();i++){
			int current = list.get(i);
			if(!map.containsKey(current)){
				map.put(current,1);
			} else {
				int count = map.get(current);
				map.put(current,count + 1);
			}
		}

//        map.values().stream()
//                .map(x->x)
//                .max();

		OptionalInt max = map.values().stream()
				.mapToInt(x->x)
				.max();

		List<Integer> myList = map.values().stream().collect(Collectors.toList());

//        List<Integer> test1 =  map.entrySet().stream()
//                .map(x->x.getValue() == max.getAsInt())
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList())

//        int max = Integer.MIN_VALUE;
//       for(int i=0;i<map.values().stream().;i++){
//
//       }

	}

	public static void countMaxFrequencies1(){
		List<Integer> list = Arrays.asList(1,2,2,2,5,5,10);
		List<Integer> newList = list.stream()
				.sorted((p1,p2) -> p1.compareTo(p2))
				.collect(Collectors.toList());

		Collections.sort(list);
		Map<Integer,Integer> map = new HashMap<>();

		for(int i=0;i<list.size();i++){

			int current = list.get(i);
			if(!map.containsKey(current)) {
				map.put(current, 1);
			} else {
				int count = map.get(current);
				map.put(current,count + 1);

			}
		}

		List<Integer> values = map.values().stream().collect(Collectors.toList());

		int max = Integer.MIN_VALUE;
		for(int j=0;j<values.size();j++){
			int curr = values.get(j);
			if(curr > max){
				max = curr;
			}
		}

		List<Integer> test = map.entrySet().stream()
				.filter(x -> x.getValue() == 3)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());

		// find the max frequency
		OptionalInt max1 = map.values().stream()
				.mapToInt(x->x)
				.max();

		int maxFrequency = map.values().stream()
				.mapToInt(z->z.intValue())
				.max().getAsInt();

		System.out.println("List");
	}

	// charLimit higher than origin comment size.
	private static final String OPENING_BRACKETS = "[{(";
	private static final String CLOSING_BRACKETS = "]})";



	// charLimit equal to than origin comment size.
//
//    public void trimStringTest1() {
//        String comment = "Start: some content in the middle:  End:";
//        System.out.println(comment.length());
//        String conciseComment = CommonUtils.trimString(comment, comment.length());
//        Assert.assertEquals(comment, conciseComment);
//    }

	// charLimit less to than origin comment size.


//	public void countWords() { // TODO
//		String testing = "Count number of words";
//		String[] split = testing.split(" ");
//		int count = 0;
//		for(int i=0;i<split.length;i++){
//			count++;
//		}
//		System.out.println( count);
//	}


	public void firstUniqueChar(){ // TODO
		String test = "loveleetcode";
		HashMap<Character,Integer> map = new HashMap<>();
		for (int i=0;i<test.length();i++){
			char current= test.charAt(i);
			if(!map.containsKey(current)){
				map.put(current,i);
			} else {
				map.put(current,-1); // invalidate
			}
		}
		int min = 0;
		for( char c:map.keySet()){
			if(map.get(c) < -1 && map.get(c) <min )
				min = map.get(c);
		}
	}


	private static void reverse(){
		List<Integer> list = Arrays.asList(1,2,3);
		List<String> list1 = Arrays.asList("deepak","rahul");

		int[] array = {1,2,3,4,5};
		int maxIndex = array.length-1;
		int halfIndex = array.length/2;
		for(int i=0;i< halfIndex;i++){
			int temp = array[i];
			array[i] = array[maxIndex-i];
			array[maxIndex-i] = temp;
		}
		System.out.println(Arrays.toString(array));
	}



	public static void countCharsTesting() {
		String input = "aabbbcc"; // 2a3b1c
		String output = ""; // ""a2b3c2";
		int count = 0;

		char first = 'a';
		for (int i = 0; i < input.length() ; i++) {
			char next = input.charAt(i);
			if (next == first) {
				count = count + 1;
			} else {
				System.out.print(""+first + ""+ count);
				count = 1;
			}
			first = next;

		}
		System.out.print(""+first + ""+ count);
	}






//	private static void countWordsInHashMap(){
//		String[] tests = {"deepak","andrew","deepak","pankaj"}; // deepak 2 ,andrew 1,pankaj 1
//		HashMap<String,Integer> map = new HashMap<>();
//		for(int i=0;i<tests.length;i++){
//			String currentWord = tests[i];
//			if(!map.containsKey(currentWord)){
//				map.put(currentWord, 1);
//			} else {
//				int count = map.get(currentWord);
//				count = count + 1;
//				map.put(currentWord,count);
//			}
//		}
//	}
//
//
//	public void CountTestWordsOneMoreTime(){
//		String[] tests = {"deepak","andrew","deepak","pankaj"}; // deepak 2 ,andrew 1,pankaj 1
//	}
//
//
//	public static void testCheckSum() {
//		Scanner scanner = new Scanner(System.in);
//		int sum = 0;
//		String line = "5 1 9 5";
//		String[] parts = line.split(" ");
//		int min = Integer.MAX_VALUE;
//		int max = Integer.MIN_VALUE;
//		for (String part : parts) {
//			int num = Integer.parseInt(part);
//			if (num < min) {
//				min = num;
//			}
//			if (num > max) {
//				max = num;
//			}
//		}
//		sum += max - min;
//		System.out.println("Checksum: " + sum);
//	}

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


//	public void removeDuplicatesInSortedArray(){
//		int[] nums = {1, 1, 2, 2, 3, 4, 4, 4, 5}; // taken from gen AI
//		int j = 1;
//		for (int i = 1; i < nums.length; i++) {
//			if (nums[i] != nums[i-1]) {
//				nums[j++] = nums[i];
//			}
//		}
//	}
//
//
//	public void isValid(){
//		String input = "{[]}";
//		//  Stack<Character> stack = new Stack<Character>();
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
//	}
//	private boolean isMatching(Character current,Character pop) {
//		return OPENING_BRACKETS.indexOf(pop) == CLOSING_BRACKETS.indexOf(current);
//	}
//	private boolean isOpeningBracket(char current) {
//		return OPENING_BRACKETS.indexOf(current) != -1;
//	}


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


//	public static void readFiles(){
//
//
//
//		try {
//			List<List<String>> records = Files.readAllLines(Paths.get("Player.csv"))
//					.stream()
//					.map(line -> Arrays.asList(line.split(",")))
//					.collect(Collectors.toList());
//		} catch(Exception ex){
//			System.out.println("Exception is:" + ex);
//		}
//	}


	public static void checkSum1() {
		String big = "5 1 9 5\n7 5 3\n2 4 6 8";
		String[] split = big.split("\\n");
		int sum = 0;
		for (int j = 0; j < split.length; j++) {
			String test = split[j];;

			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;

			String[] arr = test.split(" ");
			for (int i = 0; i < arr.length; i++) {
				int num = Integer.parseInt(arr[i]);
				if (num < min) {
					min = num;
				}
				if (num > max) {
					max = num;
				}
				// System.out.println("num =" + num);
			}
			sum = sum + (max - min);
		}

		// simple while loop
//        while(k>0){
//            WeatherData wData = tempQ.poll();
//            result.add(weatherData);
//            k--;
//
//        }
		System.out.println("my sum="+ sum);
	}

//	private static int[] readIntegers(){
//		Scanner scanner = new Scanner(System.in); // Reading
//		System.out.println("Enter list of integers");
//		String input = scanner.nextLine();
//		return null;
//	}
//
//	private static int findMIn(int[] arr){
//		int min = Integer.MAX_VALUE;
//		for(int i: arr){
//			int current = arr[i];
//			if(current < min){
//				min = current;
//			}
//		}
//		return min;
//	}
//
//	private List<String> getList(){
//		return null;
//	}


		// practice coding

		int i= 0;
		private String openingBracket = "[{(";
		private String closingBracket = "]})";

		@Test
		public void matchingBracketsPractice(){
		String input = "{[(]}"; // it should match
		Stack stack = new Stack();

		for(int i=0;i<input.length();i++){
			char current = input.charAt(i); // {

			if(opening(current)) {
				stack.add(current);
			} else {
				char seek = (char) stack.peek();
				if(closing(current) && opening(seek)){
					stack.pop();
				}
			}
		}

		boolean check = stack.isEmpty();
		System.out.println("If stack is empty ,then matching"+ check);
	}

		private boolean opening(char current) {
		return openingBracket.indexOf(current) != -1;
	}

		private boolean closing(char current){
		return closingBracket.indexOf(current) != -1;
	}

		@Test
		public void squareOfTheSortedArray(){
		int[] nums = {-1,-4, 0,3,10};
		int[] squareArray = new int[nums.length];
		Arrays.sort(nums);

		for(int i=0;i<nums.length-1;i++){
			squareArray[i] = nums[i] * nums[i];
		}
		// int[] myArray = Arrays.stream(nums).sorted().toArray();
		System.out.println("testing" + squareArray);
	}

//	Qualifications - PTC
// dynamodb video : https://www.youtube.com/watch?v=ExyktLzX-L8
//10+ years working experience in developing large scale enterprise cloud applications
//	Hands on experience developing distributed systems, large-scale systems, Backend APIs design and implementation
//	Solid understanding of distributed systems and cloud architectures
//	Strong knowledge of data structures and algorithms
//	Strong Knowledge of the Java stack - Spring Boot, Functional programming, Apache libraries and common open-source frameworks
//	Creative thinker and team player, humble attitude, self-directed with good communication skills and desire to make differences
//	Have designed, build, and maintain backend services exposing REST APIs on AWS Cloud
//	Have used AWS Services like Cloud Front, Load Balancer, EC2, S3, SQS, SNS, Secret Manager, etc.
//	Experience with NoSQL databases, particularly DynamoDB and Redis
//	Proficient in relational database systems such as MySQL, PostgreSQL or similar
//	Strong problem-solving and analytical skills with an aptitude for learning new technologies
//	Solid understanding and experience with agile software development methodologies
//			Responsibilities
//
//	As a Staff Software Engineer for the Mobile Backend Engineering Team, you will be a key member of the team to design Backend Services using REST APIs running on AWS
//	You will work within our agile software development process and have a direct impact on the products and applications we build that are directly consumed by ServiceMax customers, partners and internal engineering teams within our company
//	You will play a key role in Design & Development of Field Service Management SaaS Product highly scalable services running on AWS supporting 70k production users and processing 10 millions of transactions a day using the state-of-the-art technology
//	Troubleshoots Production issues by reviewing and analyzing information (for example, issue, impact, criticality, possible root cause)
//	Nice to have Skills
//
//	Exposure to Salesforce Service Cloud
//	Experience in using Salesforce REST APIs
//	Experience in Salesforce Apex Coding
//	BSc in Computer Science, Engineering, or relevant field

		@Test
		public void bestTimeToBuyAndSellStock(){
		int[] nums = {7,1,5,3,6,4}; int output = 5;
		int max_profit = 0;
		int min_value = Integer.MAX_VALUE;

		for(int i=0;i<nums.length;i++){
			int currentVal = nums[i];
			if(currentVal < min_value){
				min_value = currentVal;
			} else {
				int profit = currentVal - min_value;
				max_profit = Math.max(max_profit, profit);
			}
		}

		//Assert.assertEquals(output,max_profit);
	}

	@Test
	public void maxSubarrayOneMoreTime(){
	int[] nums = {-2,2,5,-11,6}; // {-2,1,-3,4,-1,2,1,-5,4}; int output = 6
//        int output = 7;
//        int max_sum = 0;
//        int current_max = 0;
//        for(int i=0;i<nums.length;i++){
//            int current = nums[i];
//            current_max= Math.max(current_max + current,current);
//            max_sum = Math.max(max_sum,current_max);
//        }
	 int maxSubArrayBruteForce = maxSubArrayBruteForce(nums);
	}
	public int maxSubArrayBruteForce(int[] nums) {
		int n = nums.length;
		int maximumSubArraySum = Integer.MIN_VALUE;
		for (int left = 0; left < n; left++) {
			int runningWindowSum = 0;
			for (int right = left; right < n; right++) {
				runningWindowSum += nums[right];
				if (runningWindowSum > maximumSubArraySum) {
					maximumSubArraySum = runningWindowSum;
				}
			}
		}
		return maximumSubArraySum;
	}

	public int maxSubarraySumByBruteForce(int[] nums){

			int maximumSubarraySum = Integer.MIN_VALUE;
		    int n = nums.length;

			for(int i=0;i<n;i++){
				int runningwindowSum = 0;
				for(int j=i;j<n;j++) {
					runningwindowSum = runningwindowSum + nums[j];
					if(runningwindowSum>maximumSubarraySum){
						maximumSubarraySum = runningwindowSum;
					}
				}
			}
			return maximumSubarraySum;
	}

		@Test
		public void BinarySearch(){
		// binary search is always done on sorted array.Linear search on unsorted
		// arrays take O(n) time but binary search takes log(n) but is should be done on sorted arr
		int[] nums = {-1,0,3,5,9,12}; int target = 8;
//        List<Integer> list = Arrays.asList(1,1,2);
//        String[] aar1 = {"est"};
		int start=0;
		int end= nums.length -1;

		if(nums.length == 0){
			// return -1;
		}

		while(start <= end){
			int midPoint = start + (end -start)/2;
			int current = nums[midPoint];
			if(current == target){
				int test = midPoint;
			} else if(current > target){
				end = midPoint - 1;
				System.out.println("do something");
			} else {
				start = midPoint + 1;
				System.out.println("do else");
			}

		}
		// return -1;
	}

		@Test
		public void testWordBreak() {
//        String s = "applepenapple";
//        List<String> wordDict = Arrays.asList("apple","pen");
//        Boolean output = true; String test = String.valueOf(output);
//        StringBuilder sb = new StringBuilder();
//        for(int i=0;i<s.length();i++){
//            char c = s.charAt(i);
//            output = true;
//            if(!wordDict.contains(sb.toString())){
//                output = false;
//                sb.append(c);
//            } else {
//                sb = new StringBuilder();
//                sb.append(c);
//                System.out.println("Testing");
//            }
//        }
//        System.out.println("output" + output);

		String s = "applepenapple";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("apple");
		wordDict.add("pen");

		if (wordBreak(s, wordDict)) {
			System.out.println("String can be segmented into words from dictionary.");
		} else {
			System.out.println("String cannot be segmented into words from dictionary.");
		}

	}

		@Test
		public static boolean wordBreak(String s, Set<String> wordDict) {
		// Create an array to store the results of subproblems
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true; // Empty string is always present in dictionary

		// Process all substrings of the given string
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				// Check if the substring can be segmented and if the resulting
				// substring is present in the dictionary
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		// Return the result for the entire string
		return dp[s.length()];
	}




		@Test
		public void reverseSubstringsBetweenEachPairs(){
		// NOT working
		String input = "(abcd)"; // "(u(love)i)"; int nums[] = {4,3,2}; String test[] = {"deep","pankaj"}; List<String> list = Arrays.asList("Me1","Me2"); char arr[] = input.toCharArray();
		String expectedOutput = "iloveu";
		// first thind ,decide if you want to use for loop or while loop.Here while loop looks better choice
		int length = input.length();
		int startIndex = 0;
		StringBuilder sb = new StringBuilder();

		while(startIndex < length){
			char current = input.charAt(startIndex);
			if(current == '('){
				int indexOfClosingBracket = input.indexOf(")");
				String subString = input.substring(startIndex+1,indexOfClosingBracket);
				sb.append(subString).reverse();
				startIndex = startIndex + indexOfClosingBracket;
			}

		}

		System.out.println("Testing:"+ sb.toString());
	}

		@Test
		public void reverseWordsInString(){

		String input = " a    good     example   "; //   hello world   "; // sky is blue
		String[] split = input.split(" ");
		StringBuilder res = new StringBuilder();
		int length = split.length;
		for(int i=length-1;i>=0;i--){
			if(split[i].length() == 0){
				continue;
			}
			String current = split[i];
			res.append(current);
			res.append(" ");

		}

		String test = res.toString().trim();
		System.out.println("Testing:" + test);
		// return res.toString();
	}
		@Test
		public void testCode() {
		System.out.println("Test");
		Gson gson = new Gson();
		try{
			FileReader reader = new FileReader("C:\\Users\\deepa\\Downloads\\TestProject\\TestProject\\src\\main\\resources\\photographers1.json");
			//Photographer dataObject = gson.fromJson(reader, Photographer.class);
			// System.out.println("Name: " + dataObject.getName());
			DataObject dataObject = gson.fromJson(reader, DataObject.class);
			for (Photographer photographer : dataObject.getPhotographers()) {
				System.out.println("ID: " + photographer.getName());
			}


		} catch (IOException e) {
			e.printStackTrace();
		}
		JsonParser parser = new JsonParser();
		try {
			JsonElement jsonData = parser.parse(new FileReader("C:\\Users\\deepa\\Downloads\\TestProject\\TestProject\\src\\main\\resources\\photographers.json")); // /Users/dshah10/IdeaProjects/iboss-decision-svc/app/src/test/resources/photographers.json
			JsonArray jsonArray = jsonData.getAsJsonArray();
			for(int i=0;i<jsonArray.size();i++){
				JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
				String name = jsonObject.get("name").getAsString();

			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

		@Test
		public void threeSum(){
		int[] nums = {-1,0,1,2,-1,-4};
		Arrays.sort(nums);
		List<List<Integer>> list = new LinkedList<>();
//        Input: nums = [-1,0,1,2,-1,-4]
//        Output: [[-1,-1,2],[-1,0,1]]
//        nums[i] + nums[j] + nums[k] == 0
		for(int i=0;i<nums.length-2;i++){
			if(i==0 || i>0 && nums[i] != nums[i-1]){
				int low = i+ 1;
				int high = nums.length -1;
				int sum = 0-nums[i];

				while(low<high){
					if(nums[low] + nums[high] == sum){
						list.add(Arrays.asList(nums[i] + nums[low]+ nums[high]));
						low++;
						high--;
					} else if(nums[low] + nums[high] > sum){
						high--;
					} else {
						low++;
					}
				}
			}
		}

		// return list;

	}

		@Test
		public void countMaxFrequencies(){
		List<Integer> list = Arrays.asList(1,2,2,2,5,5,10);
		List<Integer> newList = list.stream()
				.sorted((p1,p2) -> p1.compareTo(p2))
				.collect(Collectors.toList());

		Collections.sort(list);
		Map<Integer,Integer> map = new HashMap<>();

		for(int i=0;i<list.size();i++){

			int current = list.get(i);
			if(!map.containsKey(current)) {
				map.put(current, 1);
			} else {
				int count = map.get(current);
				map.put(current,count + 1);

			}
		}

		List<Integer> values = map.values().stream().collect(Collectors.toList());

		int max = Integer.MIN_VALUE;
		for(int j=0;j<values.size();j++){
			int curr = values.get(j);
			if(curr > max){
				max = curr;
			}
		}

		List<Integer> test = map.entrySet().stream()
				.filter(x -> x.getValue() == 3)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());

		int maxFrequency = map.values().stream()
				.mapToInt(z->z.intValue())
				.max().getAsInt();

		System.out.println("List");
	}

		@Test
		public void reverseParenthesis(){

		String input =  "(u(love)i)";
		char[] ar = input.toCharArray();
		String reversedString = helper(ar);
		System.out.println("Testing ::"+ reversedString);

	}

		private String helper(char[] s) {
		StringBuilder sb = new StringBuilder();

		while (i< s.length){
			if(s[i] == ')'){
				i++;
				return sb.reverse().toString();
			}
			else if (s[i] == '('){
				i++;
				String st = helper(s);
				sb.append(st);
			} else {
				sb.append(s[i]);
				i++;
			}
		}

		return sb.toString();
	}










































































		// charLimit higher than origin comment size.
//		private static final String OPENING_BRACKETS = "[{(";
//		private static final String CLOSING_BRACKETS = "]})";


		@Test
		public void countWords() { // TODO
		String testing = "Count number of words";
		String[] split = testing.split(" ");
		int count = 0;
		for(int i=0;i<split.length;i++){
			count++;
		}
		System.out.println( count);
	}

//		@Test
//		public void firstUniqueChar(){ // TODO
//		String test = "loveleetcode";
//		HashMap<Character,Integer> map = new HashMap<>();
//		for (int i=0;i<test.length();i++){
//			char current= test.charAt(i);
//			if(!map.containsKey(current)){
//				map.put(current,i);
//			} else {
//				map.put(current,-1); // invalidate
//			}
//		}
//		int min = 0;
//		for( char c:map.keySet()){
//			if(map.get(c) < -1 && map.get(c) <min )
//				min = map.get(c);
//		}
//	}

//		@Test
//		private static void reverse(){
//		List<Integer> list = Arrays.asList(1,2,3);
//		List<String> list1 = Arrays.asList("deepak","rahul");
//
//		int[] array = {1,2,3,4,5};
//		int maxIndex = array.length-1;
//		int halfIndex = array.length/2;
//		for(int i=0;i< halfIndex;i++){
//			int temp = array[i];
//			array[i] = array[maxIndex-i];
//			array[maxIndex-i] = temp;
//		}
//		System.out.println(Arrays.toString(array));
//	}

		@Test
		public void KthLargest(){
		int[] nums = {3,2,1,5,6,4};
		int k = 2; // 2nd largest number in the unsorted array,it should find the number 5
		// Easy way to solve but complexity is higher
//        Arrays.sort(nums);
//        return nums[nums.length -k];
	}
	private static void twoSum1() {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] results = new int[2];

		for (int i = 0; i < nums.length; i++) {
			int difference = target - nums[i];
			if (map.containsKey(difference)) {
				results[0] = i;
				results[1] = map.get(difference);
				// return results;
			}
			map.put(nums[i], i);
		}// return results;
	}

		@Test
		private static void twoSumUsingPointers() {
		// when it is sorted
		int[] nums = {2, 3,4,7, 11, 15};
		int target = 9;
		int a_pointer = 0;
		int b_pointer = nums.length-1;
		int[] results = new int[2];

		while(a_pointer<b_pointer){
			int sum = nums[a_pointer] + nums[b_pointer];
			if(sum == target){
				results[0] = a_pointer;
				results[1] = b_pointer;
				break;
			} else if (sum > target) {
				b_pointer--;
			} else {
				a_pointer++;
			}
		}

		System.out.println("Testing :"+ results);
	}

		@Test
		private static void twoSum() {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] results = new int[2];

		for (int i = 0; i < nums.length; i++) {
			int difference = target - nums[i];
			if (map.containsKey(difference)) {
				results[0] = i;
				results[1] = map.get(difference);
				// return results;
			}
			map.put(nums[i], i);
		}
		// return results;
	}

		@Test
		private static void countWordsInHashMap(){
		String[] tests = {"deepak","andrew","deepak","pankaj"}; // deepak 2 ,andrew 1,pankaj 1
		HashMap<String,Integer> map = new HashMap<>();
		for(int i=0;i<tests.length;i++){
			String currentWord = tests[i];
			if(!map.containsKey(currentWord)){
				map.put(currentWord, 1);
			} else {
				int count = map.get(currentWord);
				count = count + 1;
				map.put(currentWord,count);
			}
		}
	}

		@Test
		public void CountTestWordsOneMoreTime(){
		String[] tests = {"deepak","andrew","deepak","pankaj"}; // deepak 2 ,andrew 1,pankaj 1
	}

		@Test
		public static void testCheckSum() {
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		String line = "5 1 9 5";
		String[] parts = line.split(" ");
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (String part : parts) {
			int num = Integer.parseInt(part);
			if (num < min) {
				min = num;
			}
			if (num > max) {
				max = num;
			}
		}
		sum += max - min;
		System.out.println("Checksum: " + sum);
	}
		@Test
		public static void employeeSorting(){
		System.out.println("testing");
//        Comparator<Employee> employeeAgeComparator
//                = Comparator.comparingInt(Employee::getAge);
//        Arrays.sort(employees, employeeAgeComparator);
//
//        Comparator<Employee> employeeNameComparator
//                = Comparator.comparing(Employee::getName);
//
//        Comparator<Person> personNameComparator =
//                (a, b) -> a.getName().compareTo(b.getName());

		TreeSet<Photographer> photographerSet = new TreeSet<Photographer>(Comparator.comparingInt(Photographer::getRate));

	}

		@Test
		public void removeDuplicatesInSortedArray(){
		int[] nums = {1, 1, 2, 2, 3, 4, 4, 4, 5}; // taken from gen AI
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i-1]) {
				nums[j++] = nums[i];
			}
		}
	}

		@Test
		public void isValid(){
		String input = "{[]}";
		//  Stack<Character> stack = new Stack<Character>();
//        for(int i=0;i<input.length();i++){
//            char current = input.charAt(i);
//            if(isOpeningBracket(current)){
//                stack.push(current);
//            } else {
//                if(!isMatching(current,stack.pop())){
//                    return false;
//                }
//            }
//        }
	}
		private boolean isMatching(Character current,Character pop) {
		return OPENING_BRACKETS.indexOf(pop) == CLOSING_BRACKETS.indexOf(current);
	}
		private boolean isOpeningBracket(char current) {
		return OPENING_BRACKETS.indexOf(current) != -1;
	}

		@Test
		public static void photoApp(){
		DataStore dataStore = new DataStore();

		// Add photographers to the data store
		dataStore.addPhotographer("John", "New York", 500, Arrays.asList("Wedding", "Corporate Events"));
		dataStore.addPhotographer("Jessica", "New York", 800, Arrays.asList("Wedding", "Bridal Shower"));
		dataStore.addPhotographer("Mike", "San Francisco", 600, Arrays.asList("Rehearsal dinner", "Birthday Parties"));
		dataStore.addPhotographer("Anna", "Los Angeles", 1000, Arrays.asList("Wedding"));

		// Search for photographers
		List<Photographer> results = dataStore.searchPhotographers("New York", "Wedding", 700);
		for (Photographer p : results) {
			System.out.println("Name: " + p.getName() + ", Location: " + p.getLocation() + ", Rate: " + p.getRate());
		}

		// Get photographers sorted by rates
		List<Photographer> sortedResults = dataStore.getPhotographersByRate();
		for (Photographer p : sortedResults) {
			System.out.println("Name: " + p.getName() + ", Location: " + p.getLocation() + ", Rate: " + p.getRate());
		}
	}

		@Test
		public static void readFiles(){



		try {
			List<List<String>> records = Files.readAllLines(Paths.get("Player.csv"))
					.stream()
					.map(line -> Arrays.asList(line.split(",")))
					.collect(Collectors.toList());
		} catch(Exception ex){
			System.out.println("Exception is:" + ex);
		}
	}



		private static int[] readIntegers(){
		Scanner scanner = new Scanner(System.in); // Reading
		System.out.println("Enter list of integers");
		String input = scanner.nextLine();
		return null;
	}

		private static int findMIn(int[] arr){
		int min = Integer.MAX_VALUE;
		for(int i: arr){
			int current = arr[i];
			if(current < min){
				min = current;
			}
		}
		return min;
	}

		private List<String> getList(){
		return null;
	}

		@Test
		public void testJava8Stream(){
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
		empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
		empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
		empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));

		empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
		empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
		empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
		empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
		empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010));

		// 1. get the employees by city
		Map<String,List<Employee>> employeesByCity = new HashMap<>();

		employeesByCity = empList.stream()
				.collect(Collectors.groupingBy(Employee::getCity));
		System.out.println("Employees group by city:" + employeesByCity);

		// 2. grouo the employees by age
		Map<Integer,List<Employee>> employeesByAge = new HashMap<>();

		employeesByAge = empList.stream()
				.collect(Collectors.groupingBy(Employee::getAge));
		System.out.println("Employees group by age:" + employeesByAge);

		// 3. Find the count of male and female employees present in the organization
		Map<String,Long> noOfMaleAndFemaleEmployees = empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println("NoOfMale and Female employees ::"+ noOfMaleAndFemaleEmployees);

		// 0. remove all duplicates from the list
		List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
		Set<String> result = listWithDuplicates.stream().collect(toSet());

		// 4. Print the names of all the departments in the organization
		Stream<String> distinctDepts = empList.stream().map((Employee::getDeptName)).distinct();
		distinctDepts.forEach(System.out::println);

		// 5. Print employee details whose age is greater than 28
		empList.stream().filter(x->x.getAge() > 28).collect(Collectors.toList());

		// 6. Find max age of the employee
		empList.stream().mapToInt(Employee::getAge).max(); // remember this is max inside employee else .mapToInt(x->x.intValue()).max()

		// 7. print average of Male and Female employees
		Map<String,Double> avgAge = empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));

		// 8. Print the number of employees in each department
		Map<String,Long> countEmpByDept = empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println("No of employees in each department");
		for(Map.Entry<String, Long> entry : countEmpByDept.entrySet())
		{
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		// 9. Find oldest employeeFind oldest employee
		Optional<Employee> oldestEmp = empList.stream().max(Comparator.comparingInt(Employee::getAge));
		Employee oldestEmployee = oldestEmp.get();
		System.out.println("Oldest employee details:: \n" + oldestEmployee);

		// 10. Find youngest female employee.
		//can use anyMatch also
		Optional<Employee> youngestEmp = empList.stream().filter(e -> e.getGender() == "F")
				.min(Comparator.comparingInt(Employee::getAge));
		Employee youngestEmployee = youngestEmp.get();
		System.out.println("Youngest Female employee details:: \n" + youngestEmployee);

		// 16. Find all employees who lives in ‘Blore’ city, sort them by their name and print the names of employees.
		empList.stream().filter(e->e.getCity().equalsIgnoreCase("Blore"))
				.sorted(Comparator.comparing(Employee::getName))
				.forEach(e->System.out.println("Employing staying in Bangalore::" + e.getName()));
		// 17. No of employees in the organisation
		empList.stream().count();
		// 18. Not needed

	}

	// adding 1

}