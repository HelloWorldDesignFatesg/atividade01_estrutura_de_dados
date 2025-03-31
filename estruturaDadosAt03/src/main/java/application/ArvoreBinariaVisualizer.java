package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import model.No;

public class ArvoreBinariaVisualizer {
    private Pane pane;

    /**
     * Construtor que recebe a raiz da árvore binária e as dimensões do painel.
     * @param raiz A raiz da árvore binária.
     * @param width Largura do painel de visualização.
     * @param height Altura do painel de visualização.
     */
    public ArvoreBinariaVisualizer(No raiz, double width, double height) {
        pane = new Pane();
        pane.setPrefSize(width, height);
        // Inicia o desenho com a raiz centralizada horizontalmente, com margem superior
        desenharNo(raiz, width / 2, 50, width / 4);
    }

    /**
     * Método recursivo que desenha cada nó e suas conexões.
     * @param no Nó atual.
     * @param x Posição X do nó.
     * @param y Posição Y do nó.
     * @param horizontalSpacing Espaçamento horizontal para os nós filhos.
     */
    private void desenharNo(No no, double x, double y, double horizontalSpacing) {
        if (no == null) return;
        
        // Desenhar conexão com o filho esquerdo, se existir
        if (no.getEsquerda() != null) {
            double xEsquerda = x - horizontalSpacing;
            double yFilho = y + 60; // espaçamento vertical constante
            Line linhaEsquerda = new Line(x, y, xEsquerda, yFilho);
            pane.getChildren().add(linhaEsquerda);
            desenharNo(no.getEsquerda(), xEsquerda, yFilho, horizontalSpacing / 2);
        }
        
        // Desenhar conexão com o filho direito, se existir
        if (no.getDireita() != null) {
            double xDireita = x + horizontalSpacing;
            double yFilho = y + 60;
            Line linhaDireita = new Line(x, y, xDireita, yFilho);
            pane.getChildren().add(linhaDireita);
            desenharNo(no.getDireita(), xDireita, yFilho, horizontalSpacing / 2);
        }
        
        // Desenhar o nó: círculo com o texto (a palavra)
        Circle circulo = new Circle(x, y, 20);
        circulo.setFill(Color.LIGHTGREEN);
        circulo.setStroke(Color.BLACK);
        pane.getChildren().add(circulo);
        
        Text texto = new Text(x - 10, y + 5, no.getDado().getTexto());
        pane.getChildren().add(texto);
    }
    
    public Pane getPane() {
        return pane;
    }
}
