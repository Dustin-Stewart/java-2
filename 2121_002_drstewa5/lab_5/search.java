public class search {
//iterative search
	public static int find(int key, int[] array){
		
		for (int = 0; i < array.length; i++){
			if (key == array[i]){
				return i;
			}
		}
		return -1;
	}
//recursive search
	public static int findRecursively(int key, int[] array){
		//base case one: empty array
		//base case two: non empty, 1 element. check key vs content
		//complex case: non empty multiple element
	}

	private static int findRecursively(int key, int[] array, int index){
		//what im looking for: key
		//where im looking: array
		//where im looking in the location: index

		if (index == array.length){
			
			return -1;
			//entire array searched, return -1  to indicate key not found
		}

		else if (key == array[index]){
			
			return index;
			//key found; return index into array
		}

		else{
			
			return findRecursively(key, array, index+1);
			//key not found, still more array to search
		}
	}
}