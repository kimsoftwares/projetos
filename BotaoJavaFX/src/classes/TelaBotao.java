package classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TelaBotao extends Application {
            
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaBotao.fxml"));//carrega fxml
        Scene scene = new Scene(root);                                                //coloca o fxml em uma cena
        stage.setResizable(false);                                                   //desabilita maximizar      
        stage.getIcons().add(new Image("imagens/usuarios.png"));                    //carrega imagem e muda o icone padrão da tela login
        stage.setTitle("Teste de Botao dentro de um timer");                       //Coloca o titulo na janela
        stage.setScene(scene);                                                    //coloca a sena em uma janela
        stage.show();                                                            // abre a janela
    }
}