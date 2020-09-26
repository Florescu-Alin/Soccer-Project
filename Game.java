package soccer;

import java.util.concurrent.ThreadLocalRandom;

public class Game {
	
	public Team homeTeam;
	
	public Team awayTeam;
	
	public Goal[] goals;
	
	public Game(Team homeTeam ,Team awayTeam ,Goal[] goals ) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.goals = goals;
	}
	
	public static Goal[] generateGoals(Team[] teams,int maximumGoals) {
		
		maximumGoals = ThreadLocalRandom.current().nextInt(0,maximumGoals);
		
		Goal[] goalsMarked = new Goal [maximumGoals];
		
		for(int i = 0; i < maximumGoals; i++) {
			
			int chooseTeam=ThreadLocalRandom.current().nextInt(0,teams.length);
			
			Team teamWhichMarked = teams[chooseTeam];
			
			int choosePlayer = ThreadLocalRandom.current().nextInt(0,teamWhichMarked.getPlayerArray().length);
			
			Player playerWhoScored = teamWhichMarked.getPlayerArray()[choosePlayer];
			
			goalsMarked[i] = new Goal(teamWhichMarked , playerWhoScored);
		}
		
		return goalsMarked;
	}
		
	public static String getScore(Team home, Team away,Goal[] goals) {
		
		int gHome = 0, gAway=0;
		
		for(int i = 0 ; i < goals.length; i++ ) {
			
			if(goals[i].getTheTeam().getTeamName().equals(home.getTeamName())) {
				gHome++;
			}
			else if(goals[i].getTheTeam().getTeamName().equals(away.getTeamName())) {
				gAway++;
			}
		}
	  
		
	
	if(gHome >= gAway ) {
		return "Score was "+gHome+"-"+gAway+" "+home.getTeamName()+" - " + away.getTeamName();
	}
	else {
		return "Score was "+gAway+"-"+gHome+" "+away.getTeamName()+" - "+home.getTeamName();	
	}
	}
	public static void seeHighlights(Goal[] highlights) {
		
		if(highlights.length != 0) {
		for(int i = 0; i < highlights.length-1;i++) {
//			System.out.println(highlights[i].getThePlayer().getPlayerName()+" scored for team: -"
//		             +highlights[i].getTheTeam().getTeamName());
			
			if(highlights[i].getThePlayer().getCounted()== 0 ) {
			int nrGoals = 1;
			for(int j = i + 1 ; j < highlights.length ; j++) {
				if(highlights[i].getThePlayer().getPlayerName().equals(highlights[j].getThePlayer().getPlayerName())){
					nrGoals++;	
					highlights[j].getThePlayer().setCounted(1);
					
			  }
			}
			System.out.println("Player: "+ highlights[i].getThePlayer().getPlayerName()+ " scored "+ nrGoals);
			}
		}	
		    if(highlights[highlights.length-1].getThePlayer().getCounted() == 0) {
		    	System.out.println("Player: "+ highlights[highlights.length-1].getThePlayer().getPlayerName()+ " scored "+ 1);
		    }
		 }
	  }
	public Team getHomeTeam() {
		return homeTeam;
	}
	
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}
	public Team getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}
	public Goal[] getGoals() {
		return goals;
	}
	public void setGoals(Goal[] goals) {
		this.goals = goals;
	}

}
