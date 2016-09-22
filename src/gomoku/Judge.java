package gomoku;

public class Judge {
	public static boolean isWin_PLeft(int[][] bodyArray, int x, int y) // ≈–∂œ ‰”Æ ∫·
	{
		int x1, y1, t = 1;
		x1 = x;
		y1 = y;
		

		for (int i = 1; i < 5; i++) {
//			if (x1 > 10) {
//				break;
//			}

			if ((x1 + i) < 15 && bodyArray[y1][x1 + i] == bodyArray[y][x]) {
				t += 1;
			} else {
				break;
			}

		}

		for (int i = 1; i < 5; i++) {
//			if (x1 < 4) {
//				break;
//			}

			if ((x1 - i) > -1 && bodyArray[y1][x1 - i] == bodyArray[y][x]) {
				t += 1;
			} else {
				break;
			}
		}

		if (t > 4) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isWin_PDown(int[][] bodyArray,int x, int y) // ≈–∂œ ‰”Æ  ˙
	{
		int x1, y1, t = 1;
		x1 = x;
		y1 = y;

		for (int i = 1; i < 5; i++) {
//			if (y1 > 10) {
//				break;
//			}
			if ((y1 + i) < 15 && bodyArray[y1 + i][x1] == bodyArray[y][x]) {
				t += 1;
			} else {
				break;
			}

		}

		for (int i = 1; i < 5; i++) {
//			if (y1 < 4) {
//				break;
//			}

			if ((y1 - i) > -1 && bodyArray[y1 - i][x1] == bodyArray[y][x]) {
				t += 1;
			} else {
				break;
			}
		}

		if (t > 4) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isWin_RUp(int[][] bodyArray,int x, int y) // ≈–∂œ ‰”Æ ”“–±
	{
		int x1, y1, t = 1;
		x1 = x;
		y1 = y;

		for (int i = 1; i < 5; i++) {
//			if (x1 > 10||y1<4) {
//				break;
//			}
			if ((x1 + i) < 15 && (y1 - i) > -1
					&& bodyArray[y1 - i][x1 + i] == bodyArray[y][x]) {
				t += 1;
			} else {
				break;
			}

		}

		for (int i = 1; i < 5; i++) {
//			if (x1 < 4||y1>10) {
//				break;
//			}

			if ((x1 - i) > -1 && (y1 + i) < 15
					&& bodyArray[y1 + i][x1 - i] == bodyArray[y][x]) {
				t += 1;
			} else {
				break;
			}
		}

		if (t > 4) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isWin_LUp(int[][] bodyArray,int x, int y) // ≈–∂œ ‰”Æ ◊Û–±
	{
		int x1, y1, t = 1;
		x1 = x;
		y1 = y;

		for (int i = 1; i < 5; i++) {
//			if (x1 > 10||y1>10) {
//				break;
//			}
			if ((x1 + i) < 15 && (y1 + i < 15)
					&& bodyArray[y1 + i][x1 + i] == bodyArray[y][x]) {
				t += 1;
			} else {
				break;
			}

		}

		for (int i = 1; i < 5; i++) {
//			if (x1 < 4||y1<4) {
//				break;
//			}

			if ((x1 - i) > -1 && (y1 - i) > -1
					&& bodyArray[y1 - i][x1 - i] == bodyArray[y][x]) {
				t += 1;
			} else {
				break;
			}
		}

		if (t > 4) {
			return true;
		} else {
			return false;
		}
	}
}
