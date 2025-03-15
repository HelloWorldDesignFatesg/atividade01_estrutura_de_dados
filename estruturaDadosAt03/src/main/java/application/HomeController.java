/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package application;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import model.Palavras;
import service.GerenciadorPesquisa;
import service.IGerenciadorPesquisa;
import service.ILeitorArquivo;
import service.LeitorArquivo;
import service.Sistema;

/**
 * FXML Controller class
 *
 * @author Spindola
 */
public class HomeController implements Initializable {

    @FXML
    private Button btn_fechar;

    @FXML
    private Button btn_voltar;

    @FXML
    private AnchorPane paneSobre;
    
    @FXML
    private AnchorPane paneHome;

    @FXML
    private AnchorPane paneMedidor;

    @FXML
    private StackPane stackPane;
    
    @FXML
    private TableView<Palavras> tabela;
    
    @FXML
    private TableColumn<Palavras, String> cPalavras;

    @FXML
    private TableColumn<Palavras, Integer> cQuantidade;

    @FXML
    private Label labelResultadoTempo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
    public void abrirJanelaMedidor(){
        stackPane.getChildren().clear();
        stackPane.getChildren().add(paneMedidor);
        paneMedidor.setVisible(true);
        paneSobre.setVisible(false);
        paneHome.setVisible(false);
        btn_fechar.setVisible(false);
        btn_voltar.setVisible(true);
    }
    
    public void abrirJanelaSobre(){
        stackPane.getChildren().clear();
        stackPane.getChildren().add(paneSobre);
        paneMedidor.setVisible(false);
        paneSobre.setVisible(true);
        paneHome.setVisible(false);
        btn_fechar.setVisible(false);
        btn_voltar.setVisible(true);
    }
    
    public void abrirJanelaHome(){
        stackPane.getChildren().clear();
        stackPane.getChildren().add(paneHome);
        paneMedidor.setVisible(false);
        paneSobre.setVisible(false);
        paneHome.setVisible(true);
        btn_fechar.setVisible(true);
        btn_voltar.setVisible(false);
    }
 
    public void abrirArquivoTxt(){
        ILeitorArquivo leitor = new LeitorArquivo();
        IGerenciadorPesquisa gerenciador = new GerenciadorPesquisa();
        Sistema sistema = new Sistema();
        
        String meuTxt = leitor.lerArquivo();
        gerenciador.processarArquivo(meuTxt);
        sistema.setPalavrasLimpas(gerenciador.getPalavrasLimpas());
        sistema.IniciarMedidorDeDesempenho();
        labelResultadoTempo.setText(gerenciador.informacaoSobreArquivoTxt() + sistema.getResultados());
        
        cPalavras.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTexto()));  // Vincula o método "getTexto"
        cQuantidade.setCellValueFactory(cellData -> new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getFrequencia()).asObject());  // Vincula o método "getFrequencia"

        // Adicionar dados à tabela
        ObservableList<Palavras> palavras = FXCollections.observableArrayList();
        
        for (Palavras palavra : gerenciador.getPalavrasLimpasUnicas()){
            palavras.add(palavra);
        }
        tabela.setItems(palavras);
    }
    @FXML
    private void fecharPrograma(ActionEvent event) {
        Platform.exit();
    }
    
}
