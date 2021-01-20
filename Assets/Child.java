package Assets;

import java.util.Random;

public class Child {
	public static class haveChild {
		public static boolean born() {
			boolean[] chances = {true,true,true,false,false};
			Random rand = new Random();
	        int picked = rand.nextInt(4);
	        return chances[picked];
		}
	}
}