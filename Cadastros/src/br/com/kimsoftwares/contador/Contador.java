package br.com.kimsoftwares.contador;

import br.com.kimsoftwares.controles.TelaLoginController;
import static br.com.kimsoftwares.controles.TelaLoginController.static_btnMensagem;
import java.util.Timer;
import java.util.TimerTask;

public class Contador extends TelaLoginController {
    Timer timer;

    public Contador(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }

    class RemindTask extends TimerTask {

        @Override
        public void run() {
            static_btnMensagem.setText(btnMensagem.getText());
            timer.cancel(); 
        }
    }
}    

