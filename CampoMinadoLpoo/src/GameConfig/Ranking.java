package GameConfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class Ranking {
	public String name;
	public int time;
	
	public Ranking(String name, int time) {
		this.name = name;
		this.time = time;
	}
	public void save() {
	    String usuario = this.name +";"+ this.time;
	    String[] atl = usuario.split(";");
		try {
			FileWriter fw = new FileWriter("ranking.txt",true);
			PrintWriter pw = new PrintWriter(fw);
			pw.printf(atl[0]+",");
			pw.printf(atl[1]+",");
			pw.flush();
			pw.close();
			fw.close();
			String line = ""; // 2 - 1
			File file = new File("ranking.txt");
			if(file.exists()) {
				try {
					String singleLine = null;
					BufferedReader reader = new BufferedReader(new FileReader("ranking.txt"));
					try {
						while((singleLine = reader.readLine()) != null) {
							String[] trans = singleLine.split(",");
							int[] arr = null;
							for(int i = 1; i < trans.length; i++) {
								arr[i] = Integer.parseInt(trans[i]);
								if(arr[i] > arr[i+2]) {
									int aux = arr[i];
									arr[i] = arr[i+2];
									arr[i+1] = aux;
								}
								i++;
							}
						}
					}catch(IOException e) {System.out.println("Deu ruim");}
				}catch(FileNotFoundException e) {}
			}
			
			
		} catch (IOException e){
			e.printStackTrace();
		} 
	}
	public void lerLista() {
		Path caminho = Paths.get("ranking.txt");
			try {
				byte[] texto  =  Files.readAllBytes(caminho);
				String leitura = new String(texto);
			/*String[] palavras = leitura.split(";");
			ArrayList<Jogador> ar = new ArrayList<Jogador>();
				for (int i = 0; i < palavras.length; i++) {
				     
					
					nomei = palavras[i];
					  tempoi = palavras[i+1];
					
					ar.add(new Jogador(nomei,tempoi));
					i++;
				}
				for (int i = 0; i < ar.size(); i++) {
		            System.out.println(ar.get(i));
					
				}*/
				
			   JOptionPane.showMessageDialog(null, leitura);
			} catch (Exception erro) {
				// TODO: handle exception
			}
	 }
}
