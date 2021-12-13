package GameConfig;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
	public static void applySaveProgress(String str) {
		String[] spl = str.split("/");
		for(int i = 0; i < spl.length;i++) {
			String[] spl2 = spl[i].split(":");
			switch(spl2[0]) {
			case "level":
				Game.gameinit = true;
				break;
			}
		}
	}
	public static String loadGameProgress(int encode) {
		String line = "";
		File file = new File("saveProgress.txt");
		if(file.exists()) {
			try {
				String singleLine = null;
				BufferedReader reader = new BufferedReader(new FileReader("saveProgress.txt"));
				try {
					while((singleLine = reader.readLine()) != null) {
						String[] trans = singleLine.split(":");
						char val[] = trans[1].toCharArray();
						trans[1] = "";
						for(int i = 0; i < val.length; i++) {
							val[i]-=encode;
							trans[1]+=val[1];
						}
						line+=trans[0];
						line+=":";
						line+=trans[1];
						line+="/";
					}
					
				}catch(IOException e) {}
			}catch(FileNotFoundException e) {}
		}
		return line;
	}
	
	public static void saveGameProgress(String[] val1, int[] val2, int encode) {
		BufferedWriter write = null;
		try {
			write = new BufferedWriter(new FileWriter("saveProgress.txt"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < val1.length; i++) {
			String current = val1[i];
			current+=":";
			char[] value = Integer.toString(val2[i]).toCharArray();
			//attencion 
			for(int k = 0; k < value.length; k++) {
				value[k]+=encode;
				current+=value[k];
			}
			try {
				write.write(current);
				if(i < val1.length - 1)
					write.newLine();
			}catch(IOException e) {}
		}
		try {
			write.flush();
			write.close();
		}catch(IOException e) {
			
		}
	}
	
}
