package Board;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import GameConfig.Game;
import GameConfig.Timer;
import GameConfig.Window;

public class Handler {

    private ArrayList<Cell> current = new ArrayList<Cell>();
    private ArrayList<Cell> queue = new ArrayList<Cell>();
    private String unicBomb = "\uD83D\uDCA3";
    private String unicFlag = "\u2691";
    private String unicExplosion = "\uD83D\uDCA5";


    private static int flaggedCells = 0;
    
    public void click(Cell cell) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        int discoveredCells = 0;
        if(!cell.isFlagged()) {
            cell.setEnabled(false);
            cell.setDiscovered(true);

            int position = cell.getPosition();
            if(cell.getType() == 0) {
                if(position < Game.GRIDSIZE) {
                    if(position % Game.GRIDSIZE == 0) {
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE + 1)));
                        queue.add(Grid.cellGrid.get((position + 1)));
                    } else if(position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE - 1)));
                        queue.add(Grid.cellGrid.get((position - 1)));
                    } else {
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE + 1)));
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE - 1)));
                        queue.add(Grid.cellGrid.get((position + 1)));
                        queue.add(Grid.cellGrid.get((position - 1)));
                    }
                } else if(position >= (Game.GRIDSIZE * (Game.GRIDSIZE - 1))) {
                    if(position % Game.GRIDSIZE == 0) {
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE + 1)));
                        queue.add(Grid.cellGrid.get((position + 1)));
                    } else if(position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE - 1)));
                        queue.add(Grid.cellGrid.get((position - 1)));
                    } else {
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE + 1)));
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE - 1)));
                        queue.add(Grid.cellGrid.get((position + 1)));
                        queue.add(Grid.cellGrid.get((position - 1)));
                    }
                } else if(position % Game.GRIDSIZE == 0) {
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE + 1)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE + 1)));
                    queue.add(Grid.cellGrid.get((position + 1)));
                } else if(position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE - 1)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE - 1)));
                    queue.add(Grid.cellGrid.get((position - 1)));
                } else {
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE - 1)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE - 1)));
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE + 1)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE + 1)));
                    queue.add(Grid.cellGrid.get((position - 1)));
                    queue.add(Grid.cellGrid.get((position + 1)));
                }
            } else if(cell.getType() == 2) {
                int dangerCount = 0;
                if(position < Game.GRIDSIZE) {
                    if(position % Game.GRIDSIZE == 0) {
                        if(Grid.cellGrid.get(position + Game.GRIDSIZE).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position + Game.GRIDSIZE + 1).getType() == 1) dangerCount++; 
                        if(Grid.cellGrid.get(position + 1).getType() == 1) dangerCount++;
                    } else if(position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                        if(Grid.cellGrid.get(position + Game.GRIDSIZE).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position + Game.GRIDSIZE - 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position - 1).getType() == 1) dangerCount++;
                    } else {
                        if(Grid.cellGrid.get(position + Game.GRIDSIZE).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position + Game.GRIDSIZE + 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position + Game.GRIDSIZE - 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position + 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position - 1).getType() == 1) dangerCount++;
                        System.out.println(dangerCount);
                    }
                } else if(position >= (Game.GRIDSIZE * (Game.GRIDSIZE - 1))) {
                    if(position % Game.GRIDSIZE == 0) {
                        if(Grid.cellGrid.get(position - Game.GRIDSIZE).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position - Game.GRIDSIZE + 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position + 1).getType() == 1) dangerCount++;
                    } else if(position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                        if(Grid.cellGrid.get(position - Game.GRIDSIZE).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position - Game.GRIDSIZE - 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position - 1).getType() == 1) dangerCount++;
                    } else {
                        if(Grid.cellGrid.get(position - Game.GRIDSIZE).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position - Game.GRIDSIZE + 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position - Game.GRIDSIZE - 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position + 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position - 1).getType() == 1) dangerCount++;
                    }
                } else if(position % Game.GRIDSIZE == 0) {
                    if(Grid.cellGrid.get(position - Game.GRIDSIZE).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get(position + Game.GRIDSIZE).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get(position - Game.GRIDSIZE + 1).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get(position + Game.GRIDSIZE + 1).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get(position + 1).getType() == 1) dangerCount++;
                } else if(position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                    if(Grid.cellGrid.get((position - Game.GRIDSIZE)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position + Game.GRIDSIZE)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position - Game.GRIDSIZE - 1)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position + Game.GRIDSIZE - 1)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position - 1)).getType() == 1) dangerCount++;
                } else {
                    if(Grid.cellGrid.get((position - Game.GRIDSIZE)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position + Game.GRIDSIZE)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position - Game.GRIDSIZE - 1)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position + Game.GRIDSIZE - 1)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position - Game.GRIDSIZE + 1)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position + Game.GRIDSIZE + 1)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position - 1)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position + 1)).getType() == 1) dangerCount++;
                }
                cell.setText(String.valueOf(dangerCount));
            } else if(cell.getType() == 1) {
                for(int x = 0; x < Grid.cellGrid.size(); x++) {
                    Grid.cellGrid.get(x).setEnabled(false);
                    Grid.cellGrid.get(x).setText("");
                    if(Grid.cellGrid.get(x).getType() == 1) {Grid.cellGrid.get(x).setText(unicBomb.toUpperCase());}
                }
                Timer.stop();
                cell.setText(unicExplosion);
                File file = new File("boom.wav");
            	AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            	Clip clip = AudioSystem.getClip();
            	clip.open(audioStream);
            	
            	clip.start();
            }  

            for(int x = 0; x < queue.size(); x++) {
                if(!queue.get(x).isDiscovered()) {
                    current.add(queue.get(x));
                    queue.get(x).setDiscovered(true);
                }
            }
            queue.clear();
            while(!current.isEmpty()) {
                Cell temp = current.get(0);
                current.remove(0);
                temp.clickButton();
            }

            for(int x = 0; x < Grid.cellGrid.size(); x++) {
                if(Grid.cellGrid.get(x).isDiscovered()) {
                    discoveredCells++;
                }
            }

            if(discoveredCells == Grid.cellGrid.size() - Game.MINECOUNT) {
                for(int x = 0; x < Grid.cellGrid.size(); x++) {
                    if(Grid.cellGrid.get(x).getType() == 1) {
                        Grid.cellGrid.get(x).setEnabled(false);
                        Grid.cellGrid.get(x).setText(unicBomb.toUpperCase());
                    } else {
                        Grid.cellGrid.get(x).setEnabled(false);
                        Grid.cellGrid.get(x).setText(":)");
                    }
                }
            }
        }   
    }

    public void rightClick(Cell cell) {
        if(!cell.isDiscovered()) {
            if(!cell.isFlagged()) {
                cell.setFlagged(true);
                cell.setText(unicFlag);
                flaggedCells++;
                Window.update(flaggedCells);
            } else {
                cell.setFlagged(false);
                cell.setText("");
                flaggedCells--;
                Window.update(flaggedCells);
            }
        }
    }
}

