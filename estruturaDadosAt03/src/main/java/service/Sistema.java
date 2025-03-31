/*
 * Copyright (C) 2025 Spindola
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import model.AnalisadorDesempenho;
import model.Arvore;
import model.ArvoreAVL;
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
        IEstruturaDeDados arvoreBinaria = new Arvore("Árvore Binária");
        IEstruturaDeDados arvoreAVL = new ArvoreAVL("Árvore AVL");
        
        this.minhasEstruturas.add(buscaBinaria);
        this.minhasEstruturas.add(listaOrdenada);
        this.minhasEstruturas.add(arvoreBinaria);
        this.minhasEstruturas.add(arvoreAVL);
    }
    
    public void IniciarMedidorDeDesempenho() {
        IAnalisadorDesempenho desempenhoEstrutura = new AnalisadorDesempenho();

        if (palavrasLimpas != null && !palavrasLimpas.isEmpty()) {
            for (IEstruturaDeDados estrutura : minhasEstruturas) {
                desempenhoEstrutura.limparDados();
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
    
    // Getter para expor a lista de estruturas de dados
    public List<IEstruturaDeDados> getEstruturas() {
        return minhasEstruturas;
    }
}
