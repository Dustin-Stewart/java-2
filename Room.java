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
   
   //set/get north
	public void setNorth(Room n){
   	north=n;
   }
   public Room getNorth(){
      return north;
      }
   
   //set/get east
	public void setEast(Room e){
	   east=e;
	}		
   public Room getEast(){
      return east;
   }
   
   //set/get south
	public void setSouth(Room s){
	   south=s;
	}	
   public Room getSouth(){
      return south;
   }
   
   //set/get west
	public void setWest(Room w){
	this.west=w;
	}	

   
   //get description
   public String getDescription(){
   return this.description;
   }

   @Override
   public String toString(){
   String val = "You are in: " + description;
   val += "\nExits can be found to the: ";
   if (north != null)
      val+= " N ";
   if (east != null)
      val+= " E ";
   if (south != null)
      val+= " S ";
   if (west != null)
      val+= " W ";
   return val;
   }
}
