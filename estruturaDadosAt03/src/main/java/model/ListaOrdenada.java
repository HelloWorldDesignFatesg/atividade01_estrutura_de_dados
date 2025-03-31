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

public class ListaOrdenada implements IEstruturaDeDados {
    private List<Palavras> lista;

    public ListaOrdenada(String nome) {
        this.lista = new ArrayList<>();
    }

    @Override
    public void inserir(Palavras palavra, IAnalisadorDesempenho desempenho) {
        int posicao = 0;

        // Encontrar a posição correta para inserção (ordem alfabética)
        for (int i = 0; i < lista.size(); i++) {
            desempenho.incrementarComparacoes(); // Conta cada comparação
            String textoAtual = lista.get(i).getTexto();
            int comparacao = textoAtual.compareTo(palavra.getTexto());

            if (comparacao == 0) {
                // Palavra já existe, apenas incrementar frequência
                lista.get(i).incrementarFrequencia();
                return; // Sai do método, não insere duplicata
            } else if (comparacao > 0) {
                posicao = i; // Encontrou a posição onde inserir
                break;
            }
            posicao = i + 1; // Se maior, continua avançando
        }

        // Inserir a nova palavra na posição correta
        lista.add(posicao, new Palavras(palavra.getTexto())); // Cria nova instância
        desempenho.incrementarAtribuicoes(); // Conta a atribuição
    }

    @Override
    public Palavras buscar(String palavra) {
        // Busca linear (poderia ser binária, mas mantive simples para lista)
        for (Palavras p : lista) {
            if (p.getTexto().equals(palavra)) {
                return p; // Retorna o objeto Palavras encontrado
            }
        }
        return null; // Não encontrado
    }

    @Override
    public List<Palavras> ordenar() {
        // A lista já está ordenada pelo método inserir, então apenas retorna
        return new ArrayList<>(lista); // Retorna uma cópia para evitar modificações externas
    }

    @Override
    public String NomeEstrutra() {
        return "Lista Ordenada";
    }

    // Método auxiliar para depuração (opcional)
    public List<Palavras> getLista() {
        return new ArrayList<>(lista);
    }
}