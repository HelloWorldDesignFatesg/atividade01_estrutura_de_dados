package application;

import java.net.URL;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import model.Palavras;
import model.IEstruturaDeDados;
import model.Arvore;
import model.ArvoreAVL;
import model.No;
import service.GerenciadorPesquisa;
import service.IGerenciadorPesquisa;
import service.ILeitorArquivo;
import service.LeitorArquivo;
import service.Sistema;
import application.ArvoreAVLVisualizer;
import application.ArvoreBinariaVisualizer;

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
    
    // Variáveis para armazenar as estruturas de dados
    private IEstruturaDeDados arvoreAVL;
    private IEstruturaDeDados arvoreBinaria;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Configurações iniciais, se necessário.
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
        
        // Configura a tabela com as palavras limpas
        cPalavras.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTexto()));
        cQuantidade.setCellValueFactory(cellData -> new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getFrequencia()).asObject());

        ObservableList<Palavras> palavras = FXCollections.observableArrayList();
        for (Palavras palavra : gerenciador.getPalavrasLimpasUnicas()){
            palavras.add(palavra);
        }
        tabela.setItems(palavras);
        
        cQuantidade.setSortType(TableColumn.SortType.DESCENDING);
        tabela.getSortOrder().add(cQuantidade);
        tabela.sort();

        // Recupera as estruturas a partir do Sistema
        for (IEstruturaDeDados estrutura : sistema.getEstruturas()) {
            if (estrutura.NomeEstrutra().equals("Árvore AVL")) {
                arvoreAVL = estrutura;
            } else if (estrutura.NomeEstrutra().equals("Árvore Binária")) {
                arvoreBinaria = estrutura;
            }
        }
    }
    
    @FXML
    private void visualizarAVL(ActionEvent event) {
        if (arvoreAVL != null && arvoreAVL instanceof ArvoreAVL) {
            No raiz = ((ArvoreAVL) arvoreAVL).getRaiz();
            ArvoreAVLVisualizer visualizador = new ArvoreAVLVisualizer(raiz, 1280, 800);
            Pane paneVisualizacao = visualizador.getPane();
            
            Stage stage = new Stage();
            Scene scene = new Scene(paneVisualizacao, 1280, 800);
            stage.setScene(scene);
            stage.setTitle("Visualização da Árvore AVL");
            stage.show();
        } else {
            System.out.println("A árvore AVL não foi inicializada ou não está disponível.");
        }
    }
    
    @FXML
    private void visualizarArvoreBinaria(ActionEvent event) {
        if (arvoreBinaria != null && arvoreBinaria instanceof Arvore) {
            No raiz = ((Arvore) arvoreBinaria).getRaiz();
            if (raiz != null) {
                ArvoreBinariaVisualizer visualizador = new ArvoreBinariaVisualizer(raiz, 1280, 800);
                Pane paneVisualizacao = visualizador.getPane();
                
                Stage stage = new Stage();
                Scene scene = new Scene(paneVisualizacao, 1280, 800);
                stage.setScene(scene);
                stage.setTitle("Visualização da Árvore Binária");
                stage.show();
            } else {
                System.out.println("A raiz da árvore binária é nula.");
            }
        } else {
            System.out.println("A árvore binária não foi inicializada ou não está disponível.");
        }
    }
    
    @FXML
    private void fecharPrograma(ActionEvent event) {
        Platform.exit();
    }
}
