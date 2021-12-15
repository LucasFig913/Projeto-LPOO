package GameConfig;

import javax.swing.JOptionPane;

import Exceptions.ExcededTime;

public class Timer implements Runnable{
		private static boolean exit = false;
	    private static int seconds;
	    public String seconds2;
	   
	    public static int getSeconds() {
			return seconds;
		}
		public void setSeconds(int seconds) {
			Timer.seconds = seconds;
		}
		public int run(int x) {
	    	while (!exit) {
	            Timer.seconds++;
		         if(Timer.seconds == x){
	            	try {
		            	throw new ExcededTime(x);	            	
		            }catch(ExcededTime e) {
		            	JOptionPane.showMessageDialog(null,"Exceded Time");		       
		            	exit = true;
		            }
		         }
	            try {
	                Thread.sleep(1000);
	            } catch (Exception e) {
	            	
	            }
	            System.out.println(Timer.seconds);
	        	
	    	}
			return Timer.seconds;
	    }
	    public static void stop(){
	   
	    	exit = true;
	    }
		@Override
		public void run() {
			
		}
	}
