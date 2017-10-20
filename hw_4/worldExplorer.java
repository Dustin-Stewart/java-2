import java.util.Scanner; //import scanner

public class worldExplorer{ //begin class	
	final static int NUMBER_OF_ROOMS = 7; //initialize constant variables
	final static int NORTH =0;
	final static int EAST  =1;
	final static int SOUTH =2;
	final static int WEST  =3;	
	
		public static void main(String[] args){  //begin main mathod
			Scanner direction = new Scanner(System.in); //build scanner, called direction
			boolean runGame =true;  //set a loop control variable for a game loop and default  it to true (should contain all following steps)
			int biome =3;
			String[] descriptions = {         //build an array of descriptions, use an initializer		
			"Trees and animals abound. Well shaded and you feel light here. You see a path leading south, and another to the east", //0
			
			"A placid lake near the forest, you see fish jumping, and you wonder what they taste like. A path leads west, and a stream runs east that you can walk along.", //1
			
			"Endless ocean dominates your view, but you are dry on the sand. Theres a waterway leading west, and dusty pathway leading you south.", //2
			
			"Hallmarks of civilization all around you, and you are surrounded by other people. You long to leave. A wooded path leads north, and to the east there is just an open field", //3
			
			"A boundless field stretches beyond site. In each direction lies some extreme. You can travel in any cardinal direction from here.", //4
			
			"Arid and bleak, this desert is full of dried remains of what may have once been a lush forest. Butt loads of sand. You seem to hear waves crashing to the north, and you can see grassland to the east", //5
			
			"Frigid, and impossible to see thorugh, you have wandered far south to a tundra. A frozen wasteland fit for no one. Maybe you should head back north." //6
			}; //end array descriptions
			
			int[][] roomExitArray = new int[NUMBER_OF_ROOMS] [4]; //two d array  of exit values
				//FOREST
				roomExitArray[0][NORTH]=-1;
				roomExitArray[0][EAST] = 1;
				roomExitArray[0][SOUTH]= 3;
				roomExitArray[0][WEST] =-1;

				//LAKE
				roomExitArray[1][NORTH]=-1;
				roomExitArray[1][EAST] = 2;
				roomExitArray[1][SOUTH]= 4;
				roomExitArray[1][WEST] = 0;

				//OCEAN
				roomExitArray[2][NORTH]=-1;
				roomExitArray[2][EAST] =-1;
				roomExitArray[2][SOUTH]= 5;
				roomExitArray[2][WEST] = 1;

				//CITY
				roomExitArray[3][NORTH]= 0;
				roomExitArray[3][EAST] = 4;
				roomExitArray[3][SOUTH]=-1;
				roomExitArray[3][WEST] =-1;

				//FIELD
				roomExitArray[4][NORTH]= 1;
				roomExitArray[4][EAST] = 5;
				roomExitArray[4][SOUTH]= 6;
				roomExitArray[4][WEST] = 3;

				//DESERT
				roomExitArray[5][NORTH]= 2;
				roomExitArray[5][EAST] =-1;
				roomExitArray[5][SOUTH]=-1;
				roomExitArray[5][WEST] = 4;

				//TUNDRA
				roomExitArray[6][NORTH]= 4;
				roomExitArray[6][EAST] =-1;
				roomExitArray[6][SOUTH]=-1;
				roomExitArray[6][WEST] =-1;

			while (runGame == true){
				System.out.println(descriptions[biome]); /*print the current rooms description (use the current rooms variable as the index to 
														   the rooms descritption array and dereference the string to print it) */
				System.out.println("Which way will you go: (n)orth,(e)ast,(s)outh, or (w)est?");
				char path = direction.nextLine().charAt(0); /*get the users choice and perform the associated action with a selection statement 
															  and set up a local variable that will hold the next room number to move into */		
				if 		(path == 'n' && roomExitArray [biome][NORTH]!=-1) {
				  biome = roomExitArray[biome][NORTH];
				}
				else if (path == 'e' && roomExitArray [biome][EAST] !=-1) {
				  biome = roomExitArray[biome][EAST];	
				}
				else if (path == 's' && roomExitArray [biome][SOUTH] !=-1){
				  biome = roomExitArray[biome][SOUTH];
				}	
				else if (path == 'w' && roomExitArray [biome][WEST] !=-1) {
				  biome = roomExitArray[biome][WEST];
				} 	
				else if (path == 'q'){
				 System.out.println("later dude.");
				 runGame = false;
				}
				else{
				  System.out.println("You can't travel that direction any further.");
				}

			} //end game loop
		} //end main		
} //end class