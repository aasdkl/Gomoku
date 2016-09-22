package gomoku;


//-2代表棋盘边缘，-1代表无子，0代表白子，1代表黑子
//state表示估值对象，0表示对白子在棋盘中的估值计算，1表示对黑子
public class AlphaBetaSearth {
	public static final int ORDER = 15, SQUARE_ORDER = 225;

	public static void Makemove(int board[][], int x, int y, int side) {
		board[x][y] = side;

	}
//新增前一个子下在何处以及前一个的估值的参数
	public static int nAlphaBeta(int nPly, int nAlpha, int nBeta,
			int board[][],int side,int state,int x,int y,int evaluationP) { 
		int score = 0;
		int evaluation=JEvaluation.evaluation(board, state,LinkAll.characterJ,x,y,evaluationP);//有改动！！！！！！！！！！
		if(evaluation>5000000){
			return evaluation;
		}
		int x0=x;
		int y0=y;
		if (nPly == 0)
			return evaluation;//有改动！！！！！！！！！！
		
		if (side== 1-state) {
			/*取极小值的节点*/
			for (int t = 1; t < ORDER + 1; t++) {
				for (int m= 1; m <=2*t; m++) {
					if(m<=t){
						x0=x0-1+2*(t%2);
					}
					else{
						y0=y0-1+2*(t%2);
					}
					if (PCPlayer.isnecessary(board,x0,y0)) {																					//用于遍历可能下子点的board需要简化，减少元素个数
						Makemove(board, x0, y0, side);
						score = nAlphaBeta(nPly - 1, nAlpha, nBeta, board,1-side,state,x0,y0,evaluation);
						UnMakemove(board, x0, y0);
						if (nBeta > score) {
							nBeta=score;
							if (nAlpha >= nBeta)
								return nAlpha;
						}
					}
				}
			}
			return nBeta;
		} else {
			/*取极大值的节点*/
			for (int t = 1; t < ORDER + 1; t++) {
				for (int m= 1; m <=2*t; m++) {
					if(m<=t){
						x0=x0-1+2*(t%2);
					}
					else{
						y0=y0-1+2*(t%2);
					}
					if (PCPlayer.isnecessary(board,x0,y0)) {
						Makemove(board, x0, y0, side);																	//此处可能为1-side
						score = nAlphaBeta(nPly - 1, nAlpha, nBeta, board,1-side,state,x0,y0,evaluation);
						UnMakemove(board, x0, y0);
						if (nAlpha < score) {
							nAlpha=score;
							if (nAlpha >= nBeta)
		return nBeta;
						}
					}
				}
			}
			return nAlpha;

		}
	}

	public static void UnMakemove(int board[][], int a, int b) {
		board[a][b] = -1;
	}

}	
	

