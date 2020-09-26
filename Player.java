package soccer;

import java.util.concurrent.ThreadLocalRandom;

public class Player {
	
	private String playerName;
	private int Counted = 0;
	public Player(String playerName) {
		
		this.playerName = playerName;
	}
	
	public static Player[] createPlayers(String[] names) {
		
		Player[] players = new Player[names.length];
		
		for (int i = 0; i< names.length; i++) {
			
			players[i] = new Player(names[i]);
		}
		
		return players;
	}
	
	public static Player[] createTeamPlayers(String[] names, int nrOfPlayers) {
		
		int randomPosition;
		
		Player[] chosenPlayers = new Player[nrOfPlayers];
		String[] chosenNames = new String[nrOfPlayers];
		int currentLength=0;
		
		for (int i = 0; i < names.length; i++) {
			if(names[i].equals("")) {
				break;
			} else {
				currentLength = i;
			}
		}
		currentLength = currentLength + 1;
		for(int i = 0; i < nrOfPlayers; i++) {
			
			randomPosition = ThreadLocalRandom.current().nextInt(0, currentLength);
			chosenNames[i] = names[randomPosition];
			for (int j = randomPosition; j < currentLength - 1; j ++) {
				
				names[j] = names[j+1];
			}
			
			names[currentLength-1] = "";
			currentLength = currentLength - 1;
		}		
		chosenPlayers = createPlayers(chosenNames);
		
		return chosenPlayers;
	}
 
	public void printPlayer() {
		
		System.out.print(this.playerName);
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getCounted() {
		return Counted;
	}

	public void setCounted(int counted) {
		this.Counted = counted;
	}

}


