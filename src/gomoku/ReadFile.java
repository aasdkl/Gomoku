package gomoku;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.transform.Templates;

public class ReadFile {
	String path = "";
	FileReader fr = null;
	BufferedReader br = null;
	static int totalLine = 0;
	String[] mes = new String[200];

	ReadFile(String storyPath) throws IOException {
		totalLine = 0;
		path = storyPath;

		try {
			fr = new FileReader(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
		while ((mes[totalLine] = br.readLine()) != null) {
			totalLine++;

		}
		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}// ¹Ø±ÕÎÄ¼þ

//		for (int j = 0; j < totalLine; j++) {
//				System.out.print(mes[j]);
//			System.out.println();
//		}

	}

}
