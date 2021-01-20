package Assets.SportsScripts;

import java.util.Random;

import Assets.Life;
import Assets.Sports;

public class Baseball {
	public static int Years = 1;
	private static String[] Awards = {"MPV","OPOY","DPOY","CS"};
	static Random rand = new Random();
    static int pickedAwards = rand.nextInt(3);
    public static String Award() {
    	return "MLB" + Awards[pickedAwards];
    }
    public static void Play() {
		if(Years == 1 && Life.CurrentPlayer.SportPlayable == true) {
			String[] Rookie = {Awards[0],Awards[1],Awards[2],"ROY"};
			Random RookieYear = new Random();
		    int pickedRookieAwards = RookieYear.nextInt(3);
		    Life.CurrentPlayer.SportsAwards.put(1, Rookie[pickedRookieAwards]);
		    Years = Years + 1;
		    Sports.Years = Sports.Years + 1;
		}
		if(Years == 2 && Life.CurrentPlayer.SportPlayable == true) {
			Life.CurrentPlayer.SportsAwards.put(2, Award());
			Years = Years + 1;
			Sports.Years = Sports.Years + 1;
		}
		if(Years == 3 && Life.CurrentPlayer.SportPlayable == true) {
			Life.CurrentPlayer.SportsAwards.put(3, Award());
			Years = Years + 1;
			Sports.Years = Sports.Years + 1;
		}
		if(Years == 4 && Life.CurrentPlayer.SportPlayable == true) {
			Life.CurrentPlayer.SportsAwards.put(4, Award());
			Years = Years + 1;
			Sports.Years = Sports.Years + 1;
		}
		if(Years == 5 && Life.CurrentPlayer.SportPlayable == true) {
			Life.CurrentPlayer.SportsAwards.put(5, Award());
			Years = Years + 1;
			Sports.Years = Sports.Years + 1;
		}
		if(Years == 6 && Life.CurrentPlayer.SportPlayable == true) {
			Life.CurrentPlayer.SportsAwards.put(6, Award());
			Years = Years + 1;
			Sports.Years = Sports.Years + 1;
		}
		if(Years == 7 && Life.CurrentPlayer.SportPlayable == true) {
			Life.CurrentPlayer.SportsAwards.put(7, Award());
			Years = Years + 1;
			Sports.Years = Sports.Years + 1;
		}
		if(Years == 8 && Life.CurrentPlayer.SportPlayable == true) {
			Life.CurrentPlayer.SportsAwards.put(8, Award());
			Years = Years + 1;
			Sports.Years = Sports.Years + 1;
		}
		if(Years == 9 && Life.CurrentPlayer.SportPlayable == true) {
			Life.CurrentPlayer.SportsAwards.put(9, Award());
			Years = Years + 1;
			Sports.Years = Sports.Years + 1;
		}
		if(Years == 10 && Life.CurrentPlayer.SportPlayable == true) {
			Life.CurrentPlayer.SportsAwards.put(10, Award());
			Years = Years + 1;
			Sports.Years = Sports.Years + 1;
		}
		if(Years == 11 && Life.CurrentPlayer.SportPlayable == true) {
			Life.CurrentPlayer.SportsAwards.put(11,Award());
			Years = Years + 1;
			Sports.Years = Sports.Years + 1;
		}
		if(Years == 12 && Life.CurrentPlayer.SportPlayable == true) {
			Life.CurrentPlayer.SportsAwards.put(12, Award());
			Years = Years + 1;
			Sports.Years = Sports.Years + 1;
		}
		if(Years == 13 && Life.CurrentPlayer.SportPlayable == true) {
			Life.CurrentPlayer.SportsAwards.put(13, Award());
			Years = Years + 1;
			Sports.Years = Sports.Years + 1;
		}
		if(Years == 14 && Life.CurrentPlayer.SportPlayable == true) { 
			Life.CurrentPlayer.SportsAwards.put(14, Award());
			Years = Years + 1;
			Sports.Years = Sports.Years + 1;
		}
		if(Years == 15 && Life.CurrentPlayer.SportPlayable == true) {
			Life.CurrentPlayer.SportsAwards.put(15, Award());
			Years = Years + 1;
			Sports.Years = Sports.Years + 1;
		}
	}
}