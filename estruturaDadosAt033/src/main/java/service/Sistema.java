package service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import model.AnalisadorDesempenho;
import model.IAnalisadorDesempenho;
import model.IEstruturaDeDados;
import model.Palavras;
import model.BuscaBinaria;
import model.ListaOrdenada;
import model.Arvore;

public class Sistema {
    private List<IEstruturaDeDados> minhasEstruturas;
    private List<Palavras> palavrasLimpas;
    private String resultados = "";
    
    public Sistema() {
        this.minhasEstruturas = new ArrayList<>();
        
        IEstruturaDeDados buscaBinaria = new BuscaBinaria("Busca Binaria");
        IEstruturaDeDados listaOrdenada = new ListaOrdenada("Lista Ordenada");
        IEstruturaDeDados arvoreBinaria = new Arvore("Árvore Binária");
        
        
        this.minhasEstruturas.add(buscaBinaria);
        this.minhasEstruturas.add(listaOrdenada);
        this.minhasEstruturas.add(arvoreBinaria);
    }
    
    public void IniciarMedidorDeDesempenho() {
        IAnalisadorDesempenho desempenhoEstrutura = new AnalisadorDesempenho();

        if (palavrasLimpas != null && !palavrasLimpas.isEmpty()) {
            for (IEstruturaDeDados estrutura : minhasEstruturas) {
                
                desempenhoEstrutura.medirTempo(estrutura, palavrasLimpas);

               
                DecimalFormat df = new DecimalFormat("#0.00");
                resultados += estrutura.NomeEstrutra() +
                        "\n--- --- --- --- ---" +
                        "\nTempo: " + df.format(desempenhoEstrutura.getTempoGasto() / 1_000_000.0) + " ms" +
                        "\nComparações: " + desempenhoEstrutura.getComparacoes() +
                        "\nAtribuições: " + desempenhoEstrutura.getAtribuicoes() +
                        "\n--- --- --- --- ---\n";
            }
        } else {
            System.out.println("A lista de palavras está vazia ou nula.");
        }
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public List<Palavras> getPalavrasLimpas() {
        return palavrasLimpas;
    }

    public void setPalavrasLimpas(List<Palavras> palavrasLimpas) {
        this.palavrasLimpas = palavrasLimpas;
    }
}
