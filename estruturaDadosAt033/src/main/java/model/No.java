package model;

public class No {
    
    private Palavras dado;
    private No esquerda;
    private No direita;
    
    public No() {
    }
    
    // Construtor que recebe um objeto Palavras diretamente
    public No(Palavras dado) {
        this.dado = dado;
    }
    
    // Construtor alternativo: se você quiser continuar recebendo apenas a String
    public No(String texto) {
        this.dado = new Palavras(texto);
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
    
    @Override
    public String toString() {
        // Exemplo: imprime a palavra e a frequência
        return "No{" + "texto=" + dado.getTexto() + ", freq=" + dado.getFrequencia() + '}';
    }
}
