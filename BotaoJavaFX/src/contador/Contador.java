package contador;

import java.util.Timer;
import java.util.TimerTask;

public class Contador{
    Timer timer;

    public Contador(int seconds, String limpar) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }

    class RemindTask extends TimerTask {

        @Override
        public void run() {
            timer.cancel(); 
        }
        
    }
}    