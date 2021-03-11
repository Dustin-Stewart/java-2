import java.util.Arrays;

public class Queue<T>{
	
	 int head;
	 int tail;
	 int size;
	 T[] array;

@SuppressWarnings("unchecked") 
	public void Queue(){
		this.head = 0;
		this.tail = 0;
		this.size = 5;
		this.array = (T[]) new Object[this.size];
	}

	public void enqueue(T item){
		if(isFull()){
			this.array.resizeArray();
		}else{

			this.array[tail] = item;



		}
	}

	public boolean isFull(){
	//check if the array is full. if we add one to the index of tail, and it happens to be the head we are full.
	return (head == (tail % size) + 1);		
	}

	public boolean isEmpty(){
	return (head == tail);
	}

	public void resizeArray(){
		T[] newArray = (T[]) new Object[this.size * 2];// new array to be copied into twice the size
 			
 			for(int i = 0; i < this.size; i++){
 			
 			newArray[i] = this.array[(head + i) % this.array.size]; //copy all emements in order into the new array
 			
 			}

 		this.array = newArray; //point to new array
 		this.head = 0; //set head back to zero
 		this.tail = this.size; //set tail to the last element in the array
 		this.size = newArray[tail % size];
	}


}