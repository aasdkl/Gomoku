package gomoku;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Free {
	static JLabel bg = new JLabel(new ImageIcon("./pic/����.png"));
	static int regret = Constants.REGRET;
	static JPanel chessPane = Begin.chessPane;
	static MyButton chooseBox = null;
	static MyButton blackBox = null;
	static MyButton whiteBox = null;
	int choose = 0;

	Free() {
		Free.bg.setBounds(0, 0, 800, 600);
		Begin.chessPane.add(Free.bg);
		LinkAll.singlePlay = true;
		
		for (int y = 0; y < Constants.COLUMN; y++) {
			for (int x = 0; x < Constants.ROW; x++) {
				Constants.chessPos[y][x] = Constants.NO_CHESS;
				if (y>0&&x>0&&y<16&&x<16) {
				Constants.chess[y][x] = new ChessDown(
						295 + 32 * (x-1),
						40 + 32 * (y-1), 40, 40,
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

		// ��Ӱ�ťback
		String str1 = "./pic/button/�ص��˵�.png";
		String str2 = "./pic/button/�ص��˵�3.png";
		String str3 = "./pic/button/�ص��˵�2.png";
		MyButton back = new MyButton(-40, 415, 400, 150, str2, str1,
				str3, Constants.se, "freeBack",
				Begin.container, Begin.cardl, Begin.panel,
				chessPane);

		str1 = "./pic/button/����.png";
		str2 = "./pic/button/����3.png";
		str3 = "./pic/button/����2.png";
		MyButton regret = new MyButton(15, 220, 300, 90, str2, str1,
		str3, Constants.se, "freeRegret", Begin.container,
		Begin.cardl, Begin.panel, chessPane);

		str1 = "./pic/button/���¿���.png";
		str2 = "./pic/button/���¿���3.png";
		str3 = "./pic/button/���¿���2.png";
		MyButton again = new MyButton(10, 40, 300, 130, str2, str1,
				str3, Constants.se, "freeAgain",
				Begin.container, Begin.cardl, Begin.panel,
				chessPane);

		// //ʱ�������
		synchronized (LinkAll.time) {
			LinkAll.time.setBounds(300, 520, 150, 25);
			LinkAll.time.setFont(Constants.FONTS);
			LinkAll.time.setDoubleBuffered(true);
			LinkAll.time.setText("00:00:0");
			chessPane.add(LinkAll.time);
		}
		Thread b = new Thread(new Timing());
		b.start();

		chooseBox = new MyButton(0, 0, 800, 600, "./pic/choose.png",
				chessPane);
		blackBox = new MyButton(277, 250, 70, 70, "./pic/blackBox.png",
				"./pic/blackBox2.png", "./pic/nullBox.png",
				Constants.se, "black", Begin.container,
				Begin.cardl, Begin.panel, chessPane);
		whiteBox = new MyButton(458, 250, 70, 70, "./pic/whiteBox.png",
				"./pic/whiteBox2.png", "./pic/nullBox.png",
				Constants.se, "white", Begin.container,
				Begin.cardl, Begin.panel, chessPane);
		blackBox.setToolTipText("�ֺڷ������С�");
		whiteBox.setToolTipText("�ְ׷��ߺ��С�");
		chessPane.add(chooseBox, 0);
		chessPane.add(blackBox, 0);
		chessPane.add(whiteBox, 0);
		chessPane.add(back);
		chessPane.add(regret);
		chessPane.add(again);
		chessPane.add(bg);

		chessPane.repaint();
		
	}
}