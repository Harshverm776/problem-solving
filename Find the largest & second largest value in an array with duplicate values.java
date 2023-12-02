
public class Practice {

	public static void main(String[] args) {
//		Q. Find the largest & second largest value in an array with duplicate values.

//		Brute Force
//		This will work for both array with duplicate values & array with unique values.

		Integer arr[] = { 6, 6, 7, 3, 0, 1, 2, 7, 7, 3, 4, 1, 2, 0 };

		int largest = arr[0];
		int secondLargest = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (largest < arr[i]) {
				secondLargest = largest;
				largest = arr[i];
			}
		}

		System.out.println("Largest= " + largest + "\nSecond Largest= " + secondLargest);		
	}
}
