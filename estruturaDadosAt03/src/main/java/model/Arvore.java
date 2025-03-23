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
 * @author Luis Fernando
 */

public class Arvore implements IEstruturaDeDados {

    private No raiz; // Usa a classe No existente
    private String nome;
    
    public Arvore(String nome) {
        this.raiz = null;
        this.nome = nome;
    }

    @Override
    public void inserir(Palavras palavra, IAnalisadorDesempenho desempenho) {
        raiz = inserirNo(raiz, palavra, desempenho);
    }

    private No inserirNo(No atual, Palavras palavra, IAnalisadorDesempenho desempenho) {
        if (atual == null) {
            desempenho.incrementarAtribuicoes();
            return new No(palavra);  // Cria nó com Palavras
        }

        desempenho.incrementarComparacoes();
        int cmp = palavra.getTexto().compareTo(atual.getDado().getTexto());

        if (cmp == 0) {
            // Se a palavra já existe, incrementa a frequência
            atual.getDado().incrementarFrequencia();
        } else if (cmp < 0) {
            atual.setEsquerda(inserirNo(atual.getEsquerda(), palavra, desempenho));
        } else {
            atual.setDireita(inserirNo(atual.getDireita(), palavra, desempenho));
        }

        return atual;
    }

    @Override
    public Palavras buscar(String palavra) {
        No noEncontrado = buscarNo(raiz, palavra);
        if (noEncontrado == null) {
            return null;
        }
        return noEncontrado.getDado();
    }

    private No buscarNo(No atual, String texto) {
        if (atual == null) {
            return null;
        }
        int cmp = texto.compareTo(atual.getDado().getTexto());
        if (cmp == 0) {
            return atual;
        } else if (cmp < 0) {
            return buscarNo(atual.getEsquerda(), texto);
        } else {
            return buscarNo(atual.getDireita(), texto);
        }
    }

    @Override
    public List<Palavras> ordenar() {
        List<Palavras> lista = new ArrayList<>();
        emOrdem(raiz, lista);
        return lista;
    }

    private void emOrdem(No atual, List<Palavras> lista) {
        if (atual != null) {
            emOrdem(atual.getEsquerda(), lista);
            lista.add(atual.getDado());
            emOrdem(atual.getDireita(), lista);
        }
    }

    @Override
    public String NomeEstrutra() {
        return nome;
    }
    
}
