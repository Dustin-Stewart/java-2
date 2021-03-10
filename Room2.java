public class Room {

    private String description;
    private Room roomToNorth;
    private Room roomToSouth;
    private Room roomToEast;
    private Room roomToWest;

    public Room(String description) {
        this.description = description;
        roomToNorth = null;
        roomToSouth = null;
        roomToEast  = null;
        roomToWest  = null;
    }

    public String getDescription() {
        return description;
    }

    public void setRoomToNorth(Room r) {
        this.roomToNorth = r;
    }

    public Room getRoomToNorth() {
        return roomToNorth;
    }

    public void setRoomToSouth(Room r) {
        this.roomToSouth = r;
    }

    public Room getRoomToSouth() {
        return roomToSouth;
    }

    public void setRoomToWest(Room r) {
        this.roomToWest = r;
    }

    public Room getRoomToWest() {
        return roomToWest;
    }

    public void setRoomToEast(Room r) {
        this.roomToEast = r;
    }

    public Room getRoomToEast() {
        return roomToEast;
    }

    @Override
    public String toString() {
        String val = "You are in: " + description;
        val += "\nExits can be found to the: ";
        if (roomToNorth != null)
            val += " N ";
        if (roomToSouth != null)
            val += " S ";
        if (roomToEast != null)
            val += " E ";
        if (roomToWest != null)
            val += " W ";
        return  val;
    }

} // end class
