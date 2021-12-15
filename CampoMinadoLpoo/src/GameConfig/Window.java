package GameConfig;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Board.Grid;
import Board.Handler;

public class Window {

    private static JFrame frame;
    private static String title;
    private static int titleArea = 1;

    public Window(int width, int height, int gridSize, String title, Game game, Handler handler) {
        Window.setTitle(title);
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
        


    }
    public static void update(int flagged) {
            frame.setTitle("Minas: " + Game.MINECOUNT + " - Bandeiras: " + flagged);

    }
	public static int getTitleArea() {
		return titleArea;
	}
	public static void setTitleArea(int titleArea) {
		Window.titleArea = titleArea;
	}
	public static String getTitle() {
		return title;
	}
	public static void setTitle(String title) {
		Window.title = title;
	}
}