package gomoku;

import java.awt.*;

import javax.swing.*;

/***********************************************
 * FadeIO():ʵ��ͼƬ�ĵ��뵭��
 ***********************************************/
public class FadeIO {

	private static final long serialVersionUID = 1L;
	static FadeIMG fimg = null;
	static Container contentPane = null;
	// ���캯��
	public FadeIO(String path, Container contentPane) {
		this.contentPane = contentPane;
		contentPane.validate();
		fimg = new FadeIMG(path);
		
		contentPane.add(fimg, 0);
		Begin.frame.setVisible(true);
		fimg.run();
		
	}


	// �ڲ���
	class FadeIMG extends JPanel implements Runnable{
		private static final long serialVersionUID = 1L;
		int alpha = 0;
		int step = 1;
		Image img = null;
		String path = null;

		// ����
		public FadeIMG(String p) {
			path = p;
			img = this.getToolkit().createImage(path);
		}

		public void run() {
			for (alpha = 0; alpha < 100; alpha += step) {
				try {
					Thread.sleep(10);
				} catch (Exception e) {
				}
				repaint();
			}
			try {
				Thread.sleep(400);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			for (; alpha > 0; alpha -= step) {
				try {
					Thread.sleep(10);
				} catch (Exception e) {
				}
				repaint();
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			contentPane.remove(FadeIO.fimg);
			contentPane.repaint();
			Begin.cardl.show(Begin.panel, "menu");
		}

		public void paintComponent(Graphics g) {

			Dimension d = getSize();
			Graphics2D g2d = (Graphics2D) g;

			g2d.setBackground(Color.BLACK);
			g2d.clearRect(0, 0, d.width, d.height);

			// ����͸����ͨ��
			try {
				g2d.setComposite(AlphaComposite.getInstance(
						AlphaComposite.SRC_OVER,
						(float) alpha / 100));
			} catch (Exception e) {
				System.out.println("\n" + alpha);
			}

			// ��ͼ
			g2d.drawImage(img, 0, 0, this);
			g2d.dispose();
		}
	}
}
