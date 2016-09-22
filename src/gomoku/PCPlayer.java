package gomoku;


//传入的棋盘为17*17，实际阶数为15

public class PCPlayer {
	public static final int MAX_VALUE = 99999999;
	public static final int MIN_VALUE = -99999999;
	public static final int ORDER = 15, SQUARE_ORDER = 225;
	public static boolean timeOut = false;

	// 新增x，y代表对方上一局坐标
	public static int PcOutput(int board[][], int side, int depth,
			int character, int x, int y) {
		int maxevaluationW = -9999999;
		int maxevaluationB = -9999999;
		int minevaluationW = 9999999;
		int minevaluationB = 9999999;
		int maxvalue = -99999999;
		int minvalue = 99999999;
		// charcter值越高，攻击性越强，介于2到9之间
		// maxvalue计算分别站在己方和对方角度考虑得到的估值差，考虑到计算机性格，
		int pitnumber = 0;

		for (int i = 1; i < ORDER + 1; i++) {
			for (int j = 1; j < ORDER + 1; j++) {
				if (isnecessary(board, i, j)) {
					// makemove
					board[i][j] = side;
					// 若棋子可以直接致胜，则直接跳出，无需多判断
					if (isWin_PLeft(i, j, board) || isWin_PDown(i, j, board)
							|| isWin_RUp(i, j, board) || isWin_LUp(i, j, board)) {
						pitnumber = i * (ORDER + 2) + j;
						return pitnumber;
					}
					board[i][j] = 1 - side;
					// 若对方可以一步致胜，则选择使对方估值最小的一步下子
					if (isWin_PLeft(i, j, board) || isWin_PDown(i, j, board)
							|| isWin_RUp(i, j, board) || isWin_LUp(i, j, board)) {
						board[i][j] = side;
						// 找出使对方估值最小的落子
						maxvalue = JEvaluation.evaluation(board, 1 - side, 10);
						if (minvalue > maxvalue) {
							minvalue = maxvalue;
							pitnumber = i * (ORDER + 2) + j;
						}
					}
					board[i][j] = -1;
				}
			}
		}
		if (pitnumber != 0) {
			return pitnumber;
		}
		int x0=x,y0=y;
		int evaluationP=JEvaluation.evaluation(board, side, LinkAll.characterJ);
		for (int t = 1; t < ORDER + 1; t++) {
			for (int m= 1; m <=2*t; m++) {
				if(m<=t){
					x0=x0-1+2*(t%2);
				}
				else{
					y0=y0-1+2*(t%2);
				}
				if (isnecessary(board, x0, y0)) {
					board[x0][y0] = side;
					if (side == 0) {
						// 若计算机的棋子为0

						minevaluationW = AlphaBetaSearth.nAlphaBeta(depth,
								MIN_VALUE, MAX_VALUE, board, 1, 0,x0,y0,evaluationP);
						maxevaluationB = AlphaBetaSearth.nAlphaBeta(depth,
								MIN_VALUE, MAX_VALUE, board, 1, 1,x0,y0,-evaluationP);
						minvalue = character * minevaluationW
								+ (character - 10) * maxevaluationB;

						// minvalue=AlphaBetaSearth.nAlphaBeta(depth,
						// MIN_VALUE, MAX_VALUE, board,1,0);
					} else {

						maxevaluationW = AlphaBetaSearth.nAlphaBeta(depth,
								MIN_VALUE, MAX_VALUE, board, 0, 0,x0,y0,-evaluationP);
						minevaluationB = AlphaBetaSearth.nAlphaBeta(depth,
								MIN_VALUE, MAX_VALUE, board, 0, 1,x0,y0,evaluationP);
						minvalue = character * minevaluationB
								+ (character - 10) * maxevaluationW;

						// minvalue=AlphaBetaSearth.nAlphaBeta(depth,
						// MIN_VALUE, MAX_VALUE, board,0,1);
					}
					// 取遍历后的最大值
					if (maxvalue < minvalue) {
						maxvalue = minvalue;
						pitnumber = x0* (ORDER + 2) + y0;
					}
					board[x0][y0] = -1;
					// 如果检查到时间吃紧，直接将当前最优解抛出
					synchronized (PCPlayer.class) {
						if (timeOut) {
							return pitnumber;
						}
					}
				}
			}
		}
		return pitnumber;
	}
	

