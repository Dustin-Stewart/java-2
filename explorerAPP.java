//game application
import java.util.Scanner;

public class gameApp{
	
	public static void main(String[] args){
	boolean gameState = true;	
	Room livingRoom = new Room("It's clean.");
	
	livingRoom.setNorth();	
	livingRoom.setEast(office);	
	livingRoom.setSouth(lab);	
	livingRoom.setWest();
	
	Room office = new Room("lots of books.");
		
		
		while (gameState=true){
		Scanner direction = new Scanner(System.in);
	    System.out.println()+\n\n"Which way will you go: (n)orth,(e)ast,(s)outh, or (w)est?"\n": ");
		char path = direction.nextLine().charAt(0);
		
			if 		(path == 'q'){
			 runGame = false;  
			}
			else if (path == 'n'){ //set next room to current room's north room
			  ;	
			}
			else if (path == 'e'){
			  ;
			}	
			else if (path == 's'){
			  ;
			} 	
			else if (path == 'w'){
			  ;
			}
			else{
			  System.out.println("Stop playing around and choose a direction.(n,e,s,w, or (q)uit).");
	
		}//end game loop
		
		System.out.println("later dude.");	
	
	}//end main
	
}//end class