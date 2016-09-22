//超时检测需要改进
package gomoku;

//-2代表棋盘边缘，-1代表无子，0代表白子，1代表黑子
public class JEvaluation {
	public static final int MAX_VALUE = 50000;
	public static final int ORDER = 15, SQUARE_ORDER = 225;
	public static final int HONE = 10;
	public static final int ONE = 20;
	public static final int HTWO = 90;// 冲2分数
	public static final int TWO = 200;// 活2分数
	public static final int HTHREE = 900;// 冲3分数
	public static final int THREE = 3000;// 活3分数
	public static final int HFOUR = 10000;// 冲4分数
	public static final int FOUR = 100000;// 活4分数
	public static final int FIVE = 500000;// 胜的分数

	public static int dueEvaluation(int board[][], int side, int x, int y) {
		int i = 0;
		int t = 0;
		boolean state1=false,state2=false;
		int change=0;
//右下角	
		for (i = 1; i < 5; i++) {
			
			if ((x + i) < 16 && (y + i < 16)){
					if( board[x + i][y + i] == board[x][y]) {
				t += 1;
			} else{
				 if(board[x+i][y+i]==-1)
					 state1=true;
				break;
			}
			}
			else 
				break;
		}

		for (i = 1; i < 5; i++) {

			if ((x - i) > 0 && (y - i) > 0){
					if(board[x - i][y - i] == board[x][y]) {
				t += 1;
			} else {
				 if(board[x-i][y-i]==-1)
					 state2=true;
				break;
			}
			}
			else
				break;
		}
		if(state1&&state2){
			switch(t){
			case 0:change=change+ONE;break;
			case 1:change=change+TWO;break;
			case 2:change=change+THREE;break;
			case 3:change=change+FOUR;break;
			case 4:change=change+FIVE;break;
			}
		}
		else if(!state1&&!state2){
			;
		}
		else{
			switch(t){
			case 0:change=change+HONE;break;
			case 1:change=change+HTWO;break;
			case 2:change=change+HTHREE;break;
			case 3:change=change+HFOUR;break;
			case 4:change=change+FIVE;break;
			}
		}
		t=0;
		 state1=false;
		 state2=false;
		
//		左下角
		for (i = 1; i < 5; i++) {
			if ((x -i) > 0 && (y + i < 16)){
					if( board[x - i][y + i] == board[x][y]) {
				t += 1;
			} else{
				 if(board[x-i][y+i]==-1)
					 state1=true;
				break;
			}
			}
			else 
				break;
		}

		for (i = 1; i < 5; i++) {
			if ((x + i) < 16 && (y - i) > 0){
					if( board[x + i][y - i] == board[x][y]) {
				t += 1;
			} else {
				 if(board[x+i][y-i]==-1)
					 state2=true;
				break;
			}
			}
			else 
				break;
		}
		if(state1&&state2){
			switch(t){
			case 0:change=change+ONE;break;
			case 1:change=change+TWO;break;
			case 2:change=change+THREE;break;
			case 3:change=change+FOUR;break;
			case 4:change=change+FIVE;break;
			}
		}
		else if(!state1&&!state2){
			;
		}
		else{
			switch(t){
			case 0:change=change+HONE;break;
			case 1:change=change+HTWO;break;
			case 2:change=change+HTHREE;break;
			case 3:change=change+HFOUR;break;
			case 4:change=change+FIVE;break;
			}
		}
		t=0;
		state1=false;
		state2=false;
		
//		横
		for (i = 1; i < 5; i++) {
			if ((x + i) < 16 ){
					if(board[x + i][y ] == board[x][y]) {
				t += 1;
			} else{
				 if(board[x+i][y]==-1)
					 state1=true;
				break;
			}
			}
			else
				break;
		}

		for (i = 1; i < 5; i++) {

			if ((x - i) > 0){ 
					if(board[x - i][y] == board[x][y]) {
				t += 1;
			} else {
				 if(board[x-i][y]==-1)
					 state2=true;
				break;
			}
			}
		}
		if(state1&&state2){
			switch(t){
			case 0:change=change+ONE;break;
			case 1:change=change+TWO;break;
			case 2:change=change+THREE;break;
			case 3:change=change+FOUR;break;
			case 4:change=change+FIVE;break;
			}
		}
		else if(!state1&&!state2){
			;
		}
		else{
			switch(t){
			case 0:change=change+HONE;break;
			case 1:change=change+HTWO;break;
			case 2:change=change+HTHREE;break;
			case 3:change=change+HFOUR;break;
			case 4:change=change+FIVE;break;
			}
		}
		t=0;
		state1=false;
		state2=false;
		
//		竖
		for (i = 1; i < 5; i++) {
			if (y + i < 16){
					if( board[x][y + i] == board[x][y]) {
				t += 1;
			} else{
				 if(board[x][y+i]==-1)
					 state1=true;
				break;
			}
			}
			else
				break;
		}

		for (i = 1; i < 5; i++) {

			if ((y - i) > 0){
					if(board[x][y - i] == board[x][y]) {
				t += 1;
			} else {
				 if(board[x][y-i]==-1)
					 state2=true;
				break;
			}
			}
			else
				break;
		}
		if(state1&&state2){
			switch(t){
			case 0:change=change+ONE;break;
			case 1:change=change+TWO;break;
			case 2:change=change+THREE;break;
			case 3:change=change+FOUR;break;
			case 4:change=change+FIVE;break;
			}
		}
		else if(!state1&&!state2){
			;
		}
		else{
			switch(t){
			case 0:change=change+HONE;break;
			case 1:change=change+HTWO;break;
			case 2:change=change+HTHREE;break;
			case 3:change=change+HFOUR;break;
			case 4:change=change+FIVE;break;
			}
		}		
		return change;
	}

