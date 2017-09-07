//CombatCalculator.java
import java.util.Scanner;

public class CombatCalculator3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);														//Import scanner					
																				/*monster data variables*/
		String MonsterName = "Goblin";																//declare variable for monsters name and initialize it to "goblin"
		int MonstHlth = 100;																		//declare variable for monster's health and initializeit to 100
		int MonstAtk = 15;																			//declare variable for monster's attack and initializ it to 15
																					
																					
																				/*hero data variables*/
		int PlyrHlth = 100;																			//declare variable for hero's health and initialize it as 100
		int PlyrAtk	 = 12;																			//declare variable for hero's attack and initialize it as 12
		int PlyrMgc = 0;																			//declare variable for hero's magic power and initialize it to 0
		
																				/*Reprt combat stats*/
			System.out.printf("You are fightn' a %s%n", MonsterName); 								//print the monster's name
			System.out.printf("Monster's HP:%d%n%n", MonstHlth);									//print the monster's health
	
			System.out.printf("Your HP:%d%n", PlyrHlth);											//print the players health
			System.out.printf("Your MP:%d%n%n", PlyrMgc);												//print the players magic points
	
																				/* Combat Menu Prompt*/
			System.out.println("1.) Sword Attack");													//print option 1: Sword attack
			System.out.println("2.) Magic");														//print option 2: magic attack
			System.out.println("3.) Charge Magic");													//print option 3: charge magic
			System.out.println("4.) Run Away");														//print option 4: run away

			System.out.print("What will you do? ");													//Prompt player for action
			int selection = input.nextInt();												
																				
																								//declare variable for user input (as number) and aquire value from scanner object
																			
	
	}
}	