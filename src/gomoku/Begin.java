package gomoku;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class Begin {
	// ����ʼ��
	public static JFrame frame = new JFrame("��ʿ");
	static Container container = frame.getContentPane();
	static JPanel panel = new JPanel();
	static JPanel menuPane = new JPanel();// �˵����
	static JPanel storyPane = new JPanel();
	protected static JPanel chessPane = new JPanel();// ˫����Ϸ���
	protected static JLabel label1 = new JLabel(new ImageIcon("./pic/menu.jpg"));
	protected static JLabel label2 = new JLabel(new ImageIcon("./pic/BLACK.jpg")); 
	static CardLayout cardl = new CardLayout();// ��Ƭ����
	protected static BGMPlay musicPlay = null;
	
	protected static JLabel label = new JLabel(new ImageIcon("./pic/fog.png")); 
	
	Begin() {
		
		// ��Ӱ�ť1
		String str1 = "./pic/button/������Ϸ.png";
		String str2 = "./pic/button/������Ϸ2.png";
		String str3 = "./pic/button/������Ϸ3.png";
		String str4 = "./music/SE/1.wav";
		MyButton button1 = new MyButton(480, 376, 200, 50, str1, str2,
				str3, str4, "single", container, cardl, panel,
				chessPane);
		// ��Ӱ�ť2
		str1 = "./pic/button/˫����Ϸ.png";
		str2 = "./pic/button/˫����Ϸ2.png";
		str3 = "./pic/button/˫����Ϸ3.png";
		MyButton button2 = new MyButton(580, 423, 200, 50, str1, str2,
				str3, str4, "both", container, cardl, panel,
				chessPane);
		// ��Ӱ�ť3
		str1 = "./pic/button/��Ϸ����.png";
		str2 = "./pic/button/��Ϸ����2.png";
		str3 = "./pic/button/��Ϸ����3.png";
		MyButton button3 = new MyButton(480, 470, 200, 50, str1, str2,
				str3, str4, "setting", container, cardl, panel,
				menuPane);
		// ��Ӱ�ť4
		str1 = "./pic/button/�˳���Ϸ.png";
		str2 = "./pic/button/�˳���Ϸ2.png";
		str3 = "./pic/button/�˳���Ϸ3.png";
		MyButton button4 = new MyButton(580, 517, 200, 50, str1, str2,
				str3, str4, "exit", container, cardl, panel,
				menuPane);
		// ��Ӱ�ť�����1
		menuPane.add(button1);
		menuPane.add(button2);
		menuPane.add(button3);
		menuPane.add(button4);

		label1.setBounds(0, 0, 800, 600);
		label2.setBounds(0, 0, 800, 600);

		// ��Ӳ˵�ͼƬ

		menuPane.add(label1);
		chessPane.add(label2);

		new FadeIO("./pic/LOGO.jpg", container);

		
		// ˫�̲߳�������
		String str = "./music/��ɽ��ˮ.wav";
		musicPlay = new BGMPlay(str);
		
		frame.repaint();
	}

	public static void main(String[] args) {
		panel.setLayout(cardl);
		container.add(panel);

//		MenuBar mb = new MenuBar(); 
//		Menu menu1=new Menu("�Ѷ�");
//		Menu menu2=new Menu("�˳�");
//		MenuItem easy1 = new MenuItem("����");
//		MenuItem easy2 = new MenuItem("�ܼ�");
//		MenuItem easy3 = new MenuItem("�ϼ�");
//		MenuItem easy4 = new MenuItem("��");
//		MenuItem exit = new MenuItem("�˳���Ϸ");
//		
//		exit.addActionListener(new ActionListener() {// ������
//			public void actionPerformed(ActionEvent arg0) {
//				int choose = JOptionPane.showConfirmDialog(
//						null, "ȷ��Ҫ�˳���Ϸ��", "�˳���ʾ",
//						JOptionPane.YES_NO_OPTION);
//				if (choose == 0) { // 0��Ϊ�˳�ѡ��
//					System.exit(0);
//				}
//			}
//		});
//		
//		easy1.addActionListener(new ActionListener() {// ������
//			public void actionPerformed(ActionEvent arg0) {
//				LinkAll.depth = 0;
//			}
//		});
//		easy2.addActionListener(new ActionListener() {// ������
//			public void actionPerformed(ActionEvent arg0) {
//				LinkAll.depth = 1;
//			}
//		});
//		easy3.addActionListener(new ActionListener() {// ������
//			public void actionPerformed(ActionEvent arg0) {
//				LinkAll.depth = 2;
//			}
//		});
//		easy4.addActionListener(new ActionListener() {// ������
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
		
		
		// ��������
		frame.setSize(800, 600);// ��С
		frame.setLocationRelativeTo(null);// ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �����˳�
		frame.setResizable(false);// �̶���С
		frame.setVisible(true);// ��ʾframe
//		frame.setMenuBar(mb);

		// �Ĵ���ͼ��
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image icon = kit.createImage("./pic/icon.jpg");
		frame.setIconImage(icon);

		// �����ͼ��
		Image img1 = kit.getImage("./pic/mouse.png");
		Cursor cu = kit.createCustomCursor(img1, new Point(10, 10),
				"stick");
		frame.setCursor(cu);
		
		panel.add(chessPane, "chess");
		panel.add(menuPane, "menu");
//		panel.add(chessPane, "chess");
		panel.add(storyPane, "story");
		
		chessPane.setBackground(Color.BLACK);
		
		// ����岼������Ϊ�����ʾ
		menuPane.setLayout(null);
		chessPane.setLayout(null);
		storyPane.setLayout(null);
		
		Thread t = new Thread(new Runnn(-800,0,label,5, 0, 1600, 600, 100,"fog",menuPane));
		Runnn.loop = true;
		t.start();

		new Begin();
	}
	
}