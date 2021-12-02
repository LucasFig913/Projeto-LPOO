package gameConfig;

public class Game {
	public static final int WIDTH = 720;
	public static final int HEIGHT = 720;
	public static final int CELLSIZE = 10;
	public static final int MINECOUNT = 10;
	
	public Game() {
		new Window(WIDTH, HEIGHT, CELLSIZE, "Campo Minado", this);
	}
	
	public static void main(String[] args) {
		new Game();
	}
}