	// 去掉不必考虑下子的位置，即周围没有棋子的点
	// 即方圆两格之内无子的位置不考虑
	public static boolean isnecessary(int[][] board, int i, int j) {
		boolean a = true;
		if ((i > 0 && j > 0) && (i < 16 && j < 16)) {
			if((i>1&&j>1)&&(i<15&&j<15)){
			// 若棋子不在边界，检测周围距离为2的格点
			a = (board[i][j] == -1 && (board[i - 1][j] > -1
					|| board[i - 2][j] > -1 || board[i - 1][j + 1] > -1
					|| board[i - 2][j + 1] > -1 || board[i][j + 1] > -1
					|| board[i - 1][j + 2] > -1 || board[i][j + 2] > -1
					|| board[i + 1][j + 1] > -1 || board[i + 1][j + 2] > -1
					|| board[i + 1][j] > -1 || board[i + 2][j + 1] > -1
					|| board[i + 2][j] > -1 || board[i + 1][j - 1] > -1
					|| board[i + 2][j - 1] > -1 || board[i][j - 1] > -1
					|| board[i + 1][j - 2] > -1 || board[i][j - 2] > -1
					|| board[i + 1][j - 1] > -1 || board[i + 1][j - 2] > -1
					|| board[i + 2][j] > -1 || board[i - 2][j] > -1
					|| board[i + 2][j + 2] > -1 || board[i][j + 2] > -1
					|| board[i - 2][j + 2] > -1 || board[i - 2][j - 2] > -1
					|| board[i][j - 2] > -1 || board[i + 2][j - 2] > -1

			));
			} else{
				// 若棋子在边界，只检测周围距离为1的格点
				a = (board[i][j] == -1 && (board[i + 1][j] >= 0
						|| board[i + 1][j + 1] >= 0 || board[i + 1][j - 1] >= 0
						|| board[i][j + 1] >= 0 || board[i][j - 1] >= 0
						|| board[i - 1][j] >= 0 || board[i - 1][j + 1] >= 0 || board[i - 1][j - 1] >= 0));
			}
		}
		else{
//			若棋子坐标出界
			a=false;
		}
		return a;
	}

	public static boolean isWin_PLeft(int x, int y, int[][] bodyArray) // 判断输赢 横
	{
		int x1, y1, t = 1;
		x1 = x;
		y1 = y;

		for (int i = 1; i < 5; i++) {
			if (x1 > 11) {
				break;
			}
			if ((x1 + i) < 16 && bodyArray[x1 + i][y1] == bodyArray[x][y]) {
				t += 1;
			} else {
				break;
			}

		}

		for (int i = 1; i < 5; i++) {
			if (x1 < 5) {
				break;
			}

			if ((x1 - i) > 0 && bodyArray[x1 - i][y1] == bodyArray[x][y]) {
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

	public static boolean isWin_PDown(int x, int y, int[][] bodyArray) // 判断输赢 竖
	{
		int x1, y1, t = 1;
		x1 = x;
		y1 = y;

		for (int i = 1; i < 5; i++) {
			if (y1 > 11) {
				break;
			}
			if ((y1 + i) < 16 && bodyArray[x1][y1 + i] == bodyArray[x][y]) {
				t += 1;
			} else {
				break;
			}

		}

		for (int i = 1; i < 5; i++) {
			if (y1 < 5) {
				break;
			}

			if ((y1 - i) > 0 && bodyArray[x1][y1 - i] == bodyArray[x][y]) {
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

	public static boolean isWin_RUp(int x, int y, int[][] bodyArray) // 判断输赢 右斜
	{
		int x1, y1, t = 1;
		x1 = x;
		y1 = y;

		for (int i = 1; i < 5; i++) {
			if (x1 > 11 || y1 < 5) {
				break;
			}
			if ((x1 + i) < 16 && (y1 - i) > 0
					&& bodyArray[x1 + i][y1 - i] == bodyArray[x][y]) {
				t += 1;
			} else {
				break;
			}

		}

		for (int i = 1; i < 5; i++) {
			if (x1 < 5 || y1 > 11) {
				break;
			}

			if ((x1 - i) > 0 && (y1 + i) < 16
					&& bodyArray[x1 - i][y1 + i] == bodyArray[x][y]) {
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

	public static boolean isWin_LUp(int x, int y, int[][] bodyArray) // 判断输赢 左斜
	{
		int x1, y1, t = 1;
		x1 = x;
		y1 = y;

		for (int i = 1; i < 5; i++) {
			if (x1 > 11 || y1 > 11) {
				break;
			}
			if ((x1 + i) < 16 && (y1 + i < 16)
					&& bodyArray[x1 + i][y1 + i] == bodyArray[x][y]) {
				t += 1;
			} else {
				break;
			}

		}

		for (int i = 1; i < 5; i++) {
			if (x1 < 5 || y1 < 5) {
				break;
			}

			if ((x1 - i) > 0 && (y1 - i) > 0
					&& bodyArray[x1 - i][y1 - i] == bodyArray[x][y]) {
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
