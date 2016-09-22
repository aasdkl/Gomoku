package gomoku;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class Begin {
	// 面板初始化
	public static JFrame frame = new JFrame("棋士");
	static Container container = frame.getContentPane();
	static JPanel panel = new JPanel();
	static JPanel menuPane = new JPanel();// 菜单面板
	static JPanel storyPane = new JPanel();
	protected static JPanel chessPane = new JPanel();// 双人游戏面板
	protected static JLabel label1 = new JLabel(new ImageIcon("./pic/menu.jpg"));
	protected static JLabel label2 = new JLabel(new ImageIcon("./pic/BLACK.jpg")); 
	static CardLayout cardl = new CardLayout();// 卡片布局
	protected static BGMPlay musicPlay = null;
	
	protected static JLabel label = new JLabel(new ImageIcon("./pic/fog.png")); 
	
	Begin() {
		
		// 添加按钮1
		String str1 = "./pic/button/单人游戏.png";
		String str2 = "./pic/button/单人游戏2.png";
		String str3 = "./pic/button/单人游戏3.png";
		String str4 = "./music/SE/1.wav";
		MyButton button1 = new MyButton(480, 376, 200, 50, str1, str2,
				str3, str4, "single", container, cardl, panel,
				chessPane);
		// 添加按钮2
		str1 = "./pic/button/双人游戏.png";
		str2 = "./pic/button/双人游戏2.png";
		str3 = "./pic/button/双人游戏3.png";
		MyButton button2 = new MyButton(580, 423, 200, 50, str1, str2,
				str3, str4, "both", container, cardl, panel,
				chessPane);
		// 添加按钮3
		str1 = "./pic/button/游戏设置.png";
		str2 = "./pic/button/游戏设置2.png";
		str3 = "./pic/button/游戏设置3.png";
		MyButton button3 = new MyButton(480, 470, 200, 50, str1, str2,
				str3, str4, "setting", container, cardl, panel,
				menuPane);
		// 添加按钮4
		str1 = "./pic/button/退出游戏.png";
		str2 = "./pic/button/退出游戏2.png";
		str3 = "./pic/button/退出游戏3.png";
		MyButton button4 = new MyButton(580, 517, 200, 50, str1, str2,
				str3, str4, "exit", container, cardl, panel,
				menuPane);
		// 添加按钮到面板1
		menuPane.add(button1);
		menuPane.add(button2);
		menuPane.add(button3);
		menuPane.add(button4);

		label1.setBounds(0, 0, 800, 600);
		label2.setBounds(0, 0, 800, 600);

		// 添加菜单图片

		menuPane.add(label1);
		chessPane.add(label2);

		new FadeIO("./pic/LOGO.jpg", container);

		
		// 双线程播放音乐
		String str = "./music/高山流水.wav";
		musicPlay = new BGMPlay(str);
		
		frame.repaint();
	}

	public static void main(String[] args) {
		panel.setLayout(cardl);
		container.add(panel);

//		MenuBar mb = new MenuBar(); 
//		Menu menu1=new Menu("难度");
//		Menu menu2=new Menu("退出");
//		MenuItem easy1 = new MenuItem("极简单");
//		MenuItem easy2 = new MenuItem("很简单");
//		MenuItem easy3 = new MenuItem("较简单");
//		MenuItem easy4 = new MenuItem("简单");
//		MenuItem exit = new MenuItem("退出游戏");
//		
//		exit.addActionListener(new ActionListener() {// 匿名类
//			public void actionPerformed(ActionEvent arg0) {
//				int choose = JOptionPane.showConfirmDialog(
//						null, "确定要退出游戏吗？", "退出提示",
//						JOptionPane.YES_NO_OPTION);
//				if (choose == 0) { // 0即为退出选择
//					System.exit(0);
//				}
//			}
//		});
//		
//		easy1.addActionListener(new ActionListener() {// 匿名类
//			public void actionPerformed(ActionEvent arg0) {
//				LinkAll.depth = 0;
//			}
//		});
//		easy2.addActionListener(new ActionListener() {// 匿名类
//			public void actionPerformed(ActionEvent arg0) {
//				LinkAll.depth = 1;
//			}
//		});
//		easy3.addActionListener(new ActionListener() {// 匿名类
//			public void actionPerformed(ActionEvent arg0) {
//				LinkAll.depth = 2;
//			}
//		});
//		easy4.addActionListener(new ActionListener() {// 匿名类
//			public void actionPerformed(ActionEvent arg0) {
//				LinkAll.depth = 3;
//			}
//		});
//		
//		
//		mb.add(menu1);
//		mb.add(menu2);
//		menu1.add(easy1);
//		menu1.add(easy2);
//		menu1.add(easy3);
//		menu2.add(exit);
		
		
		// 窗口设置
		frame.setSize(800, 600);// 大小
		frame.setLocationRelativeTo(null);// 居中
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 正常退出
		frame.setResizable(false);// 固定大小
		frame.setVisible(true);// 显示frame
//		frame.setMenuBar(mb);

		// 改窗体图标
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image icon = kit.createImage("./pic/icon.jpg");
		frame.setIconImage(icon);

		// 改鼠标图标
		Image img1 = kit.getImage("./pic/mouse.png");
		Cursor cu = kit.createCustomCursor(img1, new Point(10, 10),
				"stick");
		frame.setCursor(cu);
		
		panel.add(chessPane, "chess");
		panel.add(menuPane, "menu");
//		panel.add(chessPane, "chess");
		panel.add(storyPane, "story");
		
		chessPane.setBackground(Color.BLACK);
		
		// 将面板布局设置为坐标表示
		menuPane.setLayout(null);
		chessPane.setLayout(null);
		storyPane.setLayout(null);
		
		Thread t = new Thread(new Runnn(-800,0,label,5, 0, 1600, 600, 100,"fog",menuPane));
		Runnn.loop = true;
		t.start();

		new Begin();
	}
	
}