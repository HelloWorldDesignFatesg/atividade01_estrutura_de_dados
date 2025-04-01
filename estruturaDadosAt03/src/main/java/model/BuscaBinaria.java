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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Spindola
 */

public class BuscaBinaria implements IEstruturaDeDados {
    private List<Palavras> vetor;
    private String nome;
    public BuscaBinaria(String nome) {
        this.vetor = new ArrayList<>();
        this.nome = nome;
    }
    
    @Override
    public String NomeEstrutra(){
        return nome;
    };

    @Override
    public void inserir(Palavras palavra, IAnalisadorDesempenho desempenho) {
        int posicao = 0;

        // Verificar se a palavra já existe antes de inserir
        for (Palavras p : vetor) {
            
            desempenho.incrementarComparacoes(); // Conta cada comparação
            
             if (p.getTexto().equals(palavra.getTexto())) {
                // Se a palavra já existe, não insira e apenas incremente a frequência
                p.incrementarFrequencia(); // Incrementa a frequência da palavra existente
                return; // Sai do método, pois não é necessário inserir novamente
            }
        }

        // Se a palavra não existe, realiza a busca binária para encontrar a posição
        if (!vetor.isEmpty()) {
            int inicio = 0;
            int fim = vetor.size() - 1;

            while (inicio <= fim) {
                int meio = (inicio + fim) / 2;
                String textoAtual = vetor.get(meio).getTexto();
                //desempenho.incrementarComparacoes(); // Conta cada comparação
                int comparacao = textoAtual.compareTo(palavra.getTexto());

                if (comparacao < 0) {
                    inicio = meio + 1;
                    posicao = inicio;
                } else {
                    fim = meio - 1;
                    posicao = meio;
                }
            }
        }
        vetor.add(posicao, palavra); // Insere na posição correta
        desempenho.incrementarAtribuicoes(); // Conta a atribuição
    }


    @Override
    public Palavras buscar(String palavra) {
        int inicio = 0;
        int fim = vetor.size() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            String textoAtual = vetor.get(meio).getTexto();
            int comparacao = textoAtual.compareTo(palavra);

            if (comparacao == 0) {
                return vetor.get(meio);
            } else if (comparacao < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return null;
    }

    public List<Palavras> getVetor() {
        return vetor;
    }
    
    @Override
    public List ordenar() {
        return vetor;
    }
}
