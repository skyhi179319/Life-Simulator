package Assets;

import java.math.BigDecimal;
import java.util.Random;

public class Traits {
	public static class Criminals{
		private static String[] Jobs = {"Drug Dealer","Robber"};
	}
	public static class Emergency{
		private static String[] Area = {"Police","Fire","Hospital"}; 
		private static String[] Police = {"Patrolman","Sergeant","Lieutenant","Assistant Cheif","Cheif"};
		private static String[] Fire = {"Probation","Firefighter","Lieutenant","Battalion Chief","Assistant Cheif","Cheif"};
		private static String[] Hospital = {"Nurse","Surgeon","Doctor"};
	}
	public static String CriminalJob(int Age,String Person) {
		Random rand = new Random();
        int Job = rand.nextInt(1);
		if(Age >= Restrictions.Jobs.Crime) {
			return Criminals.Jobs[Job];
		}
		else {
			if(Person == "Mom") {
				return Traits.Functions.pickParentsJob(Age,Person);
			}
			if(Person == "Dad") {
				return Traits.Functions.pickParentsJob(Age,Person);
			}
		}
		return CriminalJob(Age,Person);
	}
	public static String EmergencyArea() {
		Random rand = new Random();
        int Area = rand.nextInt(2);
		return Emergency.Area[Area];
	}
	public static String EmergencyJob(int Age,String Person) {
		if(EmergencyArea() == "Police" && Age >= Restrictions.Jobs.Police) {
			Random rand = new Random();
	        int Job = rand.nextInt(4);
	        return "Police " + Emergency.Police[Job];
		}
		else {
			if(Person == "Mom") {
				return Traits.Functions.pickParentsJob(Age,Person);
			}
			if(Person == "Dad") {
				return Traits.Functions.pickParentsJob(Age,Person);
			}
		}
		if(EmergencyArea() == "Fire" && Age >= Restrictions.Jobs.Emergency) {
			Random rand = new Random();
	        int Job = rand.nextInt(5);
	        return "Fire " + Emergency.Fire[Job];
		}
		else {
			if(Person == "Mom") {
				return Traits.Functions.pickParentsJob(Age,Person);
			}
			if(Person == "Dad") {
				return Traits.Functions.pickParentsJob(Age,Person);
			}
		}
		if(EmergencyArea() == "Hospital" && Age >= Restrictions.Jobs.Emergency) {
			Random rand = new Random();
	        int Job = rand.nextInt(2);
	        return Emergency.Hospital[Job];
		}
		else {
			if(Person == "Mom") {
				return Traits.Functions.pickParentsJob(Age,Person);
			}
			if(Person == "Dad") {
				return Traits.Functions.pickParentsJob(Age,Person);
			}
		}
		return EmergencyJob(Age,Person);
	}
	public static class Sports{
		private static String[] Jobs = {"Football","Basketball","Baseball"};
	}
	public static String SportsJob(int Age,String Person) {
		Random rand = new Random();
        int Job = rand.nextInt(2);
        if(Person == "Mom" && Sports.Jobs[Job] == "Football") {
        	return Traits.Functions.pickParentsJob(Age,Person);
        }
        else {
        	return Sports.Jobs[Job] + " Player";
        }
	}
	public static class Teaching{
		public static String[] Area = {"Primary","College"};
		public static String[] Primary = {"Elementary","Middleschool","Highschool"};
		public static String[] College = {"Professor","Adjuct","Dean"};
	}
	public static String TeachingArea() {
		Random rand = new Random();
        int Area = rand.nextInt(1);
		return Teaching.Area[Area];
	}
	public static String TeachingJob(int Age,String Person) {
		if(TeachingArea() == "Primary") {
			Random rand = new Random();
	        int Job = rand.nextInt(2);
	        if(Age >= Restrictions.Jobs.Teaching) {
	        	return Teaching.Primary[Job] + " Teacher";
	        }
	        else {
	        	return Traits.Functions.pickParentsJob(Age,Person);
	        }
		}
		if(TeachingArea() == "College") {
			Random rand = new Random();
	        int Job = rand.nextInt(2);
			return Teaching.College[Job];
		}
		return TeachingJob(Age,Person);
	}
	public static class Government{
		public static String[] Jobs = {"Governor","President"};
	}
	public static String GovernmentJob(int Age,String Person) {
		Random rand = new Random();
        int Jobs = rand.nextInt(1);
        if(Government.Jobs[Jobs] == "Governor" && Age >= Restrictions.Jobs.Govenor) {
        	return Government.Jobs[Jobs];
        }
        else {
        	return Traits.Functions.pickParentsJob(Age,Person);
        }
	}
	public static class NonDegree{
		public static String[] Jobs = {"Fast Food","Grocery Store"};
	}
	public static String NonDegreeJob(int Age, String Person) {
		Random rand = new Random();
        int Job = rand.nextInt(2);
        if(Age >= Restrictions.Jobs.Nondgree) {
        	return NonDegree.Jobs[Job];
        }
		return NonDegreeJob(Age,Person);
	}
	public static class Functions extends Life{
		public static String[] Sectors= {"Crime","Emergency","Sports","Teaching","Government","NonDegree"};
		public static String pickParentsJob(int Age,String Person) {
			Random rand = new Random();
	        int Sector = rand.nextInt(5);
	        if(Sectors[Sector] == "Crime") {
	        	return CriminalJob(Age,Person);
	        }
	        if(Sectors[Sector] == "Emergency") {
	        	return EmergencyJob(Age,Person);
	        }
	        if(Sectors[Sector] == "Sports") {
	        	return SportsJob(Age,Person);
	        }
	        if(Sectors[Sector] == "Teaching") {
	        	return TeachingJob(Age,Person);
	        }
	        if(Sectors[Sector] == "Government") {
	        	return GovernmentJob(Age,Person);
	        }
	        if(Sectors[Sector] == "NonDegree") {
	        	return NonDegreeJob(Age,Person);
	        }
			return pickParentsJob(Age,Person);
		}
		public static String pickDateJob(int Age,String Person) {
			Random rand = new Random();
	        int Sector = rand.nextInt(5);
	        if(Sectors[Sector] == "Crime") {
	        	return CriminalJob(Age,Person);
	        }
	        if(Sectors[Sector] == "Emergency") {
	        	return EmergencyJob(Age,Person);
	        }
	        if(Sectors[Sector] == "Sports") {
	        	return SportsJob(Age,Person);
	        }
	        if(Sectors[Sector] == "Teaching") {
	        	return TeachingJob(Age,Person);
	        }
	        if(Sectors[Sector] == "Government") {
	        	return GovernmentJob(Age,Person);
	        }
	        if(Sectors[Sector] == "NonDegree") {
	        	return NonDegreeJob(Age,Person);
	        }
			return pickDateJob(Age,Person);
		}
		public static BigDecimal pickMomSalary() {
			try{
				String Job = Life.Sims.Parents.Mom.Job;
				if(Jobs.JobsArray.containsKey(Job)) {
					return Jobs.JobsArray.get(Job);
				}
			}
			catch(StackOverflowError e) {
				System.out.println(e);
				Life.Sims.Parents.Mom.Job = CreateLife.pickMomJob(Life.Sims.Parents.Mom.Age, "Mom");
				String Job = Life.Sims.Parents.Mom.Job;
				if(Jobs.JobsArray.containsKey(Job)) {
					return Jobs.JobsArray.get(Job);
				}
			}
			return pickMomSalary();
		}
		public static BigDecimal pickDadSalary() {
			try {
				String Job = Life.Sims.Parents.Dad.Job;
				if(Jobs.JobsArray.containsKey(Job)) {
					return Jobs.JobsArray.get(Job);
				}
			}
			catch(StackOverflowError e) {
				System.out.println(e);
				Life.Sims.Parents.Mom.Job = CreateLife.pickDadJob(Life.Sims.Parents.Dad.Age, "Dad");
				String Job = Life.Sims.Parents.Dad.Job;
				if(Jobs.JobsArray.containsKey(Job)) {
					return Jobs.JobsArray.get(Job);
				}
			}
			return pickDadSalary();
		}
		public static BigDecimal getSalary(String Job) {
			if(Jobs.JobsArray.containsKey(Job)) {
				return Jobs.JobsArray.get(Job);
			}
			return getSalary(Job);
		}
		public static void resetUser() {
			Life.CurrentPlayer.Age = 0;
			Life.CurrentPlayer.Sex = "";
			Life.CurrentPlayer.Activities.clear();
			Life.CurrentPlayer.CaughtInCrime = false;
			Life.CurrentPlayer.College.clear();
			Life.CurrentPlayer.CollegeSport.clear();
			Life.CurrentPlayer.CrimesCommitedWJail = 0;
			Life.CurrentPlayer.CrimesCommitedWOJail = 0;
			Life.CurrentPlayer.Dating = "";
			Life.CurrentPlayer.Debts = new BigDecimal(0.00);
			Life.CurrentPlayer.Degrees.clear();
			Life.CurrentPlayer.hasChild = false;
			Life.CurrentPlayer.Highschool.clear();
			Life.CurrentPlayer.isMarried = false;
			Life.CurrentPlayer.Jail = false;
			Life.CurrentPlayer.Job = "";
			Life.CurrentPlayer.LastJob = "";
			Life.CurrentPlayer.MainSector = "";
			Life.CurrentPlayer.Middleschool.clear();
			Life.CurrentPlayer.Money = new BigDecimal(0.00);
			Life.CurrentPlayer.OnlyChildName = "";
			Life.CurrentPlayer.PettyCash = new BigDecimal(0.00);
			Life.CurrentPlayer.ProSport.clear();
			Life.CurrentPlayer.Raise = new BigDecimal(0.00);
			Life.CurrentPlayer.RelationshipStatus = "";
			Life.CurrentPlayer.RetiredJobs.clear();
			Life.CurrentPlayer.Retirement = false;
			Life.CurrentPlayer.Salary = new BigDecimal(0.00);
			Life.CurrentPlayer.SchoolStatus = "";
			Life.CurrentPlayer.Sector = "";
			Life.CurrentPlayer.SportPlayable = false;
			Life.CurrentPlayer.SportsAwards.clear();
			Life.CurrentPlayer.SportsStatus = "";
			Life.CurrentPlayer.StringMoney = "";
			Life.CurrentPlayer.StringSalary = "";
			Life.CurrentPlayer.yearOnlyChildBirth = 0;
			Life.CurrentPlayer.YearsMustServe = 0;
		}
	}
}