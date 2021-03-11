/**
@author Dustin Stewart
@version 2/22/18
*/
import java.lang.ArithmeticException; 

/**
 * A class to model a fraction. Methods include add, 
 * subtract, multiply, divide, toString, and the 
 * appropriate getters.
 *
 * PLEASE COMPLETE THE DOCUMENTATION FOR THIS CLASS. 
 *
 * Notice that the equals method fulfills the contract
 * stipulated by the method from class Object. Likewise
 * for method hashCode. WHENEVER YOU OVERRIDE EQUALS, YOU
 * SHOULD OVERRIDE HASHCODE--THIS IS BEST JAVA PRACTICE!
 *
 * @author 	Franklin D. Worrell
 * @version 23 January 2016
 */ 
public class Fraction {
	private int numerator; 	
	private int denominator; 
	
	/**
	 * Initializes <code>numerator</code> and 
	 * <code>denominator</code> to values passed 
	 * as arguments. 
	 * 
	 * @param	numerator	the new Fraction's numerator
	 * @param	denominator	the new Fraction's denominator
	 */ 
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator; 
		this.denominator = denominator; 
	} // end constructor
	
	
	/** 
	 * Returns the <code>numerator</code> of 
	 * the <code>Fraction</code>. 
	 *
	 * @return	this.numerator
	 */ 
	public int getNumerator() {
		return this.numerator; 
	} // end method getNumerator
	
	
	/**
	 * 
	 */ 
	public int getDenominator() {
		return this.denominator; 
	} // end method getDenominator
	
	
	/**
	 * Adds the <code>Fraction</code> to another 
	 * provided as an argument. Returns the sum as 
	 * a new <code>Fraction</code> instance. 
	 * 
	 * @param	otherFraction	the other addend Fraction
	 * @return	a new Fraction that is the sum
	 */ 
	public Fraction add(Fraction otherFraction) {
		int commonDenominator = this.denominator * otherFraction.denominator; 
		int sumNumerator = (this.numerator * otherFraction.denominator) + (otherFraction.numerator * this.denominator); 
		Fraction sum = new Fraction(sumNumerator, commonDenominator); 
		return sum.simplify(); 
	} // end method add
	
	
	/**
	 * 
	 */ 
	public Fraction subtract(Fraction otherFraction) {
		int commonDenominator = this.denominator * otherFraction.denominator; 
		int differenceNumerator = (this.numerator * otherFraction.denominator) - (otherFraction.numerator * this.denominator); 
		Fraction difference = new Fraction(differenceNumerator, commonDenominator); 		
		return difference.simplify(); 
	} // end method subtract 
	
	
	/**
	 * 
	 */ 
	public Fraction multiply(Fraction otherFraction) {
		int prodNumerator = this.numerator * otherFraction.numerator; 
		int prodDenominator = this.denominator * otherFraction.denominator; 
		Fraction product = new Fraction(prodNumerator, prodDenominator); 
		return product.simplify(); 
	} // end method multiply 
	
	
	/**
	 * Divides the <code>Fraction</code> by divisor 
	 * provided as an argument. Returns the quotient 
	 * as a new <code>Fraction</code> instance. 
	 * 
	 * @param	otherFraction	the divisor Fraction
	 * @throws	ArithmeticException
	 * @return	a new Fraction that is the quotient
	 */ 
	public Fraction divide(Fraction otherFraction) throws ArithmeticException {
		// Attempted division by zero. 
		if (otherFraction.numerator == 0) {
			throw new ArithmeticException("Division by zero is undefined."); 
		} 
		
		// Valid divisor fraction passed as parameter. 
		else {
			// Create inverse of divisor. 
			Fraction inverse = new Fraction(otherFraction.denominator, otherFraction.numerator); 
			// Multiply dividend by inverse of divisor. 
			return this.multiply(inverse).simplify(); 
		} 
	} // end method divide
	
	
	/**
	 * Returns a String representation of the 
	 * <code>Fraction</code>. 
	 * 
	 * @return	a String representation of this
	 */ 
	@Override
	public String toString() {
		return this.numerator + " / " + this.denominator; 
	} // end method toString
	
	
	/**
	 * 
	 */ 
	@Override
	public boolean equals(Object otherFraction) {
		// Check for null reference and matching types. 
		if ((otherFraction != null) && 
			(this.getClass().equals(otherFraction.getClass()))) {
			
			// Simplify both fractions for comparison. 
			Fraction simplified = this.simplify(); 
			Fraction simpOther = ((Fraction) otherFraction).simplify(); 
			
			// Compare the numerators and denominators. 
			if ((simplified.numerator == simpOther.numerator) && 
				(simplified.denominator == simpOther.denominator)) {
				return true; 
			} 
				
			else {
				return false; 
			}
		} 
		
		else {
			return false; 
		} 
	} // end method equals
	
	
	/**
	 * Returns a hash code for the <code>Fraction</code>. 
	 * 
	 * @return	the hash code for the Fraction 
	 */ 
	@Override
	public int hashCode() {
		// Get the greatest common factor for use in simplifying Fraction.
		int factor = gCF(this.numerator, this.denominator); 
		
		// Use Bloch's formula for producing hash code. 
		int result = 17; 
		result = 31 * result + (this.numerator / factor); 
		result = 31 * result + (this.denominator / factor); 
		return result; 
	} // end method hashCode

	
	/**
	 * Returns the greatest common factor of two integer values. 
	 * Implements Euclid's algorithm. 
	 *
	 * @param	a	one of the numbers being factored
	 * @param	b	the other number being factored
	 * @return	the greatest common factor of the two integers
	 */ 
	private int gCF(int a, int b) {
		if (b == 0) {
			return a; 
		} 
		
		else {
			return gCF(b, a % b); 
		}
	} // end method gCF
	
	
	/**
	 * Returns a new <code>Fraction</code> that is 
	 * the <code>Fraction</code> simplified. 
	 * 
	 * @return	a new simplified Fraction
	 */ 
	private Fraction simplify() {
		int factor = gCF(this.numerator, this.denominator); 
		return new Fraction(this.numerator / factor, this.denominator / factor); 
	} // end method simplify
} // end class Fraction