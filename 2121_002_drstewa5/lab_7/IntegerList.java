import java.util.LinkedList;
import java.util.Arrays;
import java.util.ListIterator;
/**
@author Dustin Stewart
@version 3/15/18
*/

public class IntegerList {
	
	public static void main(String[] args){

		Integer[] numbers = {7,2,5,9,4,10,21,
		               		31,6,19,2,32,21};
		
		LinkedList<Integer> data = new LinkedList<>(
			Arrays.asList(numbers));

		System.out.println("Iiteration using a for loop");
	
		for (int i=0; i < data.size(); i++){
	
			if (data.get(i) % 2 == 0) {
		
				System.out.println("Removing: "+data.get(i));
		
				data.remove(i);
		
				i--;
			}

			else {
		
				System.out.println(data.get(i));
			}
		}

		System.out.println();
		
		data = new LinkedList<>(Arrays.asList(numbers));
		
		System.out.println("Iteration with an iterator");
		
		ListIterator<Integer> iterator = data.listIterator(0);
		
		while (iterator.hasNext()){
			
			Integer temp = iterator.next();
			
			if(temp % 2 == 0) {
		
				System.out.println("Removing: " + temp);
		
				iterator.remove();
			}

			else{
		
				System.out.println(temp);
			}
		}

		System.out.println();

		data = new LinkedList<>(Arrays.asList(numbers));
		
		System.out.println("Iteration with an enhanced for loop");

		for (Integer value : data) {

			if(value % 2 == 0) {
				
				System.out.println("Removing: " + value);
				
				data.remove(value);
			}

			else{

				System.out.println(value);
			}
		}
	}
}