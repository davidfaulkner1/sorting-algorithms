package ie.gmit.dip;

// Code for merge sort algorithm referenced from Java T Point: https://www.javatpoint.com/merge-sort

public class MergeSort {
	
	public void mergeSort(int[] a, int lowIndex, int highIndex) {
		// recursive method to divide up elements in input array down to individual sub-arrays
		if (lowIndex < highIndex) {
			int midIndex = (lowIndex + highIndex) / 2;
			mergeSort(a, lowIndex, midIndex);
			mergeSort(a, midIndex + 1, highIndex);
			merge(a, lowIndex, midIndex, highIndex);
		}
	}

	private void merge(int[] a, int lowIndex, int midIndex, int highIndex) {
		// initialise integers left and right
		int left = midIndex - lowIndex + 1;
		int right = highIndex - midIndex;
		
		// seperate arrays into left and right
		int[] leftArr = new int[left];
		int[] rightArr = new int[right];

		// assign left array with lowest values increasing in value
		for (int i = 0; i < left; i++) {
			leftArr[i] = a[lowIndex + i];
		}
		
		// assign right array with lowest values increasing in value
		for (int j = 0; j < right; j++) {
			rightArr[j] = a[midIndex + j + 1];
		}

		// initialise i, j and k variables for sorted array assignment
		int i = 0, j = 0;
		int k = lowIndex;

		// loop to assign new sorted array with lowest values progressively increasing
		while (i < left && j < right) {
			if (leftArr[i] <= rightArr[j]) {
				a[k] = leftArr[i];
				i++;
			} else {
				a[k] = rightArr[j];
				j++;
			}
			k++;
		}

		while (i < left) {
			a[k] = leftArr[i];
			i++;
			k++;
		}

		while (j < right) {
			a[k] = rightArr[j];
			j++;
			k++;
		}

	}

}
