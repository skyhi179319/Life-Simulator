package Assets;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;



import java.math.BigDecimal;
import java.math.MathContext;

public class Life {
	public static class Names{
		public static class Boys{
			public static String[] Firstname = {"Joe","Skyler","David","Zane","Leo","Noah"};
			public static String[] Lastname = {"Stevens","Barr","Gibbs","Dobbs","Tyson","Hanson"};
			public static String pickFirstname() {
				Random rand = new Random();
		        int Name = rand.nextInt(5);
		        return Firstname[Name];
			}
			public static String pickLastname() {
				Random rand = new Random();
		        int Name = rand.nextInt(5);
		        return Lastname[Name];
			}
		}
		public static class Girls{
			public static String[] Firstname = {"Jade","Skylar","Zoie","Emily"};
			public static String[] Lastname = {"Jackson","Dukes","Herman","Cameron"};
			public static String pickFirstname() {
				Random rand = new Random();
		        int Name = rand.nextInt(3);
		        return Firstname[Name];
			}
			public static String pickLastname() {
				Random rand = new Random();
		        int Name = rand.nextInt(3);
		        return Lastname[Name];
			}
		}
	}
	public static class Sims{
		public static class Parents{
			public static class Mom{
				public static String Firstname = Names.Girls.pickFirstname();
				public static String Lastname = Life.CurrentPlayer.Lastname;
				public static int Age = 21;
				public static String Sex = "Female";
				public static String Job = CreateLife.pickMomJob(Age,"Mom");
				//public static BigDecimal Money = new BigDecimal(0.00);
				public static BigDecimal Salary = CreateLife.PickMomSalary();

			}
			public static class Dad{
				public static String Firstname = Names.Boys.pickFirstname();
				public static String Lastname = Life.CurrentPlayer.Lastname;
				public static int Age = 21;
				public static String Sex = "Male";
				public static String Job = CreateLife.pickDadJob(Age,"Dad");
				//public static BigDecimal Money = new BigDecimal(0.00);
				public static BigDecimal Salary = CreateLife.PickDadSalary();
			}
		}
	}
	public static class CurrentPlayer{
		public static String Firstname;
		public static String Lastname;
		public static int Age;
		public static String Sex;
		public CurrentPlayer(String firstname,String lastname,int age,String sex) {
			Firstname = firstname;
			Lastname = lastname;
			Age = age;
			Sex = sex;
		}
		public static String SchoolStatus = "";
		public static String SportsStatus = "";
		public static ArrayList<String> Activities = new ArrayList<String>();
		// School Sports Single Awards
		public static ArrayList<String> Middleschool = new ArrayList<String>();
		public static ArrayList<String> Highschool = new ArrayList<String>();
		public static ArrayList<String> College = new ArrayList<String>();
		// College Info
		public static ArrayList<String> Degrees = new ArrayList<String>();
		public static ArrayList<String> CollegeSport = new ArrayList<String>();
		public static ArrayList<String> ProSport = new ArrayList<String>();
		// Pro Sport
		public static TreeMap<Integer,String> SportsAwards = new TreeMap<Integer,String>(); 
		// Tells If Pro Sports Are Able To Be Played
		public static boolean SportPlayable;
		public static String Job = "";
		public static String LastJob = ""; // For Retirement only
		public static String MainSector = "";
		public static String Sector = "";
		public static boolean Retirement = false;
		public static int Jobshad = 0;
		public static TreeMap<Integer,String> RetiredJobs = new TreeMap<Integer,String>();
		public static BigDecimal Money = new BigDecimal(0.00);
		public static BigDecimal Raise = new BigDecimal(0.00);
		public static BigDecimal PettyCash = new BigDecimal(0.00);
		public static BigDecimal Debts = new BigDecimal(0.00);
		public static String StringMoney = "";
		public static BigDecimal Salary = new BigDecimal(0.00).round(new MathContext(2));
		public static String StringSalary = "";
		public static int CrimesCommitedWOJail = 0;
		public static int CrimesCommitedWJail = 0;
		public static boolean CaughtInCrime = false;
		public static boolean Jail = false;
		public static int YearsMustServe = 0;
		public static String Crime = "";
		public static String Dating = "";
		public static String RelationshipStatus = ""; 
		public static boolean isMarried = false; 
		public static int yearOnlyChildBirth;
		public static String OnlyChildName = "";
		public static boolean hasChild = false;
	}
	public static class simChild{
		public static String Firstname;
		public static String Lastname;
		public static String Sex;
		public simChild(String firstname,String lastname,String sex) {
			Firstname = firstname;
			Lastname = lastname;
			Sex = sex;
		}
	}
	public static class OldLife{
		public static int InheritAge = 18;
		public static BigDecimal MoneyInherited = new BigDecimal(0); 
	}
	public static class NewPlayer{
		public static String Firstname;
		public static String Lastname;
		public static String Sex;
		public NewPlayer(String firstname,String lastname,String sex) {
			Firstname = firstname;
			Lastname = lastname;
			Sex = sex;
		}
	}
}