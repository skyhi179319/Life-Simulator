package Assets;

import java.util.ArrayList;
import java.util.Random;

public class Sports {
	public static int Years;
	private static String pickSport(ArrayList<String> Sport) {
		if(Sport.size() == 1) {
			return Sport.get(0);
		}
		else {
			int sport = Sport.size() - 1;
			Random rand = new Random();
	        int picked = rand.nextInt(sport);
	        return Sport.get(picked);
		}
	}
	private static String pickCollegeSport(ArrayList<String> Sport) {
		Life.CurrentPlayer.CollegeSport.add(pickSport(Sport));
		return pickSport(Sport);
	}
	public static String Draft(int age,String Sport) {
		boolean draft = false;
		if(age == 21) {
			boolean[] DraftPicks = {true,true,true,false,false};
			Random rand = new Random();
	        int picked = rand.nextInt(4);
	        draft = DraftPicks[picked];
	        if(Sport == "Football" && draft == true) {
	        	return "Football";
	        }
	        else if (Sport == "Basketball" && draft == true) {
	        	return "Basketball";
	        }
	        else if (Sport == "Baseball" && draft == true) {
	        	return "Baseball";
	        }
	        else {
	        	return "Undrafted";
	        }
		}
		return Draft(age,Sport);
	}
	public static class College{
		String SportPlaying = pickCollegeSport(Life.CurrentPlayer.Activities);
	}
	public static class Pro{
		public static void Play(int Age,String Sport) {
			if(Draft(Age,Sport) == "Football") {
				Life.CurrentPlayer.SportPlayable = true;
				Life.CurrentPlayer.ProSport.add("Football Player");
				Life.CurrentPlayer.Job = "Football Player";
				Life.CurrentPlayer.SportsStatus = "Pro Football Player";
			}
			else if(Draft(Age,Sport) == "Basketball") {
				Life.CurrentPlayer.SportPlayable = true;
				Life.CurrentPlayer.ProSport.add("Basketball Player");
				Life.CurrentPlayer.Job = "Basketball Player";
				Life.CurrentPlayer.SportsStatus = "Pro Basketball Player";
			}
			else if(Draft(Age,Sport) == "Baseball") {
				Life.CurrentPlayer.SportPlayable = true;
				Life.CurrentPlayer.ProSport.add("Baseball Player");
				Life.CurrentPlayer.Job = "Baseball Player";
				Life.CurrentPlayer.SportsStatus = "Pro Baseball Player";
			}
			else if(Draft(Age,Sport) == "Undrafted") {
				Life.CurrentPlayer.SportPlayable = false;
				Life.CurrentPlayer.ProSport.add("Undrafted");
				Life.CurrentPlayer.SportsStatus = "Undrafted";
			}
		}
		
	}
	public static String getSport() {
		return Life.CurrentPlayer.ProSport.get(0);
	}
}