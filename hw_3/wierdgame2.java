//CombatCalculator.java
import java.util.Scanner;																			//import scanner


public class wierdgame2 {																			//class declaration
												/*hero data variables*/
	static int HP = 0;																			//declare static variable for hero's health and initialize it as 0
	static int AP = 0;																			//declare static variable for hero's attack and initialize it as 0
	static int MP = 0;																			//declare static variable for hero's magic power and initialize it to 0
	static int XP = 0;
											/*monster data variables*/
	static String MonsterName;																	//declare variable for monsters name and initialize it 
	static int MonstHlth;																		//declare variable for monster's health and initializeit to 100
	static int MonstAtk;			
	static int MonsterXP;
	
	static Scanner input = new Scanner(System.in);												//use scanner input 													

	
		public static void main(String[] args) {														//begin main method											
			heroCreationMethod();
			MonsterGenerator();
													/*Various result texts */
		String round1 = "For reasons unknown, you are about to fight ";								//declare string for first round of "combat"
		String battle = "HOW are you STILL fighting ";												//declare string for latter rounds
		String end = "You're Killing them!";														//declare string for final rounds
		
														/*Game Mechanics*/	
		int action = 0; 																			//Declare an interger to hold the players action selcection
		int turncounter = 0;																		//Turn counter
				
														/*loop Control*/
		
		while (MonstHlth > 0 && action	!= 4 && HP >0){												/*Declare loop control variable and initialize it to be true, this says that 
																									while the mmonster is alive and you dont run, to continue the while statement*/
			turncounter++;																			/*While the loop control variable is true, keep track of how many turns. 
																									 this affects in game text*/
		
						
				if (turncounter < 2){															   	  	 //this block prints the text for the first round
				System.out.printf("%n%n%s%s.%n~~~~~~~~~~~~~~~~~~%n",round1, MonsterName); 		 		 //lines for clarity
									}
				
				else if (turncounter >=2 && turncounter <5){										   	 //this block prints mid game text
					System.out.printf("%n%n%s%s!?!%n~~~~~~~~~~~~~~~~~~%n", battle, MonsterName);  		 //lines for clarity
									}			
			
				else  {																					 //this block prints end game text
						System.out.printf("%n%n%s%n~~~~~~~~~~~~~~~~~~%n", end);
									}
														/*Report combat stats with spacing*/
																	
					System.out.printf("%s's Stamina: %d%n%n", MonsterName, MonstHlth);				//print the monster's health
					System.out.printf("Your Stamina: %d%n", HP);									//print the players health
					System.out.printf("Your FP: %d (Freaky Power)%n%n", MP);						//print the players magic points
	
														/* Combat Menu Prompt (action selections*/
																	
					System.out.println("1.) Rude Attack");											//print option 1
					System.out.println("2.) Wack Spell");											//print option 2
					System.out.println("3.) Charge Freaky Power");									//print option 3
					System.out.printf ("4.) Run Away (please)%n%n");								//print option 4

														/* Begin Turn*/
														
		System.out.printf("Wait, what are you about to do??? ");											//Prompt player for action
		action = input.nextInt();																        	//declare variable for user input (as number) and aquire value from scanner object																
																								
														/*Selection operations & Stat updaters*/
			
														//attack
					if (action == 1) {																										//if plyr choose option 1 (check with equality operator)
						System.out.printf("%n***%nThou striketh yon %s with a Foam Sword for %d (Why??)%n***%n", MonsterName, PlyrAtk);				//print attack text:
							MonstHlth = MonstHlth - 12;																						//Calculate damage & update monster health using subtraction
									}						
									
														//magic																																												
					else if (action == 2 && MP	>= 3) {																									/*else if plyr chose option 2, (check with equality operator).
																																							if the player more than 3 magic points it works otherwise it prints 
																																							alt text*/
						System.out.printf("%n***%nYour freaky power is ready boo, and you cast a Wack Spell on %s for no apparent reason.%n", MonsterName);	//print spell message:
							System.out.printf("The freakin' spell cut %s's HP in half!  WTF?%n***%n", MonsterName);										
							 MonstHlth = MonstHlth / 2;																										//calculate damage and update monster health using division
								MP = MP - 3;																	  									//reduce the players magic points by the spell cost using subtraction
									}					
																																								
														//alternate message for trying to use magic without magic points
					else if (action== 2 && MP <3){
						System.out.printf("%n***%nThat Freaky Power ain't ready yet!%n***%n");									
					}
				
														//charge
					else if (action == 3) {																												//else if plyr chose option 3, (check with equality operator)
						System.out.printf("%n***%nYou focus way too hard and charge your Freaky Power.%n***%n%n");										//print charging message:
							MP++;																													//increment magic points and update players magic using addition
									}																													//new hero magic is == old hero magic + 1	
												
														//escape																																																														
				
					else if	(action == 4) {																												//else if plyr chose option 4, (ceck with equality operator)					
																																						//Stop combat loop by setting control variable to false
					System.out.printf("*n~~~You run, you run so far away~~~%n");																			//print retreat message:					
									}															
										
														//error message
					else {
							
						System.out.printf("%n***%nPick an option from the list, preferably non-violent%n***%n");									//else the player chose incorrectly
						}																															//print an error message
																																
														/*"Monster Turn"*/           				
						if (MonstHlth > 0 && action !=4 && turncounter % 2 ==0 ) {																	//test to see if the monster is alive, if the plyr ran, or if the turn is odd
						System.out.printf("-----------------------------------%nYou are so reckless in your violent quest!%n");						//print text
					
					
						System.out.printf("You literally hurt yourself on accident trying to hurt %s.%nSeems habitual.%n-----------------------------------%n", MonsterName);			//result of test and lines for clarity																							//IF MONSTER HEALTH <= 0
						HP = HP - MonstAtk;																																	//Plyr loses health equivalent to monster health
						}																				
		
						
		}												/*End of while loop*/
					
														/*if the monster dies*/
				if (MonstHlth <=0)  {
					System.out.printf("%nOH MY GOD WHAT HAVE YOU DONE TO THAT PERSON?!");					//print "victory message
									}
									
														/*if plyr dies*/
				if (HP <=0) 	{
					System.out.printf("%nYOU KILLED YOURSELF. JUSTICE SERVED.");								//print death screen
									}
	}													/*end main method*/	

