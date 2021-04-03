package contador;

import controller.TelaBotaoController;
import java.util.Timer;
import java.util.TimerTask;

public class Contador{
    Timer timer;
    TelaBotaoController limpar = new TelaBotaoController();
    
    public Contador(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }
    
    class RemindTask extends TimerTask {

        @Override
        public void run() {
            limpar.limparbtnMensagem("");
            timer.cancel(); 
        }   
    }
}    