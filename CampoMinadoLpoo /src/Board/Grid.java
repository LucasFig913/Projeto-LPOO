package Board;
import java.util.*;
import javax.swing.*;

import gameConfig.Game;

public class Grid extends JPanel{

	private int bound = Game.CELLSIZE * Game.CELLSIZE;	
	private Boolean picked = false;	
	private ArrayList<Integer> mines = new ArrayList<Integer>(); 	
	public static ArrayList<Cell>cellGrid = new ArrayList<Cell>();
	
	public Grid() {
		createCells();
		addCells();
	}

	public void createCells() {
		for(int i = 1; i<= Game.MINECOUNT; i++) {
			while(!picked) {
				int minePosition = (int)(Math.random()*bound);
				if(!mines.contains(minePosition)) {
					mines.add(minePosition);
					picked = true;
				}
			}
			picked = false;
		}
		for(int i = 0; i < bound; i++) {
			if(mines.contains(i)) {
				 cellGrid.add(new Cell(1, i, false, false));
			}else if(i % Game.CELLSIZE == 0){
				if(mines.contains(i - Game.CELLSIZE)    ||
						mines.contains(i - Game.CELLSIZE+1)  ||
						mines.contains(i +1)                 ||
						mines.contains(i + Game.CELLSIZE)    ||
						mines.contains(i + Game.CELLSIZE + 1)) {
					cellGrid.add(new Cell(2, i, false, false));
				}else {
					cellGrid.add(new Cell(0, i, false, false));
				}
			}else if(i % Game.CELLSIZE == Game.CELLSIZE - 1){
				if(mines.contains(i - Game.CELLSIZE - 1)     || 
						mines.contains(i - Game.CELLSIZE)    ||
						mines.contains(i - 1)                ||
						mines.contains(i + Game.CELLSIZE - 1)||
						mines.contains(i + Game.CELLSIZE)) {
					cellGrid.add(new Cell(2, i, false, false));
				}else {
					cellGrid.add(new Cell(0, i, false, false));
				}
				}else{
				if(mines.contains(i - Game.CELLSIZE - 1)     || 
						mines.contains(i - Game.CELLSIZE)    ||
						mines.contains(i - Game.CELLSIZE+1)  ||
						mines.contains(i - 1)                ||
						mines.contains(i +1)                 ||
						mines.contains(i + Game.CELLSIZE - 1)||
						mines.contains(i + Game.CELLSIZE)    ||
						mines.contains(i + Game.CELLSIZE + 1)) {
					cellGrid.add(new Cell(2, i, false, false));
				}else {
					cellGrid.add(new Cell(0, i, false, false));
				}
			}
		}
		
	}

	public void addCells() {
		
		
	}
}