						public static void heroCreationMethod(){					//declare new method called/for heroCreation
							
							int points = 20;								//declare points variable set to 20
							int action;										//declare an interger called action for user action
							
							while (points != 0 ){						//declare loop statement
								
								System.out.printf("Health:%d, Attack:%d, Magic:%d%n", HP, AP, MP);				//print out user stats
								System.out.println("1.) +10 Health");											//print option 1
								System.out.println("2.) +1 Attack");											//print option 2
								System.out.println("3.) +3 Magic");												//print option 3
								System.out.printf("You have %d Magic Points to spend. How you wanna play it: ", points);				//print option 4
								
								action = input.nextInt();											        	//declare variable for user input (as number) and aquire value from scanner object
								
								points--;																		//decrement points
					
									if (action = 1){																//Selection statements and their corresponding actions
									HP += 10;						
									}
									else if (action = 2){
									AP+=1;
									}
									else if (action = 3){
									MP +=3;	
									}
									else {
										System.out.println("Type A Number 1 through 3");
										points++;
									}
							}
						}			
						
						/*public static void MonsterGenerator(){
							int monsterType = (int) Math.floor(Math.random()*2);

								if (monsterType=0){
								MonsterName = goblin;
								MonstAtk = 8 + (int) Math.ceil(Math.random()*4);
								MonstHlth =75 (int) Math.ceil(Math.random()*24);
								MonsterXP= 1;
								}
								
								if (monsterType=1){
								MonsterName = orc;
								MonstAtk = 12 + (int) Math.ceil(Math.random()*4);
								MonstHlth =75 (int) Math.ceil(Math.random()*24)+0;
								MonsterXP= 2;
								}
								
								if (monsterType=2){
								MonsterName = Troll;
								MonstAtk = 15 + (int) Math.ceil(Math.random()*4)+0;
								MonstHlth =150 (int) Math.ceil(Math.random()*49)+0;
								MonsterXP= 3;
								}*/

						}
						
				// closed bracket here
			// closed bracket here		
		// closed bracket here		
	// closed bracket here	
// closed bracket here														/*end Class*/
		
			