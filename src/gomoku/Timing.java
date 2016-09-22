package gomoku;

import javax.swing.JOptionPane;


public class Timing implements Runnable{
	long startime=0;
	long endtime=0;
	int interval=0;
	String mins="";
	String second="";
	int cou = 0;
	boolean state=false;
	
	public void run(){
		LOOP:while(true){
			if(state){
				synchronized(LinkAll.class){
					cou=LinkAll.count;
					}
				startime=System.currentTimeMillis();
				
				synchronized(PCPlayer.class){
					PCPlayer.timeOut=false;
				}
				
				while(state){
					try {
						synchronized(LinkAll.class){
							Thread.sleep(LinkAll.waitime);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					endtime=System.currentTimeMillis();
					interval=(int)(endtime-startime);
					
					mins=String.format("%02d", interval/60000);
					second=String.format("%02d", (interval%60000)/1000);
					
					synchronized(LinkAll.time){
						LinkAll.time.setText(mins+":"+second+":"+(interval/100)%10);
					}
					synchronized(LinkAll.class){
						if(cou!=LinkAll.count){
							break;
						}}
					
					if(interval>120000){
						synchronized(PCPlayer.class){
							PCPlayer.timeOut=true;
						}
					}
					
					if(interval>180000){
						synchronized(LinkAll.class){
							LinkAll.isStart=false;
							
							JOptionPane.showMessageDialog(
									null,
									(cou % 2 != 0) ? "白子超时，黑子赢"
											:"黑子超时，白子赢");
							for (int y = 0; y < Constants.COLUMN; y++) {
								for (int x = 0; x < Constants.ROW; x++) {
									if (Constants.chessPos[y][x] == Constants.NO_CHESS) {
										Begin.chessPane.remove(Constants.chess[y][x]);
									}
								}
							}
						}
						break LOOP;
					}
					synchronized(LinkAll.class){
						state=LinkAll.isStart;
					}
				}
			}else{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(LinkAll.class){
					state=LinkAll.isStart;
				}
			}
		}
	}
}

