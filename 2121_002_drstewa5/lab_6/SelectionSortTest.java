import java.util.Arrays; 
import org.junit.Before;
import org.junit.Test; 
import static org.junit.Assert.assertEquals; 

/**
 * A JUnit test class for class SelectionSort.
 * @author	Franklin D. Worrell
 * @version	5 March 2018 
 */ 
public class SelectionSortTest {
	int[] intsArray = {-1212, 13, 7, 7896, 10192, 4573625, -12, -1, 0, 1, 18};;
	int[] intsCopy = new int[11]; 
	
	
	/**
	 * Reinitializes the test fixture between tests, since the selection sort 
	 * implementation alters the array.
	 */ 
	@Before
	public void setup() {
		intsArray = new int[] {-1212, 13, 7, 7896, 10192, 4573625, -12, -1, 0, 1, 18}; 
		for (int i = 0; i < intsArray.length; i++) {
			intsCopy[i] = intsArray[i]; 
		} 
	} // end method setup
	
	
	/**
	 * Tests the sortIterative method of SelectionSearch.
	 */ 
	@Test
	public void testSortIterative() {
		SelectionSort.sortIterative(intsCopy); 
		Arrays.sort(intsArray); 
		for (int i = 0; i < intsArray.length; i++) {
			assertEquals(intsArray[i], intsCopy[i]); 
		} 
	} // end method testSortIterative

	
	/**
	 * Tests the sortRecursive method of SelectionSearch.
	 */ 
	@Test
	public void testSortRecursive() {
		SelectionSort.sortRecursive(intsCopy); 
		Arrays.sort(intsArray); 
		for (int i = 0; i < intsArray.length; i++) {
			assertEquals(intsArray[i], intsCopy[i]); 
		} 
	} // end method testSortIterative
} // end class LinearSearchTest