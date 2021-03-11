import java.util.List;
/**
 * A basic iterative implementation of the selection sort algorithm. 
 * 
 * TODO: Make the static sort method generic to pass provided tests. 
 * 
 * @author Franklin D. Worrell
 * @version 19 March 2018 
 */ 
public class SelectionSort {
	/**
	 * Implements the iterative selection sort algorithm. Sorts the array 
	 * passed as argument--i.e., it alters the array instead of returning 
	 * a new instance. 
	 * @param array the <code>int[]</code> to sort 
	 */ 
	public static <T extends Comparable<T>> void sort(List<T> array) {
		for (int i = 0; i < array.size(); i++) {
			int minimumIndex = findMinimum(array, i); 
			swap(array, i, minimumIndex); 
		}
	} 
	
	
	/**
	 * Given an array and two indices into the array, it swaps the elements 
	 * at those indices in the array. 
	 * @param array the <code>int[]</code> whose elements are to be swapped 
	 * @param first the index of one of the elements to swap 
	 * @param second the index of the other element to swap 
	 */ 
	private static <T> void swap(List<T> array, int first, int second) {
		T temp = array.get(first);
		array.set(first, array.get(second)); 
		array.set(second, temp); 
	} 
	
	
	/**
	 * Returns the index of the smallest element in the array, starting 
	 * (inclusive) at the index specified. 
	 * @param array the <code>int[]</code> to search 
	 * @param start the index at which to begin looking for the minimum 
	 * @return the index of the minimal <code>int</code> in the <code>int[]</code>
	 */ 
	private static <T extends Comparable<T>> int findMinimum(
			List<T> array, int start) {
		int minimumIndex = start; 
		for (int i = start + 1; i < array.size(); i++) {
			if (array.get(i).compareTo(array.get(minimumIndex)) < 0) {
				minimumIndex = i; 
			}
		}
		
		return minimumIndex; 
	}
	
}