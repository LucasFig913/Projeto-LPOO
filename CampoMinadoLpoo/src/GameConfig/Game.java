package GameConfig;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton PLAY = new JButton("PLAY");
		PLAY.setBackground(Color.WHITE);
		PLAY.setForeground(Color.BLACK);
		PLAY.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
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
		EASY.setBackground(Color.WHITE);
		EASY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key = 1;
			}
		});
		EASY.setBounds(161, 148, 106, 23);
		contentPane.add(EASY);
		
		JButton NORMAL = new JButton("NORMAL");
		NORMAL.setBackground(Color.WHITE);
		NORMAL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key = 2;
			}
		});
		NORMAL.setBounds(161, 184, 106, 23);
		contentPane.add(NORMAL);
		
		JButton HARD = new JButton("MALUCO");
		HARD.setBackground(Color.WHITE);
		HARD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				key = 3;
			}
		});
		HARD.setBounds(161, 218, 106, 23);
		contentPane.add(HARD);
		
		JButton RANKING = new JButton("RANKING");
		RANKING.setBackground(Color.WHITE);
		RANKING.setBounds(161, 252, 106, 23);
		contentPane.add(RANKING);
		RANKING.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ranking ranking2 = new Ranking(null, 0);
				ranking2.showRanking();
			}
		});

		
		JButton LOADGAME = new JButton("LOAD GAME");
		LOADGAME.setBackground(Color.WHITE);
		LOADGAME.setBounds(161, 286, 106, 23);
		contentPane.add(LOADGAME);

		
		
		
		JLabel CampoMinado = new JLabel("CampoMinado");
		CampoMinado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 46));
		CampoMinado.setBackground(Color.WHITE);
		CampoMinado.setBounds(45, 31, 348, 43);
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
