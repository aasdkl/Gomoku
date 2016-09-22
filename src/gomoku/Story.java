package gomoku;

import java.awt.Color;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Story {

	static JPanel pane = Begin.storyPane;
	static ReadFile a = null;
	static dialogButton fullDialog = new dialogButton(0, 0, 800, 600,
			"./pic/null.png", pane,"part0");
	int line = 0;

	 static JLabel Dialog = new JLabel(new ImageIcon("./pic/speek2.png"));
	public Story() {
		 String str = "./music/��ֽ.wav";
		 BGMPlay.change(str);

		part0();
	}

	private void part0() {
		LinkAll.isStory=true;
		fullDialog.setBorder(null);
		pane.repaint();
		pane.add(fullDialog, 0);
		pane.setBackground(Color.BLACK);
	}
	
	
	static void part1(){
		LinkAll.isStory=true;
		JLabel temp = new JLabel(new ImageIcon("./pic/Plot1.png"));
				
		Thread t3 = new Thread(new Runnn(150, 0,temp,-5,0, 800,600,60,true,0,"plot1",pane));
		t3.start();
		
		pane.repaint();

		
	}

	static void part2() {
		
		LinkAll.isStory=true;
		JLabel temp = new JLabel(new ImageIcon("./pic/Plot2.png"));
				
		Thread t3 = new Thread(new Runnn(150, 0,temp,-5,0, 800,600,60,true,0,"plot2",pane));
		t3.start();
		pane.repaint();

		
	}
	
	
	
	
	
	

}

class dialogButton extends JButton {
	
