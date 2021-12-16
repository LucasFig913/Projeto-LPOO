package GameConfig;

import java.io.BufferedReader;
import Board.Grid;
import Board.Handler;
import Board.Cell;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import Exceptions.InvalidAttribute;

public class SaveProgress{
	/*public static  void progressSave(){
		try {
		for(int k = 0 ; k < Grid.addCells(); k++){
			FileWriter writer = new FileWriter("saveProgress.txt",true);
			PrintWriter writer2 = new PrintWriter(writer);
			writer2.printf(Grid.cellGrid.get(k));    
			writer2.flush();
			writer2.close();
			writer.close();
		}
		} catch (IOException e) {	
			JOptionPane.showMessageDialog(null, "N�o foi possivel salvar, jogue novamente!");	
		} 
	}*/
	
	/*public static void applySaveProgress(String str) throws InvalidAttribute {
		String[] spl = str.split("/");
		for(int i = 0; i < spl.length;i++) {
			String[] spl2 = spl[i].split(":");
			switch(spl2[0]) {
			case "level":
				Game.setGameinit(true);
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
	}*/
	
}
