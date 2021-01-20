package Assets.JobScrips;

import Assets.Finances;
import Assets.Life;

public class Emergency {
	public static class Police{
		private static int Years = 0;
		private static void Worked() {
			Years = Years + 1;
		}
		private static void promotePatrolman() {
			if(Life.CurrentPlayer.Job == "Police Patrolman") {
				if(Years == 2) {
					Life.CurrentPlayer.Job = "Police Sergeant";
				}
			}
		}
		private static void promoteSergeant() {
			if(Life.CurrentPlayer.Job == "Police Sergeant") {
				if(Years == 5) {
					Life.CurrentPlayer.Job = "Police Lieutenant";
				}
			}
		}
		private static void promoteLieutenant() {
			if(Life.CurrentPlayer.Job == "Police Lieutenant") {
				if(Years == 10) {
					Life.CurrentPlayer.Job = "Assistant Cheif";
				}
			}
		}
		private static void promoteAssistantCheif() {
			if(Life.CurrentPlayer.Job == "Assistant Cheif") {
				if(Years == 15) {
					Life.CurrentPlayer.Job = "Police Cheif";
				}
			}
		}
		private static void raisePoliceCheif() {
			if(Life.CurrentPlayer.Job == "Police Cheif") {
				if(Years == 17) {
					Finances.Raise("Police Cheif");
				}
				if(Years == 20) {
					Finances.Raise("Police Cheif");
				}
				if(Years >= 21) {
					Finances.Raise("Police Cheif");
				}
			}
		}
		public static void Promote() {
			Worked();
			promotePatrolman();
			promoteSergeant();
			promoteLieutenant();
			promoteAssistantCheif();
			raisePoliceCheif();
		}
	}
	public static class Fire{
		private static int Years = 0;
		private static void Worked() {
			Years = Years + 1;
		}
		private static void promoteProbation() {
			if(Life.CurrentPlayer.Job == "Probation Firefighter") {
				if(Years == 2) {
					Life.CurrentPlayer.Job = "Firefighter";
				}
			}
		}
		private static void promoteFirefighter() {
			if(Life.CurrentPlayer.Job == "Firefighter") {
				if(Years == 5) {
					Life.CurrentPlayer.Job = "Fire Lieutenant";
				}
			}
		}
		private static void promoteFireLieutenant() {
			if(Life.CurrentPlayer.Job == "Fire Lieutenant") {
				if(Years == 7) {
					Life.CurrentPlayer.Job = "Battalion Cheif";
				}
			}
		}
		private static void promoteBattalionCheif() {
			if(Life.CurrentPlayer.Job == "Battalion Cheif") {
				if(Years == 10) {
					Life.CurrentPlayer.Job = "Fire Assistiant Cheif";
				}
			}
		}
		private static void promoteFireAssustiantCheif() {
			if(Life.CurrentPlayer.Job == "Fire Assistiant Cheif") {
				if(Years == 15) {
					Life.CurrentPlayer.Job = "Fire Cheif";
				}
			}
		}
		private static void raiseFireCheif() {
			if(Life.CurrentPlayer.Job == "Fire Cheif") {
				if(Years == 17) {
					Finances.Raise("Fire Cheif");
				}
				if(Years == 20) {
					Finances.Raise("Fire Cheif");
				}
				if(Years >= 21) {
					Finances.Raise("Fire Cheif");
				}
			}
		}
		public static void Promote() {
			Worked();
			promoteProbation();
			promoteFirefighter();
			promoteFireLieutenant();
			promoteBattalionCheif();
			promoteFireAssustiantCheif();
			raiseFireCheif();
		}
	}
	public static class Hospital{
		private static int Years = 0;
		private static void Worked() {
			Years = Years + 1;
		}
		private static void promoteNurse() {
			if(Life.CurrentPlayer.Job == "Nurse") {
				if(Years == 3) {
					Life.CurrentPlayer.Job = "Surgeon";
				}
			}
		}
		private static void promoteSurgeon() {
			if(Life.CurrentPlayer.Job == "Surgeon") {
				if(Years == 8) {
					Life.CurrentPlayer.Job = "Doctor";
				}
			}
		}
		private static void raiseDoctor() {
			if(Life.CurrentPlayer.Job == "Doctor") {
				if(Years == 10) {
					Finances.Raise("Doctor");
				}
				if(Years == 12) {
					Finances.Raise("Doctor");
				}
				if(Years >= 15) {
					Finances.Raise("Doctor");
				}
			}
		}
		public static void Promote() {
			Worked();
			promoteNurse();
			promoteSurgeon();
			raiseDoctor();
		}
	}
	public static void sector(String MainSector,String Sector) {
		if(MainSector == "Emergency") {
			if(Sector == "Police") {
				Police.Promote();
			}
			if(Sector == "Fire") {
				Fire.Promote();
			}
			if(Sector == "Hospital") {
				Hospital.Promote();
			}
		}
	}
}