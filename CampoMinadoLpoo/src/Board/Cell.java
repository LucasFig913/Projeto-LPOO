package Board;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import GameConfig.Game;

import java.awt.event.*;
import java.io.IOException;

public class Cell extends JButton {

	private static final long serialVersionUID = 1L;
	private int type;
    private int position;
    private boolean discovered;
    private boolean flagged;

	private Handler handler;
	
	public Boolean cellCrazy() {
		if(Game.crazy == true) {
			return Game.crazy;	
		}else {
			return Game.crazy=false;
		}
	}

    public Cell(int type, int position, boolean discovered, boolean flagged, Handler handler) {
        this.type = type;
        this.position = position;
        this.discovered = discovered;
        this.flagged = flagged;
        this.handler = handler;        

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)) {
                    try {
						rightClickButton();
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
                } else {
                    try {
						clickButton();
					} catch (LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            }

            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });
    }
    
    public void rightClickButton() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        handler.rightClick(this);       
    }

    public int getType() {
        // TYPES -- 0: Empty, 1: Mine, 2: Number
        return type;
    }

    public int getPosition() {
        return position;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean d) {
        this.discovered = d;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean f) {
        this.flagged = f;
    }

    public void clickButton() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        handler.click(this);
    }


}
