package GameConfig;

import javax.swing.JOptionPane;
import java.lang.Runnable;

import Exceptions.ExcededTime;

public class Timer implements Runnable{
		private static boolean exit;
	    private static int seconds;

	    public static int getSeconds() {
			return seconds;
		}
		public void setSeconds(int seconds) {
			Timer.seconds = seconds;
		}
		public static Runnable timer = new Runnable() {
			public void run() {
		           while(!exit) {
					Timer.seconds++;
			         if(Timer.seconds == 999){
		            	try {
			            	throw new ExcededTime(999);	            	
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
		    }
		};

		public static boolean isExit() {
			return exit;
		}
		public static void setExit(boolean exit) {
			Timer.exit = exit;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}

	}