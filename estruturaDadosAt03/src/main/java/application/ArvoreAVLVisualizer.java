package application;

import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import model.No;

public class ArvoreAVLVisualizer {
    private Pane pane;
    private ScrollPane scrollPane; // Variável declarada

    /**
     * Construtor que recebe a raiz da árvore e as dimensões do painel.
     */
    public ArvoreAVLVisualizer(No raiz, double width, double height) {
        pane = new Pane();
        // Ajuste o tamanho do pane conforme a necessidade; 
        // aqui definimos um tamanho inicial, mas pode ser dinâmico
        pane.setPrefSize(width * 2, height * 2); // Exemplo: área maior para permitir scroll

        // Inicia o desenho com a raiz centralizada horizontalmente e com uma margem superior
        desenharNo(raiz, width, 30, width / 2);

        // Cria o ScrollPane e define suas propriedades
        scrollPane = new ScrollPane(pane);
        scrollPane.setPrefSize(width, height);
        scrollPane.setPannable(true);  // Permite arrastar o conteúdo com o mouse

        // Adiciona zoom com a roda do mouse enquanto a tecla Ctrl é pressionada
        scrollPane.addEventFilter(ScrollEvent.SCROLL, event -> {
            if (event.isControlDown()) {
                double delta = event.getDeltaY();
                double scale = pane.getScaleX(); // Assume escala uniforme para X e Y
                double factor = (delta > 0) ? 1.1 : 0.9;
                pane.setScaleX(scale * factor);
                pane.setScaleY(scale * factor);
                event.consume();
            }
        });
    }

    /**
     * Método recursivo para desenhar cada nó da árvore.
     * @param no Nó atual.
     * @param x Posição X do nó.
     * @param y Posição Y do nó.
     * @param horizontalSpacing Espaçamento horizontal para os filhos.
     */
    private void desenharNo(No no, double x, double y, double horizontalSpacing) {
        if (no == null) return;

        // Desenha linha conectando com o filho esquerdo, se existir
        if (no.getEsquerda() != null) {
            double xEsquerda = x - horizontalSpacing;
            double yFilho = y + 60;
            Line linhaEsquerda = new Line(x, y, xEsquerda, yFilho);
            pane.getChildren().add(linhaEsquerda);
            desenharNo(no.getEsquerda(), xEsquerda, yFilho, horizontalSpacing / 2);
        }

        // Desenha linha conectando com o filho direito, se existir
        if (no.getDireita() != null) {
            double xDireita = x + horizontalSpacing;
            double yFilho = y + 60;
            Line linhaDireita = new Line(x, y, xDireita, yFilho);
            pane.getChildren().add(linhaDireita);
            desenharNo(no.getDireita(), xDireita, yFilho, horizontalSpacing / 2);
        }

        // Desenha o nó (círculo com o texto)
        Circle circulo = new Circle(x, y, 20);
        circulo.setFill(Color.LIGHTBLUE);
        circulo.setStroke(Color.BLACK);

        // Exibe o texto (a palavra contida no nó)
        Text texto = new Text(x - 10, y + 5, no.getDado().getTexto());

        pane.getChildren().addAll(circulo, texto);
    }

    public ScrollPane getPane() {
        return scrollPane;
    }
}
