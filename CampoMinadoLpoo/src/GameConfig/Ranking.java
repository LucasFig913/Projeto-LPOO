package GameConfig;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Ranking {
	private  String name ;
	private  String ext = "";
	private  String all;
	private String val;
	private String time2;
	private int time;

	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public Ranking(String name, int time) {
		this.name = name;
		this.time = time;
	}	
	public Ranking() {
	}	
	 public void showRanking() {
		Path path = Paths.get("ranking.txt");
			try {
				byte[] text = Files.readAllBytes(path);
				String read = new String(text);
				val = read;
			} catch (Exception e) {}
			String[] wds = val.split(";");
			ArrayList<Ranking> val2 = new ArrayList<Ranking>();
			for (int i = 0; i < wds.length -1  ; i++) {
				  time2 = ""+time;
				  name = wds[i];
				  time2 = wds[i+1];
				  time = Integer.parseInt(time2);
				val2.add(new Ranking(name,time));
				i++;
			}
			Collections.sort(val2, new SortTime());
			for (int i = 0; i < val2.size(); i++) {
				 all = val2.get(i).toString();
				 ext += all+"\n";
			}
			JOptionPane.showMessageDialog(null, ext,"Ranking",3);	
	 }
	public  void rankingSave(){
					name = JOptionPane.showInputDialog("TYPE YOUR NAME");
		try {
			FileWriter writer = new FileWriter("ranking.txt",true);
			PrintWriter writer2 = new PrintWriter(writer);
			writer2.printf(name + ";" + time+ ";");
			writer2.flush();
			writer2.close();
			writer.close();
		} catch (IOException e) {	
			JOptionPane.showMessageDialog(null, "N�o foi possivel salvar, jogue novamente!");	
		} 
	}
	public String toString(){
		return "Name: " + name + " ---- "+ " Time: " + time +" seconds \n";
	}

}
