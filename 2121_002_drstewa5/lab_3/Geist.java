/**Anadapter for vlas ghost to change the interface for German use
@author Dustin Stewart
@version 1 Feb 8 2018
*/
public class Geist{
	private Ghost adaptee;

	public Geist(String namen){
		this.adaptee = new Ghost(namen);
	}

	public void ereschrecken(){
		this.adaptee.scare();
	}

	public void herumgeistern(){
		this.adaptee.haunt();
	}
}