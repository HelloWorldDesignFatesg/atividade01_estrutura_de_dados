package model;

public class No {
    
    private String dado;
    private No esquerda;
    private No direita;
    
    public No() {
    }
    
    public No(String dado) {
        this.dado = dado;
    }
    
    public String getDado() {
        return dado;
    }
    
    public void setDado(String dado) {
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
        return "No{" + "dado=" + dado + '}';
    }
}
