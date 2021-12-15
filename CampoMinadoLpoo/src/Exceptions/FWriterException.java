package Exceptions;

public class FWriterException extends Exception{
	private int time;
	private String name;
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FWriterException(){
		super("N�o foi poss�vel acessar o arquivo");

	}
}
