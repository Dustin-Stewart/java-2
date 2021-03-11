import java.util.ArrayList; 
import org.junit.Before;
import org.junit.Test; 
import static org.junit.Assert.assertEquals; 

/**
 * A JUnit test class for class BinarySearch.
 * @author	Franklin D. Worrell
 * @version	2 October 2016
 */ 

public class BinarySearchTest {
	// Test fixture instances. 
	ArrayList<String> strings; 
	ArrayList<Integer> integers; 
	
	// Pre-sorted arrays used to initialize text fixture. 
	String[] stringsArray = {"!", "#!", "AWESOME", "C++", "Java", "Try", 
							 "coding", "fun", "goodbye", "hello", "try"}; 
	int[] intsArray = {-1212, -12, -1, 0, 1, 7, 13, 18, 7896, 4573625}; 
	
	
	/**
	 * Initializes the test fixture of ArrayLists with the elements contained
	 * the String[] and int[] class variables.
	 */ 
	@Before
	public void setup() {
		// Initialize and populate the ArrayList of Strings. 
		strings =  new ArrayList<String>(); 
		for (int i = 0; i < stringsArray.length; i++) {
			strings.add(stringsArray[i]); 
		} 
		
		// Initialize and populate the ArrayList of Integers. 
		integers = new ArrayList<Integer>(); 
		for (int i = 0; i < intsArray.length; i++) {
			integers.add(intsArray[i]); 
		} 
	} // end method setup
	
	
	/**
	 * Tests the binarySearch method of BinarySearch.
	 */ 
	@Test
	public void testBinarySearch() {
		/* Tests with the ArrayList<String>. */ 
		assertEquals(4, BinarySearch.binarySearch(strings, stringsArray[4])); 
		assertEquals(-1, BinarySearch.binarySearch(strings, "me")); 
		assertEquals(0, BinarySearch.binarySearch(strings, stringsArray[0])); 
		assertEquals(8, BinarySearch.binarySearch(strings, "goodbye")); 
		assertEquals(-1, BinarySearch.binarySearch(strings, "awesome")); 
		
		/* Tests with the ArrayList<Integer>. */ 
		assertEquals(-1, BinarySearch.binarySearch(integers, -7)); 
		assertEquals(0, BinarySearch.binarySearch(integers, -1212)); 
		assertEquals(4, BinarySearch.binarySearch(integers, intsArray[4])); 
		assertEquals(9, BinarySearch.binarySearch(integers, 4573625)); 
		assertEquals(8, BinarySearch.binarySearch(integers, intsArray[8])); 
	} // end method testBinarySearch
} // end class BinarySearchTest