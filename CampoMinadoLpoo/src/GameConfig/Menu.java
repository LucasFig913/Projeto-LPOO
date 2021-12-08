package GameConfig;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Menu extends JFrame{

	private JPanel contentPane;
	static JButton PLAY;
	JButton DIFICULTY;
	JButton RANKING;
	
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PLAY = new JButton("PLAY");
		PLAY.setBackground(Color.BLACK);
		PLAY.setForeground(Color.BLACK);
		PLAY.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		PLAY.setBounds(161, 94, 106, 43);
		PLAY.addActionListener(e -> Game.gameState="NORMAL");
		contentPane.add(PLAY);
				
		DIFICULTY = new JButton("DIFFICULTY");
		DIFICULTY.setBackground(Color.BLACK);
		DIFICULTY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		DIFICULTY.setBounds(161, 148, 106, 23);
		contentPane.add(DIFICULTY);
		
		RANKING = new JButton("RANKING");
		RANKING.setBackground(Color.BLACK);
		RANKING.setBounds(161, 182, 106, 23);
		contentPane.add(RANKING);
		
		JLabel CampoMinado = new JLabel("CampoMinado");
		CampoMinado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 46));
		CampoMinado.setBackground(Color.WHITE);
		CampoMinado.setBounds(45, 31, 348, 43);
		contentPane.add(CampoMinado);
	}


}
