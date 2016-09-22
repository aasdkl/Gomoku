package gomoku;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Runnn implements Runnable {

	int x = 0;
	int y = 0;
	JLabel label = null;
	int speedX = 0;
	int speedY = 0;
	int sizeX = 0;
	int sizeY = 0;
	int waitTime = 0;
	boolean cut = false;
	public static boolean loop=false;
	int cutPoint = 0;
	String tag ="";
	JPanel pane = Begin.menuPane;

	Runnn(int x, int y, JLabel label, int speedX, int speedY, int sizeX, int sizeY,
			int waitTime, String tag, JPanel pane) {
		this.x = x;
		this.y = y;
		this.label = label;
		this.speedX = speedX;
		this.speedY = speedY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.waitTime = waitTime;
		this.tag = tag;
		this.pane = pane;
	}

	Runnn(int x, int y, JLabel label, int speedX, int speedY, int sizeX, int sizeY,
			int waitTime, boolean cut, int cutPoint,String tag,JPanel pane) {
		this.x = x;
		this.y = y;
		this.label = label;
		this.speedX = speedX;
		this.speedY = speedY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.waitTime = waitTime;
		this.cut = cut;
		this.cutPoint = cutPoint;
		this.tag = tag;
		this.pane = pane;

	}
	
	public void run() {
		while (true) {
			x += speedX;
			y += speedY;
			if (!cut) {
				if(tag.equals("fog")){
					if (x==0) {
						while(loop){
							x=-800;
							break;
						}
					}
				}
				if (x < -sizeX || x > 800 || y < -sizeY || y > 800) {
					pane.remove(label);
					pane.repaint();
					break;
				}
			} else {
				if (((speedX==0)?y:x)==cutPoint) {
					try {
						Thread.sleep(1000);
							pane.remove(label);
						
						
						switch (tag) {
						case "story":
							new Story();
							Thread t3 = new Thread(new FadeNew("./pic/BeginAlpha.png", 0, 0, 800, 600, 40, "begin",Begin.storyPane));
							t3.start();

							Begin.cardl.show(Begin.panel, "story");
							
							break;
							
						case "plot1":

							Thread t = new Thread(new FadeNew("./pic/picture1Alpha.png", 0, 0, 800, 600, 40, "part1",Begin.storyPane));
							t.start();
							break;

							
						case "plot2":
							
							Thread t2 = new Thread(new FadeNew("./pic/picture5Alpha.png", 0, 0, 800, 600, 40, "part2",Begin.storyPane));
							t2.start();
							break;

						default:
							break;
						}
						
						pane.repaint();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				}
			}
			
			label.setBounds(x, y, sizeX, sizeY);
			pane.add(label, 0);
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
