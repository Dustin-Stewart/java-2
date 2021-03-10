//CombatCalculator.java
import java.util.Scanner;

public class CombatCalculator8 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);														//Import scanner					
																				/*monster data variables*/
		String MonsterName = "Somebody";																//declare variable for monsters name and initialize it to "goblin"
		int MonstHlth = 100;																		//declare variable for monster's health and initializeit to 100
		int MonstAtk = 15;																			//declare variable for monster's attack and initializ it to 15
																					
																					
		String round1 = "For reasons unknown, you are fighting ";
		String battle = "HOW are you STILL fighting ";	
		String end = "You're Killing them!";																/*hero data variables*/
		int PlyrHlth = 100;																			//declare variable for hero's health and initialize it as 100
		int PlyrAtk	 = 12;																			//declare variable for hero's attack and initialize it as 12
		int PlyrMgc = 0;																			//declare variable for hero's magic power and initialize it to 0
		int action = 0; 
		int turncounter = 0;											/*loop Control*/
		
		while (MonstHlth >= 0 && action	!= 4){																					//Declare loop control variable and initialize it to be true
			 																						//While the loop control variable is true
		
				turncounter++;		
			  if(turncounter < 1){	
				System.out.printf("%n%n%s%s.%n%n",round1, MonsterName);
					}
				else if (turncounter <=3){
					System.out.printf("%n%n%s%s!?!%n%n", battle, MonsterName);
					}			
				else  if
					(turncounter >3 && MonstHlth <=30 ) {
						System.out.printf("%s%n%n", end);
				}
																	/*Report combat stats*/
			
				
			
				
				
				
				System.out.printf("%s's Stamina: %d%n%n", MonsterName, MonstHlth);								//print the monster's health
		
				System.out.printf("Your Stamina: %d%n", PlyrHlth);										//print the players health
				System.out.printf("Your FP: %d (Freaky Power)%n%n", PlyrMgc);											//print the players magic points
	
																				/* Combat Menu Prompt*/
				System.out.println("1.) Rude Attack");												//print option 1: Sword attack
				System.out.println("2.) Wack Spell");													//print option 2: magic attack
				System.out.println("3.) Charge Freaky Power");												//print option 3: charge magic
				System.out.printf ("4.) Run Away (please)%n%n");													//print option 4: run away

				System.out.print("Why are you doing this??? ");												//Prompt player for action
				action = input.nextInt();														//declare variable for user input (as number) and aquire value from scanner object
				System.out.println();																	
																								
																				/*Selection operations & Stat updaters*/
					if (action == 1) {																					//if plyr choose option 1 (check with equality operator)
						System.out.printf("Thou striketh yon %s with a Foam Sword for %d (Why??)%n%n", MonsterName, PlyrAtk);				//print attack text:
							
							MonstHlth = MonstHlth - 12;																		//Calculate damage & update monster health using subtraction
							}																										//new monster health == old monster health - hero attack power								
																															
																												
					else if (action == 2 && PlyrMgc	>= 3) {																				//else if plyr chose option 2, (check with equality operator)
																															//IF THE PLAYER HAS 3 OR MORE MAGIC POINTS
																																//REDUCE THE PLAYERS MAGIC POINTS BY THE SPELL COST USING SUBTRACTION
																																	//CALCULATE NEW MAGIC POWER == OLD MAGIC POWER MINUS 3
						System.out.printf("Your freaky power is ready boo, and you cast a Wack Spell on %s for no apparent reason.%n", MonsterName);										//print spell message:
							System.out.printf("The freakin' spell cut %s's HP in half!  WTF?%n%n", MonsterName);																						//else print the message : you dont have enough mana
							 MonstHlth = MonstHlth / 2;		

								PlyrMgc = PlyrMgc - 3;																				//calculate damage and update monster health using division
							}																												//new monster health == old monster health / 2	
										
			
					else if (action == 3) {																				//else if plyr chose option 3, (check with equality operator)
						System.out.printf("You focus way too hard and charge your Freaky Power.%n%n");										//print charging message:
							PlyrMgc++;
																																//increment magic points and update players magic using addition
							}																										//new hero magic is == old hero magic + 1			
																																											
				
					else if	(action == 4) {																				//else if plyr chose option 4, (ceck with equality operator)
						
						System.out.println("You run, you run so far away");																			//Stop combat loop by setting control variable to false
																							//print retreat message:
							}																										//"You run away!"						
					
					else if (action== 2 && PlyrMgc <3){
						System.out.printf("That Freaky Power ain't ready yet!%n%n");
					}
					else {
							
						System.out.printf("I don't understand that command%n%n");											//else the player chose incorrectly
						}																								//print an error message:
																																//"i dont understand that command"
																															//IF MONSTER HEALTH <= 0
																																		//STOP COMBAT LOOP BY SETTING CONTROL VARIABLES TO FALSE
																																	//PRINT VICTORY MESSAGE
		
														/*Monster Turn*/
					
		System.out.printf("%s's Turn (you done f**ked up, now)")											//initial text
					
					if (MonstHlth > 0) {
						System.out.printf(" you literally hurt yourself on accident trying to hurt %s.%nSeems habitual.%n%n");
					}
					
					if (MonstHlth <= 0) {
					System.out.printf("Oh my god what have you done to that person?!", MonsterName);
										}
			}
		}			
	}	
			