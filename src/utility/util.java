package utility;

import java.util.Random;

import controller.GameControl;
import model.Position;

public class util {
	public static boolean findEle(int[] arr, int targetValue) {
		for (int s : arr) {
			if (s == (targetValue))
				return true;
		}
		return false;
	}

	public static int randInt(int lo, int hi) {
		Random random = new Random();
		int s = random.nextInt(hi) % (hi - lo + 1) + lo;
		return s;
	}

	public static Position randPos() {
		return new Position(randInt(1, GameControl.gameSize-1), randInt(1, GameControl.gameSize-1));
	}
	
}
