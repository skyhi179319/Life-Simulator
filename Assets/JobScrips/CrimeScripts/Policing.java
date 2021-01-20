package Assets.JobScrips.CrimeScripts;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComponent;

import Assets.Life;
import Assets.Restrictions;

public class Policing {
	public static class Jail{
		public static int BreakoutAtt = 0;
		public static void Breakout(){
			boolean[] chances = {true,true,false,false,false};
			Random rand = new Random();
	        int picked = rand.nextInt(4);
	        if(chances[picked] == true && BreakoutAtt == 0) {
	        	boolean[] turnedInChances = {true,true,false,false,false};
	        	Random rand1 = new Random();
		        int turnedIn = rand1.nextInt(4);
		        if(turnedInChances[turnedIn] == true) {
		        	Life.CurrentPlayer.Jail = true;
		        }
		        if(turnedInChances[turnedIn] == false) {
		        	Life.CurrentPlayer.Jail = false;
		        }
	        }
	        if(chances[picked] == false && BreakoutAtt == 0) {
	        	Life.CurrentPlayer.Jail = false;
	        }
	        
		}
		private static void hideElements(JComponent Component) {
			Component.setVisible(false);
		}
		private static void showElement(JComponent Component) {
			Component.setVisible(true);
		}
		public static void lock(JButton School,JButton Job,JButton Crime) {
			if(Life.CurrentPlayer.Jail == true && Life.CurrentPlayer.Age >= Restrictions.Jobs.Crime) {
				hideElements(School);
				hideElements(Job);
				hideElements(Crime);
			}
			if(Life.CurrentPlayer.Jail == false && Life.CurrentPlayer.Age >= Restrictions.Jobs.Crime) {
				if(Life.CurrentPlayer.Age <= 21) {
					showElement(School);
				}
				showElement(Job);
				showElement(Crime);
			}
		}
		public static String JailStatus(){
			String Years = Integer.toString(Life.CurrentPlayer.YearsMustServe);
			return Years + " Years";
		}
		public static String JailFullStatus() {
			String Status;
			Status = JailStatus() + " and you tried to breakout " + BreakoutAtt + " time";
			return Status;
		}
	}
	private static class Sentencing{
		private static class Years{
			private static int DrugDealerMax = 15;
			private static int RobberMax = 15;
		}
		private static void Sentence() {
			boolean[] guilty = {true,true,false,false,false};
			Random rand = new Random();
	        int picked = rand.nextInt(4);
			if(guilty[picked] == true) {
				Life.CurrentPlayer.Jail = true;
				if(Life.CurrentPlayer.Job == "Drug Dealer") {
					Random years = new Random();
			        int yearsPicked = years.nextInt(Years.DrugDealerMax);
			        if(yearsPicked == 0) {
			        	Random pickYearsAgin = new Random();
				        int yearsPickedAgain = pickYearsAgin.nextInt(Years.DrugDealerMax);
				        Life.CurrentPlayer.YearsMustServe = yearsPickedAgain;
			        }
			        else {
			        	Life.CurrentPlayer.YearsMustServe = yearsPicked;
			        }
				}
				else if(Life.CurrentPlayer.Job == "Robber") {
					Random years = new Random();
			        int yearsPicked = years.nextInt(Years.RobberMax);
			        if(yearsPicked == 0) {
			        	Random pickYearsAgin = new Random();
				        int yearsPickedAgain = pickYearsAgin.nextInt(Years.RobberMax);
				        Life.CurrentPlayer.YearsMustServe = yearsPickedAgain;
			        }
			        else {
			        	Life.CurrentPlayer.YearsMustServe = yearsPicked;
			        }
				}
			}
		}
	}
	public static class Offense{
		public static void Attempt() {
			boolean[] attempt = {true,true,false,false,false};
			Random rand = new Random();
	        int picked = rand.nextInt(1);
	        if(attempt[picked] == false){
	        	Life.CurrentPlayer.CrimesCommitedWOJail = Life.CurrentPlayer.CrimesCommitedWOJail + 1;
	        }
	        if(attempt[picked] == true) {
	        	Life.CurrentPlayer.CrimesCommitedWJail = Life.CurrentPlayer.CrimesCommitedWJail + 1;
	        	Sentencing.Sentence();
	        }
		}
		private static void Release() {
			Life.CurrentPlayer.Jail = false;
		}
		public static void yearsLeft() {
			if(Life.CurrentPlayer.YearsMustServe == 0) {
				Release();
			}
			else {
				Life.CurrentPlayer.YearsMustServe = Life.CurrentPlayer.YearsMustServe - 1;
			}
		}
		
	}
}