package gomoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.html.HTML.Tag;

public class ChessDown extends JButton {

	private static final long serialVersionUID = 1L;
	String message = null;
	static ImageIcon BlEntered = new ImageIcon(Constants.BlSet);
	static ImageIcon WhEntered =  new ImageIcon(Constants.WhSet);
	static ImageIcon released =  new ImageIcon(Constants.no);// 初始图片
	static ImageIcon blPressed =  new ImageIcon(Constants.bl);// 按下去的图片black
	static ImageIcon blPass =  new ImageIcon(Constants.blAlpha);
	static ImageIcon whPressed =  new ImageIcon(Constants.wh);// 按下去的图片white
	static ImageIcon WhPass =  new ImageIcon(Constants.whAlpha);
	static int bodyArray15[][] = new int[15][15]; // 设置棋盘棋子状态 0 无子 1 白子 2 黑子

	ChessDown(final int x, final int y, int sizex, int sizey, String BlSet,
			String WhSet, String no, String bl, String wh,
			final String blAlpha, final String whAlpha,
			final String music, final int xline, final int yline,
			final JPanel chessPane, final int[][] chessPos) {
		// 按钮地址
		final Integer[] temp = { yline, xline };
		
		

		// 按钮透明化
		setOpaque(false);
		setIcon(released);// 初始化
		setBorderPainted(false);
		setBorder(null);
		setBounds(x, y, sizex, sizey); // 按钮大小，位置
		// 按钮透明，这样用圆形按钮的时候也不会出现按钮边框
		setContentAreaFilled(false);
		setPressedIcon((LinkAll.count % 2 == 0)?blPressed:whPressed);// 按下按钮时的图片
		setRolloverIcon((LinkAll.count % 2 == 0)?blPass:WhPass);// 经过时的图片
		// 监听按钮事件

		addActionListener(new ActionListener() {// 匿名类

			public void actionPerformed(ActionEvent arg0) {
				// 单人的时候

				SEPlay se = new SEPlay(music);
				se.run();
				Constants.chessPos[yline][xline] = (LinkAll.count % 2 == 0) ? Constants.BLACK
						: Constants.WHITE;
				Constants.preChess.add(temp);

				if(LinkAll.count == 0){
					LinkAll.isStart=true;
				}
				
				
				// 显示点击的棋子
				setPressedIcon((LinkAll.count % 2 == 0) ? BlEntered
						: WhEntered);
				setIcon((LinkAll.count % 2 == 0) ? BlEntered
						: WhEntered);
				setRolloverIcon((LinkAll.count % 2 == 0) ? BlEntered
						: WhEntered);
				removeActionListener(this);

				// 移除上一颗棋子的红框
				if (LinkAll.count != 0) {
					Constants.chess[Constants.preChess
							.get(LinkAll.count - 1)[0]][Constants.preChess
							.get(LinkAll.count - 1)[1]]
							.setRolloverIcon((LinkAll.count % 2 == 0) ? whPressed
									: blPressed);
					Constants.chess[Constants.preChess
							.get(LinkAll.count - 1)[0]][Constants.preChess
							.get(LinkAll.count - 1)[1]]
							.setIcon((LinkAll.count % 2 == 0) ? whPressed
									: blPressed);
					Constants.chess[Constants.preChess
							.get(LinkAll.count - 1)[0]][Constants.preChess
							.get(LinkAll.count - 1)[1]]
							.setPressedIcon((LinkAll.count % 2 == 0) ? whPressed
									: blPressed);
				}

				// 换另一方的颜色
				for (int y = 1; y < Constants.COLUMN-1; y++) {
					for (int x = 1; x < Constants.ROW-1; x++) {
						if (chessPos[y][x] == Constants.NO_CHESS) {
							Constants.chess[y][x].setRolloverIcon((LinkAll.count % 2 == 0) ? WhPass
									: blPass);
							Constants.chess[y][x].setPressedIcon((LinkAll.count % 2 == 0) ? whPressed
									: blPressed);
							
						}
					}
				}


				// judge			
				
				for (int i = 1; i < Constants.COLUMN-1; i++) {
					for (int j = 1; j < Constants.ROW-1; j++) {
						bodyArray15[i-1][j-1] = Constants.chessPos[i][j];
					}
				}
				
				if (Judge.isWin_PLeft(bodyArray15, temp[1]-1,
						temp[0]-1)
						|| Judge.isWin_PDown(
								bodyArray15,
								temp[1]-1,
								temp[0]-1)
						|| Judge.isWin_RUp(
								bodyArray15,
								temp[1]-1,
								temp[0]-1)
						|| Judge.isWin_LUp(
								bodyArray15,
								temp[1]-1,
								temp[0]-1)) // 判断输赢
				{
					LinkAll.isStart=false;
					LinkAll.isEnd = true;
// here
					JOptionPane.showMessageDialog(
							null,
							((LinkAll.count % 2 == 0) ? "黑方"
									: "白方")
									+ "赢了!");
					
					for (int y = 1; y < Constants.COLUMN-1; y++) {
						for (int x = 1; x < Constants.ROW-1; x++) {
							if (chessPos[y][x] == Constants.NO_CHESS) {
								Begin.chessPane.remove(Constants.chess[y][x]);
							}
						}
					}
//storymode
					if (LinkAll.isStory) {
						if (LinkAll.count < 20) {
							for (int j = dialogButton.fileLine; j < ReadFile.totalLine; j++) {
								if(Story.a.mes[j].startsWith("<")){
									dialogButton.fileLine= j+1;
									break;
								}
							}
							Begin.cardl.show(Begin.panel, "story");

						} else if(LinkAll.count >= 20 && !LinkAll.plot7){
							for (int j = dialogButton.fileLine; j < ReadFile.totalLine; j++) {
								if(Story.a.mes[j].startsWith(">")){
									dialogButton.fileLine= j+1;
									break;
								}
							}
							Begin.cardl.show(Begin.panel, "story");
						}
					}
				}
				if (LinkAll.count == 265) {
					JOptionPane.showMessageDialog(null,
							"和棋");
					LinkAll.isStart = false;
				}

				LinkAll.count++;
				Begin.chessPane.repaint();
				
				
				
				
				if(LinkAll.singlePlay){
					//	若为电脑先下，且玩家选择下第四和第五子，跳过电脑端
					if(LinkAll.isWaitTwo && LinkAll.count==4 && LinkAll.playOrder==Constants.AI){
					}
					else if((LinkAll.count==5)&&(LinkAll.playOrder==Constants.AI)&&LinkAll.isWaitTwo &&!LinkAll.changeState){
						int a1 = JEvaluation.evaluation(Constants.chessPos, (LinkAll.count%2==0)?Constants.BLACK:Constants.WHITE,LinkAll.characterJ);
						int b1 = JEvaluation.evaluation(Constants.chessPos, (LinkAll.count%2==0)?Constants.WHITE:Constants.BLACK,LinkAll.characterJ);
						if (a1 >= b1) {
							int i = PCPlayer.PcOutput(Constants.chessPos, (LinkAll.count%2==0)?Constants.BLACK:Constants.WHITE, LinkAll.depth, 2,temp[1],temp[0]);
							PCsetMove(i / 17, i % 17);
							JOptionPane.showMessageDialog(null,"对方已选择不改变阵营");
						} else {
							JOptionPane.showMessageDialog(null,"对方已选择改变阵营");
						}
					}
					//若为玩家先下，则先让玩家下3子
					else if((LinkAll.count==1||LinkAll.count==2)&&LinkAll.playOrder==Constants.PLAYER){
					}
					
					else if((LinkAll.count==3)&&LinkAll.playOrder==Constants.PLAYER){
						int a2 = JEvaluation.evaluation(Constants.chessPos, (LinkAll.count%2==0)?Constants.BLACK:Constants.WHITE,LinkAll.characterJ);
						int b2 = JEvaluation.evaluation(Constants.chessPos, (LinkAll.count%2==0)?Constants.WHITE:Constants.BLACK,LinkAll.characterJ);
						if (a2 >= b2) {
							int i = PCPlayer.PcOutput(Constants.chessPos, (LinkAll.count%2==0)?Constants.BLACK:Constants.WHITE, LinkAll.depth,2,temp[1],temp[0]);
							PCsetMove(i / 17, i % 17);
							JOptionPane.showMessageDialog(null,"对方已选择不改变阵营");
						} else {
							JOptionPane.showMessageDialog(null,"对方已选择改变阵营");
						}
					}else{
						int i = PCPlayer.PcOutput(Constants.chessPos, (LinkAll.count%2==0)?Constants.BLACK:Constants.WHITE, LinkAll.depth,2,temp[1],temp[0]);
						PCsetMove(i / 17, i % 17);
					}
	
				}
				
				
				
				
				
				
				


			}
		});

		
	}
// 消图标
// 加count
// 加棋子位置
// 加
	static void PCsetMove(int yline, int xline) {
	if(!LinkAll.isEnd){
		SEPlay se = new SEPlay(Constants.se);
		se.run();
		Constants.chessPos[yline][xline] = (LinkAll.count % 2 == 0) ? Constants.BLACK
				: Constants.WHITE;
		Integer[] temp = {yline,xline};
		Constants.preChess.add(temp);
		


//		if(LinkAll.count == 0){
			LinkAll.isStart=true;
//		}
		
		// 显示点击的棋子
		Constants.chess[temp[0]][temp[1]]
				.setPressedIcon((LinkAll.count % 2 == 0) ? BlEntered
				: WhEntered);
		Constants.chess[temp[0]][temp[1]]
				.setIcon((LinkAll.count % 2 == 0) ? BlEntered
				: WhEntered);
		Constants.chess[temp[0]][temp[1]]
				.setRolloverIcon((LinkAll.count % 2 == 0) ? BlEntered
				: WhEntered);
		
		Constants.chess[temp[0]][temp[1]]
				.removeActionListener(Constants.chess[temp[0]][temp[1]].getActionListeners()[0]);
		
		// 移除上一颗棋子的红框
		if (LinkAll.count != 0) {
			Constants.chess[Constants.preChess
					.get(LinkAll.count - 1)[0]][Constants.preChess
					.get(LinkAll.count - 1)[1]]
					.setRolloverIcon((LinkAll.count % 2 == 0) ? whPressed
							: blPressed);
			Constants.chess[Constants.preChess
					.get(LinkAll.count - 1)[0]][Constants.preChess
					.get(LinkAll.count - 1)[1]]
					.setIcon((LinkAll.count % 2 == 0) ? whPressed
							: blPressed);
			Constants.chess[Constants.preChess
					.get(LinkAll.count - 1)[0]][Constants.preChess
					.get(LinkAll.count - 1)[1]]
					.setPressedIcon((LinkAll.count % 2 == 0) ? whPressed
							: blPressed);
			
		}

		
		// 换另一方的颜色
		for (int y = 1; y < Constants.COLUMN-1; y++) {
			for (int x = 1; x < Constants.ROW-1; x++) {
				if (Constants.chessPos[y][x] == Constants.NO_CHESS) {
					Constants.chess[y][x].setRolloverIcon((LinkAll.count % 2 == 0) ? WhPass
							: blPass);
					Constants.chess[y][x].setPressedIcon((LinkAll.count % 2 == 0) ? whPressed
							: blPressed);
				}
			}
		}
		
		// judge				

		for (int i = 1; i < Constants.COLUMN-1; i++) {
			for (int j = 1; j < Constants.ROW-1; j++) {
				bodyArray15[i-1][j-1] = Constants.chessPos[i][j];
			}
		}
		if (Judge.isWin_PLeft(bodyArray15, temp[1]-1,
				temp[0]-1)
				|| Judge.isWin_PDown(
						bodyArray15,
						temp[1]-1,
						temp[0]-1)
				|| Judge.isWin_RUp(
						bodyArray15,
						temp[1]-1,
						temp[0]-1)
				|| Judge.isWin_LUp(
						bodyArray15,
						temp[1]-1,
						temp[0]-1)) // 判断输赢
		{
			LinkAll.isStart=false;
//here
			JOptionPane.showMessageDialog(
					null,
					((LinkAll.count % 2 == 0) ? "黑方"
							: "白方")
							+ "赢了!");
			for (int y = 1; y < Constants.COLUMN-1; y++) {
				for (int x = 1; x < Constants.ROW-1; x++) {
					if (Constants.chessPos[y][x] == Constants.NO_CHESS) {
						Begin.chessPane.remove(Constants.chess[y][x]);
					}
				}
			}
//storymode
			if (LinkAll.isStory) {
					for (int j = dialogButton.fileLine; j < ReadFile.totalLine; j++) {
						if(Story.a.mes[j].startsWith("!")){
							dialogButton.fileLine= j+1;
							break;
						}
					}
					
					Begin.cardl.show(Begin.panel, "story");

			}
		}
		if (LinkAll.count == (265)) {
			JOptionPane.showMessageDialog(null,
					"和棋");
			LinkAll.isStart = false;
		}
		LinkAll.count++;
		Begin.chessPane.repaint();
	}
	}
}


