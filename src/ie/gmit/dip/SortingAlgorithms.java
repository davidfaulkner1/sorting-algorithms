package ie.gmit.dip;

public class SortingAlgorithms {
	// instance variable for generation of random array after each run
	private int[] randArr;
	// number of times to run benchmark test for each size in input array
	private int runs = 10; 

	// objects set up for each sorting algorithm class
	private BubbleSort bs = new BubbleSort();
	private MergeSort ms = new MergeSort();
	private CountingSort cs = new CountingSort();
	private InsertionSort is = new InsertionSort();
	private ShellSort ss = new ShellSort();

	public void benchmark(int sort, int[] a) {
		// store run results in this array
		double[] results = new double[runs];
		
		// outer loop to run through each index of the sizes array (n = a[i])
		for (int i = 0; i < a.length; i++) {
			// nested for-loop to run each the algorithm 10 times through each test array size
			for (int j = 0; j < runs; j++) {
				// generate new random array for each run
				randArr = randomArray(a[i]);
				
				// log benchmark start time
				// benchmark test code referenced from CTA project outline document
				long start = System.nanoTime();
				// switch statement to select chosen method to test
				switch (sort) {
				case 1 -> bs.bubbleSort(randArr);
				case 2 -> ms.mergeSort(randArr, 0, randArr.length - 1);
				case 3 -> cs.countSort(randArr, a[i]);
				case 4 -> is.insertionSort(randArr);
				case 5 -> ss.shellSort(randArr, a[i]);
				default -> throw new IllegalArgumentException("Unexpected value: " + sort);
				}
				// log benchmark end time
				long end = System.nanoTime();
				// get elapsed time in nanoseconds
				long elapsed = end - start;
				// convert benchmark time to milliseconds
				double timeMillis = elapsed / 1000000.0d;

				// add result of run to results array at index j
				results[j] = timeMillis;
			}

			// call method with results array to get average of 10 results after inner loop runs are complete
			getAverage(results);
		}
	}

	private void getAverage(double[] results) {
		double sum = 0;
		for (int i = 0; i < results.length; i++) {
			sum += results[i];
		}

		// calculate average of results array
		double avg = sum / results.length;
		
		// print average result to console output
		System.out.printf("%10.3f", avg);
	}

	// randomArray method referenced from CTA project outline document
	public int[] randomArray(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * size);
		}
		
		// return randomly generated array of given size
		return arr;
	}

	
	public static void main(String[] args) {
		// array for sizes of random array to put thorugh sorting benchmark method
		int[] sizes = { 100, 250, 500, 750, 1000, 1250, 1500, 2500, 5000, 7500, 10000, 25000 };
		
		// print header of console output table
		System.out.printf("%-14s", "Size");
		for (int i = 0; i < sizes.length; i++) {
			System.out.printf("%10d", sizes[i]);
		}

		
		/* ** to use the SortingAlgorithms benchmark() method, call the sorting algorithm corresponding to the given integer below as the first argument **
		 * 
		 * 1: Bubble sort 
		 * 2: Merge sort 
		 * 3: Counting sort 
		 * 4: Insertion sort 
		 * 5: Shell sort
		 * 
		 * i.e. to run benchmark test on bubble sort --> sort.benchmark(1, sizes);
		 * 
		 */

		
		// create object "sort" to call each sorting algorithm benchmark test
		SortingAlgorithms sort = new SortingAlgorithms();

		System.out.printf("%-15s", "\nBubble Sort");
		sort.benchmark(1, sizes);

		System.out.printf("%-15s", "\nMerge Sort");
		sort.benchmark(2, sizes);

		System.out.printf("%-15s", "\nCounting Sort");
		sort.benchmark(3, sizes);

		System.out.printf("%-15s", "\nInsertion Sort");
		sort.benchmark(4, sizes);

		System.out.printf("%-15s", "\nShell Sort");
		sort.benchmark(5, sizes);

	}
}