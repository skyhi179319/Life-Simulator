package Assets;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComponent;

import Assets.Life.CurrentPlayer;
public class Ageing { 
	public static class UpdateInfo{
		public static String MomInfo = Life.Sims.Parents.Mom.Firstname + " " + Life.Sims.Parents.Mom.Lastname;
		public static String MomJob = Life.Sims.Parents.Mom.Job + ": $" + Life.Sims.Parents.Mom.Salary;
		public static String DadInfo = Life.Sims.Parents.Dad.Firstname + " " + Life.Sims.Parents.Dad.Lastname;
		public static String DadJob = Life.Sims.Parents.Dad.Job + ": $" + Life.Sims.Parents.Dad.Salary;
		public static String UserInfo = Life.CurrentPlayer.Firstname + " " + Life.CurrentPlayer.Lastname;
	}
	public static void hideButton(JComponent Button) {
		Button.setVisible(false);
	}
	public static void showButton(JComponent Button) {
		Button.setVisible(true);
	}
	public static BigDecimal AddMoney(int age,BigDecimal Current,BigDecimal Salary) {
		BigDecimal money = Current.add(Finances.NetWorth(age, Salary)).setScale(2);
		return money;
	}
	/*
		 Add Salary As String
		 Turning Salary Into A String Then Converting To A BigDecimal
		 Delete Mom & Dad Money And Change Method For User Only.
		 Make Not That Any New Updates May Not Contain Any Currency For Mom & Dad
	*/		
	public static String AddMoneyString(int Age,BigDecimal Current,BigDecimal Salary) {
		BigDecimal Money = Current.add(Finances.NetWorth(Age, Salary)).setScale(2);
		return Money.toString();
	}
	/*
	public static BigDecimal setUserSalary(String Job) {
		return Jobs.JobsArray.get(Job);
	}
	*/
	public static void setUserSalary(String Job) {
		CurrentPlayer.Salary = Jobs.JobsArray.get(Job);
		CurrentPlayer.Salary.round(new MathContext(2)).add(Life.CurrentPlayer.Raise).add(Life.CurrentPlayer.PettyCash);
		CurrentPlayer.StringSalary = Jobs.JobsArray.get(Job).toPlainString();
	}
	public static String PrintMoney(String Money) {
		return CurrentPlayer.StringMoney = Money;
	}
	private static void Promote() {
		if(Life.CurrentPlayer.MainSector == "Emergency") {
			Assets.JobScrips.Emergency.sector(Life.CurrentPlayer.MainSector, Life.CurrentPlayer.Sector);
		}
		else if(Life.CurrentPlayer.MainSector == "Teaching") {
			Assets.JobScrips.Degree.sector(Life.CurrentPlayer.MainSector, Life.CurrentPlayer.Sector);
		}
		else if(Life.CurrentPlayer.MainSector.equals("Services")&& Life.CurrentPlayer.Sector.equals("Fast Food")) {
			Assets.JobScrips.NonDegree.sector("Services", "Fast Food");
		}
		else if(Life.CurrentPlayer.MainSector.equals("Services")&& Life.CurrentPlayer.Sector.equals("Grocery Store")) {
			Assets.JobScrips.NonDegree.sector("Services", "Grocery Store");
		}
		else if(Life.CurrentPlayer.MainSector == "Crime") {
			Assets.JobScrips.NonDegree.sector("Crime", "Crime");
		}
		else {
			
		}
	}
	public static void RetireJob(String Job) {
		if(Life.CurrentPlayer.RetiredJobs.isEmpty()) {
			Life.CurrentPlayer.RetiredJobs.put(0, Job);
		}
		else {
			int next = Life.CurrentPlayer.RetiredJobs.size() + 1;
			Life.CurrentPlayer.RetiredJobs.put(next,Job);
		}
		Life.CurrentPlayer.Jobshad = Life.CurrentPlayer.Jobshad + 1;
	}
	public static void AgeUser(int Age,BigDecimal Money,BigDecimal Salary) {
		if(Life.CurrentPlayer.Age + 1 == Restrictions.Settings.Age) {
			if(Life.CurrentPlayer.hasChild == true) {
				Life.Sims.Parents.Dad.Firstname = Life.CurrentPlayer.Firstname;
				Life.Sims.Parents.Dad.Lastname = Life.CurrentPlayer.Lastname;
				Life.Sims.Parents.Dad.Age = Life.CurrentPlayer.yearOnlyChildBirth;
				if(Life.CurrentPlayer.Job == "") {
					Life.Sims.Parents.Dad.Job = "No Job";
				}
				else {
					Life.Sims.Parents.Dad.Job = Life.CurrentPlayer.LastJob;
				}
				Life.Sims.Parents.Mom.Firstname = Dating.CurrentDate.Firstname;
				Life.Sims.Parents.Mom.Lastname = Dating.CurrentDate.Lastname;
				Life.Sims.Parents.Mom.Age = Life.CurrentPlayer.yearOnlyChildBirth;
				if(Dating.CurrentDate.Job == "") {
					Life.Sims.Parents.Mom.Job = "No Job";
				}
				else {
					Life.Sims.Parents.Mom.Job = Dating.CurrentDate.Job;
				}
				Life.Sims.Parents.Dad.Salary = Traits.Functions.getSalary(Life.Sims.Parents.Dad.Job);
				Life.Sims.Parents.Mom.Salary = Traits.Functions.getSalary(Life.Sims.Parents.Mom.Job);
				UpdateInfo.DadInfo = Life.Sims.Parents.Dad.Firstname + " " + Life.Sims.Parents.Dad.Lastname;
				UpdateInfo.DadJob = Life.Sims.Parents.Dad.Job + ": $" + Life.Sims.Parents.Dad.Salary;
				UpdateInfo.MomInfo = Life.Sims.Parents.Mom.Firstname + " " + Life.Sims.Parents.Mom.Lastname;
				UpdateInfo.MomJob = Life.Sims.Parents.Mom.Job + ": $" + Life.Sims.Parents.Mom.Salary;
				Life.OldLife.MoneyInherited =  Life.CurrentPlayer.Money.multiply(new BigDecimal(0.20)).round(new MathContext(2)).setScale(2);
				System.out.println(Life.OldLife.MoneyInherited);
			}
		}
		if(Life.CurrentPlayer.Age == Restrictions.Settings.Retire) {
			Life.CurrentPlayer.Retirement = true;
			Life.CurrentPlayer.LastJob = Life.CurrentPlayer.Job;
			RetireJob(Life.CurrentPlayer.LastJob);
			Life.CurrentPlayer.Job = "Retired";
			Jobs.JobsArray.replace("Retired", Finances.retirementFunds());
		}
		if(Life.CurrentPlayer.Age <= 21) {
			School.Milestone(Life.CurrentPlayer.Age);
		}
		Promote();
		if(Life.CurrentPlayer.SportPlayable == true) {
			if(Sports.getSport() == "Footballl Player") {
				Assets.SportsScripts.Football.Play();
			}
			if(Sports.getSport() == "Basketball Player") {
				Assets.SportsScripts.Basketball.Play();
			}
			if(Sports.getSport() == "Baseball Player") {
				Assets.SportsScripts.Baseball.Play();
			}
		}
		if(Sports.Years == 15) {
			Life.CurrentPlayer.SportPlayable = false;
		}
		if(Life.CurrentPlayer.SportPlayable == false && Sports.Years == 15 ) {
			Collection res = Life.CurrentPlayer.SportsAwards.values();
		    Iterator i = res.iterator();
		    while (i.hasNext()) {
		    	System.out.println(i.next());
		    }
			Life.CurrentPlayer.Job = "";
		}
		Life.CurrentPlayer.Age = Age + 1;
		setUserSalary(CurrentPlayer.Job);
		BigDecimal money = AddMoney(Age,Money,Salary);
		Life.CurrentPlayer.Money = money;
		PrintMoney(AddMoneyString(Age,Money,Salary));
		Life.CurrentPlayer.PettyCash = new BigDecimal(0.00);
		Life.CurrentPlayer.Debts = new BigDecimal(0.00);
	}
	public static void AgeMom(int Age) {
		if(Life.Sims.Parents.Mom.Age >= Restrictions.Settings.Age) {
			
		}
		else {
			Life.Sims.Parents.Mom.Age = Age + 1;
		}
	}
	public static void AgeDad(int Age) {
		if(Life.Sims.Parents.Dad.Age >= Restrictions.Settings.Age) {
			
		}
		else {
			Life.Sims.Parents.Dad.Age = Age + 1;
		}
	}
	public static void Age() {
		AgeUser(Life.CurrentPlayer.Age,Life.CurrentPlayer.Money,Life.CurrentPlayer.Salary.round(new MathContext(2)));
		AgeMom(Life.Sims.Parents.Mom.Age);
		AgeDad(Life.Sims.Parents.Dad.Age);
	}
}