import java.util.ArrayList; 

/**
 * Provides a static method that implements the recursive binary search
 * algorithm. 
 * @author	
 * @version
 */ 
public class BinarySearch {
	
	/**
	 * Recursively implements binary search algorithm. This public method
	 * merely calls the private method that recurses. 
	 * @param	list	the ArrayList to be searched 
	 * @param	value	the search query value
	 * @return	index of value if found, otherwise -1
	 */ 
	public static <T extends Comparable<T>> int binarySearch(ArrayList<T> list, T value) {
		return binarySearch(list, value, 0, list.size()-1);

	} // end method binarySearch
	
	private static <T extends Comparable<T>> int binarySearch(ArrayList<T> list, T key, int start,
		int end){
		//the entire arraylist has been unsuccesfully searched
		if (start > end){
			return -1;
		}
		//still some arraylist to search
		else{
			int middle = (start + end) / 2; //this line is buggy

			//found the value
			if(key.compareTo(list.get(middle)) == 0){
				return middle;
			}
			else if (key.compareTo(list.get(middle)) < 0){
				return binarySearch(list, key, start, middle - 1);
			}
			else{
				return binarySearch(list, key, middle + 1, end);
			}
		}
	}
} // end class BinarySearch

/*iterative version:
int start=0;
int end= list.size()-1;

while (start<=end){
	int middle=...;
	}
	return -1
} 