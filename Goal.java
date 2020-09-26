package soccer;

public class Goal {
	
	public Team theTeam;
	
	public Player thePlayer;
	
	public Goal(Team theTeam,Player thePlayer) {
		this.theTeam = theTeam;
		this.thePlayer = thePlayer;	
	}
	
	
	public Team getTheTeam() {
		return theTeam;
	}
	public void setTheTeam(Team theTeam) {
		this.theTeam = theTeam;
	}
	public Player getThePlayer() {
		return thePlayer;
	}
	public void setThePlayer(Player thePlayer) {
		this.thePlayer = thePlayer;
	}
	

}