	public static JLabel firstLine = null;
	public static JLabel secondLine = null;
	public static JLabel thirdLine = null;
	public static JLabel fourthLine = null;
	public static JLabel fifthLine = null;
	public static JLabel sixthLine = null;
	int line = 1;
	static int fileLine = 0;
	static String temp = "";
	static boolean jump = false;
	static boolean full = true;
	static boolean cont=false;
	public dialogButton(int x, int y, int sizex, int sizey, String str1,
			final JPanel pane, final String tag) {
		// ��ť��ַ
		ImageIcon entered = new ImageIcon(str1);// ��꾭����ʱ���ͼƬ
		ImageIcon released = new ImageIcon(str1);// ��ʼͼƬ
		ImageIcon pressed = new ImageIcon(str1);// ����ȥ��ͼƬ

		// ��ť͸����
		setOpaque(false);
		setIcon(released);// ��ʼ��
		setBorderPainted(false);
		setBorder(null);
		setBounds(x, y, sizex, sizey); // ��ť��С��λ��
		// ��ť͸����������Բ�ΰ�ť��ʱ��Ҳ������ְ�ť�߿�
		setContentAreaFilled(false);
		// ���°�ťʱ��ͼƬ
		setPressedIcon(pressed);
		// ����ʱ��ͼƬ

		addActionListener(new ActionListener() {// ������
			public void actionPerformed(ActionEvent arg0) {
				
				SEPlay se = new SEPlay(
						"./music/SE/010dj008.wav");
				se.run();

	if(full){
				if (fileLine != ReadFile.totalLine) {
					if (line == 0) {
						pane.remove(firstLine);
						pane.remove(secondLine);
						pane.remove(thirdLine);
						pane.remove(fourthLine);
						pane.remove(fifthLine);
						pane.remove(sixthLine);
						pane.repaint();
					}
					if (Story.a.mes[fileLine].equals("end;")) {
						line = 1;
						fileLine = 0;
						temp = "";
						jump = false;
						full = true;
						pane.removeAll();
						pane.repaint();
						switch (tag) {
						case "part0":
							Story.part1();
							break;
							
						default:
							break;
						}
					}
					switch (line) {
					case 0:
						if (Story.a.mes[fileLine]
								.length() > Constants.LINE_MAX) {
							temp = Story.a.mes[fileLine]
									.substring(0,
											Constants.LINE_MAX+1);
							Story.a.mes[fileLine] = Story.a.mes[fileLine]
									.substring(Constants.LINE_MAX+1);
							fileLine--;
							jump = true;
						} else {
							temp = Story.a.mes[fileLine];
						}
						firstLine = new JLabel(temp);
						firstLine.setFont(Constants.FONTS);
						firstLine.setBounds(Constants.LEFT_SIDE, 100,
								800, 70);
						pane.add(firstLine, 0);
						line++;
						fileLine++;
						if (jump) {
							jump = false;
						} else {
							break;
						}

					case 1:
						if (Story.a.mes[fileLine]
								.length() > Constants.LINE_MAX) {
							temp = Story.a.mes[fileLine]
									.substring(0,
											Constants.LINE_MAX+1);
							Story.a.mes[fileLine] = Story.a.mes[fileLine]
									.substring(Constants.LINE_MAX+1);
							fileLine--;
							jump = true;
						} else {
							temp = Story.a.mes[fileLine];
						}
						secondLine = new JLabel(temp);
						secondLine.setFont(Constants.FONTS);
						secondLine.setBounds(Constants.LEFT_SIDE, 140,
								800, 70);
						pane.add(secondLine, 0);
						line++;
						fileLine++;
						if (jump) {
							jump =false;
						} else {
							break;
						}
						

					case 2:
						if (Story.a.mes[fileLine]
								.length() > Constants.LINE_MAX) {
							temp = Story.a.mes[fileLine]
									.substring(0,
											Constants.LINE_MAX+1);
							Story.a.mes[fileLine] = Story.a.mes[fileLine]
									.substring(Constants.LINE_MAX+1);
							fileLine--;
							jump = true;
						} else {
							temp = Story.a.mes[fileLine];
						}
						thirdLine = new JLabel(temp);
						thirdLine.setFont(Constants.FONTS);
						thirdLine.setBounds(Constants.LEFT_SIDE, 180,
								800, 70);
						pane.add(thirdLine, 0);
						line++;
						fileLine++;
						if (jump) {
							jump = false;
						} else {
							break;
						}

					case 3:
						if (Story.a.mes[fileLine]
								.length() > Constants.LINE_MAX) {
							temp = Story.a.mes[fileLine]
									.substring(0,
											Constants.LINE_MAX+1);
							Story.a.mes[fileLine] = Story.a.mes[fileLine]
									.substring(Constants.LINE_MAX+1);
							fileLine--;
							jump = true;
						} else {
							temp = Story.a.mes[fileLine];
						}
						fourthLine = new JLabel(temp);
						fourthLine.setFont(Constants.FONTS);
						fourthLine.setBounds(Constants.LEFT_SIDE, 220,
								800, 70);
						pane.add(fourthLine, 0);
						line++;
						fileLine++;
						if (jump) {
							jump = false;
						} else {
							break;
						}
					case 4:
						if (Story.a.mes[fileLine]
								.length() > Constants.LINE_MAX) {
							temp = Story.a.mes[fileLine]
									.substring(0,
											Constants.LINE_MAX+1);
							Story.a.mes[fileLine] = Story.a.mes[fileLine]
									.substring(Constants.LINE_MAX+1);
							fileLine--;
							jump = true;
						} else {
							temp = Story.a.mes[fileLine];
						}
						fifthLine = new JLabel(temp);
						fifthLine.setFont(Constants.FONTS);
						fifthLine.setBounds(Constants.LEFT_SIDE, 260,
								800, 70);
						pane.add(fifthLine, 0);
						line++;
						fileLine++;
						if (jump) {
							jump = false;
						} else {
							break;
						}
					case 5:
						if (Story.a.mes[fileLine]
								.length() > Constants.LINE_MAX) {
							temp = Story.a.mes[fileLine]
									.substring(0,
											Constants.LINE_MAX+1);
							Story.a.mes[fileLine] = Story.a.mes[fileLine]
									.substring(Constants.LINE_MAX+1);
							fileLine--;
							jump = true;
						} else {
							temp = Story.a.mes[fileLine];
						}
						sixthLine = new JLabel(temp);
						sixthLine.setFont(Constants.FONTS);
						sixthLine.setBounds(Constants.LEFT_SIDE, 300,
								800, 70);
						pane.add(sixthLine, 0);
						line=0;
						fileLine++;
						if (jump) {
							jump = false;
						} else {
							break;
						}

					}

				}
				}else{
//chess					
				if (Story.a.mes[fileLine].equals("chess;")) {
					Begin.chessPane.removeAll();
					if (firstLine.isShowing()) {
						pane.remove(firstLine);
					}
					if (secondLine.isShowing()) {
						pane.remove(secondLine);
					}
					if (thirdLine.isShowing()) {
						pane.remove(thirdLine);
					}
					fileLine++;
					line=0;
					LinkAll.isStory=true;
					LinkAll.changeState=false;
					LinkAll.singlePlay=true;
					new Free();
					Thread a  = new Thread(new FadeNew("./pic/����alpha.png", 0, 0, 800, 600, 10,"free"));
					a.start();
				}
					while(Story.a.mes[fileLine].equals("")){
						if (line != 2) {
							fileLine++;
							line++;
						} else {
							fileLine++;
							line = 0;
						}
					}
					
					if (fileLine != ReadFile.totalLine) {
						if (line == 0) {
							if (firstLine.isShowing()) {
								pane.remove(firstLine);
							}
							if (secondLine.isShowing()) {
								pane.remove(secondLine);
							}
							if (thirdLine.isShowing()) {
								pane.remove(thirdLine);
							}
						}
//end						
						 if(Story.a.mes[fileLine].trim().equals("end;")) {
							if(fileLine+1 == ReadFile.totalLine){
								 new Begin();
							}
							line = 1;
							fileLine = 0;
							temp = "";
							jump = false;
							full = true;
							pane.removeAll();
//							pane.repaint();
							
							switch (tag) {
							case "part1":
								Story.part2();
								break;
								
							default:
								break;
							}

						}

						switch (line) {
						case 0:
							if (Story.a.mes[fileLine]
									.length() > Constants.LINE_MAX) {
								temp = Story.a.mes[fileLine]
										.substring(0,
												Constants.LINE_MAX+1);
								Story.a.mes[fileLine] = Story.a.mes[fileLine]
										.substring(Constants.LINE_MAX+1);
								fileLine--;
								jump = true;
							} else {
								temp = Story.a.mes[fileLine];
							}
							
							firstLine = new JLabel(temp);
							firstLine.setFont(Constants.FONTS);
							firstLine.setBounds(Constants.LEFT_SIDE, Constants.FIRST_LINE,
									800, 70);
							pane.add(firstLine, 0);
							line++;
							fileLine++;
							if (jump) {
								jump = false;
							} else {
								break;
							}

						case 1:
							if (Story.a.mes[fileLine]
									.length() > Constants.LINE_MAX) {
								temp = Story.a.mes[fileLine]
										.substring(0,
												Constants.LINE_MAX+1);
								Story.a.mes[fileLine] = Story.a.mes[fileLine]
										.substring(Constants.LINE_MAX+1);
								fileLine--;
								jump = true;
							} else {
								temp = Story.a.mes[fileLine];
							}
							secondLine = new JLabel(temp);
							secondLine.setFont(Constants.FONTS);
							secondLine.setBounds(Constants.LEFT_SIDE, 410,
									800, 70);
							pane.add(secondLine, 0);
							line++;
							fileLine++;
							if (jump) {
								jump = false;
							} else {
								break;
							}
							
						case 2:
							if (Story.a.mes[fileLine]
									.length() > Constants.LINE_MAX) {
								temp = Story.a.mes[fileLine]
										.substring(0,
												Constants.LINE_MAX+1);
								Story.a.mes[fileLine] = Story.a.mes[fileLine]
										.substring(Constants.LINE_MAX+1);
								fileLine--;
								jump = true;
							} else {
								temp = Story.a.mes[fileLine];
							}
							thirdLine = new JLabel(temp);
							thirdLine.setFont(Constants.FONTS);
							thirdLine.setBounds(Constants.LEFT_SIDE, 450,
									800, 70);
							pane.add(thirdLine, 0);
							line=0;
							fileLine++;
							if (jump) {
								jump = false;
							} else {
								break;
							}
							
						}

					}
							


			}
			}
		});
	}
}
