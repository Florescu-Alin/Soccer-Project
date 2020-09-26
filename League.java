package soccer;

import static soccer.Game.generateGoals;
import static soccer.Game.getScore;
import static soccer.Player.createPlayers;
import static soccer.Player.createTeamPlayers;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class League {
	
//	public static String[] pickNames(String[] names, int nrOfNames) {
//		
//		String[] choosenNames = new String[nrOfNames];
//		int nrJucatoriEchipa = nrOfNames, j, nrTotalDeNume = names.length - 1;
//		
//		for (int i = 0; i <  nrJucatoriEchipa; i++) {
//			
//			boolean are;
//			do {
//				are = true;
//				j = ThreadLocalRandom.current().nextInt(0, nrTotalDeNume);
//				if  (names[j] == null) are = false;
//			} while (!are);
//			choosenNames[i] = names[j];
//			names[j] = null;
//		}
//
//		return choosenNames;
//	}
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int endSimulator = 1;
		
		String[] names = {"Messi", "Pique", "Suarez", "Roberto", "Ronaldo", "Ramos", "Benzema", "Modric",
				"Bale", "Nacho", "Neymar", "Lucas", "Rakitic", "Isco", "Costa", "Robben", "Alvarez", "Hernandez", 
				"Douglas", "Mariano", "Aguero", "Mascherano", "Giroud", "Griezman", "Gimenez", "Godin", "Cavani"};
		
	//	String[] test = pickNames(names, 11);
	//	String[] test2 = pickNames(names, 11);
		
		
		
		Player[] playersBarcelona = createTeamPlayers(names, 5);
		Player[] playersRealMadrid = createTeamPlayers(names, 5);
		
		Team barcelona = new Team("Barcelona", playersBarcelona);
		Team real_madrid = new Team("Real Madrid", playersRealMadrid);
		
		Team[] teams = {barcelona, real_madrid};
		
		do {
			
			System.out.println("==============League 1===============");
			System.out.println("See the teams ------ 1");
			System.out.println("Simulate a game ------ 2");
			
			endSimulator = keyboard.nextInt();
			
			switch(endSimulator) {
				case 1:
				{
					System.out.print("The teams in this simulator are: ");
					
					for(int i = 0; i<teams.length; i++) {
//						System.out.print(teams[i].getTeamName() +  " ");
						teams[i].printTeamName();
					}
					System.out.println();
					break;
				}
				case 2: 
				{
					Goal[] highlights = generateGoals(teams, 7);
					System.out.println(getScore(barcelona, real_madrid, highlights));
					Game.seeHighlights(highlights);
					
					for(int i = 0; i <highlights.length; i++ ) {
						highlights[i].getThePlayer().setCounted(0);
					}
					
					break;
				}
				default:
				{
					System.out.println("Choose a correct option!");
					break;
				}
			}
		
			System.out.println("Want to EXIT? ------- 0");
			System.out.println("Want to CONTINUE? ------- 1");
			endSimulator = keyboard.nextInt();
			
		} while (endSimulator != 0);
		keyboard.close();
	} 
}
