package Assets.SchoolScripts;

import java.util.Random;

public class College {
	public static int years = 0;
	public static String chooseSportsPlacement() {
		String[] Sports = {"Co-Captian","Captian"};
		Random rand = new Random();
        int picked = rand.nextInt(1);
        return Sports[picked];
	}
}