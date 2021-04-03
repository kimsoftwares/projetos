package br.com.kimsoftwares.classes;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TelaPrincipal extends Application {
    private static Stage stage; // aqui é uma janela
           
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/kimsoftwares/telas/TelaPrincipal.fxml"));//carrega fxml
        Scene scene = new Scene(root);                                                                    //coloca o fxml em uma cena
        stage.setResizable(false);                                                                       //desabilita maximizar      
        stage.getIcons().add(new Image("br/com/kimsoftwares/imagens/usuarios.png"));                    //carrega imagem e muda o icone padrão da tela login
        stage.setTitle("Tela principal do Sistema Cadastros versão 1.0.0");                                     //Coloca o titulo na janela
        stage.setScene(scene);                                                                        //coloca a sena em uma janela
        stage.show();                                                                                // abre a janela
        setStage(stage);
    }
    //Metodos gets e sets do atributo da tela login
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        TelaPrincipal.stage = stage;
    }
}    
