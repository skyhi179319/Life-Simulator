package Assets.JobScrips;

import Assets.Finances;
import Assets.Jobs;
import Assets.Life;

public class Degree {
	public static class Teaching{
		private static int Years = 0;
		private static void Worked() {
			Years = Years + 1;
		}
		private static void setYears() {
			if(Life.CurrentPlayer.Job == Jobs.Teaching.MiddleSchool.Job) {
				Years = 2;
			}
			if(Life.CurrentPlayer.Job == Jobs.Teaching.HighSchool.Job) {
				Years = 4;
			}
			if(Life.CurrentPlayer.Job == Jobs.Teaching.College.Adjuct.Job) {
				Years = 6;
			}
			if(Life.CurrentPlayer.Job == Jobs.Teaching.College.Professor.Job) {
				Years = 10;
			}
			if(Life.CurrentPlayer.Job == Jobs.Teaching.College.Dean.Job) {
				Years =  15;
			}
		}
		private static void promoteElementaryTeacher() {
			if(Life.CurrentPlayer.Job == "Elementary Teacher") {
				if(Years == 2) {
					Life.CurrentPlayer.Job = "Middleschool Teacher";
				}
			}
		}
		private static void promoteMiddleSchoolTeacher() {
			if(Life.CurrentPlayer.Job == "Middleschool Teacher") {
				if(Years == 4) {
					Life.CurrentPlayer.Job = "Highschool Teacher";
				}
			}
		}
		private static void promoteHighSchoolTeacher() {
			if(Life.CurrentPlayer.Job == "Highschool Teacher") {
				if(Years == 6) {
					Life.CurrentPlayer.Job = "Adjuct";
				}
			}
		}
		private static void promoteAdjuct() {
			if(Life.CurrentPlayer.Job == "Adjuct") {
				if(Years == 10) {
					Life.CurrentPlayer.Job = "Prefessor";
				}
			}
		}
		private static void promotePrefessor() {
			if(Life.CurrentPlayer.Job == "Prefessor") {
				if(Years == 15) {
					Life.CurrentPlayer.Job = "Dean";
				}
			}
		}
		private static void raiseDean() {
			if(Life.CurrentPlayer.Job == "Dean") {
				if(Years == 17) {
					Finances.Raise("Dean");
				}
				if(Years == 20) {
					Finances.Raise("Dean");
				}
				if(Years >= 21) {
					Finances.Raise("Dean");
				}
			}
		}
		public static void Promote() {
			setYears();
			Worked();
			promoteElementaryTeacher();
			promoteMiddleSchoolTeacher();
			promoteHighSchoolTeacher();
			promoteAdjuct();
			promotePrefessor();
			raiseDean();
		}
	}
	public static void sector(String MainSector,String Sector) {
		if(MainSector == "Teaching") {
			Teaching.Promote();
		}
	}
}