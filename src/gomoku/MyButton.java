package gomoku;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyButton extends JButton {
	static MyButton setBG = null;
	static MyButton openBGM = null;
	static MyButton closeBGM = null;
	static MyButton openSE = null;
	static MyButton closeSE = null;
	static MyButton settingBack = null;
	static MyButton alphaBlack= null; 
	static JSlider depthSb =  new JSlider(JSlider.HORIZONTAL, 0, 3, 0);

	static JLabel temp = null;
	static JLabel INLeft = null;
	static JLabel INRight = null;
	static JLabel alphaINLeft = null;
	static JLabel alphaINRight = null;
	static MyButton story = null;
	static MyButton free = null;
	static MyButton singleBack = null;
	int choose = 0;
	
	String message = "";

	public MyButton(int x, int y, int sizex, int sizey, String str1,
			String str2, String str3, String music, String mes,
			Container contentPane, CardLayout cardl, JPanel panel,
			JPanel pane) {
		message = mes;
		// 按钮地址
		ImageIcon entered = new ImageIcon(str1);// 鼠标经过的时候的图片
		ImageIcon released = new ImageIcon(str2);// 初始图片
		ImageIcon pressed = new ImageIcon(str3);// 按下去的图片

		// 按钮透明化
		setOpaque(false);
		setIcon(released);// 初始化
		setBorderPainted(false);
		setBorder(null);
		setBounds(x, y, sizex, sizey); // 按钮大小，位置
		// 按钮透明，这样用圆形按钮的时候也不会出现按钮边框
		setContentAreaFilled(false);
		// 按下按钮时的图片
		setPressedIcon(pressed);
		// 经过时的图片
		setRolloverIcon(entered);
		// 监听按钮事件

		switch (mes) {
		case "single":
			single(music, contentPane, cardl, panel, pane);
			break;
		case "both":
			both(music, contentPane, cardl, panel, pane);
			break;
		case "setting":
			setting(music, contentPane, cardl, panel, pane);
			break;
		case "exit":
			exit(music);
			break;
		case "bothBack":
			bothBack(music, contentPane, cardl, panel, pane);
			break;
		case "bothRegret":
			bothRegret(music, contentPane, cardl, panel, pane);
			break;
		case "bothAgain":
			bothAgain(music, contentPane, cardl, panel, pane);
			break;
		case "openBGM":
			openBGM(str1, music);
			break;
		case "openSE":
			openSE(str1, music);
			break;
		case "closeBGM":
			closeBGM(str1, music);
			break;
		case "closeSE":
			closeSE(str1, music);
			break;
		case "settingBack":
			settingBack(str1, str2, str3, music, pane);
			break;
		case "story":
			story(music, contentPane, cardl, panel, pane);
			break;
		case "free":
			free(music, contentPane, cardl, panel, pane);
			break;
		case "singleBack":
			singleBack(music);
			break;
		case "freeBack":
			freeBack();
			break;
		case "freeRegret":
			freeRegret();
			break;
		case "freeAgain":
			freeAgain();
			break;
		case "black":
			black();
			break;
		case "white":
			white();
			break;
		default:
			JOptionPane.showMessageDialog(null, "找不到按钮", "error",
					JOptionPane.ERROR_MESSAGE);
			
			break;
		}
	}

	private void white() {
		addActionListener(new ActionListener() {// 匿名类
			public void actionPerformed(ActionEvent arg0) {
				SEPlay se = new SEPlay(Constants.se);
				se.run();
				Begin.chessPane.remove(Free.blackBox);
				Begin.chessPane.remove(Free.whiteBox);
				Begin.chessPane.remove(Free.chooseBox);
				Begin.chessPane.repaint();
				LinkAll.playOrder = Constants.AI;
				
					ChessDown.PCsetMove(8,8);
					for (int i = 0; i < 2; i++) {
						while (true) {
							int y = 8+(int)(Math.random()*5-2.5);
							int x = 8+(int)(Math.random()*5-2.5);
							if (Constants.chessPos[y][x] == Constants.NO_CHESS) {
								ChessDown.PCsetMove(y,x);
								break;
							}
						}
					}//count++?
					choose = JOptionPane.showConfirmDialog(
								 null, "是否交换阵营？", "交换提示",
								 JOptionPane.YES_NO_CANCEL_OPTION);		
					if (choose ==0){
						// 如果选择Change，电脑再下一子，实现玩家易帜
						int i = PCPlayer.PcOutput(Constants.chessPos, Constants.WHITE, LinkAll.depth,2,1,1);
						ChessDown.PCsetMove(i / 17, i % 17);
//								將changeState變爲true，表明已經交換
								LinkAll.changeState=true;
					} else if (choose == 1) {
						LinkAll.changeState=true;
					} else if (choose ==2){
						LinkAll.isWaitTwo=true;
					}
					
			}
		});
	}

	private void black() {
		addActionListener(new ActionListener() {// 匿名类
			public void actionPerformed(ActionEvent arg0) {
				SEPlay se = new SEPlay(Constants.se);
				se.run();
				Begin.chessPane.remove(Free.blackBox);
				Begin.chessPane.remove(Free.whiteBox);
				Begin.chessPane.remove(Free.chooseBox);
				LinkAll.playOrder = Constants.PLAYER;
				Begin.chessPane.repaint();
				JOptionPane.showMessageDialog(null, "请先下三子。");
			}
		});
	}

	private void freeAgain() {
		// TODO Auto-generated method stub
		addActionListener(new ActionListener() {// 匿名类
			public void actionPerformed(ActionEvent arg0) {
				// 播放音效
				SEPlay se = new SEPlay(Constants.se);
				se.run();
				// 调开选择栏
				int choose = JOptionPane.showConfirmDialog(
						null, "确定要重新开局吗？", "提示",
						JOptionPane.YES_NO_OPTION);
				if (choose == 0) { // 0即为退出选择

					Begin.chessPane.removeAll();
					LinkAll.count = 0;
					LinkAll.isStart=false;
					LinkAll.singlePlay = false;
					LinkAll.isEnd=false;
					LinkAll.changeState=false;
					LinkAll.isWaitTwo=false;
					Constants.preChess.clear();
					Free.regret = Constants.REGRET;
					new Free();
					Begin.chessPane.repaint();
				}
			}
		});
	}

	private void freeRegret() {
		addActionListener(new ActionListener() {// 匿名类
			public void actionPerformed(ActionEvent arg0) {
				// 播放音效
				SEPlay se = new SEPlay(Constants.se);
				se.run();
				
				if (Free.regret != 0) {
					int times = 2;
					int choose = JOptionPane.showConfirmDialog(
							null, "悔棋的次数还有" + Free.regret + "次，是否要悔棋？", "悔棋提示",
							JOptionPane.YES_NO_OPTION);
					if (choose == 0) { // 0即为yes
//						if (((LinkAll.playOrder == Constants.AI) && ((LinkAll.count == 4) || (LinkAll.count == 5)))
//								|| (LinkAll.playOrder == Constants.PLAYER) && ((LinkAll.count <= 3) || (LinkAll.count == 5))) {
//							times = 1;
//						}else{
//							times = 2;
//						}
						if(LinkAll.count <= 5){
							JOptionPane.showMessageDialog(null,
									"暂时无法悔棋。");
						}
						else if (LinkAll.count == 0 || ((LinkAll.playOrder == Constants.AI) && (LinkAll.count == 3))) {
							JOptionPane.showMessageDialog(null,
									"无棋可悔。");
						}else{
							Free.regret--;
							for (int i = 0; i < times; i++) {
								LinkAll.count--;
								int y = Constants.preChess.get(LinkAll.count)[0];
								int x = Constants.preChess.get(LinkAll.count)[1];
								Constants.chessPos[y][x] = Constants.NO_CHESS;
								Constants.preChess.remove(LinkAll.count);
					 
								Begin.chessPane.remove(Constants.chess[y][x]);
									Constants.chessPos[y][x] = Constants.NO_CHESS;
									Constants.chess[y][x] = new ChessDown(
											295 + 32 * (x-1), 40 + 32 * (y-1), 40,
											40, Constants.BlSet,
											Constants.WhSet, Constants.no,
											Constants.bl, Constants.wh,
											Constants.blAlpha,
											Constants.whAlpha,
											Constants.se, x, y, Begin.chessPane,
											Constants.chessPos);
					 
								Begin.chessPane.add(Constants.chess[y][x],0);
					 
								// 换另一方的颜色
								for (int yy = 1; yy < Constants.COLUMN-1; yy++) {
									for (int xx = 1; xx < Constants.ROW-1; xx++) {
										if (Constants.chessPos[yy][xx] == Constants.NO_CHESS) {
											Constants.chess[yy][xx].setRolloverIcon((LinkAll.count % 2 == 0) ? ChessDown.blPass
													: ChessDown.WhPass);
											Constants.chess[yy][xx].setPressedIcon((LinkAll.count % 2 == 0) ? ChessDown.blPressed
													: ChessDown.whPressed);
										}
									}
								}
							}
							Begin.chessPane.repaint();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "悔棋的次数已用完……背水一战吧！");
				}
			}
		});
		
	}

	private void freeBack() {
		// TODO Auto-generated method stub
		addActionListener(new ActionListener() {// 匿名类
			public void actionPerformed(ActionEvent arg0) {
				// 播放音效
				SEPlay se = new SEPlay(Constants.se);
				se.run();
				int choose = JOptionPane.showConfirmDialog(
						null, "确定要返回主菜单吗？", "返回提示",
						JOptionPane.YES_NO_OPTION);
				if (choose == 0) { // 0即为yes
					Begin.cardl.show(Begin.panel, "menu");
					Begin.chessPane.removeAll();
					LinkAll.count = 0;
					LinkAll.changeState=false;
					LinkAll.isWaitTwo=false;
					LinkAll.isEnd=false;
					LinkAll.isStart=false;
					LinkAll.singlePlay = false;
					Constants.preChess.clear();
					Free.regret = Constants.REGRET;
				}
			}
		});
	}

	private void singleBack(final String music) {
		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// 播放音效
				SEPlay se = new SEPlay(
						"./music/SE/Button27.wav");
				se.run();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// 播放音效
				SEPlay se = new SEPlay(music);
				se.run();
				Begin.menuPane.remove(story);
				Begin.menuPane.remove(free);
				Begin.menuPane.remove(singleBack);
				Begin.menuPane.remove(alphaBlack);
				Begin.menuPane.repaint();
				
			}
		});
	}

	private void free(final String music, Container contentPane,
			CardLayout cardl, JPanel panel, JPanel menuPane) {
		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			
			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// 播放音效
				SEPlay se = new SEPlay(
						"./music/SE/Button27.wav");
				se.run();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// 播放音效
				SEPlay se = new SEPlay(music);
				se.run();
				Begin.chessPane.removeAll();
				Begin.menuPane.remove(story);
				Begin.menuPane.remove(free);
				Begin.menuPane.remove(singleBack);
				Begin.menuPane.remove(alphaBlack);
				Begin.menuPane.repaint();
				new Free();
				Thread a  = new Thread(new FadeNew("./pic/棋盘alpha.png", 0, 0, 800, 600, 10,"free"));
				a.start();

			}
		});
	}

	private void story(final String music, final Container contentPane,
			final CardLayout cardl, final JPanel panel, final JPanel menuPane) {
		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// 播放音效
				SEPlay se = new SEPlay(
						"./music/SE/Button27.wav");
				se.run();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// 播放音效
				SEPlay se = new SEPlay(music);
				se.run();
				Begin.menuPane.removeAll();
				Begin.menuPane.setBackground(Color.BLACK);
				String str = "./pic/ry.png";
				temp = new JLabel(new ImageIcon(str));
				
				Thread t1 = new Thread(new Runnn(0, 0,INLeft,-10,0, 400,600,90,"",Begin.menuPane));
				t1.start();
				Thread t2 = new Thread(new Runnn(400, 0,INRight,10,0,400,600,90,"",Begin.menuPane));
				t2.start();
				Thread t3 = new Thread(new Runnn(0, 900,temp,0,-20, 800,600,80,true,0,"story",Begin.menuPane));
				t3.start();
				

				
				Begin.menuPane.repaint();
				Begin.musicPlay.stop();

				
			}
		});
	}
	
	private void bothAgain(final String music, final Container contentPane,
			final CardLayout cardl, final JPanel panel,
			final JPanel chessPane) {
		addActionListener(new ActionListener() {// 匿名类
			public void actionPerformed(ActionEvent arg0) {
				// 播放音效
				SEPlay se = new SEPlay(music);
				se.run();
				// 调开选择栏
				int choose = JOptionPane.showConfirmDialog(
						null, "确定要重新开局吗？", "提示",
						JOptionPane.YES_NO_OPTION);
				if (choose == 0) { // 0即为退出选择

//					cardl.show(panel, "menu");
					chessPane.removeAll();
					LinkAll.count = 0;
					LinkAll.isStart=false;
					Constants.preChess.clear();
					Both.regret = Constants.BOTH_REGRET;
//					cardl.show(panel, "chess");
					new Both(contentPane, cardl, panel,
							chessPane);
					chessPane.repaint();
				}
			}
		});
	}

	private void settingBack(final String str1, final String str2,
			final String str3, final String music,
			final JPanel menuPane) {
		addActionListener(new ActionListener() {// 匿名类
			public void actionPerformed(ActionEvent arg0) {
				SEPlay se = new SEPlay(music);
				se.run();
				menuPane.remove(openBGM);
				menuPane.remove(depthSb);
				menuPane.remove(closeBGM);
				menuPane.remove(openSE);
				menuPane.remove(closeSE);
				menuPane.remove(settingBack);
				menuPane.remove(setBG);
				menuPane.repaint();
			}
		});
	}

	private void openBGM(final String str1, final String music) {
		addActionListener(new ActionListener() {// 匿名类
			public void actionPerformed(ActionEvent arg0) {
				SEPlay se = new SEPlay(music);
				se.run();
				String str2 = "./pic/button/yes_null.png";
				ImageIcon i1 = new ImageIcon(str1);
				ImageIcon i2 = new ImageIcon(str2);

				MyButton.openBGM.setIcon(i1);
				Begin.musicPlay.play();
				MyButton.closeBGM.setIcon(i2);
				BGMPlay.isPlay = true;

			}
		});
	}

	private void closeBGM(final String str1, final String music) {
		addActionListener(new ActionListener() {// 匿名类
			public void actionPerformed(ActionEvent arg0) {
				SEPlay se = new SEPlay(music);
				se.run();
				String str2 = "./pic/button/yes_null.png";
				ImageIcon i1 = new ImageIcon(str1);
				ImageIcon i2 = new ImageIcon(str2);
				Begin.musicPlay.stop();

				MyButton.closeBGM.setIcon(i1);
				MyButton.openBGM.setIcon(i2);
				BGMPlay.isPlay = false;
			}
		});
	}

	private void openSE(final String str1, final String music) {
		addActionListener(new ActionListener() {// 匿名类
			public void actionPerformed(ActionEvent arg0) {
				String str2 = "./pic/button/yes_null.png";
				ImageIcon i1 = new ImageIcon(str1);
				ImageIcon i2 = new ImageIcon(str2);

				SEPlay se = new SEPlay(music);
				se.run();
				SEPlay.noSE = false;
				String str = "./pic/set.png";
				MyButton.openSE.setIcon(i1);
				MyButton.closeSE.setIcon(i2);
			}
		});
	}

	private void closeSE(final String str1, final String music) {
		addActionListener(new ActionListener() {// 匿名类
			public void actionPerformed(ActionEvent arg0) {
				SEPlay se = new SEPlay(music);
				se.run();
				String str2 = "./pic/button/yes_null.png";
				ImageIcon i1 = new ImageIcon(str1);
				ImageIcon i2 = new ImageIcon(str2);
				SEPlay.noSE = true;
				MyButton.closeSE.setIcon(i1);
				MyButton.openSE.setIcon(i2);
			}
		});
	}

	private void single(final String path, final Container contentPane,
			final CardLayout cardl, final JPanel panel, final JPanel menuPane) {
		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// 播放音效
				SEPlay se = new SEPlay(
						"./music/SE/Button27.wav");
				se.run();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// 播放音效
				SEPlay se = new SEPlay(path);
				se.run();
				
				alphaBlack = new MyButton(0, 0, 800, 600, "./pic/IN.png",
						Begin.menuPane);
				
				String str1 = "./pic/button/故事模式.png";
				String str2 = "./pic/button/故事模式2.png";
				String str3 = "./pic/button/故事模式3.png";
				
				story = new MyButton(184, 160, 300, 150,
						str2, str1, str3, Constants.se,
						"story", contentPane,
						cardl, panel, menuPane);

				String str = "./pic/INleft.png";
				
				INLeft = new JLabel(new ImageIcon(str));
				
				str1 = "./pic/button/自由模式.png";
				str2 = "./pic/button/自由模式2.png";
				str3 = "./pic/button/自由模式3.png";
				
				free = new MyButton(327, 274, 300, 150,
						str2, str1, str3, Constants.se,
						"free", contentPane,
						cardl, panel, menuPane);
				
				str = "./pic/INRight.png";
				
				INRight = new JLabel(new ImageIcon(str));
				
				str1 = "./pic/button/回到菜单.png";
				str2 = "./pic/button/回到菜单3.png";
				str3 = "./pic/button/回到菜单2.png";
				
				singleBack = new MyButton(490, 400, 300, 150,
						str2, str1, str3, Constants.se,
						"singleBack", contentPane,
						cardl, panel, menuPane);
				
				Begin.menuPane.add(alphaBlack, 0);
				Begin.menuPane.add(story, 0);
				Begin.menuPane.add(free, 0);
				Begin.menuPane.add(singleBack, 0);
				Begin.menuPane.repaint();
			}
		});
	}

	private void both(final String path, final Container contentPane,
			final CardLayout cardl, final JPanel panel,
			final JPanel pane2) {
		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// 播放音效
				SEPlay se = new SEPlay(
						"./music/SE/Button27.wav");
				se.run();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// 播放音效
				SEPlay se = new SEPlay(path);
				se.run();
				
				Thread a  = new Thread(new FadeNew("./pic/棋盘2alpha.png", 0, 0, 800, 600, 10,"both"));
				a.start();
				Begin.chessPane.removeAll();
				new Both(Begin.container, Begin.cardl, Begin.panel, Begin.chessPane);

			}
		});
	}

	private void setting(final String path, final Container contentPane,
			final CardLayout cardl, final JPanel panel,
			final JPanel menuPane) {
		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// 播放音效
				SEPlay se = new SEPlay(
						"./music/SE/Button27.wav");
				se.run();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// 播放音效
				SEPlay se = new SEPlay(path);
				se.run();
				String str = "./pic/set.png";
				setBG = new MyButton(0, 0, 800, 600, str,
						menuPane);
				

				String str1 = "./pic/button/yes_null.png";
				String str2 = "./pic/button/yes.png";
				openBGM = new MyButton(370, 65, 60, 60, str2,
						(BGMPlay.isPlay) ? str2
								: str1, str2,
								Constants.se, "openBGM",
						contentPane, cardl, panel,
						menuPane);
				closeBGM = new MyButton(
						590,
						65,
						60,
						60,
						str2,
						(!BGMPlay.isPlay) ? str2
								: str1, str2,
								Constants.se, "closeBGM",
						contentPane, cardl, panel,
						menuPane);

				openSE = new MyButton(370, 145, 60, 60, str2,
						(!SEPlay.noSE) ? str2 : str1,
						str2,Constants.se, "openSE",
						contentPane, cardl, panel,
						menuPane);
				closeSE = new MyButton(590, 145, 60, 60, str2,
						(SEPlay.noSE) ? str2 : str1,
						str2, Constants.se, "closeSE",
						contentPane, cardl, panel,
						menuPane);

				str1 = "./pic/button/回到菜单.png";
				str2 = "./pic/button/回到菜单3.png";
				str = "./pic/button/回到菜单2.png";
				settingBack = new MyButton(490, 400, 300, 150,
						str2, str1, str, Constants.se,
						"settingBack", contentPane,
						cardl, panel, menuPane);

				// 添加深度滑块
				depthSb.setMajorTickSpacing(4);
				depthSb.setMinorTickSpacing(1);
				depthSb.setPaintTicks(true);
				depthSb.setBounds(400, 350, 300, 30);
				Color bg = new Color(0, 0, 0, 0);
				depthSb.setBackground(bg);
				depthSb.setDoubleBuffered(true);
				depthSb.setIgnoreRepaint(true);
				depthSb.setOpaque(false);
				depthSb.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						LinkAll.depth = depthSb.getValue();
						 synchronized (Free.class) {
							 if (LinkAll.depth == 1){
								LinkAll.waitime = 10;
							 } else if (LinkAll.depth >= 2){
								LinkAll.waitime = 100;
							 }
						 }
					}
				});
				menuPane.add(setBG, 0);
				menuPane.add(depthSb, 0);
				menuPane.add(openBGM, 0);
				menuPane.add(closeBGM, 0);
				menuPane.add(openSE, 0);
				menuPane.add(closeSE, 0);
				menuPane.add(settingBack, 0);
				menuPane.repaint();

			}
		});
	}

	private void exit(final String path) {
		addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// 播放音效
				SEPlay se = new SEPlay(
						"./music/SE/Button27.wav");
				se.run();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// 播放音效
				SEPlay se = new SEPlay(path);
				se.run();
				// 调开选择栏
				int choose = JOptionPane.showConfirmDialog(
						null, "确定要退出游戏吗？", "退出提示",
						JOptionPane.YES_NO_OPTION);
				if (choose == 0) { // 0即为退出选择
					System.exit(0);
				}
			}
		});
	}

	private void bothBack(final String path, final Container contentPane,
			final CardLayout cardl, final JPanel panel,
			final JPanel pane2) {
		addActionListener(new ActionListener() {// 匿名类
			public void actionPerformed(ActionEvent arg0) {
				// 播放音效
				SEPlay se = new SEPlay(path);
				se.run();
				int choose = JOptionPane.showConfirmDialog(
						null, "确定要返回主菜单吗？", "返回提示",
						JOptionPane.YES_NO_OPTION);
				if (choose == 0) { // 0即为yes
					cardl.show(panel, "menu");
					pane2.removeAll();
					LinkAll.count = 0;
					LinkAll.isStart=false;
					Constants.preChess.clear();
					Both.regret = Constants.BOTH_REGRET;
				}
			}
		});
	}

	// 未完
	private void bothRegret(final String path, Container contentPane,
			CardLayout cardl, JPanel panel, JPanel pane2) {
		addActionListener(new ActionListener() {// 匿名类
			public void actionPerformed(ActionEvent arg0) {
				// 播放音效
				SEPlay se = new SEPlay(path);
				se.run();
				int choose = JOptionPane.showConfirmDialog(
						null, "悔棋的次数还有∞次，是否要悔棋？",
						"悔棋提示",
						JOptionPane.YES_NO_OPTION);
				if (choose == 0) { // 0即为yes
					if (LinkAll.count == 0) {
						JOptionPane.showMessageDialog(null,
								"无棋可悔。");
					}else{
					 Both.regret--;
					 LinkAll.count--;
					 int y = Constants.preChess.get(LinkAll.count)[0];
					 int x = Constants.preChess.get(LinkAll.count)[1];
					 Constants.chessPos[y][x] = Constants.NO_CHESS;
					 Constants.preChess.remove(LinkAll.count);
					 
					 Begin.chessPane.remove(Constants.chess[y][x]);
					 Constants.chess[y][x]=new ChessDown(
								12 + 32 * (x-1),
								20 + 32 * (y-1), 
								40, 40,
								Constants.BlSet, Constants.WhSet, Constants.no,
								Constants.bl, Constants.wh,Constants.blAlpha,
								Constants.whAlpha,
								Constants.se, x, y,
								Both.chessPane,
								Constants.chessPos);
					 
					 Begin.chessPane.add(Constants.chess[y][x],0);
					 
						// 换另一方的颜色
						for (int yy = 1; yy < Constants.COLUMN-1; yy++) {
							for (int xx = 1; xx < Constants.ROW-1; xx++) {
								if (Constants.chessPos[yy][xx] == Constants.NO_CHESS) {
									Constants.chess[yy][xx].setRolloverIcon((LinkAll.count % 2 == 0) ? ChessDown.blPass
											: ChessDown.WhPass);
									Constants.chess[yy][xx].setPressedIcon((LinkAll.count % 2 == 0) ? ChessDown.blPressed
											: ChessDown.whPressed);
									
								}
							}
						}
						 Begin.chessPane.repaint();
				}
			}
			}
		});
		
	}

	public MyButton(int x, int y, int sizex, int sizey, String str1,
			JPanel pane) {
		// 按钮地址
		ImageIcon entered = new ImageIcon(str1);// 鼠标经过的时候的图片
		ImageIcon released = new ImageIcon(str1);// 初始图片
		ImageIcon pressed = new ImageIcon(str1);// 按下去的图片

		// 按钮透明化
		setOpaque(false);
		setIcon(released);// 初始化
		setBorderPainted(false);
		setBorder(null);
		setBounds(x, y, sizex, sizey); // 按钮大小，位置
		// 按钮透明，这样用圆形按钮的时候也不会出现按钮边框
		setContentAreaFilled(false);
		// 按下按钮时的图片
		setPressedIcon(pressed);
		// 经过时的图片
	}
}

