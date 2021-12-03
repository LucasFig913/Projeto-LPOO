package GameConfig;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Board.Handler;

public class Game {

    public static final int WIDTH = 720, HEIGHT = 720;
    public static final int GRIDSIZE = 15;
    public static final int MINECOUNT = (int) Math.round(GRIDSIZE * GRIDSIZE * .1);

    private Handler handler = new Handler();

    public Game() {
        new Window(WIDTH, HEIGHT, GRIDSIZE, "Campo minado - ", this, handler);
        Window.update(0);
    }

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	
    	File file = new File("bomba.wav");
    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    	Clip clip = AudioSystem.getClip();
    	clip.open(audioStream);
    	
    	clip.start();
    	
        new Game();
    }

}
