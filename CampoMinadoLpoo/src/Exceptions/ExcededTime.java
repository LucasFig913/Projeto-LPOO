package Exceptions;

public class ExcededTime extends Exception {
	private int seconds;
	private int x;
	
	public ExcededTime(int seconds) {
		super();
		this.setSeconds(seconds);
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
}
