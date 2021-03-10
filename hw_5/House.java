//class House
public class House{
	private Room livingRoom;
   private Room kitchen;
   private Room diningRoom;
	private Room bedroom;
	private Room bathroom;
	private Room frontPorch;
	private Room office;
	private Room backPorch;
 
   
    public House(){    
      frontPorch = new Room("Front Porch: Kinda chilly, maybe I should go inside.");      
      livingRoom = new Room("Living Room: Wow this is pretty nice. Do I detect sandalwood?");
      bathroom = new Room("Bathroom: Very sanitary. I could totally poop here.");
      office = new Room("Office: This is quite organized.");
      kitchen = new Room("Kitchen: Smells like summer sausage and boxed wine. My kinda house.");
      diningRoom = new Room("Dining Room: Seems like a lovely place to eat summer sausage and drink boxed wine.");
      bedroom = new Room("Bed Room: A very intimate space which i should revere.");
      backPorch = new Room("Back Porch: A lovely view from here.");
      
      bedroom.setExits(null,diningRoom,office,null);
      diningRoom.setExits(backPorch,null,kitchen,bedroom);
      kitchen.setExits(diningRoom,null,livingRoom,office);
      office.setExits(bedroom,kitchen,bathroom,null);   
      bathroom.setExits(office,livingRoom,null,null);
      livingRoom.setExits(kitchen,null,frontPorch,bathroom);     
      frontPorch.setExits(livingRoom,null,null,null);
      backPorch.setExits(null,null,diningRoom,null);
      }
    
   public Room getRoom(){
      return frontPorch;
	}
   
}
