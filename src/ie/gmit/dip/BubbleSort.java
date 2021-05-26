package ie.gmit.dip;

/* Code for bubble sort algorithm referenced from Computational Thinking with Algorithms, 
 * lecture Part 2 - Patrick Mannion GMIT
 */

public class BubbleSort {

	public int[] bubbleSort(int[] a) {
		// outer loop to set correct item at end of array and move inwards
		for (int outer = a.length - 1; outer > 0; outer--) {
			// inner loop for each full pass of array
			for (int inner = 0; inner < outer; inner++) {
				// check if first item is greater than adjacent item to the right
				if (a[inner] > a[inner + 1]) {
					// create temporary variable for switch
					int temp = a[inner];
					a[inner] = a[inner + 1];
					a[inner + 1] = temp;
				}
			}
		}
		
		// return sorted array
		return a;
	}

}
