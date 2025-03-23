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
    public void limparDados(){
        tempoGasto = 0;
        comparacoes = 0;
        atribuicoes = 0;
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
