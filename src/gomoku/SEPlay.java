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
	
	
	//���캯����������ѡ���ֵ�·��
	SEPlay(String str){
		string = str;
	}

	//1.��ȡ�����ļ�
	public void run(){
		file = new File(string); 	//��·��ת��Ϊ���ļ�
		try {
			stream = AudioSystem.getAudioInputStream(file);//���ļ�ת��Ϊ��Ƶ������
			AudioFormat format = stream.getFormat();//��ȡ��Ƶ��ʽ
			realplay(format, stream);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	//2.��������
	private void realplay(AudioFormat format, AudioInputStream stream) throws LineUnavailableException, IOException{
		if (!noSE) {
		  DataLine.Info info = new DataLine.Info(Clip.class, format);//������Ƶ����Ϣ
		  Clip clip =(Clip)AudioSystem.getLine(info); //������Ƶ��
			  clip.open(stream);//����Ƶ������������Ƶ��
			  clip.start(); //����
		}
	}
		
}