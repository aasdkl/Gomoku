package gomoku;

import javax.swing.JLabel;

public class LinkAll {
	static int count = 0;
	static boolean isStart = false;
	static int characterJ=5;
//	static int color2 = 0;// 记录玩家的选择，便于重置时颜色恢复，旗子的颜色标识 0:白子 1:黑子
	static int waitime = 1;
	static JLabel time = new JLabel("");
	
	static boolean changeState = false;// 记录是否已经交换过棋子
	static int playOrder = Constants.PLAYER; //默认玩家先走
	static int depth = 0;
	static boolean singlePlay = false;
	static boolean isStory = false;
	static boolean isWaitTwo = false;
	static boolean isEnd =false;
//	static boolean plot1 = false;
//	static boolean plot2 = false;
//	static boolean plot3 = false;
//	static boolean plot4 = false;
//	static boolean plot5 = false;
//	static boolean plot6 = false;
	static boolean plot7 = false;
	
}
