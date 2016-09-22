package gomoku;


//-2�������̱�Ե��-1�������ӣ�0������ӣ�1�������
//state��ʾ��ֵ����0��ʾ�԰����������еĹ�ֵ���㣬1��ʾ�Ժ���
public class AlphaBetaSearth {
	public static final int ORDER = 15, SQUARE_ORDER = 225;

	public static void Makemove(int board[][], int x, int y, int side) {
		board[x][y] = side;

	}
//����ǰһ�������ںδ��Լ�ǰһ���Ĺ�ֵ�Ĳ���
	public static int nAlphaBeta(int nPly, int nAlpha, int nBeta,
			int board[][],int side,int state,int x,int y,int evaluationP) { 
		int score = 0;
		int evaluation=JEvaluation.evaluation(board, state,LinkAll.characterJ,x,y,evaluationP);//�иĶ���������������������
		if(evaluation>5000000){
			return evaluation;
		}
		int x0=x;
		int y0=y;
		if (nPly == 0)
			return evaluation;//�иĶ���������������������
		
		if (side== 1-state) {
			/*ȡ��Сֵ�Ľڵ�*/
			for (int t = 1; t < ORDER + 1; t++) {
				for (int m= 1; m <=2*t; m++) {
					if(m<=t){
						x0=x0-1+2*(t%2);
					}
					else{
						y0=y0-1+2*(t%2);
					}
					if (PCPlayer.isnecessary(board,x0,y0)) {																					//���ڱ����������ӵ��board��Ҫ�򻯣�����Ԫ�ظ���
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
			/*ȡ����ֵ�Ľڵ�*/
			for (int t = 1; t < ORDER + 1; t++) {
				for (int m= 1; m <=2*t; m++) {
					if(m<=t){
						x0=x0-1+2*(t%2);
					}
					else{
						y0=y0-1+2*(t%2);
					}
					if (PCPlayer.isnecessary(board,x0,y0)) {
						Makemove(board, x0, y0, side);																	//�˴�����Ϊ1-side
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
	

