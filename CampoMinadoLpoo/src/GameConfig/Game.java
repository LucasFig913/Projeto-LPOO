package GameConfig;
import java.awt.EventQueue;
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
    public static int difficulty = 1;
    public static String gameState;

    public Handler handler = new Handler();


    public Game() {
        if(difficulty == 1) {
    		GRIDSIZE = 15;
    	}else if(difficulty == 2){
    		GRIDSIZE = 20;
    	}else if(difficulty == 3) {
    		GRIDSIZE = 25;
    	}
    	new Window(WIDTH, HEIGHT, GRIDSIZE, "Campo minado - ", this, handler);  
        Window.update(0);
    }
    
    public static void update() {
    	gameState = "MENU";
    	if(gameState == "NORMAL") {
            new Game();
            System.out.println("foi");
    	}else if(gameState == "MENU") {
    		EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					Menu frame = new Menu();
    					frame.setVisible(true);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
    	}
    }
    

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	update();
    	
    	/*File file = new File("bomba.wav");
    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    	Clip clip = AudioSystem.getClip();
    	clip.open(audioStream);
    	
    	clip.start();*/
    	
        	

    }

}

