package gomoku;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FadeNew implements Runnable {

	int x = 0;
	int y = 0;
	static JLabel[] label = new JLabel[Constants.FADE];
	int sizeX = 0;
	int sizeY = 0;
	int waitTime = 0;
	String tag = "";
	String path = "";
	JPanel pane = Begin.menuPane;
	JLabel pic = null;
	
	// ¹¹Ôìº¯Êý
	FadeNew(String path, int x, int y, int sizeX, int sizeY, int waitTime,
			String tag) {
		for (int i = 0; i < Constants.FADE; i++) {
			JLabel temp = new JLabel(new ImageIcon(path));
			label[i] = temp;
		}
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.waitTime = waitTime;
		this.tag = tag;
	}

	FadeNew(String path, int x, int y, int sizeX, int sizeY, int waitTime,
			String tag, JPanel menuPane) {

		for (int i = 0; i < Constants.FADE; i++) {
			JLabel temp = new JLabel(new ImageIcon(path));
			label[i] = temp;
		}

		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.waitTime = waitTime;
		this.tag = tag;
		this.pane = menuPane;
	}

	public void run() {
		for (int i = 0; i < Constants.FADE; i++) {
			label[i].setBounds(x, y, sizeX, sizeY);
			pane.add(label[i], 0);
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pane.repaint();
		}

		switch (tag) {
		case "both":
			Begin.cardl.show(Begin.panel, "chess");
			for (int i = 0; i < Constants.FADE; i++) {
				pane.remove(label[i]);
			}
			pane.repaint();
			break;

		case "free":
			Free.bg.setBounds(0, 0, 800, 600);
			Begin.chessPane.add(Free.bg);
			Begin.cardl.show(Begin.panel, "chess");

			for (int i = 0; i < Constants.FADE; i++) {
				pane.remove(label[i]);
			}
			pane.repaint();
			break;

		case "begin":
			pic = new JLabel(new ImageIcon("./pic/Begin.jpg"));
			pic.setBounds(0, 0, 800, 600);
			pic.setBorder(null);
			Begin.storyPane.add(pic,0);
			try {
				Story.a = new ReadFile("./text/Story0.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (Story.a.mes[0].length() > Constants.LINE_MAX) {
				dialogButton.temp = Story.a.mes[0].substring(0,
						Constants.LINE_MAX + 1);
				Story.a.mes[0] = Story.a.mes[0]
						.substring(Constants.LINE_MAX + 1);
				dialogButton.fileLine--;
			} else {
				dialogButton.temp = Story.a.mes[0];
			}
			
			for (int i = 0; i < Constants.FADE; i++) {
				Begin.storyPane.remove(label[i]);
			}
			

			Begin.storyPane.repaint();
			
			dialogButton.firstLine = new JLabel(dialogButton.temp);
			dialogButton.firstLine.setFont(Constants.FONTS);
			dialogButton.firstLine.setBounds(Constants.LEFT_SIDE, 100,
					800, 70);
			pane.add(dialogButton.firstLine, 0);
			dialogButton.fileLine++;

			break;

		case "part1":
			pic = new JLabel(new ImageIcon("./pic/picture1.png"));
			pic.setBounds(0, 0, 800, 600);
			pic.setBorder(null);
			Begin.storyPane.add(pic,0);
			Story.Dialog.setBounds(0, 0, 800, 600);
			pane.add(Story.Dialog, 0);
			Story.fullDialog.setBorder(null);
			pane.add(Story.fullDialog, 0);
			dialogButton.full = false;
			try {
				Story.a = new ReadFile("./text/Story1.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (Story.a.mes[0].length() > Constants.LINE_MAX) {
				dialogButton.temp = Story.a.mes[0].substring(0,
						Constants.LINE_MAX + 1);
				Story.a.mes[0] = Story.a.mes[0]
						.substring(Constants.LINE_MAX + 1);
				dialogButton.fileLine--;
				dialogButton.jump=true;
			} else {
				dialogButton.temp = Story.a.mes[0];
			}
			dialogButton.firstLine = new JLabel(dialogButton.temp);
			dialogButton.firstLine.setFont(Constants.FONTS);
			dialogButton.firstLine.setBounds(Constants.LEFT_SIDE, Constants.FIRST_LINE, 800, 70);
			pane.add(dialogButton.firstLine, 0);
			dialogButton.fileLine++;
			break;
			
		case "part2":
			pic = new JLabel(new ImageIcon("./pic/picture5.png"));
			pic.setBounds(0, 0, 800, 600);
			pic.setBorder(null);
			Begin.storyPane.add(pic,0);
			Story.Dialog.setBounds(0, 0, 800, 600);
			pane.add(Story.Dialog, 0);
			Story.fullDialog.setBorder(null);
			pane.add(Story.fullDialog, 0);
			dialogButton.full = false;
			try {
				Story.a = new ReadFile("./text/Story2.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (Story.a.mes[0].length() > Constants.LINE_MAX) {
				dialogButton.temp = Story.a.mes[0].substring(0,
						Constants.LINE_MAX + 1);
				Story.a.mes[0] = Story.a.mes[0]
						.substring(Constants.LINE_MAX + 1);
				dialogButton.fileLine--;
				dialogButton.jump=true;
			} else {
				dialogButton.temp = Story.a.mes[0];
			}
			dialogButton.firstLine = new JLabel(dialogButton.temp);
			dialogButton.firstLine.setFont(Constants.FONTS);
			dialogButton.firstLine.setBounds(Constants.LEFT_SIDE, Constants.FIRST_LINE, 800, 70);
			pane.add(dialogButton.firstLine, 0);
			dialogButton.fileLine++;

			break;
		default:
			break;
		}

	}
}
