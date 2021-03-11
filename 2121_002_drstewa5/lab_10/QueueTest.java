import org.junit.Before; 
import org.junit.Test; 
import static org.junit.Assert.assertEquals; 
import static org.junit.Assert.assertTrue; 
import java.util.NoSuchElementException; 

/**
 * A JUnit test class for class Queue. Not the best unit tester.
 * Notice the test to prove type safety despite suppressing the 
 * compiler warnings. 
 *
 * Ideally, we'd either have implemented a toString method in
 * Queue that would allow us to access its state at any moment
 * or provided more fine tuned methods that would allow us to 
 * peak into the Queue's state. These would have been used to 
 * UNIT test the Queue. The test here is more of a functional
 * test. 
 *
 * @author	Franklin D. Worrell
 * @revised 16 October 2016
 */ 
public class QueueTest {
	Queue<Integer> integerQueue; 
	Queue<String> stringQueue; 
	
	/**
	 * Initializes and populates the test Queues.
	 */ 
	@Before
	public void setup() {
		integerQueue = new Queue<>(); 
		integerQueue.enqueue(16); 
		integerQueue.enqueue(177); 
		integerQueue.enqueue(-2218); 
		integerQueue.enqueue(7869); 
		integerQueue.enqueue(0); 
		integerQueue.enqueue(1); 
		
		stringQueue = new Queue<>(); 
	} // end method setup
	
	/**
	 * Tests to ensure that type safety is guaranteed by our
	 * implementation, despite the compiler's objections.
	 */ 
	@Test
	public void testTypeSafety() {
		assertTrue(integerQueue.dequeue() instanceof Integer); 
		stringQueue.enqueue("Hello"); 
		assertTrue(stringQueue.dequeue() instanceof String); 
	} // end method testTypeSafety
	
	/**
	 * Performs test on a Queue containing Integers. Though more a
	 * functional test than a unit test, this test and the next should
	 * provide enough information to debug your code. 
	 */ 
	@Test
	public void testIntegerQueue() {
		assertEquals((Integer) 16, integerQueue.dequeue()); 
		assertEquals((Integer) 177, integerQueue.dequeue()); 
		integerQueue.enqueue(-13); 
		assertEquals((Integer) (-2218), integerQueue.dequeue()); 
		assertEquals((Integer) 7869, integerQueue.dequeue()); 
		assertEquals((Integer) 0, integerQueue.dequeue()); 
		assertEquals((Integer) 1, integerQueue.dequeue()); 
		assertEquals((Integer) (-13), integerQueue.dequeue()); 
		try {
			integerQueue.dequeue(); 
		} 
		catch (NoSuchElementException e) {
			assertTrue(e instanceof NoSuchElementException); 
		} 
	} // end method testIntegerQueue
	
	/**
	 * Performs tests on a Queue containing Strings that was
	 * empty when the test began.
	 */ 
	@Test
	public void testStringQueue() {
		try {
			stringQueue.dequeue(); 
		} 
		catch (NoSuchElementException e) {
			assertTrue(e instanceof NoSuchElementException); 
		} 
		stringQueue.enqueue("Hi"); 
		stringQueue.enqueue("Bye"); 
		assertEquals("Hi", stringQueue.dequeue()); 
		assertEquals("Bye", stringQueue.dequeue()); 
		try {
			stringQueue.dequeue(); 
		} 
		catch (NoSuchElementException e) {
			assertTrue(e instanceof NoSuchElementException); 
		} 
		
		// Make sure resizing array doesn't mess anything up. 
		stringQueue.enqueue("A"); 
		stringQueue.enqueue("b"); 
		stringQueue.enqueue("check"); 
		stringQueue.enqueue("Elvis lives!"); 
		stringQueue.enqueue("drama"); 
		stringQueue.enqueue("tragedy"); 
		stringQueue.enqueue("comedy"); 
		assertEquals("A", stringQueue.dequeue()); 
		assertEquals("b", stringQueue.dequeue()); 
		assertEquals("check", stringQueue.dequeue()); 
		assertEquals("Elvis lives!", stringQueue.dequeue()); 
		assertEquals("drama", stringQueue.dequeue()); 
		assertEquals("tragedy", stringQueue.dequeue()); 
		assertEquals("comedy", stringQueue.dequeue()); 
		try {
			stringQueue.dequeue(); 
		} 
		catch (NoSuchElementException e) {
			assertTrue(e instanceof NoSuchElementException); 
		} 
	} // end method testStringQueue
} // end class QueueTester
