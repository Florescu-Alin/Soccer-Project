package soccer;

public class Team {
	
	public String teamName;
	
	public Player[] playerArray;
	
	public Team(String teamName ,Player[] playerArray) {
		this.teamName = teamName;
		this.playerArray = playerArray;
	}
	
	public void printTeamName() {
		
		System.out.println(this.teamName +" ");
	}
	
	public void printPlayerName() {
		
		for(int i = 0 ; i < this.playerArray.length; i++) {
			
			System.out.println(this.playerArray[i].getPlayerName()+" ");
		}
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Player[] getPlayerArray() {
		return playerArray;
	}
	public void setPlayerArray(Player[] playerArray) {
		this.playerArray = playerArray;
	}

}
