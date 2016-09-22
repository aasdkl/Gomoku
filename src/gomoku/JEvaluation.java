//��ʱ�����Ҫ�Ľ�
package gomoku;

//-2�������̱�Ե��-1�������ӣ�0������ӣ�1�������
public class JEvaluation {
	public static final int MAX_VALUE = 50000;
	public static final int ORDER = 15, SQUARE_ORDER = 225;
	public static final int HONE = 10;
	public static final int ONE = 20;
	public static final int HTWO = 90;// ��2����
	public static final int TWO = 200;// ��2����
	public static final int HTHREE = 900;// ��3����
	public static final int THREE = 3000;// ��3����
	public static final int HFOUR = 10000;// ��4����
	public static final int FOUR = 100000;// ��4����
	public static final int FIVE = 500000;// ʤ�ķ���

	public static int dueEvaluation(int board[][], int side, int x, int y) {
		int i = 0;
		int t = 0;
		boolean state1=false,state2=false;
		int change=0;
//���½�	
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
		
//		���½�
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
		
//		��
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
		
//		��
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

	// ��ԭevaluation�����أ�ֻҪ��֪����ʱ�µ��ӵ�λ�ã�֮ǰ�����̵Ĺ�ֵ���
	public static int evaluation(int board[][], int side, int character1,
			int x, int y, int evaluationP) {
		int changeA = 0;
		int changeB = 0;
		int t = 0;// ��¼���Ӹ���
		int i = 0;
		boolean state=false;
		
		for (int m = -1; m < 2; m++) {
			for (int n = -1; n < 2; n++) {
				if (m == 0 && n == 0) {
					// ȡ�������Ӷ����ӵ�ֵ
					changeA =changeA+dueEvaluation(board, side, x, y);

				} else {
//					��Ϊ�Է����ӣ�����Է�����֮ǰ�Ĺ���
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
//				�д�����������������������������
					if (board[x + m][y + n] == side) {
						while (true) {
							if (board[x + m * (t + 1)][y + n * (t + 1)] == side) {
								t++;
							} else if (board[x + m * (t + 1)][y + n * (t + 1)] == -1) {
								// ��������
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
								// ��Ȼ�������Ѿ��������
								}
								t = 0;
								break;
							} else {
								// ��Ϊ�߽���߶Է�����
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
								// ��������
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
								// ��Ȼ�������Ѿ��������
								}
								t = 0;
								break;
							} else {
								// ��Ϊ�߽���߶Է�����
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

	// ��Ҫʵ������֪֮ǰ��ֵ�Լ���ǰ�µ��ӣ��ó���ֵ�ĺ���
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
		// a��ʾ�Ե�ǰ���̵Ĺ�ֵ
		return a * character1 + b * (character1 - 10);
	}

	// �÷���������ˮƽ����
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

	// �÷������ڼ���һ�������ڴ�ֱ����Ĺ���
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

//	�÷������ڼ������������·���Ĺ���	
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

//�÷������ڼ������������·���Ĺ���
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
