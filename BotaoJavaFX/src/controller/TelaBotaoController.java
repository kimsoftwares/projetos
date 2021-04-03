package controller;

import contador.Contador;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TelaBotaoController implements Initializable {
            
    @FXML private Button btnInfo;
    @FXML private Button btnMensagem;
    @FXML private Button btnApagar;
    @FXML private Button btnSair;
    
    @FXML
    private void clicouBotaoSair(ActionEvent event) {
        System.exit(0);
    }   
    
    @FXML
    private void clicouBotaoMensagem(ActionEvent event) {
        btnInfo.setText("Quero apagar esta mensagem em 10 segundos dentro de um timer");
    }
    
    @FXML
    private void clicouBotaoApagar(ActionEvent event) {
        new Contador(10);
        //Esta retornando null
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    public String limparbtnMensagem(String texto){
        btnInfo.setText(texto);
        return texto;
    }
}
