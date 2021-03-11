import java.util.List;/**
 * A basic iterative implementation of the linear search algorithm. 
 * 
 * TODO: Make the static method generic to accommodate test class. 
 * 
 * @author Franklin Worrell
 * @version 19 March 2018
 */ 
public class LinearSearch {
	public static <T extends Comparable<T>> int linearSearch(List<T> array, T key) {
		for (int i = 0; i < array.size(); i++) {
			if (key.compareTo(array.get(i)) == 0) {
				return i; 
			}
		}
		
		return -1; 
	}
	
}