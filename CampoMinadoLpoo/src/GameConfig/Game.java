package GameConfig;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Board.Handler;
import Exceptions.InvalidAttribute;

public class Game extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 720, HEIGHT = 720;
    public static int GRIDSIZE = 15;
    public static int MINECOUNT = (int) Math.round(GRIDSIZE * GRIDSIZE * .1);
    public static int key = 1;
    public static Boolean crazy;
    public Handler handler = new Handler();
	public static int getGRIDSIZE() {
		return GRIDSIZE;
	}


	public static void setGRIDSIZE(int gRIDSIZE) {
		GRIDSIZE = gRIDSIZE;
	}
	private JPanel contentPane;
	private static boolean gameinit = false;
	private boolean exit = false;

	Thread t1 = new Thread(Timer.timer);
	
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


	public Game() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton PLAY = new JButton("PLAY");
		PLAY.setBackground(Color.DARK_GRAY);
		PLAY.setForeground(Color.CYAN);
		PLAY.setBounds(161, 94, 106, 43);
		PLAY.addActionListener(e -> {
			try {
				gameInicialization();
			} catch (UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		PLAY.addActionListener(e -> dispose());
		PLAY.addActionListener(e -> Game.gameinit = true);
		contentPane.add(PLAY);
		PLAY.addActionListener(e -> t1.start());//new Thread(Timer.t1).start());
		
		JButton EASY = new JButton("EASY");
		EASY.setBackground(Color.DARK_GRAY);
		EASY.setForeground(Color.CYAN);
		EASY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key = 1;
			}
		});
		EASY.setBounds(161, 148, 106, 23);
		contentPane.add(EASY);
		
		JButton NORMAL = new JButton("NORMAL");
		NORMAL.setBackground(Color.DARK_GRAY);
		NORMAL.setForeground(Color.CYAN);
		NORMAL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key = 2;
			}
		});
		NORMAL.setBounds(161, 184, 106, 23);
		contentPane.add(NORMAL);
		
		JButton HARD = new JButton("MALUCO");

		HARD.setBackground(Color.DARK_GRAY);
		HARD.setForeground(Color.CYAN);
		HARD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key = 3;
			}
		});
		HARD.setBounds(161, 218, 106, 23);
		contentPane.add(HARD);
		
		JButton RANKING = new JButton("RANKING");
		RANKING.setBackground(Color.DARK_GRAY);
		RANKING.setForeground(Color.CYAN);
		
		RANKING.setBounds(161, 252, 106, 23);
		contentPane.add(RANKING);
		RANKING.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ranking ranking2 = new Ranking(null, 0);
				ranking2.showRanking();
			}
		});

		
		JButton LOADGAME = new JButton("LOAD GAME");

		LOADGAME.setBackground(Color.DARK_GRAY);
		LOADGAME.setForeground(Color.CYAN);;
		LOADGAME.setBounds(161, 286, 106, 23);
		contentPane.add(LOADGAME);

		
		
		JLabel lblNewLabel = new JLabel("Quadrilha Minada");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 44));
		lblNewLabel.setBounds(67, 11, 322, 101);
		contentPane.add(lblNewLabel);
		
		JLabel CampoMinado = new JLabel("");
		CampoMinado.setIcon(new ImageIcon("menu2.gif"));
		CampoMinado.setHorizontalAlignment(SwingConstants.CENTER);
		CampoMinado.setVerticalAlignment(SwingConstants.TOP);
		CampoMinado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 46));
		CampoMinado.setBackground(Color.WHITE);
		CampoMinado.setBounds(0, 0, 434, 640);
		contentPane.add(CampoMinado);

	}
    public void gameInicialization() throws UnsupportedAudioFileException, IOException, LineUnavailableException {    	
    	Game.gameinit = true;
    	
    	if(key == 1) {
    		GRIDSIZE = 15;
    	}else if(key == 2){ 
    		GRIDSIZE = 17;
    	}else if(key == 3) {
    		GRIDSIZE = 20;
    	}
    	new Window(WIDTH, HEIGHT, GRIDSIZE, "Campo minado - ", this, handler);  
        Window.update(0);
        
    }
	public boolean isExit() {
		return exit;
	}
	public void setExit(boolean exit) throws InvalidAttribute {
		if(((Object)exit).getClass().getSimpleName() != "Boolean") {
			throw new InvalidAttribute();
		}else {
			this.exit = exit;			
		}
	}
	
	public static boolean isGameinit() {
		return gameinit;
	}
	public static void setGameinit(boolean gameinit) throws InvalidAttribute {
		if(((Object)gameinit).getClass().getSimpleName() != "Boolean") {
			throw new InvalidAttribute();
		}
		else {
			Game.gameinit = gameinit;
		}
	}

}