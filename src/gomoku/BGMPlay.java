package gomoku;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URI;
import java.net.URL;

public class BGMPlay {
	static boolean isPlay = true;
	private static final String AudioClip = null;
	static AudioClip clip =null;
	static File musicFile;
	static URI uri;
	static URL url;
	
	BGMPlay(String str){
		musicFile = new File(str);
		uri = musicFile.toURI();
		try {
			url = uri.toURL();
		} catch (Exception e) {
		}
		clip=Applet.newAudioClip(url);
		clip.play();
	}
	
	public void play() {
		if(isPlay && clip != null){
			( (java.applet.AudioClip) clip).play();
		}
	}
	public void stop() {
		if(isPlay && clip != null){
			( (java.applet.AudioClip) clip).stop();
		}
	}
	
	public static void change(String str){
		musicFile = new File(str);
		uri = musicFile.toURI();
		try {
			url = uri.toURL();
		} catch (Exception e) {
		}
		clip=Applet.newAudioClip(url);
		if(isPlay && clip != null){
			clip.play();
		}
	}
	
}
