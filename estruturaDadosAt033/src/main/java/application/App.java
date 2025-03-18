package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import javafx.stage.StageStyle;
import model.AnalisadorDesempenho;
import model.BuscaBinaria;
import model.IAnalisadorDesempenho;
import model.IEstruturaDeDados;
import model.Palavras;
import service.GerenciadorPesquisa;
import service.IGerenciadorPesquisa;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private String textoTeste;
    
    @Override
    public void start(Stage stage) throws IOException {
        try{
            scene = new Scene(loadFXML("home"));
            stage.setTitle("Nome_App");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();   
        }catch(Exception erro){
            System.out.println(erro.getMessage());
        }
    }
    

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}