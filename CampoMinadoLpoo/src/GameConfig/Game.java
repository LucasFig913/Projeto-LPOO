package GameConfig;
import java.awt.*;
import java.awt.event.*;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Board.Handler;
import GameConfig.Menu;

public class Game extends JFrame {

    public static int WIDTH = 720, HEIGHT = 720;
    public static int GRIDSIZE = 15;
    public static int MINECOUNT = (int) Math.round(GRIDSIZE * GRIDSIZE * .1);
    public static int key = 1;
    public Handler handler = new Handler();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Game() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton PLAY = new JButton("PLAY");
		PLAY.setBackground(Color.BLACK);
		PLAY.setForeground(Color.BLACK);
		PLAY.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		PLAY.setBounds(161, 94, 106, 43);
		PLAY.addActionListener(e -> gameInicialization());
		contentPane.add(PLAY);
		
		JButton DIFICULTY = new JButton("DIFFICULTY");
		DIFICULTY.setBackground(Color.BLACK);
		DIFICULTY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		DIFICULTY.setBounds(161, 148, 106, 23);
		contentPane.add(DIFICULTY);
		
		JButton RANKING = new JButton("RANKING");
		RANKING.setBackground(Color.BLACK);
		RANKING.setBounds(161, 182, 106, 23);
		contentPane.add(RANKING);
		
		JLabel CampoMinado = new JLabel("CampoMinado");
		CampoMinado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 46));
		CampoMinado.setBackground(Color.WHITE);
		CampoMinado.setBounds(45, 31, 348, 43);
		contentPane.add(CampoMinado);

	}
    public void gameInicialization() {
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


