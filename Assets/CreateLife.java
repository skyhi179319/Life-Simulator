package Assets;
import java.math.BigDecimal;


public class CreateLife {
	public static void CreateCurrent(String Firstname,String Lastname,String Sex) {
		Life.NewPlayer Player = new Life.NewPlayer(Firstname, Lastname,Sex);
		new Life.CurrentPlayer(Player.Firstname,Player.Lastname,0,Player.Sex);
	}
	public static String pickMomJob(int Age,String Person){
		return Traits.Functions.pickParentsJob(Age,Person);
	}
	public static String pickDadJob(int Age,String Person){
		return Traits.Functions.pickParentsJob(Age,Person);
	}
	public static BigDecimal PickMomSalary() {
		return Traits.Functions.pickMomSalary();
	}
	public static BigDecimal PickDadSalary() {
		return Traits.Functions.pickDadSalary();
	}
	public static void CreateDate(String Firstname,String Lastname) {
		Dating.newDate Date = new Dating.newDate(Firstname, Lastname);
		new Dating.CurrentDate(Date.Firstname, Date.Lastname, Life.CurrentPlayer.Age);
		Dating.CurrentDate.Job = Traits.Functions.pickDateJob(Dating.CurrentDate.Age, "Mom");
	}
	public static void CreateSimChild(String Firstname,String Lastname,String Sex) {
		Life.NewPlayer Player = new Life.NewPlayer(Firstname,Life.CurrentPlayer.Lastname,Sex);
		new Life.simChild(Player.Firstname, Player.Lastname,Player.Sex);
	}
	public static void CreateChild(String Firstname) {
		Life.CurrentPlayer.Firstname = Firstname;
		Life.CurrentPlayer.Lastname = Life.simChild.Lastname;
		Ageing.UpdateInfo.UserInfo = Life.CurrentPlayer.Firstname + " " + Life.CurrentPlayer.Lastname;
	}
}