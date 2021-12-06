package GameConfig;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class Menu extends JFrame {
    private static JFrame frame;
    private static String title;
	
    public Menu(int width, int height, int gridSize) {
    	JButton PLAY = new JButton("PLAY");
    	PLAY.setVisible(true);
    	getContentPane().add(PLAY, BorderLayout.CENTER);
    	frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

}
