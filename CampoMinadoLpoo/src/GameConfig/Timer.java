package GameConfig;

import java.util.concurrent.atomic.AtomicBoolean;

import Board.Cell;
import Board.Handler;

public class Timer implements Runnable{
		private static boolean exit = false;
	    public static int seconds;
	   
	    public static int getSeconds() {
			return seconds;
		}
		public void setSeconds(int seconds) {
			this.seconds = seconds;
		}
		public int run(int x) {
	    	while (!exit) {
	            this.seconds++;
	            if(this.seconds==x)
	            	System.exit(0);
	            try {
	                Thread.sleep(1000);
	            } catch (Exception e) {
	            	
	            }
	            System.out.println(this.seconds);
	        	
	    	}
			return this.seconds;
	    }
	    public static void stop(){
	   
	    	exit = true;
	    }
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	}
