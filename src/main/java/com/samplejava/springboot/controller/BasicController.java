package com.samplejava.springboot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;

@RestController
@RequestMapping("/sample_test_prg/v1")
public class BasicController {

	private static final Logger logger = LogManager.getLogger(BasicController.class);

	@GetMapping(path = "/array")
	public void Array() {
	}

	@GetMapping(path = "/maxSubArray")
	public Integer getMax() {
		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4));

		Integer maxEndingHere = arrayList.get(0); // Initialize to the first element
		Integer maxSoFar = arrayList.get(0); // Initialize to the first element

		for(int i = 1; i < arrayList.size(); i++) {
			maxEndingHere = Math.max(arrayList.get(i), maxEndingHere + arrayList.get(i));
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
			System.out.println(maxSoFar);
		}
		System.out.println(maxSoFar);
		return maxSoFar;
	}

	@GetMapping(path = "/missingFirstPositive")
	public Integer getPositive() {


		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(-2, 0, -3, 4, 3, -1, 2, 1, -5, 5, 4,7,9));
		TreeSet<Integer> treeSet = new TreeSet<>(arrayList);
		List<Integer> onlyInt = treeSet.stream().filter(x -> x >= 1).toList();
		for(int i=0; i < onlyInt.size(); i++) {
			Integer nextValue = onlyInt.get(i) + 1;
			if(i == onlyInt.size()-1) {
				return onlyInt.get(i) + 1;
			} else if(!onlyInt.get(i+1).equals(nextValue)){
				return nextValue;
			}
		}
		return null;
	}

	@GetMapping(path = "/mergeSortedArray")
	public List<Integer> mergeSortedArray() {
		ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1,2,3,0,0,0));
		ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(2,5,6));
		Integer numOfEleFirst = 3;
		Integer numOfEleSecond = 2;
		ArrayList<Integer> merged = new ArrayList<>();
		merged.addAll(array1.subList(0,numOfEleFirst));
		merged.addAll(array2.subList(0,numOfEleSecond));
		Collections.sort(merged);
		return merged;
	}

	@GetMapping(path = "/kthLargestElement")
	public Optional<Integer> nthLargestElement() {
		ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1,2,3,10,9,15,1,3,8));
		Integer positionToTake = 3;
		TreeSet<Integer> sortedUnique = new TreeSet<>(array1);  // { 1,2,3,8,9,10,15 }
		Integer length = sortedUnique.size();
		return sortedUnique.stream().skip(length-positionToTake).findFirst();
	}

	@GetMapping(path = "/fibonacci")
	public void fib() {
	int previous = 1;
	int current = 1;
	for(int i = 1; i < 10; i++) {
		System.out.println(previous);
		int temp = previous + current;
		previous =	current;
		current = temp;
		}
	}

	@GetMapping(path = "/sumTwos")
	public List<Integer> sumTwos() {
		List<Integer> input = Arrays.asList(5,7,7,3,7,8);
		Integer matchCount = 15;
		Map<Integer, Integer> valueIndexMap = new HashMap<>();
		for (int i =0; i < input.size(); i++) {
			Integer findNum = matchCount - input.get(i);
			if(valueIndexMap.containsKey(findNum)) {
				return Arrays.asList(valueIndexMap.get(findNum), i);
			}
			valueIndexMap.put(input.get(i), i);
		}
		return null;
	}

	@GetMapping(path = "/longestSubString")
	public Integer longestSubString() {
		String s = "fazrudeen";
		int maxLength = 0;
		int left = 0;
		int right = 0;
		HashSet<Character> charSet = new HashSet<>();
		while (right < s.length()) {
			char currentChar = s.charAt(right);
			if (!charSet.contains(currentChar)) {
				charSet.add(currentChar);
				maxLength = Math.max(maxLength, right - left + 1);
//				maxLength = Math.max(0, 0 - 0 + 1); F
//				maxLength = Math.max(1, 1 - 0 + 1); a
//				maxLength = Math.max(2, 2 - 0 + 1); z
//				maxLength = Math.max(3, 3 - 0 + 1); r
//				maxLength = Math.max(4, 4 - 0 + 1); u
//				maxLength = Math.max(5, 5 - 0 + 1); d
//				maxLength = Math.max(6, 6 - 0 + 1); e
//				maxLength = Math.max(7, 6 - 1 + 1); e
//				maxLength = Math.max(7, 6 - 1 + 1); n
				right++;
			} else {
				charSet.remove(s.charAt(left));
				left++;
			}
		}
		System.out.println(charSet);
		return maxLength;
	}

	@GetMapping(path = "/findOnlywhatDups")
	public void findOnlywhatDups() {

		ArrayList<Integer> arrayList = new ArrayList<>();

		HashMap<Integer, Integer> hashMap1 = new HashMap<>();
		arrayList.forEach(x -> {
			if (!hashMap1.containsKey(x)) {
				hashMap1.put(x, 1);
			} else hashMap1.put(x, hashMap1.get(x)+1);
		});

		for(Map.Entry<Integer, Integer> each : hashMap1.entrySet()) {
			each.getValue();
		}

		int previous = 1;
		int current = 1;
		for(int i = 1; i < 10; i++) {
			System.out.println(previous);
			System.out.println(current);
			 int temp = previous + current;
			 previous =	current;
			 current = temp;
		}
	}
}
