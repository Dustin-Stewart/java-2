/**
*A test of our implementation
*of singleton and adapter
@author Dustin Stewart
@version 1 Feb 8 2018
*/
public class Runner {
	public static void main(String[] args){

		TheOneRing trueRing = TheOneRing.getTheOneRing();
		TheOneRing copyRing = TheOneRing.getTheOneRing();

		trueRing.castIntoTheFire();
		copyRing.castIntoTheFire();

		//two instances have two different spaces in memory, so if both variable names point to the smae location then they are the same object//

		System.out.println((trueRing == copyRing) ? "YAY!!" : "Whoops...");

		Geist germanGhost = new Geist("Hans");
		germanGhost.ereschrecken();
		germanGhost.herumgeistern();
	}
}