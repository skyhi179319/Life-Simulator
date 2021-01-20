package Assets;

import java.math.MathContext;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Status {
	public static String getSchool() {
		if(Life.CurrentPlayer.SchoolStatus == "") {
			return "Not In School";
		}
		else {
			return Life.CurrentPlayer.SchoolStatus;
		}
	}
	public static String getSports() {
		if(Life.CurrentPlayer.Activities.isEmpty()) {
			return "No Sports";
		}
		else {
			Life.CurrentPlayer.SportsStatus = Life.CurrentPlayer.Activities.get(0);
			return Life.CurrentPlayer.SportsStatus;
		}
	}
	public static String getJob() {
		if(Life.CurrentPlayer.Job == "") {
			return "No Job";
		}
		else {
			return Life.CurrentPlayer.Job;
		}
	}
	public static String getSalary() {
		if(Life.CurrentPlayer.Job == "") {
			return "$0.00";
		}
		else {
			String Salary = "$" + Jobs.JobsArray.get(Life.CurrentPlayer.Job).round(new MathContext(2)).setScale(2).toPlainString();
			return Salary;
		}
	}
	public static String getJobInfo() {
		return " - " + getJob() + " - " + getSalary() + "/$" + Life.CurrentPlayer.Raise.round(new MathContext(2)).setScale(2).toPlainString();
	}
	public static String getSportAward(ArrayList<String> Level) {
		if(Level.isEmpty()) {
			return "Didn't Play Sports";
		}
		return Level.get(0);
	}
	public static void UpdateLabel(JLabel Label, String Text) {
		Label.setText(Text);
	}
}