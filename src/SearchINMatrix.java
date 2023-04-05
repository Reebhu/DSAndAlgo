public class SearchINMatrix {

	public static void main(String[] args) {
		int[][] mat = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
		searchMatrix(mat, 3);
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int[] arr = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			arr[i] = matrix[i][0];
		}
		int possibleRowNum = findClosest(arr, target);
		System.out.println(possibleRowNum);

		int possibleColNum = findClosest(matrix[possibleRowNum], target);
		System.out.println(possibleColNum);
		return matrix[possibleRowNum][possibleColNum] == target;

	}

	// Returns element closest to target in arr[]
	public static int findClosest(int[] arr, int target) {
		int n = arr.length;

		// Corner cases
		if (target <= arr[0])
			return 0;
		if (target >= arr[n - 1])
			return n - 1;

		// Doing binary search
		int i = 0, j = n, mid = 0;
		while (i < j) {
			mid = (i + j) / 2;

			if (arr[mid] == target)
				return mid;

            /* If target is less than array element,
               then search in left */
			if (target < arr[mid]) {

				// If target is greater than previous
				// to mid, return closest of two
				if (mid > 0 && target > arr[mid - 1])
					return mid - 1;

				/* Repeat for left half */
				j = mid;
			}

			// If target is greater than mid
			else {
				if (mid < n - 1 && target < arr[mid + 1])
					return mid;
				i = mid + 1; // update i
			}
		}

		// Only single element left after search
		return mid;
	}

	// Method to compare which one is the more close
	// We find the closest by taking the difference
	//  between the target and both values. It assumes
	// that val2 is greater than val1 and target lies
	// between these two.
	public int getClosest(int val1, int val2,
	                      int target) {
		if (target - val1 >= val2 - target)
			return val2;
		else
			return val1;
	}

}
