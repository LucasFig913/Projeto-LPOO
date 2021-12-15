package Exceptions;

public class FWriterException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		super("Não foi possível acessar o arquivo");

	}
}
