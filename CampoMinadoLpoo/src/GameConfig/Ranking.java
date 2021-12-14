package GameConfig;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Ranking {
	public String name;
	public int time;
	public String[] name2;
	public int[] time2;
	public int aux;
	public String aux2;
	
	public Ranking(String name, int time) {
		this.name = name;
		this.time = time;
	}
	@SuppressWarnings("resource")
	public void save() {
	    String usuario = this.name +","+ this.time+",";
	    String[] atl = usuario.split(",");
		try {
			FileWriter fw = new FileWriter("ranking.txt",true);
			PrintWriter pw = new PrintWriter(fw);
			pw.printf(usuario);
			pw.flush();
			pw.close();
			fw.close();
			try {
				String singleLine = null;
				BufferedReader reader = new BufferedReader(new FileReader("ranking.txt"));
				try {
					while((singleLine = reader.readLine()) != null) {
						String[] trans = singleLine.split(",");
						for(int i = 0; i < trans.length; i++) {		
							if(i%2==0) {
								name2[i] = trans[i];
								time2[i] = 0;
							}else {
								time2[i] = Integer.parseInt(trans[i]);
								name2[i] = null;
							}
						}
						//Bubble Sort
						for(int l = 0; l < time2.length; l++) {
							for(int c = l + 2; c < time2.length; c++) {
								if(time2[l] < time2[c]) {
									     aux = time2[l];
									     aux2 = name2[l];
									time2[l] = time2[c];
									name2[l] = name2[c];
									time2[c] = aux;
									name2[c] = aux2;
									
								}
							}
							l++;
						}
						/*BufferedWriter writer = null;
						writer = new BufferedWriter( new FileWriter("jogadores.txt",true) );
						for(int k = 0; k < time2.length; k++) {	
							writer.write(time2[k]+name2[k]+"\n");
				
						}*/
					}
				}catch(Exception e) {}
		}catch(Exception e) {}
	}catch(Exception e) {}
}
	
	public void lerLista() {
		Path caminho = Paths.get("ranking.txt");
			try {
				byte[] texto  =  Files.readAllBytes(caminho);
				String leitura = new String(texto);
				JOptionPane.showMessageDialog(null, leitura);
			  
			} catch (Exception erro) {
				// TODO: handle exception
			}
	 }

}
