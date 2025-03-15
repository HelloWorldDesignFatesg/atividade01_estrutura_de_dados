/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author Spindola
 */
import java.util.List;

public class AnalisadorDesempenho implements IAnalisadorDesempenho {
    private long tempoGasto;
    private int comparacoes;
    private int atribuicoes;

    public AnalisadorDesempenho() {
        this.tempoGasto = 0;
        this.comparacoes = 0;
        this.atribuicoes = 0;
    }

    @Override
    public void medirTempo(IEstruturaDeDados estrutura, List<Palavras> palavras) {
        comparacoes = 0;
        atribuicoes = 0;

        long inicio = System.nanoTime();

        for (Palavras palavra : palavras) {
            estrutura.inserir(palavra, this);
        }

        long fim = System.nanoTime();
        tempoGasto = fim - inicio;
    }

    @Override
    public long getTempoGasto() {
        return tempoGasto;
    }

    @Override
    public Integer getComparacoes() {
        return comparacoes;
    }

    @Override
    public Integer getAtribuicoes() {
        return atribuicoes;
    }

    @Override
    public void incrementarComparacoes() {
        comparacoes++;
    }

    @Override
    public void incrementarAtribuicoes() {
        atribuicoes++;
    }
}
