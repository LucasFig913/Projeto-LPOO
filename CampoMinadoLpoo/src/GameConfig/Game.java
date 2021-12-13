package GameConfig;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractAction;
import javax.swing.Action;

import Board.Handler;
import GameConfig.Menu;

public class Game {

    public static int WIDTH = 720, HEIGHT = 720;
    public static int GRIDSIZE = 15;
    public static int MINECOUNT = (int) Math.round(GRIDSIZE * GRIDSIZE * .1);
    public static int key = 1;

    public Handler handler = new Handler();

    
    public Game() {
        	
    	if(key == 1) {
    		GRIDSIZE = 15;
    	}else if(key == 2){
    		GRIDSIZE = 20;
    	}else if(key == 3) {
    		GRIDSIZE = 25;
    	}
    	new Window(WIDTH, HEIGHT, GRIDSIZE, "Campo minado - ", this, handler);  
        Window.update(0);
        
    }
    
       

}


