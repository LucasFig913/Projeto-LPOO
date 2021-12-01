package Board;
import javax.swing.*;

public class Cell extends JButton{

	private int type;
	private int position; 
	private Boolean opened;
	private Boolean flagged;
	
	public Cell(int type, int position, Boolean opened, Boolean flagged) {
		this.type = type;
		this.position = position;
		this.opened = opened;
		this.flagged = flagged;
	}

	public int getType() {
		//tipos: 0- vazio; 1- bomba; 2- numero
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Boolean getOpened() {
		return opened;
	}

	public void setOpened(Boolean opened) {
		this.opened = opened;
	}

	public Boolean getFlagged() {
		return flagged;
	}

	public void setFlagged(Boolean flagged) {
		this.flagged = flagged;
	}
}
