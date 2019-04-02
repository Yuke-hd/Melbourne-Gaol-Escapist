package utility;


public class util {
	public static boolean findEle(int[] arr, int targetValue) {
		for (int s : arr) {
			if (s==(targetValue))
				return true;
		}
		return false;

	}
}