	// 对原evaluation的重载，只要多知道此时下的子的位置，之前对棋盘的估值便可
	public static int evaluation(int board[][], int side, int character1,
			int x, int y, int evaluationP) {
		int changeA = 0;
		int changeB = 0;
		int t = 0;// 记录连子个数
		int i = 0;
		boolean state=false;
		
		for (int m = -1; m < 2; m++) {
			for (int n = -1; n < 2; n++) {
				if (m == 0 && n == 0) {
					// 取得因下子而增加的值
					changeA =changeA+dueEvaluation(board, side, x, y);

				} else {
//					若为对方棋子，计算对方棋子之前的贡献
					if(board[x+m][y+n]==1-side){
						for(i=2;i<5;i++){
							if(x+m*i<16&&x+m*i>0&&y+n*i<16&&y+n*i>0){
								if(board[x+m*i][y+n*i]==1-side){
									t++;
								}
								else if(board[x+m*i][y+n*i]==-1){
									state=true;
									break;
								}
								else{
									state=false;
									break;
								}
							}
							else{
								state=false;
								break;
							}
						}
						if(state){
							switch(t){
							case 0:changeB=changeB-ONE+HONE;break;
							case 1:changeB=changeB-TWO+HTWO;break;
							case 2:changeB=changeB-THREE+HTHREE;break;
							case 3:changeB=changeB-FOUR+HFOUR;break;
//							case 4:changeB=changeB-FIVE;break;
							}
						}
						else{
							switch(t){
							case 0:changeB=changeB-HONE;break;
							case 1:changeB=changeB-HTWO;break;
							case 2:changeB=changeB-HTHREE;break;
							case 3:changeB=changeB-HFOUR;break;
//							case 4:changeB=changeB+FIVE;break;
							}
						}
						t=0;
					}
					else if(board[x+m][y+n]==side){
						for(i=2;i<5;i++){
							if(x+m*i<16&&x+m*i>0&&y+n*i<16&&y+n*i>0){
								if(board[x+m*i][y+n*i]==side){
									t++;
								}
								else if(board[x+m*i][y+n*i]==-1){
									state=true;
									break;
								}
								else{
									state=false;
									break;
								}
							}
							else{
								state=false;
								break;
							}
						}
						if(state){
							switch(t){
							case 0:changeA=changeA-ONE;break;
							case 1:changeA=changeA-TWO;break;
							case 2:changeA=changeA-THREE;break;
							case 3:changeA=changeA-FOUR;break;
//							case 4:changeA=changeA-FIVE;break;
							}
						}
						else{
							switch(t){
							case 0:changeA=changeA-HONE;break;
							case 1:changeA=changeA-HTWO;break;
							case 2:changeA=changeA-HTHREE;break;
							case 3:changeA=changeA-HFOUR;break;
//							case 4:changeA=changeA+FIVE;break;
							}
						}
						t=0;
					}
					else{
					;	
					}
				}
			}
		}
			/*
//				有错！！！！！！！！！！！！！！！
					if (board[x + m][y + n] == side) {
						while (true) {
							if (board[x + m * (t + 1)][y + n * (t + 1)] == side) {
								t++;
							} else if (board[x + m * (t + 1)][y + n * (t + 1)] == -1) {
								// 若无棋子
								switch (t) {
								case 0: {
									changeA = changeA - ONE + HONE;
									break;
								}
								case 1: {
									changeA = changeA - TWO + HTWO;
									break;
								}
								case 2: {
									changeA = changeA - THREE + HTHREE;
									break;
								}
								case 3: {
									changeA = changeA - FOUR + HFOUR;
									break;
								}
								// 显然不可能已经有五个子
								}
								t = 0;
								break;
							} else {
								// 若为边界或者对方棋子
								switch (t) {
								case 0: {
									changeA = changeA - HONE;
									break;
								}
								case 1: {
									changeA = changeA - HTWO;
									break;
								}
								case 2: {
									changeA = changeA - HTHREE;
									break;
								}
								case 3: {
									changeA = changeA - HFOUR;
									break;
								}
								}
								t = 0;
								break;
							}
						}

					} else if (board[x + m][y + n] == 1 - side) {
						while (true) {
							if (board[x + m * (t + 1)][y + n * (t + 1)] == 1 - side) {
								t++;
							} else if (board[x + m * (t + 1)][y + n * (t + 1)] == -1) {
								// 若无棋子
								switch (t) {
								case 0: {
									changeB = changeB - ONE + HONE;
									break;
								}
								case 1: {
									changeB = changeB - TWO + HTWO;
									break;
								}
								case 2: {
									changeB = changeB - THREE + HTHREE;
									break;
								}
								case 3: {
									changeB = changeB - FOUR + HFOUR;
									break;
								}
								// 显然不可能已经有五个子
								}
								t = 0;
								break;
							} else {
								// 若为边界或者对方棋子
								switch (t) {
								case 0: {
									changeB = changeB - HONE;
									break;
								}
								case 1: {
									changeB = changeB - HTWO;
									break;
								}
								case 2: {
									changeB = changeB - HTHREE;
									break;
								}
								case 3: {
									changeB = changeB - HFOUR;
									break;
								}
								}
								t = 0;
								break;
							}
						}
					} 
				}
			}
		}
		 */
		return evaluationP+changeA*character1+changeB*(character1-10);
	}

