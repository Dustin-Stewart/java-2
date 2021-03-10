//game application
import java.util.Scanner;

public class YouveJustBrokenIntoMyHouse{
   
   static Room currentRoom;
   public static void main(String[] args){
   
      gameLoop();
      
}//end method main
     
		public static void gameLoop(){ 
         boolean gameState = true;
         House myHouse = new House();
         currentRoom = myHouse.getRoom();          
   		
      while (gameState==true)
      {
         String wall = "I just walked into a wall, should pay close attention to the direction i'm going.\n";
         String invalid = "Stop playing around and choose a direction.(n,e,s,w, or (q)uit)." ;
   		Scanner direction = new Scanner(System.in);
         System.out.println(currentRoom);
   	   System.out.println("\n\nWhich way will you go: (n)orth,(e)ast,(s)outh, or (w)est?\n: ");
   		char path = direction.nextLine().charAt(0);
		
   			if 		(path == 'q'){
   			   gameState = false;  ;
   			}
            
   			else if (path == 'n'){ //set next room to current room's north room
   			   if (currentRoom.getNorth() == null){
                   System.out.println(wall);
               }
               else{
                  currentRoom = currentRoom.getNorth();	
   			   }
            }
   			else if  (path == 'e'){
              if (currentRoom.getEast() == null){
                   System.out.println(wall);
              }
                 else{
                 currentRoom = currentRoom.getEast();
               }
   			}	
            
   			else if (path == 's'){
   			  if (currentRoom.getSouth() == null){
                   System.out.println(wall);
               }  
                 else{
               currentRoom = currentRoom.getSouth();
   			   } 	
            }
              
   			else if  (path == 'w'){
   			  if (currentRoom.getWest() == null){
                System.out.println(wall);
               }
                else{
                   currentRoom = currentRoom.getWest();
   			   }
            }
            
            else {
   			   System.out.println(invalid);
   	      }
            
                    
		   }//end while statement		
	
      System.out.println("\nlater dude.");		
      
      }//end method gameLoop

}//end class