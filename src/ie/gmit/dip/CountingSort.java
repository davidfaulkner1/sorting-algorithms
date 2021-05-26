package ie.gmit.dip;

import java.util.Arrays;

// Code for counting sort algorithm referenced from Baeldung: https://www.baeldung.com/java-counting-sort

public class CountingSort {

	// count() method returns frequencies array
	private int[] count(int[] input, int n) {
		// initialise output array "arr"
		int[] arr = new int[n + 1];
		Arrays.fill(arr, 0);
		
		// calculate frequency of each number in array
		for(int i : input) {
			arr[i] += 1;
		}
		
		// get sum of consecutive elements to know how many elements are less than or equal to a particular number
		for(int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
		}
		
		// return output array which contains frequencies of each element 
		return arr;
	}
	
	public int[] countSort(int[] input, int n) {
		// compute int array "arr"
		int[] arr = count(input, n);
		
		// initialise new array for sorted elements
		int[] sorted = new int[input.length];
		
		// iterate through the input array in reverse, for each input element find the correct index for it in the sorted array
		for (int i = input.length - 1; i >= 0; i--) {
			int element = input[i];
			sorted[arr[element] - 1] = element;
			// reduce value of occurence by 1 in "arr"
			arr[element] -= 1;
		}

		// return sorted array
		return sorted;
	}
	
}
