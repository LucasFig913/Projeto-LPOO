package GameConfig;
import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.sound.sampled.*;

import Board.Grid;
import Board.Handler;

import java.awt.*;

public class Window {

    private static JFrame frame;
    private static String title;

    public Window(int width, int height, int gridSize, String title, Game game, Handler handler) {
        Window.title = title;
        frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new Grid(new GridLayout(gridSize, gridSize), handler);

        frame.setContentPane(panel);
        frame.pack();

        frame.setVisible(true);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);


    }
    private void setJMenuBar(JMenuBar menuBar) {
		// TODO Auto-generated method stub
		
	}
	public static void update(int flagged) {
    	frame.setTitle("Minas: " + Game.MINECOUNT + " - Bandeiras: " + flagged);
    }
}
