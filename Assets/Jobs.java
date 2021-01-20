package Assets;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

public class Jobs extends Salary{
	public static TreeMap<String,BigDecimal> JobsArray = new TreeMap<String,BigDecimal>(); 
	public static class Crime{
		public static class Local{
			public static class DrugDealer{
				public static String Job = "Drug Dealer";
				public static BigDecimal Salary = new BigDecimal(25000.00);
			}
			public static class Robber{
				public static String Job = "Robber";
				public static BigDecimal Salary = new BigDecimal(10000.00);
			}
		}
	}
	public static class Emergency{
		public static class Police{
			public static class Patrolman{
				public static String Job = "Police Patrolman";
				public static BigDecimal Salary = new BigDecimal(27500.00);
			}
			public static class Sergeant{
				public static String Job = "Police Sergeant";
				public static BigDecimal Salary = new BigDecimal(30000.00);
			}
			public static class Lieutenant{
				public static String Job = "Police Lieutenant";
				public static BigDecimal Salary = new BigDecimal(32500.00);
			}
			public static class AssistantCheif{
				public static String Job = "Assistant Cheif";
				public static BigDecimal Salary = new BigDecimal(37500.00);
			}
			public static class Cheif{
				public static String Job = "Police Cheif";
				public static BigDecimal Salary = new BigDecimal(40000.00);
			}
		}
		public static class Fire{
			public static class Probation{
				public static String Job = "Probation Firefighter";
				public static BigDecimal Salary = new BigDecimal(27500.00);
			}
			public static class Firefighter{
				public static String Job = "Firefighter";
				public static BigDecimal Salary = new BigDecimal(30000.00);
			}
			public static class Lieutenant{
				public static String Job = "Fire Lieutenant";
				public static BigDecimal Salary = new BigDecimal(32500.00);
			}
			public static class BattalionChief{
				public static String Job = "Battalion Chief";
				public static BigDecimal Salary = new BigDecimal(35000.00);
			}
			public static class AssistantCheif{
				public static String Job = "Fire Assistiant Cheif";
				public static BigDecimal Salary = new BigDecimal(37500.00);
			}
			public static class Cheif{
				public static String Job = "Fire Cheif";
				public static BigDecimal Salary = new BigDecimal(40000.00);
			}
		}
		public static class Hospital{
			public static class Nurse{
				public static String Job = "Nurse";
				public static BigDecimal Salary = new BigDecimal(27500.00);
			}
			public static class Surgeon{
				public static String Job = "Surgeon";
				public static BigDecimal Salary = new BigDecimal(30000.00);
			}
			public static class Doctor{
				public static String Job = "Doctor";
				public static BigDecimal Salary = new BigDecimal(35000.00);
			}
		}
	}
	public static class Sports{
		public static class Football{
			public static String Job = "Football Player";
			public static BigDecimal Salary = new BigDecimal(1000000.00);
		}
		public static class Basketball{
			public static String Job = "Basketball Player";
			public static BigDecimal Salary = new BigDecimal(1000000.00);
		}
		public static class Baseball{
			public static String Job = "Baseball Player";
			public static BigDecimal Salary = new BigDecimal(1000000.00);
		}
	}
	public static class Teaching{
		public static class Elementary{
			public static String Job = "Elementary Teacher";
			public static BigDecimal Salary = new BigDecimal(30000.00);
		}
		public static class MiddleSchool{
			public static String Job = "Middleschool Teacher";
			public static BigDecimal Salary = new BigDecimal(32500.00);
		}
		public static class HighSchool{
			public static String Job = "Highschool Teahcer";
			public static BigDecimal Salary = new BigDecimal(35000.00);
		}
		public static class College{
			public static class Professor{
				public static String Job = "Prefessor";
				public static BigDecimal Salary = new BigDecimal(35000.00);
			}
			public static class Adjuct{
				public static String Job = "Adjuct";
				public static BigDecimal Salary = new BigDecimal(30000.00);
			}
			public static class Dean{
				public static String Job = "Dean";
				public static BigDecimal Salary = new BigDecimal(40000.00);
			}
		}
	}
	public static class Government{
		public static class Governor{
			public static String Job = "Governor";
			public static BigDecimal Salary = new BigDecimal(40000.00);
		}
		public static class Presidemt{
			public static String Job = "President";
			public static BigDecimal Salary = new BigDecimal(50000.00);
		}
	}
	public static class NonDegree{
		public static class FastFood{
			public static String Job = "Fast Food";
			public static BigDecimal Salary = new BigDecimal(20000.00);
		}
		public static class GroceryStore{
			public static String Job = "Grocery Store";
			public static BigDecimal Salary = new BigDecimal(25000.00);
		}
		public static class GasStation{
			public static String Job = "Gas Station";
			public static BigDecimal Salary = new BigDecimal(25000.00);
		}
		public static class SuperMarket{
			public static String Job = "Super Market";
			public static BigDecimal Salary = new BigDecimal(30000.00);
		}
		public static class Marketer{
			public static String Job = "Marketer";
			public static BigDecimal Salary = new BigDecimal(35000.00);
		}
	}
	public static class Degree{
		public static class Programmer{
			public static String Job = "Programmer";
			public static BigDecimal Salary = new BigDecimal(45000.00);
		}
		public static class Pastor{
			public static String Job = "Pastor";
			public static BigDecimal Salary = new BigDecimal(35000.00);
		}
		public static class Scientist{
			public static String Job = "Scientist";
			public static BigDecimal Salary = new BigDecimal(50000.00);
		}
	}
	public static void Populate() {
		JobsArray.put(Crime.Local.DrugDealer.Job, Crime.Local.DrugDealer.Salary);
		JobsArray.put(Crime.Local.Robber.Job,Crime.Local.Robber.Salary);
		JobsArray.put(Emergency.Police.Patrolman.Job, Emergency.Police.Patrolman.Salary);
		JobsArray.put(Emergency.Police.Sergeant.Job, Emergency.Police.Sergeant.Salary);
		JobsArray.put(Emergency.Police.Lieutenant.Job, Emergency.Police.Lieutenant.Salary);
		JobsArray.put(Emergency.Police.AssistantCheif.Job, Emergency.Police.AssistantCheif.Salary);
		JobsArray.put(Emergency.Police.Cheif.Job, Emergency.Police.Cheif.Salary);
		JobsArray.put(Emergency.Fire.Probation.Job, Emergency.Fire.Probation.Salary);
		JobsArray.put(Emergency.Fire.Firefighter.Job, Emergency.Fire.Firefighter.Salary);
		JobsArray.put(Emergency.Fire.Lieutenant.Job, Emergency.Fire.Lieutenant.Salary);
		JobsArray.put(Emergency.Fire.BattalionChief.Job, Emergency.Fire.BattalionChief.Salary);
		JobsArray.put(Emergency.Fire.AssistantCheif.Job, Emergency.Fire.AssistantCheif.Salary);
		JobsArray.put(Emergency.Fire.Cheif.Job, Emergency.Fire.Cheif.Salary);
		JobsArray.put(Emergency.Hospital.Nurse.Job, Emergency.Hospital.Nurse.Salary);
		JobsArray.put(Emergency.Hospital.Surgeon.Job, Emergency.Hospital.Surgeon.Salary);
		JobsArray.put(Emergency.Hospital.Doctor.Job, Emergency.Hospital.Doctor.Salary);
		JobsArray.put(Sports.Football.Job, Sports.Football.Salary);
		JobsArray.put(Sports.Basketball.Job, Sports.Basketball.Salary);
		JobsArray.put(Sports.Baseball.Job, Sports.Baseball.Salary);
		JobsArray.put(Teaching.Elementary.Job, Teaching.Elementary.Salary);
		JobsArray.put(Teaching.MiddleSchool.Job, Teaching.MiddleSchool.Salary);
		JobsArray.put(Teaching.HighSchool.Job, Teaching.HighSchool.Salary);
		JobsArray.put(Teaching.College.Professor.Job, Teaching.College.Professor.Salary);
		JobsArray.put(Teaching.College.Adjuct.Job, Teaching.College.Adjuct.Salary);
		JobsArray.put(Teaching.College.Dean.Job, Teaching.College.Dean.Salary);
		JobsArray.put(Government.Governor.Job, Government.Governor.Salary);
		JobsArray.put(Government.Presidemt.Job, Government.Presidemt.Salary);
		JobsArray.put(NonDegree.FastFood.Job, NonDegree.FastFood.Salary);
		JobsArray.put(NonDegree.GroceryStore.Job,NonDegree.GroceryStore.Salary);
		JobsArray.put(NonDegree.GasStation.Job, NonDegree.GasStation.Salary);
		JobsArray.put(NonDegree.SuperMarket.Job, NonDegree.SuperMarket.Salary);
		JobsArray.put(NonDegree.Marketer.Job,NonDegree.Marketer.Salary);
		JobsArray.put(Degree.Programmer.Job, Degree.Programmer.Salary);
		JobsArray.put(Degree.Pastor.Job,Degree.Pastor.Salary);
		JobsArray.put(Degree.Scientist.Job,Degree.Scientist.Salary);
		JobsArray.put("No Job", new BigDecimal(0.00));
		JobsArray.put("", new BigDecimal(0.00));
		JobsArray.put("Retired", new BigDecimal(0.00));
	}
	public static String[] FindJob(int age,ArrayList<String> Degree) {
		String[] DegreeAlts = {NonDegree.GroceryStore.Job,Crime.Local.DrugDealer.Job,Emergency.Police.Patrolman.Job};
		if(Degree.isEmpty() && Life.CurrentPlayer.Retirement == false) {
			if(age >= 21) {
				String[] Set1 = {NonDegree.FastFood.Job,Emergency.Police.Patrolman.Job,Crime.Local.Robber.Job};
				String[] Set2 = {Emergency.Fire.Probation.Job,Crime.Local.DrugDealer.Job,NonDegree.GroceryStore.Job};
				String[][] Set = {Set1,Set2};
				Random rand = new Random();
		        int picked = rand.nextInt(1);
		        return Set[picked];
			}
			if(age >= 14) {
				String[] Results = {NonDegree.FastFood.Job,NonDegree.GroceryStore.Job,NonDegree.SuperMarket.Job};
				return Results;
			}
			if(age <= 13) {
				String[] Results = {"No Job"};
				return Results;
			}
			if(age >= 18) {
				String[] Results = {NonDegree.Marketer.Job,NonDegree.GasStation.Job};
				return Results;
			}
		}
		if(!Degree.isEmpty() && Life.CurrentPlayer.Retirement == false) {
			if(age <= 21){
				String[] Set1 = {NonDegree.FastFood.Job,Emergency.Police.Patrolman.Job,Crime.Local.Robber.Job};
				String[] Set2 = {Emergency.Fire.Probation.Job,Crime.Local.DrugDealer.Job,NonDegree.GroceryStore.Job};
				String[][] Set = {Set1,Set2};
				Random rand = new Random();
		        int picked = rand.nextInt(1);
		        return Set[picked];
			}
		}
		if(Degree.get(0) == "IT" && Life.CurrentPlayer.Retirement == false ) {
			String[] Results = {Jobs.Degree.Programmer.Job,DegreeAlts[0],DegreeAlts[1]};
			return Results;
		}
		if(Degree.get(0) == "Computer Science" && Life.CurrentPlayer.Retirement == false) {
			String[] Results = {Jobs.Degree.Programmer.Job,DegreeAlts[0],DegreeAlts[1],DegreeAlts[2]};
			return Results;
		}
		if(Degree.get(0) == "Medical" && Life.CurrentPlayer.Retirement == false) {
			String[] Results = {Jobs.Emergency.Hospital.Nurse.Job,Jobs.Emergency.Hospital.Surgeon.Job, Jobs.Emergency.Hospital.Doctor.Job,DegreeAlts[0],DegreeAlts[1]};
			return Results;
		}
		if(Degree.get(0) == "Religeous Studies" && Life.CurrentPlayer.Retirement == false) {
			String[] Results = {Jobs.Degree.Pastor.Job,DegreeAlts[0],DegreeAlts[1],DegreeAlts[2]};
			return Results;
		}
		if(Degree.get(0) == "Biology" && Life.CurrentPlayer.Retirement == false) {
			String[] Results = {Jobs.Degree.Scientist.Job,DegreeAlts[0],DegreeAlts[1]};
			return Results;
		}
		if(Degree.get(0) == "Physics" && Life.CurrentPlayer.Retirement == false) {
			String[] Results = {Jobs.Degree.Scientist.Job,DegreeAlts[0],DegreeAlts[1]};
			return Results;
		}
		if(Degree.get(0) == "Teaching" && Life.CurrentPlayer.Retirement == false) {
			String[] Set1 = {Jobs.Teaching.Elementary.Job,Jobs.Teaching.MiddleSchool.Job,Jobs.Teaching.HighSchool.Job};
			String[] Set2 = {Teaching.College.Professor.Job,Teaching.College.Adjuct.Job,Teaching.College.Dean.Job};
			String[][] Set = {Set1,Set2};
			Random rand = new Random();
	        int picked = rand.nextInt(1);
	        return Set[picked];
		}
		if(Degree.get(0) == "Art" && Life.CurrentPlayer.Retirement == false) {
			String[] Results = {Teaching.Elementary.Job,Teaching.MiddleSchool.Job,Teaching.HighSchool.Job};
			return Results;
		}
		if(Degree.get(0) == "Law" && Life.CurrentPlayer.Retirement == false) {
			String[] Results = {Emergency.Police.Patrolman.Job,Emergency.Police.Sergeant.Job,DegreeAlts[0],DegreeAlts[1]};
			return Results;
		}
		if(age >= 22) {
			Jobs.FindAdvanceJobs(age, Degree);
			String[] Advance = Jobs.FindAdvanceJobs(age, Degree);
			Life.CurrentPlayer.Debts = new BigDecimal(100.00);
			return Advance;
		}
		System.out.println(Jobs.FindAdvanceJobs(age, Degree));
		return FindJob(age,Degree);
	}
	private static ArrayList<String> AdvanceSearch(int age, ArrayList<String> Degree){
		ArrayList<String> Jobs = new ArrayList<String>();
		String[] possibleDegreeJobs = FindJob(age,Degree);
		if(Degree.isEmpty()) {
			if(age >= 14) {
				Jobs.add(NonDegree.FastFood.Job);
				Jobs.add(NonDegree.GroceryStore.Job);
				Jobs.add(NonDegree.SuperMarket.Job);
			}
			if(age >= 18) {
				Jobs.add(NonDegree.GasStation.Job);

				Jobs.add(NonDegree.Marketer.Job);
			}
			if(age >= 21) {
				Jobs.add(Emergency.Police.Patrolman.Job);
				Jobs.add(Emergency.Fire.Probation.Job);
			}
		}
		if(!Degree.isEmpty()) {
			if(age == 21) {
				Jobs.add("No Jobs");
			}
			if(age >= 22) {
				for(String i: possibleDegreeJobs) {
					if(!Jobs.contains(i)) {
						Jobs.add(i);
					}
				}
			}
			if(age >= Restrictions.Jobs.Govenor) {
				Jobs.add(Government.Governor.Job);
			}
			if(age >= Restrictions.Jobs.President) {
				Jobs.add(Government.Presidemt.Job);
			}
		}
		return Jobs;
	}
	private static int pickNumber(int size) {
		Random rand = new Random();
        int picked = rand.nextInt(size);
        return picked;
	}
	public static String[] FindAdvanceJobs(int age, ArrayList<String> Degree) {
		ArrayList<String> JobSearch = AdvanceSearch(age,Degree);
		ArrayList<String> Jobs = new ArrayList<String>();
		/*
		int i = 0;
		while(i < Jobs.size() - 1) {
			Jobs.add(JobSearch.get(i));
			i++;
		}
		*/
		String[] results = {JobSearch.get(pickNumber(JobSearch.size() - 1)),JobSearch.get(pickNumber(JobSearch.size() - 1))};
		return results;
	}
	private static void setSector(String Job) {
		String[] secondary = {Jobs.Teaching.Elementary.Job,Jobs.Teaching.MiddleSchool.Job,Jobs.Teaching.HighSchool.Job};
		String[] College = {Jobs.Teaching.College.Adjuct.Job,Jobs.Teaching.College.Professor.Job,Jobs.Teaching.College.Dean.Job};
		if(Job.contains("Police")) {
			Life.CurrentPlayer.MainSector = "Emergency";
			Life.CurrentPlayer.Sector = "Police";
		}
		else if(Job.contains("Fire") || Job.equals("Battalion Cheif")) {
			Life.CurrentPlayer.MainSector = "Emergency";
			Life.CurrentPlayer.Sector = "Fire";
		}
		else if(Job.equals("Nurse") || Job.equals("Surgeon") || Job.equals("Doctors")) {
			Life.CurrentPlayer.MainSector = "Emergency";
			Life.CurrentPlayer.Sector = "Hospitial";
		}
		// Add Teaching Section with Arrays
		else if(Job.equals(secondary[0])||Job.equals(secondary[1])||Job.equals(secondary[2])
				||Job.equals(College[0])||Job.equals(College[1])||Job.equals(College[2])){
			Life.CurrentPlayer.MainSector = "Teaching";
			Life.CurrentPlayer.Sector = "Teaching";
		}
		else if(Job.equals(NonDegree.FastFood.Job)) {
			Life.CurrentPlayer.MainSector = "Services";
			Life.CurrentPlayer.Sector = "Fast Food";
		}
		else if(Job.equals(NonDegree.GroceryStore.Job)) {
			Life.CurrentPlayer.MainSector = "Services";
			Life.CurrentPlayer.Sector = "Grocery Store";
		}
		else if(Job.equals(Crime.Local.DrugDealer.Job)||Job.equals(Crime.Local.Robber.Job)) {
			Life.CurrentPlayer.MainSector = "Crime";
			Life.CurrentPlayer.Sector = "Crime";
		}
		else {
			
		}
	}
	public static String pickJob(String Job) {
		if(Life.CurrentPlayer.Job == "") {
			return Life.CurrentPlayer.Job = Job;
		}
		else {
			Ageing.RetireJob(Life.CurrentPlayer.Job);
			setSector(Job);
			return Life.CurrentPlayer.Job = Job;
		}
	}
}