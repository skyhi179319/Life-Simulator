package Assets;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map.Entry;

import Assets.Life.CurrentPlayer;

public class Finances {
	private static BigDecimal Tax = new BigDecimal(0.10);
	//private static Double Tax = .10;
	private static BigDecimal Bills = new BigDecimal(10000.00);
	public static BigDecimal TaxesOwe(BigDecimal amount) {
		BigDecimal tax = amount.multiply(Tax);
		return tax;
	}
	public static BigDecimal StringSalary(String Salary) {
		Double val = Double.valueOf(Salary);
		BigDecimal salary = BigDecimal.valueOf(val).round(new MathContext(2));
		return salary.setScale(2);
	}
	public static BigDecimal NetPay(BigDecimal salary) {
		BigDecimal net = salary.subtract(TaxesOwe(StringSalary(Life.CurrentPlayer.StringSalary)));
		return net.round(new MathContext(2)).setScale(2);
	}
	public static BigDecimal Pay(int age,BigDecimal salary) {
		if(age < Restrictions.Settings.Taxes) {
			return StringSalary(Life.CurrentPlayer.StringSalary).setScale(2);
		}
		else {
			return NetPay(StringSalary(Life.CurrentPlayer.StringSalary)).setScale(2);
		}
	}
	public static BigDecimal NetGain(int age,BigDecimal salary) {
		if(age < Restrictions.Settings.MoveOut) {
			return Pay(age,StringSalary(Life.CurrentPlayer.StringSalary)).setScale(2);
		}
		else if(Life.CurrentPlayer.Jail == true) {
			return Pay(age,StringSalary(Life.CurrentPlayer.StringSalary)).setScale(2);
		}
		else {
			BigDecimal money = Pay(age,StringSalary(Life.CurrentPlayer.StringSalary));
			return money.subtract(Bills.add(Life.CurrentPlayer.Debts)).setScale(2);
		}
	}
	public static BigDecimal NetWorth(int age, BigDecimal salary) {
		return NetGain(age,StringSalary(Life.CurrentPlayer.StringSalary)).setScale(2);
	}
	/*
	 * Isolating Salary From a String to a Double to A BigDecimal
	 */
	private static BigDecimal Raises = new BigDecimal(1);
	public static BigDecimal Raise(String Job) {
		if(Life.CurrentPlayer.Raise == new BigDecimal(0.0)) {
			return new BigDecimal(0.0);
		}
		else {
			BigDecimal Salary = Jobs.JobsArray.get(Job);
			BigDecimal Total = Salary.multiply(new BigDecimal(.01)).multiply(Raises).add(Life.CurrentPlayer.Raise);
			Life.CurrentPlayer.Raise = Total.round(new MathContext(2));
			return Life.CurrentPlayer.Raise.setScale(2);
		}
	}
	public static BigDecimal retirementFunds() {
		String Job = Life.CurrentPlayer.LastJob;
		BigDecimal Salary = Jobs.JobsArray.get(Job);
		BigDecimal Funds = Salary.add(Life.CurrentPlayer.Raise).multiply(Raises);
		return Funds.round(new MathContext(2)).setScale(2);
	}
}