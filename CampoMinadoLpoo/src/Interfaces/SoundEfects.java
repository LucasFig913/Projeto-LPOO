package Interfaces;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public interface SoundEfects {
	static void deathEffect() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("boom.wav");
    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    	Clip clip = AudioSystem.getClip();
    	clip.open(audioStream);
    	
    	clip.start();
	}
	
	static void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File file = new File("music.wav");
    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    	Clip clip = AudioSystem.getClip();
    	clip.open(audioStream);
    	
    	clip.start();
	}
	
	static void click() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File file = new File("click.wav");
    	AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    	Clip clip = AudioSystem.getClip();
    	clip.open(audioStream);
    	
    	clip.start();
	}
	
	
}
