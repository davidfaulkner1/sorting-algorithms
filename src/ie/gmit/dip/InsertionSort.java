package ie.gmit.dip;

// Code for insertion sort algorithm referenced from Java T Point: https://www.javatpoint.com/insertion-sort-in-java

public class InsertionSort {

	public int[] insertionSort(int[] a) {
		// start index at 1 and test index at 0 and 1
		for(int k = 1; k < a.length; k++) {
			// set key and initial j value 
			int temp = a[k]; 
			int j = k-1;
			
			// Switch loop if elements are larger than the key
			while(j >= 0 && temp <= a[j]) {
				a[j+1] = a[j];
				j--;
			}
			
			// change key value to next element in array
			a[j+1] = temp;
		}

		// return sorted array
		return a;
	}
	
}
