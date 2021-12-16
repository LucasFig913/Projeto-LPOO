package Board;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import GameConfig.Game;

public class Grid extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int bound = Game.GRIDSIZE * Game.GRIDSIZE;

    private boolean picked = false;

    private ArrayList<Integer> mines = new ArrayList<Integer>();

    public static ArrayList<Cell> cellGrid = new ArrayList<Cell>();

    public Grid(GridLayout g, Handler h) throws IOException {
        super(g);
        createCells(h);
        addCells();
    	setBackground(new Color(0, 153, 0));
    }
	public void createCells(Handler h) throws IOException {
        for(int i = 1; i <= Game.MINECOUNT; i++) {
            while(!picked) {
                int minePosition = (int) (Math.random() * bound);
                if (!mines.contains(minePosition)) {
                    mines.add(minePosition);
                    picked = true;
                }
            }
            picked = false;
        }

        for(int i = 0; i < bound; i++) {
            if(mines.contains(i)) {
                cellGrid.add(new Cell(1, i, false, false, h));
            } else if(i % Game.GRIDSIZE == 0){
                if(mines.contains(i - Game.GRIDSIZE) ||
                        mines.contains(i - Game.GRIDSIZE + 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Game.GRIDSIZE) ||
                        mines.contains(i + Game.GRIDSIZE + 1)) {
                    cellGrid.add(new Cell(2, i, false, false, h));
                } else {
                    cellGrid.add(new Cell(0, i, false, false, h));
                }
            } else if(i % Game.GRIDSIZE == Game.GRIDSIZE - 1){
                if(mines.contains(i - Game.GRIDSIZE - 1) ||
                        mines.contains(i - Game.GRIDSIZE) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + Game.GRIDSIZE - 1) ||
                        mines.contains(i + Game.GRIDSIZE)) {
                    cellGrid.add(new Cell(2, i, false, false, h));
                } else {
                    cellGrid.add(new Cell(0, i, false, false, h));
                }
            }else {
                if(mines.contains(i - Game.GRIDSIZE - 1) ||
                        mines.contains(i - Game.GRIDSIZE) ||
                        mines.contains(i - Game.GRIDSIZE + 1) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Game.GRIDSIZE - 1) ||
                        mines.contains(i + Game.GRIDSIZE) ||
                        mines.contains(i + Game.GRIDSIZE + 1)) {
                    cellGrid.add(new Cell(2, i, false, false, h));
                } else {
                    cellGrid.add(new Cell(0, i, false, false, h));
                }
            }
        }
    }
    
    public void crateCrazyCells(Handler h) throws IOException {
    	if(Game.key == 4) {
    		
    		for(int i = 1; i <= Game.MINECOUNT/2; i++) {
                while(!picked) {
                    int minePosition = (int) (Math.random() * bound);
                    if (!mines.contains(minePosition)) {
                        mines.add(minePosition);
                        picked = true;
                    }
                }
                picked = false;
            }

            for(int i = 0; i < bound; i++) {
                if(mines.contains(i)) {
                    cellGrid.add(new Cell(3, i, false, false, h));
                } else if(i % Game.GRIDSIZE == 0){
                    if(mines.contains(i - Game.GRIDSIZE) ||
                            mines.contains(i - Game.GRIDSIZE + 1) ||
                            mines.contains(i + 1) ||
                            mines.contains(i + Game.GRIDSIZE) ||
                            mines.contains(i + Game.GRIDSIZE + 1)) {
                        cellGrid.add(new Cell(4, i, false, false, h));
                    } else {
                        cellGrid.add(new Cell(0, i, false, false, h));
                    }
                 
                    } else {
                        cellGrid.add(new Cell(0, i, false, false, h));
                    }
                }
            }
    	}
            
        
    

    private void addCells() {
        for(int i = 0; i < cellGrid.size(); i++) {
            add(cellGrid.get(i));
        }
    }
}
