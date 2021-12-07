package GameConfig;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import Board.Grid;

import java.awt.BorderLayout;
import javax.swing.JButton;

public class Menu extends JFrame {
	
    private static JFrame frame;
    private static String title = "teste";

    public Menu(int width, int height) {
    	frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //JPanel panel = new Grid(new GridLayout(gridSize, gridSize), handler);

        frame.pack();

        frame.setVisible(true);
    }

}
