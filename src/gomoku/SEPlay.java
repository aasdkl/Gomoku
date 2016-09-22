package gomoku;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SEPlay implements Runnable{

	File file = null;
	String string = null;
	static boolean noSE = false;
	AudioInputStream stream = null;
	
	
	//构造函数，传递所选音乐的路径
	SEPlay(String str){
		string = str;
	}

	//1.读取声音文件
	public void run(){
		file = new File(string); 	//将路径转化为该文件
		try {
			stream = AudioSystem.getAudioInputStream(file);//将文件转换为音频输入流
			AudioFormat format = stream.getFormat();//获取音频格式
			realplay(format, stream);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	//2.播放声音
	private void realplay(AudioFormat format, AudioInputStream stream) throws LineUnavailableException, IOException{
		if (!noSE) {
		  DataLine.Info info = new DataLine.Info(Clip.class, format);//设置音频行信息
		  Clip clip =(Clip)AudioSystem.getLine(info); //建立音频行
			  clip.open(stream);//将音频数据流读入音频行
			  clip.start(); //播放
		}
	}
		
}