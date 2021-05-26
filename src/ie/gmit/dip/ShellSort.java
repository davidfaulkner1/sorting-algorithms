package ie.gmit.dip;

// Code for shell sort algorithm referenced from Java T Point: https://www.javatpoint.com/shell-sort

public class ShellSort {

	public int[] shellSort(int[] arr, int n) {
		// initialise variables
		int i, j, k, temp;
		
		// outer loop begins with a large gap depending on the array input size then it will reduce the gap by half after every fully completed nested loop
		for(i = n / 2; i > 0; i /= 2) {
			// this middle nested loop loops through the array with the gap set in the outer loop until the whole array is gap sorted
			for(j = i; j < n; j++) {
				for(k = j - i; k >= 0; k -= i) {
					// if there is no need to switch items then break out of loop
					if(arr[k+i] >= arr[k]) {
						break;
					} else {
						// set variables for switch of items
						temp = arr[k];
						arr[k] = arr[k+i];
						arr[k+i] = temp;
					}
				}
			}
		}
		
		// return sorted array
		return arr;
	}
	
}
