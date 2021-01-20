package Assets.JobScrips;

import java.math.BigDecimal;

import Assets.Finances;
import Assets.Life;

public class NonDegree {
	public static class Crime{
		public static void addMoney(BigDecimal PettyCash) {
			Life.CurrentPlayer.PettyCash = PettyCash.add(PettyCash);
		}
		public static class DrugDealer{
			private static int Years;
			private static void Worked() {
				Years = Years + 1;
			}
			private static void raiseDrugDealer() {
				Worked();
				if(Life.CurrentPlayer.Job == "Drug Dealer") {
					if(Years == 10) {
						Finances.Raise("Drug Dealer");
					}
					if(Years == 15) {
						Finances.Raise("Drug Dealer");
					}
					if(Years == 18){
						Finances.Raise("Drug Dealer");
					}
					if(Years >= 21) {
						Finances.Raise("Drug Dealer");
					}
				}
			}
		}
		public static class Robber{
			private static int Years;
			private static void Worked() {
				Years = Years + 1;
			}
			private static void raiseRobber() {
				Worked();
				if(Life.CurrentPlayer.Job == "Robber") {
					if(Years == 10) {
						Finances.Raise("Robber");
					}
					if(Years == 15) {
						Finances.Raise("Robber");
					}
					if(Years == 18) {
						Finances.Raise("Robber");
					}
					if(Years >= 21) {
						Finances.Raise("Robber");
					}
				}
			}
		}
		private static void Promote() {
			if(Life.CurrentPlayer.Job == "Drug Dealer") {
				DrugDealer.raiseDrugDealer();
			}
			if(Life.CurrentPlayer.Job == "Robber") {
				Robber.raiseRobber();
			}
		}
	}
	public static class FastFood{
		private static int Years;
		private static void Worked() {
			Years = Years + 1;
		}
		private static void raiseFastFood() {
			Worked();
			if(Life.CurrentPlayer.Job == "Fast Food") {
				if(Years == 10) {
					Finances.Raise("Fast Food");
				}
				if(Years == 15) {
					Finances.Raise("Fast Food");
				}
				if(Years == 18) {
					Finances.Raise("Fast Food");
				}
				if(Years >= 21) {
					Finances.Raise("Fast Food");
				}
			}
		}
	}
	public static class GroceryStore{
		private static int Years;
		private static void Worked() {
			Years = Years + 1;
		}
		private static void raiseGrocery() {
			Worked();
			if(Life.CurrentPlayer.Job == "Grocery Store") {
				if(Years == 10) {
					Finances.Raise("Grocery Store");
				}
				if(Years == 15) {
					Finances.Raise("Grocery Store");
				}
				if(Years == 18) {
					Finances.Raise("Grocery Store");
				}
				if(Years >= 21) {
					Finances.Raise("Grocery Store");
				}
			}
		}
	}
	public static void sector(String MainSector,String Sector) {
		if(MainSector == "Crime") {
			Crime.Promote();
		}
		if(Sector == "Fast Food") {
			FastFood.raiseFastFood();
		}
		if(Sector == "Grocery Store") {
			GroceryStore.raiseGrocery();
		}
	}
}