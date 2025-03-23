package model;

public class No {
    
    private Palavras dado;
    private No esquerda;
    private No direita;
    private int altura;
    
    public No() {
    }
    
    public No(Palavras dado) {
        this.dado = dado;
        this.altura = 1;
    }
    
    public Palavras getDado() {
        return dado;
    }
    
    public void setDado(Palavras dado) {
        this.dado = dado;
    }
    
    public No getEsquerda() {
        return esquerda;
    }
    
    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }
    
    public No getDireita() {
        return direita;
    }
    
    public void setDireita(No direita) {
        this.direita = direita;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    @Override
    public String toString() {
        // Exemplo: imprime a palavra e a frequência
        return "No{" + "texto=" + dado.getTexto() + ", freq=" + dado.getFrequencia() + '}';
    }
}