	// 需要实现在已知之前的值以及当前下的子，得出估值的函数
	public static int evaluation(int board[][], int side, int character1) {
		int a = 0;
		int b = 0;
		for (int i = 1; i < ORDER + 1; i++) {
			for (int j = 1; j < ORDER + 1; j++) {
				if (board[i][j] == side) {
					
						a += perEvaluateValueP(board, side, i, j);
				
						a += perEvaluateValueV(board, side, i, j);
				
						a += perEvaluateValueVP(board, side, i, j);
			
						a += perEvaluateValuePV(board, side, i, j);
				} else if (board[i][j] == 1 - side) {
				
						b += perEvaluateValueP(board, 1 - side, i, j);
	
						b += perEvaluateValueV(board, 1 - side, i, j);
				
						b += perEvaluateValueVP(board, 1 - side, i, j);
		
						b += perEvaluateValuePV(board, 1 - side, i, j);
				}
			}
		}
		// a表示对当前棋盘的估值
		return a * character1 + b * (character1 - 10);
	}

	// 该方法用于求水平方向
	public static int perEvaluateValueP(int board[][], int side, int x, int y) {
		int i;
		int t=0;
		int change=0;
		boolean state1=false;
		boolean state2=false;
		for (i = 1; i < 5; i++) {
			if (y + i < 16){
					if( board[x][y + i] == board[x][y]) {
				t += 1;
			} else{
				 if(board[x][y+i]==-1)
					 state1=true;
				break;
			}
			}
			else
				break;
		}

		for (i = 1; i < 5; i++) {

			if ((y - i) > 0){
					if(board[x][y - i] == board[x][y]) {
				t += 1;
			} else {
				 if(board[x][y-i]==-1)
					 state2=true;
				break;
			}
			}
			else
				break;
		}
		if(state1&&state2){
			switch(t){
			case 0:change=change+ONE;break;
			case 1:change=change+TWO;break;
			case 2:change=change+THREE;break;
			case 3:change=change+FOUR;break;
			case 4:change=change+FIVE;break;
			}
		}
		else if(!state1&&!state2){
			;
		}
		else{
			switch(t){
			case 0:change=change+HONE;break;
			case 1:change=change+HTWO;break;
			case 2:change=change+HTHREE;break;
			case 3:change=change+HFOUR;break;
			case 4:change=change+FIVE;break;
			}
		}
		return change/(t+1);
		/*
		int value = 0, t = 1;
		if (b[x][y + 1] == -1 && b[x][y - 1] == -1)
			value = ONE;
		else {
			if (b[x][y + 1] == -1)
				t = -1;
			if (b[x][y + t] == -2 || b[x][y + t] == 1 - side)
				value = HONE;
			else {
				if (b[x][y + t * 2] == -2 || b[x][y + t * 2] == 1 - side)
					value = HTWO;
				else if (b[x][y + t * 2] == -1)
					value = TWO;
				else {
					if (b[x][y + t * 3] == -2 || b[x][y + t * 3] == 1 - side)
						value = HTHREE;
					else if (b[x][y + t * 3] == -1)
						value = THREE;
					else {
						if (b[x][y + t * 4] ==1- side)
							value = HFOUR;
						else if(b[x][y+t*4]==side)
							value = FIVE;
						else
							value=FOUR;
					}
				}
			}
		}
		return value/2;
		*/
	}

