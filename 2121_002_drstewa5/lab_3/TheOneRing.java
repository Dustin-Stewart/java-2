/**
 * A class that implements the Singleton
 * design pattern. 
 * 
 * @author	Franklin D. Worrell
 * @revised	31 October 2016
 */ 
public class TheOneRing {
	private String bearer; 					   // the ring's bearer
	private static TheOneRing instance = null;

											   //private means private  "to the file".
	
	private void TheOneRing(){
		this.bearer = "The Dark Lord Sauron";
	}
	//a getter that gets an instance of the class//
	public static TheOneRing getTheOneRing(){
		if (instance == null){
			instance = new TheOneRing();
		}

			return instance;
		}
	
	/**
	 * Reveals the ring's secrets to the clever wizard.
	 */ 
	public void castIntoTheFire() {
		System.out.println(); 
		System.out.println("One Ring to rule them all, One Ring to find them, "); 
		System.out.println("One Ring to bring them all and in the darkness bind them. "); 
		System.out.println(); 
	} // end method castIntoTheFire
} // end class TheOneRing