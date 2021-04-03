package br.com.kimsoftwares.controles;

import br.com.kimsoftwares.classes.TelaLogin;
import br.com.kimsoftwares.classes.TelaPrincipal;
import br.com.kimsoftwares.conexao.ConexaoDB;
import br.com.kimsoftwares.contador.Contador;
import br.com.kimsoftwares.sql.UsuariosSQL;
import java.sql.Connection;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TelaLoginController implements Initializable {
            
    @FXML private Button btnLogin;
    @FXML public Button btnMensagem;
    @FXML private ImageView imgConectado;
    @FXML private TextField txtLogin;
    @FXML private PasswordField txtSenha;
    
    public static Button static_btnMensagem;
    
    @FXML
    private void clicouBotaoLogin(ActionEvent event) {
        System.out.println("Teste de botão");
        new Contador(10);
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Connection conexao = ConexaoDB.getConexao();
        
        //A linha abaixo serve de apoio ao status da conexão
        if (conexao != null) {
            btnMensagem.setText("Conectado com o banco de dados");
            Image imagem = new Image("/br/com/kimsoftwares/imagens/conectado.png");
            imgConectado.setImage(imagem);
            
            
        } else {
            btnMensagem.setText("Sem conexão com o banco de dados");
            Image imagem = new Image("/br/com/kimsoftwares/imagens/nao_conectado.png");
            imgConectado.setImage(imagem);

        }
        
        btnMensagem = static_btnMensagem;
        
        txtLogin.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                txtSenha.requestFocus();
            }
        });

        btnLogin.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logar();
            }
        });
        
        txtSenha.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logar();
            }
        });

        btnLogin.setOnMouseClicked((MouseEvent e) -> {
            logar();
        });
    }

    public void fecha() {
        TelaLogin.getStage().close();
    }

    public void logar() {
        
        
        if (txtLogin.getText().equals("elmar") && txtSenha.getText().equals("1234")) {
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            fecha();
            try {
                telaPrincipal.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(UsuariosSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Erro");
            alert.setTitle("Atenção erro de login ou senha");
            alert.setContentText("Usuário ou senha inválido.");
            alert.show();
        }
    }
}    
