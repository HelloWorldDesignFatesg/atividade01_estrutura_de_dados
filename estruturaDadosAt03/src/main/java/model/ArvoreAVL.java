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
import model.IAnalisadorDesempenho;
import model.IEstruturaDeDados;
import model.No;
import model.Palavras;

/**
 *
 * @author Ozeias Campos
 */
public class ArvoreAVL implements IEstruturaDeDados {

    private No raiz;
    private String nome;

    public ArvoreAVL(String nome) {
        this.nome = nome;
        this.raiz = null;
    }

    // Dentro da classe ArvoreAVL (arquivo ArvoreAVL.java)
    public No getRaiz() {
        return raiz;
    }

    @Override
    public void inserir(Palavras palavra, IAnalisadorDesempenho desempenho) {
        raiz = inserirNo(raiz, palavra, desempenho);
    }

    private No inserirNo(No no, Palavras palavra, IAnalisadorDesempenho desempenho) {
        if (no == null) {
            desempenho.incrementarAtribuicoes();
            return new No(palavra);
        }

        desempenho.incrementarComparacoes();
        int cmp = palavra.getTexto().compareTo(no.getDado().getTexto());

        if (cmp < 0) {
            no.setEsquerda(inserirNo(no.getEsquerda(), palavra, desempenho));
        } else if (cmp > 0) {
            no.setDireita(inserirNo(no.getDireita(), palavra, desempenho));
        } else {
            no.getDado().incrementarFrequencia();
            return no;
        }

        // Atualiza a altura
        no.setAltura(1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita())));

        // Realiza o balanceamento se necessário
        return balancear(no, palavra.getTexto());
    }

    @Override
    public Palavras buscar(String palavra) {
        No noEncontrado = buscarNo(raiz, palavra);
        return noEncontrado != null ? noEncontrado.getDado() : null;
    }

    private No buscarNo(No no, String texto) {
        if (no == null) {
            return null;
        }

        int cmp = texto.compareTo(no.getDado().getTexto());

        if (cmp == 0) {
            return no;
        } else if (cmp < 0) {
            return buscarNo(no.getEsquerda(), texto);
        } else {
            return buscarNo(no.getDireita(), texto);
        }
    }

    public void remover(String palavra, IAnalisadorDesempenho desempenho) {
        raiz = removerNo(raiz, palavra, desempenho);
    }

    private No removerNo(No no, String palavra, IAnalisadorDesempenho desempenho) {
        if (no == null) {
            return null;
        }

        desempenho.incrementarComparacoes();
        int cmp = palavra.compareTo(no.getDado().getTexto());

        if (cmp < 0) {
            no.setEsquerda(removerNo(no.getEsquerda(), palavra, desempenho));
        } else if (cmp > 0) {
            no.setDireita(removerNo(no.getDireita(), palavra, desempenho));
        } else {
            // Nó encontrado
            if (no.getEsquerda() == null || no.getDireita() == null) {
                No temp = (no.getEsquerda() != null) ? no.getEsquerda() : no.getDireita();
                if (temp == null) {
                    no = null;
                } else {
                    no = temp;
                }
            } else {
                No sucessor = obterMinimo(no.getDireita());
                no.setDado(sucessor.getDado());
                no.setDireita(removerNo(no.getDireita(), sucessor.getDado().getTexto(), desempenho));
            }
        }

        if (no == null) {
            return null;
        }

        no.setAltura(1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita())));

        return balancear(no, palavra);
    }

    private No obterMinimo(No no) {
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }

    @Override
    public List<Palavras> ordenar() {
        List<Palavras> lista = new ArrayList<>();
        emOrdem(raiz, lista);
        return lista;
    }

    private void emOrdem(No no, List<Palavras> lista) {
        if (no != null) {
            emOrdem(no.getEsquerda(), lista);
            lista.add(no.getDado());
            emOrdem(no.getDireita(), lista);
        }
    }

    @Override
    public String NomeEstrutra() {
        return nome;
    }

    private int altura(No no) {
        return (no == null) ? 0 : no.getAltura();
    }

    private int obterBalanceamento(No no) {
        return (no == null) ? 0 : altura(no.getEsquerda()) - altura(no.getDireita());
    }

    private No balancear(No no, String palavra) {
        int balanceamento = obterBalanceamento(no);

        if (balanceamento > 1 && palavra.compareTo(no.getEsquerda().getDado().getTexto()) < 0) {
            return rotacionarDireita(no);
        }

        if (balanceamento < -1 && palavra.compareTo(no.getDireita().getDado().getTexto()) > 0) {
            return rotacionarEsquerda(no);
        }

        if (balanceamento > 1 && palavra.compareTo(no.getEsquerda().getDado().getTexto()) > 0) {
            no.setEsquerda(rotacionarEsquerda(no.getEsquerda()));
            return rotacionarDireita(no);
        }

        if (balanceamento < -1 && palavra.compareTo(no.getDireita().getDado().getTexto()) < 0) {
            no.setDireita(rotacionarDireita(no.getDireita()));
            return rotacionarEsquerda(no);
        }

        return no;
    }

    private No rotacionarDireita(No y) {
        No x = y.getEsquerda();
        No T2 = x.getDireita();

        x.setDireita(y);
        y.setEsquerda(T2);

        y.setAltura(Math.max(altura(y.getEsquerda()), altura(y.getDireita())) + 1);
        x.setAltura(Math.max(altura(x.getEsquerda()), altura(x.getDireita())) + 1);

        return x;
    }

    private No rotacionarEsquerda(No x) {
        No y = x.getDireita();
        No T2 = y.getEsquerda();

        y.setEsquerda(x);
        x.setDireita(T2);

        x.setAltura(Math.max(altura(x.getEsquerda()), altura(x.getDireita())) + 1);
        y.setAltura(Math.max(altura(y.getEsquerda()), altura(y.getDireita())) + 1);

        return y;
    }
}