	// 该方法用于计算一个棋子在垂直方向的贡献
	public static int perEvaluateValueV(int board[][], int side, int x, int y) {
		int i;
		int t=0;
		int change=0;
		boolean state1=false;
		boolean state2=false;
		for (i = 1; i < 5; i++) {
			if ((x + i) < 16 ){
					if(board[x + i][y ] == board[x][y]) {
				t += 1;
			} else{
				 if(board[x+i][y]==-1)
					 state1=true;
				break;
			}
			}
			else
				break;
		}

		for (i = 1; i < 5; i++) {

			if ((x - i) > 0){ 
					if(board[x - i][y] == board[x][y]) {
				t += 1;
			} else {
				 if(board[x-i][y]==-1)
					 state2=true;
				break;
			}
			}
		}
		if(state1&&state2){
			switch(t){
			case 0:change=change+ONE;break;
			case 1:change=change+TWO;break;
			case 2:change=change+THREE;break;
			case 3:change=change+FOUR;break;
			case 4:change=change+FIVE;break;
			}
		}
		else if(!state1&&!state2){
			;
		}
		else{
			switch(t){
			case 0:change=change+HONE;break;
			case 1:change=change+HTWO;break;
			case 2:change=change+HTHREE;break;
			case 3:change=change+HFOUR;break;
			case 4:change=change+FIVE;break;
			}
		}
		return change/(t+1);
		/*
		int value = 0, t = 1;
		if (b[x + 1][y] == -1 && b[x - 1][y] == -1)
			value = ONE;
		else {
			if (b[x + 1][y] == -1)
				t = -1;
			if (b[x + t][y] == -2 || b[x + t][y] == 1 - side)
				value = HONE;
			else {
				if (b[x + t * 2][y] == -2 || b[x + t * 2][y] == 1 - side)
					value = HTWO;
				else if (b[x + t * 2][y] == -1)
					value = TWO;
				else {
					if (b[x + t * 3][y] == -2 || b[x + t * 3][y] == 1 - side)
						value = HTHREE;
					else if (b[x + t * 3][y] == -1)
						value = THREE;
					else {
						if (b[x + t * 4][y] != side)
							value = HFOUR;
						else {
							value = FIVE;
						}
					}
				}
			}
		}
		return value;
		*/
	}

//	该方法用于计算棋子在右下方向的贡献	
	public static int perEvaluateValueVP(int board[][], int side, int x, int y) {
		int i;
		int t=0;
		int change=0;
		boolean state1=false;
		boolean state2=false;
		for (i = 1; i < 5; i++) {
			
			if ((x + i) < 16 && (y + i < 16)){
					if( board[x + i][y + i] == board[x][y]) {
				t += 1;
			} else{
				 if(board[x+i][y+i]==-1)
					 state1=true;
				break;
			}
			}
			else 
				break;
		}

		for (i = 1; i < 5; i++) {

			if ((x - i) > 0 && (y - i) > 0){
					if(board[x - i][y - i] == board[x][y]) {
				t += 1;
			} else {
				 if(board[x-i][y-i]==-1)
					 state2=true;
				break;
			}
			}
			else
				break;
		}
		if(state1&&state2){
			switch(t){
			case 0:change=change+ONE;break;
			case 1:change=change+TWO;break;
			case 2:change=change+THREE;break;
			case 3:change=change+FOUR;break;
			case 4:change=change+FIVE;break;
			}
		}
		else if(!state1&&!state2){
			;
		}
		else{
			switch(t){
			case 0:change=change+HONE;break;
			case 1:change=change+HTWO;break;
			case 2:change=change+HTHREE;break;
			case 3:change=change+HFOUR;break;
			case 4:change=change+FIVE;break;
			}
		}
		return change/(t+1);
		/*
		int value = 0, t = 1;
		if (b[x + 1][y + 1] == -1 && b[x - 1][y - 1] == -1)
			value = ONE;
		else {
			if (b[x + 1][y + 1] == -1)
				t = -1;
			if (b[x + t][y + t] == -2 || b[x + t][y + t] == 1 - side)
				value = HONE;
			else {
				if (b[x + t * 2][y + t * 2] == -2
						|| b[x + t * 2][y + t * 2] == 1 - side)
					value = HTWO;
				else if (b[x + t * 2][y + t * 2] == -1)
					value = TWO;
				else {
					if (b[x + t * 3][y + t * 3] == -2
							|| b[x + t * 3][y + t * 3] == 1 - side)
						value = HTHREE;
					else if (b[x + t * 3][y + t * 3] == -1)
						value = THREE;
					else {
						if (b[x + t * 3][y + t * 4] != side)
							value = HFOUR;
						else {
							value = FIVE;
						}
					}
				}
			}
		}
		return value;
		*/
	}

//该方法用于计算棋子在坐下方向的贡献
	public static int perEvaluateValuePV(int board[][], int side, int x, int y) {
		int i;
		int t=0;
		int change=0;
		boolean state1=false;
		boolean state2=false;
		for (i = 1; i < 5; i++) {
			if ((x -i) > 0 && (y + i < 16)){
					if( board[x - i][y + i] == board[x][y]) {
				t += 1;
			} else{
				 if(board[x-i][y+i]==-1)
					 state1=true;
				break;
			}
			}
			else 
				break;
		}

		for (i = 1; i < 5; i++) {
			if ((x + i) < 16 && (y - i) > 0){
					if( board[x + i][y - i] == board[x][y]) {
				t += 1;
			} else {
				 if(board[x+i][y-i]==-1)
					 state2=true;
				break;
			}
			}
			else 
				break;
		}
		if(state1&&state2){
			switch(t){
			case 0:change=change+ONE;break;
			case 1:change=change+TWO;break;
			case 2:change=change+THREE;break;
			case 3:change=change+FOUR;break;
			case 4:change=change+FIVE;break;
			}
		}
		else if(!state1&&!state2){
			;
		}
		else{
			switch(t){
			case 0:change=change+HONE;break;
			case 1:change=change+HTWO;break;
			case 2:change=change+HTHREE;break;
			case 3:change=change+HFOUR;break;
			case 4:change=change+FIVE;break;
			}
		}
		return change/(t+1);
		/*
		int value = 0, t = 1;
		if (b[x - 1][y + 1] == -1 && b[x + 1][y - 1] == -1)
			value = ONE;
		else {
			if (b[x - 1][y + 1] == -1)
				t = -1;
			if (b[x - t][y + t] == -2 || b[x - t][y + t] == 1 - side)
				value = HONE;
			else {
				if (b[x - t * 2][y + t * 2] == -2
						|| b[x - t * 2][y + t * 2] == 1 - side)
					value = HTWO;
				else if (b[x - t * 2][y + t * 2] == -1)
					value = TWO;
				else {
					if (b[x - t * 3][y + t * 3] == -2
							|| b[x - t * 3][y + t * 3] == 1 - side)
						value = HTHREE;
					else if (b[x - t * 3][y + t * 3] == -1)
						value = THREE;
					else {
						if (b[x - t * 4][y + t * 4] != side)
							value = HFOUR;
						else {
							value = FIVE;
						}
					}
				}
			}
		}
		return value;
		*/
	}

}
