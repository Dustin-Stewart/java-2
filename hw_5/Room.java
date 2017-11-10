//class room
public class Room{
	
	private String description;
	private Room north;
	private Room east;
	private Room south;
	private Room west;
  
   public Room(String description){
	
      this.description = description;         
      north = null;
      east  = null;
      south = null;
      west  = null;
   }
   
   public void setExits(Room n, Room e, Room s, Room w){
      
      this.north = n;
      this.east  = e;
      this.south = s;
      this.west  = w;
   }
  
   public Room getNorth(){
      return north;
   }
   
   public Room getEast(){
      return east;
   }
   
   public Room getSouth(){
      return south;
   }
   
   public Room getWest(){
      return this.west;
   }
  
   @Override
   public String toString(){
      String val = "You are in the "+description;
      val += "\nExits can be found to the: ";
      
      if (north != null)
         val+= " n ";
         
      if (east != null)
         val+= " e ";
         
      if (south != null)
         val+= " s ";
      
      if (west != null)
         val+= " w ";
      
      return val;
      
   }//end to string
   
}//end class
