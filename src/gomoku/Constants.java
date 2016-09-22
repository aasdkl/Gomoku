package gomoku;

import java.awt.Font;
import java.util.ArrayList;

public class Constants {
	public static final int ROW = 17;
	public static final int COLUMN = 17;
	public static final int NO_CHESS = -1;
	public static final int BLACK = 0;
	public static final int WHITE = 1;
	public static final int BOTH_REGRET = 999999999;
	public static final int REGRET = 3;
	
	public static final int SIZE = 28;
	public static final int LINE_MAX = 25;
	public static final int LEFT_SIDE = 82;
	public static final int FIRST_LINE= 370;
	public static final int FADE = 12;
	public static final String FONT = "»ªÎÄÐÐ¿¬";
	public static final Font FONTS = new Font(FONT, Font.PLAIN, SIZE);
	
	public static final int PLAYER = 1;
	public static final int AI = 0;
	
	static ChessDown[][] chess = new ChessDown[Constants.ROW][Constants.COLUMN];
	public static int[][] chessPos = new int[Constants.ROW][Constants.COLUMN];
	static ArrayList<Integer[]> preChess = new ArrayList<Integer[]>();
	static String BlSet = "./pic/chess/B1set.png";
	static String WhSet = "./pic/chess/W1set.png";
	static String no = "./pic/chess/null.png";
	static String bl = "./pic/chess/B1.png";
	static String se = "./music/SE/1.wav";
	static String wh = "./pic/chess/W1.png";
	static String blAlpha = "./pic/chess/B1aplha.png";
	static String whAlpha = "./pic/chess/W1alpha.png";
}
