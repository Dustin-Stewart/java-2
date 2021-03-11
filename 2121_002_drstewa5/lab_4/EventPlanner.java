import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.util.ArrayList; 

/**
 * Stores a set of <code>Events</code> in an 
 * <code>ArrayList</code> for processing and 
 * printing. Allows the <code>Events</code> 
 * to be serialized and stored to a file for
 * saving them between runs of the program.  
 *
 * @author	YOUR_NAME_HERE
 * @version	DATE_LAST_CHANGED_HERE
 * @see	Event
 * @see Runner
 */ 
public class EventPlanner {
	ArrayList<Event> events; 						// List of Events to process.
	ObjectOutputStream serializationOutput = null; 	// Streams for serialization. 
	ObjectInputStream deserializationInput = null; 
	private static final String SAVE_FILE = "myEvants.ser";
	
	/**
	 * Constructor initializes the ArrayList of Events and 
	 * leaves it empty.
	 */ 
	public EventPlanner() {
		this.events = new ArrayList<Event>();
	} // end constructor

	
	/**
	 * Adds two precreated Event instances to the ArrayList.
	 */ 
	public void addEvents() {
        this.events.add(new Event( "Redmann's Party", "2014-03-03 22:00", "Redmann's House", "Come pass a good time" ));
        this.events.add(new Event( "CSCI 2120 Test", "2014-03-24 16:30", "MATH 226", "2nd Test" ));		
	} // end method addEvents
	
	
	/**
	 * Prints the EventPlanner instance's contents.
	 */ 
	public void printEvents() {
		// Planner is empty, inform the user. 
		if (this.events.size() < 1) {
			System.out.println("Planner is empty."); 
		} 
		
		// Otherwise print the Events. 
		else {
			for (Event event : this.events) {
				System.out.println(event.toString());
				System.out.println(); 
			}
		}
	} // end method printEvents
	
	
	/**
	 * Clears all the Events from this. 
	 */ 
	public void clearSchedule() {
		this.events.clear(); 
	} // end method clearSchedule
	
	
	/**
	 * Opens an ObjectOutputStream to serialize the contents
	 * of the ArrayList of Events.
	 */ 
	public void openOutputStream() {
		try{
			this.serializationOutput = new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
			}

			catch(FileNotFoundException e){
				System.err.println("Error opening save file for writing.");
			}

			catch(IOException e) {
				System.err.println("Error writing stream header for write file.");
			}

	} // end method openOutputStream 
	
	
	/**
	 * Serializes the Events in the ArrayList and writes 
	 * them to the ObjectOutputStream.
	 */ 
	public void writeObjects() {
		try{
			for(Event event : this.events){
				this.serializationOutput.writeObject(event);
			}
		}

		catch (NullPointerException e){
			System.err.println("Save file was not previously opened for writing.");
			System.err.println("Reinitializing...");
			this.openOutputStream();
			this.writeObjects();
		}

		catch(IOException e){
			System.err.println("Error writing to save file.");
				e.printStackTrace();
		}
	} // end method writeObjects 
	
	
	/**
	 * Closes the ObjectOutputStream.
	 */ 
	public void closeOutputStream() {
		try{
			this.serializationOutput.close();
		}

		catch(IOException e){
			System.err.println("Error closing save file after writing.");
			e.printStackTrace();
			System.exit(1);
		}
	} // end method closeOutputStream
	
	
	/**
	 * 
	 */ 
	public void openInputStream() {
		try{
			this.deserializationInput = new ObjectInputStream(new FileInputStream(SAVE_FILE));
			}

			catch(FileNotFoundException e){
				System.err.println("Error opening save file for reading.");
			}

			catch(IOException e) {
				System.err.println("Error writing stream header from write file.");
			}

	} // end method openInputStream
	
	
	/**
	 * 
	 */ 
	public void readObjects() {
		try{
			while (true){
				this.events.add((Event) this.deserializationInput.readObject());
			}
		}

		catch(EOFException e){
			System.out.println("Finished reading from save file.");

		}

		catch(ClassNotFoundException e){
			System.err.println("Contents of save file were corrupted.");
		}

		catch(IOException e)  {
			System.err.println("Error reading from save file.");
			e.printStackTrace();
		}
	} // end method readObjects
	
	
	/**
	 * 
	 */ 
	public void closeInputStream() {
			try{
		this.deserializationInput.close();
	}

		catch(IOException e){
			System.err.println("Error closing save file after reading.");
			e.printStackTrace();
			System.exit(1);
		}
	} // end method closeInputStream
} // end class Calendar