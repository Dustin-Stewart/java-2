//CombatCalculator.java
import java.util.Scanner;

public class CombatCalculator6 {
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
		int action = 0; 
													/*loop Control*/
			while (MonstHlth >= 0 && action	!= 4){																					//Declare loop control variable and initialize it to be true
					 																						//While the loop control variable is true
		
																				/*Report combat stats*/
				System.out.printf("You are fightn' a %s%n", MonsterName); 							//print the monster's name
				System.out.printf("Monster's HP:%d%n%n", MonstHlth);								//print the monster's health
		
				System.out.printf("Your HP:%d%n", PlyrHlth);										//print the players health
				System.out.printf("Your MP:%d%n%n", PlyrMgc);											//print the players magic points
	
																				/* Combat Menu Prompt*/
				System.out.println("1.) Sword Attack");												//print option 1: Sword attack
				System.out.println("2.) Magic");													//print option 2: magic attack
				System.out.println("3.) Charge Magic");												//print option 3: charge magic
				System.out.printf ("4.) Run Away%n%n");													//print option 4: run away

				System.out.print("What will you do? ");												//Prompt player for action
				action = input.nextInt();														//declare variable for user input (as number) and aquire value from scanner object
				System.out.println();																	
																								
																				/*Selection operations & Stat updaters*/
					if (action == 1) {																					//if plyr choose option 1 (check with equality operator)
						System.out.printf("You strike the %s with your sword for %d%n", MonsterName, PlyrAtk);				//print attack text:
							 MonstHlth = MonstHlth - 12;																		//Calculate damage & update monster health using subtraction
							}																										//new monster health == old monster health - hero attack power								
																															
																												
					else if (action == 2) {																				//else if plyr chose option 2, (check with equality operator)
																															//IF THE PLAYER HAS 3 OR MORE MAGIC POINTS
																																//REDUCE THE PLAYERS MAGIC POINTS BY THE SPELL COST USING SUBTRACTION
																																	//CALCULATE NEW MAGIC POWER == OLD MAGIC POWER MINUS 3
						System.out.printf("You cast weaken spell on the %s%n", MonsterName);										//print spell message:
																													//else print the message : you dont have enough mana
							 MonstHlth = MonstHlth / 2;																					//calculate damage and update monster health using division
							}																												//new monster health == old monster health / 2	
										
			
					else if (action == 3) {																				//else if plyr chose option 3, (check with equality operator)
						System.out.println("You focus and charge your magic power");										//print charging message:
							PlyrMgc++;
																																//increment magic points and update players magic using addition
							}																										//new hero magic is == old hero magic + 1			
																																											
				
					else if	(action == 4) {																				//else if plyr chose option 4, (ceck with equality operator)
						
						System.out.println("You run away!");																			//Stop combat loop by setting control variable to false
																							//print retreat message:
							}																										//"You run away!"						
					
					else {
						System.out.print("I don't understand that command");											//else the player chose incorrectly
						}																								//print an error message:
																																//"i dont understand that command"
																															//IF MONSTER HEALTH <= 0
																																//STOP COMBAT LOOP BY SETTING CONTROL VARIABLES TO FALSE
																																	//PRINT VICTORY MESSAGE
		
					if (MonstHlth <= 0) {
					System.out.printf("you defeated the %s!", MonsterName);
										}
			}
		}			
	}	
			