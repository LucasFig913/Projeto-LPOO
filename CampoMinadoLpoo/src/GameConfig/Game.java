package GameConfig;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Board.Handler;
import GameConfig.Menu;

public class Game {

    public static int WIDTH = 720, HEIGHT = 720;
    public static int GRIDSIZE = 15;
    public static int MINECOUNT = (int) Math.round(GRIDSIZE * GRIDSIZE * .1);
    public static String gameState = "MENU";

    public Handler handler = new Handler();


    public Game() {
        new Window(WIDTH, HEIGHT, GRIDSIZE, "Campo minado - ", this, handler);  
        Window.update(0);
        
    }
    
    public static void update() {
    	if(gameState == "NORMAL") {
            new Game();
    	}else if(gameState == "MENU") {
            Menu menu = new Menu(WIDTH, HEIGHT);
            menu.setVisible(true);
    	}
    }
    

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	update();
    	
    	File file = new File("bomba.wav");
    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    	Clip clip = AudioSystem.getClip();
    	clip.open(audioStream);
    	
    	clip.start();*/
    	
    	
    	Menu menu = new Menu(WIDTH, HEIGHT, GRIDSIZE);
    	

    }

}
