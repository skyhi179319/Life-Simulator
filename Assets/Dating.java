package Assets;

public class Dating {
	public static  class pickDate{
		public static String[] Name() {
			String Firstname = Life.Names.Girls.pickFirstname();
			String Lastname = Life.Names.Girls.pickLastname();
			String[] Name = {Firstname,Lastname};
			if(Lastname == Life.CurrentPlayer.Lastname) {
				return Name();
			}
			else {
				return Name;
			}
		}
	}
	public static class newDate{
		public static String Firstname;
		public static String Lastname;
		public newDate(String firstname,String lastname) {
			Firstname = firstname;
			Lastname = lastname;
		}
	}
	public static class CurrentDate{
		public static String Firstname;
		public static String Lastname;
		public static int Age;
		public CurrentDate(String firstname,String lastname,int age) {
			Firstname = firstname;
			Lastname = lastname;
			Age = age;
		}
		public static String Job = "";
		public static String OnlyChild = "";
		public static String RelationshipStatus = "";
	}
}