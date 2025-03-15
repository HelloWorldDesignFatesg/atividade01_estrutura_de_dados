/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import model.AnalisadorDesempenho;
import model.BuscaBinaria;
import model.IAnalisadorDesempenho;
import model.IEstruturaDeDados;
import model.ListaOrdenada;
import model.Palavras;

/**
 *
 * @author Spindola
 */
public class Sistema {
    private List<IEstruturaDeDados> minhasEstruturas;
    private List<Palavras> palavrasLimpas;
    private String resultados = "";
    
    public Sistema() {
        this.minhasEstruturas = new ArrayList<>();
        IEstruturaDeDados buscaBinaria = new BuscaBinaria("Busca Binaria");
        IEstruturaDeDados listaOrdenada = new ListaOrdenada("Lista Ordenada");
        this.minhasEstruturas.add(buscaBinaria);
        this.minhasEstruturas.add(listaOrdenada);
    }
    
    public void IniciarMedidorDeDesempenho(){
        IAnalisadorDesempenho desempenhoBuscaBinaria = new AnalisadorDesempenho();
        IGerenciadorPesquisa gerenciador = new GerenciadorPesquisa();
        System.out.println("Chegou aqui");
        
        if (palavrasLimpas != null && !palavrasLimpas.isEmpty()) {
            System.out.println("A lista de palavras está com uma ou mais palavras..");
            for (IEstruturaDeDados estrutura : minhasEstruturas){
                desempenhoBuscaBinaria.medirTempo(estrutura, palavrasLimpas);
                DecimalFormat df = new DecimalFormat("#0.00");
                resultados += estrutura.NomeEstrutra() +
                        "\n--- --- --- --- ---" +
                        "\nTempo: " + df.format(desempenhoBuscaBinaria.getTempoGasto() / 1_000_000.0) + " ms" +
                        "\nComparações: " + desempenhoBuscaBinaria.getComparacoes() +
                        "\nAtribuições: " + desempenhoBuscaBinaria.getAtribuicoes() +
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
