package GameConfig;


import java.util.concurrent.atomic.AtomicBoolean;

public class Timer implements Runnable{
    private boolean exit = false;
    private int seconds;
    @Override
    public void run() {
    	while (!exit) {
            seconds++;
            if(seconds==990)
                seconds=0;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
    public void stop(){
        exit = true;
    }
}