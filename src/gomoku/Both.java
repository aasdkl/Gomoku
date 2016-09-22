package gomoku;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Both {
	JLabel bg = new JLabel(new ImageIcon("./pic/棋盘2.png"));
	static int regret = Constants.BOTH_REGRET;
	static JPanel chessPane = null;
	Both(Container container, CardLayout cardl, JPanel panel,
			JPanel chessPane) {

		Both.chessPane = chessPane;
		
		bg.setBounds(0, 0, 800, 600);

		for (int y = 0; y < Constants.COLUMN; y++) {
			for (int x = 0; x < Constants.ROW; x++) {
				Constants.chessPos[y][x] = Constants.NO_CHESS;
				if (y>0&&x>0&&y<16&&x<16) {
				Constants.chess[y][x] = new ChessDown(
						12 + 32 * (x-1),
						20 + 32 * (y-1), 40, 40,
						Constants.BlSet, Constants.WhSet, Constants.no,
						Constants.bl, Constants.wh,Constants.blAlpha,
						Constants.whAlpha,
						Constants.se, x, y,
						Both.chessPane,
						Constants.chessPos);
				}
			}
		}

		for (int y = 1; y < Constants.COLUMN-1; y++) {
			for (int x = 1; x < Constants.ROW-1; x++) {
				chessPane.add(Constants.chess[y][x]);
			}
		}
		
		// 添加按钮back
		String str1 = "./pic/button/回到菜单.png";
		String str2 = "./pic/button/回到菜单3.png";
		String str3 = "./pic/button/回到菜单2.png";
		String str4 = "./music/SE/1.wav";
		MyButton back = new MyButton(490, 400, 300, 150, str2, str1,
				str3, str4, "bothBack", container, cardl, panel,
				chessPane);
		
		str1 = "./pic/button/悔棋.png";
		str2 = "./pic/button/悔棋3.png";
		str3 = "./pic/button/悔棋2.png";
		MyButton regret = new MyButton(490, 250, 300, 90, str2, str1,
				str3, str4, "bothRegret", container, cardl, panel,
				chessPane);
		
		str1 = "./pic/button/重新开局.png";
		str2 = "./pic/button/重新开局3.png";
		str3 = "./pic/button/重新开局2.png";
		MyButton again = new MyButton(490, 40, 300, 130, str2, str1,
				str3, str4, "bothAgain", container, cardl, panel,
				chessPane);
		
		////时间计数器
		synchronized (LinkAll.time) {
			LinkAll.time.setBounds(220, 520, 150, 25);
			LinkAll.time.setFont(Constants.FONTS);
			LinkAll.time.setDoubleBuffered(true);
			LinkAll.time.setText("00:00:0");
			chessPane.add(LinkAll.time);
		}
		Thread b = new Thread(new Timing());
		b.start();
		
		chessPane.add(back);
		chessPane.add(regret);
		chessPane.add(again);
		chessPane.add(bg);
		
		chessPane.repaint();
	}

}
