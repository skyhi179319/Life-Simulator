package Assets;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import Assets.Graphics.Objects;

public class Actions {
	public static class Job{
		public static void autoClick(JButton Button) {
			Button.doClick();
		}
	}
	public static class School{
		public static void autoClick(JButton Button) {
			Button.doClick();
		}
		public static void ClearLabel(JLabel Label) {
			if(Life.CurrentPlayer.SchoolStatus == "") {
				Label.setText("");
			}
		}
	}
	public static class Storyline{
		private static class CurrentLife{
			private static String PlayerName = Life.CurrentPlayer.Firstname + " " + Life.CurrentPlayer.Lastname;
			private static int Age = Life.CurrentPlayer.Age;
			private static String MoneySaved = Life.CurrentPlayer.StringMoney;
			private static String getMainSport() {
				return Life.CurrentPlayer.Activities.get(0);
			}
			private static String getDegree() {
				return Life.CurrentPlayer.Degrees.get(0);
			}
			private static String SchoolSports() {
				ArrayList<String> Response = new ArrayList<>();
				if(!Life.CurrentPlayer.Activities.isEmpty()) {
					if(Life.CurrentPlayer.Middleschool.get(0) == "Co-Captian") {
						Response.add("a co-captain in " + getMainSport() + " in middleschool.");
					}
					if(Life.CurrentPlayer.Middleschool.get(0) == "Captian") {
						Response.add("a captain in " + getMainSport() + " in middleschool.");
					}
					if(Life.CurrentPlayer.Highschool.get(0) == "Co-Captain") {
						Response.add("He continued playing " + getMainSport() + " and became a co-captain in highschool.");
					}
					if(Life.CurrentPlayer.Highschool.get(0) == "Captain") {
						Response.add("He continued playing " + getMainSport() + " and became a captain in highschool.");
					}
					if(Life.CurrentPlayer.College.get(0) == "Co-Captian") {
						Response.add("As he was getting a degree in " + getDegree() + " he became the co-captian for the "
								+ getMainSport() + " team.");
					}
					if(Life.CurrentPlayer.College.get(0) == "Captian") {
						Response.add("As he was getting a degree in " + getDegree() + " he became the captian for the "
								+ getMainSport() + " team.");
					}
					return Response.get(0) +  " " + Response.get(1) + " " + Response.get(2);
				}
				else {
					Response.add("not wanting to play competitive sports");
					return Response.get(0);
				}
				
			}
			private static String getJobs(int i) {
				if(!Life.CurrentPlayer.LastJob.equals(Life.CurrentPlayer.RetiredJobs.get(i))){
					return Life.CurrentPlayer.LastJob;
				}
				else {
					return Life.CurrentPlayer.RetiredJobs.get(i);
				}
			}
			private static String JobLife() {
				if(!Life.CurrentPlayer.ProSport.isEmpty()) {
					if(Life.CurrentPlayer.ProSport.get(0) == "Undrafted") {
						return "He became an undrafted player after college, but he became a" + getJobs(0).toLowerCase();   
					}
					else {
						return "He became an " + Life.CurrentPlayer.ProSport.get(0).toLowerCase() + " after college. After retiring he became an" + getJobs(1) + ".";
					}
				}
				else {
					return "He became an "+ getJobs(Life.CurrentPlayer.Jobshad + 1).toLowerCase() + " after college"; 
				}
			}
		}
		public static void createStory() {
			String Intro = CurrentLife.PlayerName + " was " + CurrentLife.Age + " when he died";
			String School = "He was " + CurrentLife.SchoolSports();
			String Job = CurrentLife.JobLife();
			String Death = "When he died he had $" + CurrentLife.MoneySaved + " saved.";
			String Story = Intro + "\n" + School + "\n" + Job + "\n" + Death;
			new Objects.Actions.Info(Story);
		}
	}
}