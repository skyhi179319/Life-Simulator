package Assets;

import java.util.ArrayList;
import java.util.Random;

public class School {
	public static class Elementary{
		public static int Age = 6;
	}
	public static class Middle{
		public static int Age = 12;
	}
	public static class High{
		public static int Age = 14;
	}
	public static class College{
		public static int Age = 18;
		public static class Degrees{
			// Add Degrees
			private static String[] DegreeSet1 = {"IT","Computer Science","Medical"};
			private static String[] DegreeSet2 = {"Religeous Studies","Biology","Physics"};
			private static String[] DegreeSet3 = {"Teaching","Art","Law"};
			private static String[] DegreeSet4 = {"IT","Law","Medical","Teaching"};
			public static String[] DegreeSet() {
				String[][] DegreeSetArea = {DegreeSet1,DegreeSet2,DegreeSet3,DegreeSet4};
				Random rand = new Random();
		        int picked = rand.nextInt(3);
		        return DegreeSetArea[picked];
			}
			public static void pickDegree(String Degree) {
				Life.CurrentPlayer.Degrees.add(Degree);
			}
		}
	}
	public static void AddSportDetails(ArrayList<String> Detail,String DetailString){
		Detail.add(DetailString);
	}
	public static void Milestone(int Age) {
		if(Age == 6) {
			Assets.SchoolScripts.Elementary.years = 1;
			Life.CurrentPlayer.SchoolStatus = "Elementary";
		}
		if(Age == 7) {
			Assets.SchoolScripts.Elementary.years = 2;
		}
		if(Age == 8) {
			Assets.SchoolScripts.Elementary.years = 3;
		}
		if(Age == 9) {
			Assets.SchoolScripts.Elementary.years = 4;
		}
		if(Age == 10) {
			Assets.SchoolScripts.Elementary.years = 5;
		}
		if(Age == 11 && Assets.SchoolScripts.Elementary.years == 5) {
			Assets.SchoolScripts.Middle.years = 1;
			Life.CurrentPlayer.SchoolStatus = "Middle School";
		}
		if(Age == 12) {
			Assets.SchoolScripts.Middle.years = 2;
		}
		if(Age == 13) {
			Assets.SchoolScripts.Middle.years = 3;
			if(Life.CurrentPlayer.Activities.isEmpty()) {
				
			}
			else {
				Life.CurrentPlayer.Middleschool.add(Assets.SchoolScripts.Middle.chooseSportsPlacement());
			}
		}
		if(Age == 14) {
			Assets.SchoolScripts.High.years = 1;
			Life.CurrentPlayer.SchoolStatus = "High School";
		}
		if(Age == 15) {
			Assets.SchoolScripts.High.years = 2;
		}
		if(Age == 16) {
			Assets.SchoolScripts.High.years = 3;
		}
		if(Age == 17) {
			Assets.SchoolScripts.High.years = 4;
			if(Life.CurrentPlayer.Activities.isEmpty()) {
				
			}
			else {
				Life.CurrentPlayer.Highschool.add(Assets.SchoolScripts.High.chooseSportsPlacement());
			}
		}
		if(Age == 18) {
			Assets.SchoolScripts.College.years = 1;
			Life.CurrentPlayer.SchoolStatus = "College";
		}
		if(Age == 19) {
			Assets.SchoolScripts.College.years = 2;
		}
		if(Age == 20) {
			Assets.SchoolScripts.College.years = 3;
		}
		if(Age == 21) {
			Assets.SchoolScripts.College.years = 4;
			if(Life.CurrentPlayer.Activities.isEmpty()) {
				
			}
			else {
				Life.CurrentPlayer.College.add(Assets.SchoolScripts.College.chooseSportsPlacement());
				Sports.Pro.Play(Age, Life.CurrentPlayer.Activities.get(0));
			}
			Life.CurrentPlayer.SchoolStatus = "";
		}
	}
}