/**
 * A class providing both a recursive and an iterative implementation 
 * of the selection sort algorithm. Every effort should be made to make 
 * the helper methods compatible between implementations. 
 * @author Franklin D. Worrell
 * @version 5 March 2018 
 */ 
public class SelectionSort {
	/**
	 * Implements the iterative selection sort algorithm. Sorts the array 
	 * passed as argument--i.e., it alters the array instead of returning 
	 * a new instance. 
	 * @param array the <code>int[]</code> to sort 
	 */ 
	public static void sortIterative(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			int minimumIndex = findMinimum(array, i);
			swap(array, i, minimumIndex);
		}
	} 
	
	/**
	 * Implements the recursive selection sort algorithm. Sorts the array 
	 * passed as argument--i.e., it alters the array instead of returning 
	 * a new instance. 
	 * @param array the <code>int[]</code> to sort 
	 */ 
	public static void sortRecursive(int[] array) {
		sortRecursive(array, 0);
	} 
	
	/**
	 * Implements the recursive selection sort algorithm. Sorts the array 
	 * passed as argument--i.e., it alters the array instead of returning 
	 * a new instance. 
	 * @param array the <code>int[]</code> to sort 
	 */ 
	private static void sortRecursive(int[] array,int start) {
		
		if (start < array.length -1) {
			int minimumIndex = findMinimum(array, start);
			swap(array, minimumIndex, start);
			sortRecursive(array,start + 1);	//post incrementor throws stack overflow
		}
		//Base case: arrays of one or fewer elements are sorted
		//Do nothing .allow method to return.	
	} 
	
	/**
	 * Given an array and two indices into the array, it swaps the elements 
	 * at those indices in the array. 
	 * @param array the <code>int[]</code> whose elements are to be swapped 
	 * @param first the index of one of the elements to swap 
	 * @param second the index of the other element to swap 
	 */ 
	private static void swap(int[] array, int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	} 
	
	
	/**
	 * Returns the index of the smallest element in the array, starting 
	 * (inclusive) at the index specified. 
	 * @param array the <code>int[]</code> to search 
	 * @param start the index at which to begin looking for the minimum 
	 * @require start < array.length
	 * @return the index of the minimal <code>int</code> in the <code>int[]</code>
	 */ 
	private static int findMinimum(int[] array, int start) {
		int minimumIndex = start;
		for (int i = start + 1; i < array.length; i++){
			if(array[i]<array[minimumIndex]){
				minimumIndex = i;
			}
		}

		return minimumIndex;
	}
	
}