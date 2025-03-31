package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import model.No;

public class ArvoreAVLVisualizer {
    private Pane pane;

    /**
     * Construtor que recebe a raiz da árvore e as dimensões do painel.
     */
    public ArvoreAVLVisualizer(No raiz, double width, double height) {
        pane = new Pane();
        pane.setPrefSize(width, height);
        // Inicia o desenho com a raiz centralizada horizontalmente e com uma margem superior
        desenharNo(raiz, width / 2, 30, width / 4);
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

        // Desenha linhas conectando com o filho esquerdo, se existir
        if (no.getEsquerda() != null) {
            double xEsquerda = x - horizontalSpacing;
            double yFilho = y + 60;
            Line linhaEsquerda = new Line(x, y, xEsquerda, yFilho);
            pane.getChildren().add(linhaEsquerda);
            desenharNo(no.getEsquerda(), xEsquerda, yFilho, horizontalSpacing / 2);
        }

        // Desenha linhas conectando com o filho direito, se existir
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

    public Pane getPane() {
        return pane;
    }
}
