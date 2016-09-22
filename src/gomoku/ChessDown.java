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
	static ImageIcon released =  new ImageIcon(Constants.no);// ��ʼͼƬ
	static ImageIcon blPressed =  new ImageIcon(Constants.bl);// ����ȥ��ͼƬblack
	static ImageIcon blPass =  new ImageIcon(Constants.blAlpha);
	static ImageIcon whPressed =  new ImageIcon(Constants.wh);// ����ȥ��ͼƬwhite
	static ImageIcon WhPass =  new ImageIcon(Constants.whAlpha);
	static int bodyArray15[][] = new int[15][15]; // ������������״̬ 0 ���� 1 ���� 2 ����

	ChessDown(final int x, final int y, int sizex, int sizey, String BlSet,
			String WhSet, String no, String bl, String wh,
			final String blAlpha, final String whAlpha,
			final String music, final int xline, final int yline,
			final JPanel chessPane, final int[][] chessPos) {
		// ��ť��ַ
		final Integer[] temp = { yline, xline };
		
		

		// ��ť͸����
		setOpaque(false);
		setIcon(released);// ��ʼ��
		setBorderPainted(false);
		setBorder(null);
		setBounds(x, y, sizex, sizey); // ��ť��С��λ��
		// ��ť͸����������Բ�ΰ�ť��ʱ��Ҳ������ְ�ť�߿�
		setContentAreaFilled(false);
		setPressedIcon((LinkAll.count % 2 == 0)?blPressed:whPressed);// ���°�ťʱ��ͼƬ
		setRolloverIcon((LinkAll.count % 2 == 0)?blPass:WhPass);// ����ʱ��ͼƬ
		// ������ť�¼�

		addActionListener(new ActionListener() {// ������

			public void actionPerformed(ActionEvent arg0) {
				// ���˵�ʱ��

				SEPlay se = new SEPlay(music);
				se.run();
				Constants.chessPos[yline][xline] = (LinkAll.count % 2 == 0) ? Constants.BLACK
						: Constants.WHITE;
				Constants.preChess.add(temp);

				if(LinkAll.count == 0){
					LinkAll.isStart=true;
				}
				
				
				// ��ʾ���������
				setPressedIcon((LinkAll.count % 2 == 0) ? BlEntered
						: WhEntered);
				setIcon((LinkAll.count % 2 == 0) ? BlEntered
						: WhEntered);
				setRolloverIcon((LinkAll.count % 2 == 0) ? BlEntered
						: WhEntered);
				removeActionListener(this);

				// �Ƴ���һ�����ӵĺ��
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

				// ����һ������ɫ
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
								temp[0]-1)) // �ж���Ӯ
				{
					LinkAll.isStart=false;
					LinkAll.isEnd = true;
// here
					JOptionPane.showMessageDialog(
							null,
							((LinkAll.count % 2 == 0) ? "�ڷ�"
									: "�׷�")
									+ "Ӯ��!");
					
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
							"����");
					LinkAll.isStart = false;
				}

				LinkAll.count++;
				Begin.chessPane.repaint();
				
				
				
				
				if(LinkAll.singlePlay){
					//	��Ϊ�������£������ѡ���µ��ĺ͵����ӣ��������Զ�
					if(LinkAll.isWaitTwo && LinkAll.count==4 && LinkAll.playOrder==Constants.AI){
					}
					else if((LinkAll.count==5)&&(LinkAll.playOrder==Constants.AI)&&LinkAll.isWaitTwo &&!LinkAll.changeState){
						int a1 = JEvaluation.evaluation(Constants.chessPos, (LinkAll.count%2==0)?Constants.BLACK:Constants.WHITE,LinkAll.characterJ);
						int b1 = JEvaluation.evaluation(Constants.chessPos, (LinkAll.count%2==0)?Constants.WHITE:Constants.BLACK,LinkAll.characterJ);
						if (a1 >= b1) {
							int i = PCPlayer.PcOutput(Constants.chessPos, (LinkAll.count%2==0)?Constants.BLACK:Constants.WHITE, LinkAll.depth, 2,temp[1],temp[0]);
							PCsetMove(i / 17, i % 17);
							JOptionPane.showMessageDialog(null,"�Է���ѡ�񲻸ı���Ӫ");
						} else {
							JOptionPane.showMessageDialog(null,"�Է���ѡ��ı���Ӫ");
						}
					}
					//��Ϊ������£������������3��
					else if((LinkAll.count==1||LinkAll.count==2)&&LinkAll.playOrder==Constants.PLAYER){
					}
					
					else if((LinkAll.count==3)&&LinkAll.playOrder==Constants.PLAYER){
						int a2 = JEvaluation.evaluation(Constants.chessPos, (LinkAll.count%2==0)?Constants.BLACK:Constants.WHITE,LinkAll.characterJ);
						int b2 = JEvaluation.evaluation(Constants.chessPos, (LinkAll.count%2==0)?Constants.WHITE:Constants.BLACK,LinkAll.characterJ);
						if (a2 >= b2) {
							int i = PCPlayer.PcOutput(Constants.chessPos, (LinkAll.count%2==0)?Constants.BLACK:Constants.WHITE, LinkAll.depth,2,temp[1],temp[0]);
							PCsetMove(i / 17, i % 17);
							JOptionPane.showMessageDialog(null,"�Է���ѡ�񲻸ı���Ӫ");
						} else {
							JOptionPane.showMessageDialog(null,"�Է���ѡ��ı���Ӫ");
						}
					}else{
						int i = PCPlayer.PcOutput(Constants.chessPos, (LinkAll.count%2==0)?Constants.BLACK:Constants.WHITE, LinkAll.depth,2,temp[1],temp[0]);
						PCsetMove(i / 17, i % 17);
					}
	
				}
				
				
				
				
				
				
				


			}
		});

		
	}
// ��ͼ��
// ��count
// ������λ��
// ��
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
		
		// ��ʾ���������
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
		
		// �Ƴ���һ�����ӵĺ��
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

		
		// ����һ������ɫ
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
						temp[0]-1)) // �ж���Ӯ
		{
			LinkAll.isStart=false;
//here
			JOptionPane.showMessageDialog(
					null,
					((LinkAll.count % 2 == 0) ? "�ڷ�"
							: "�׷�")
							+ "Ӯ��!");
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
					"����");
			LinkAll.isStart = false;
		}
		LinkAll.count++;
		Begin.chessPane.repaint();
	}
	}
}


