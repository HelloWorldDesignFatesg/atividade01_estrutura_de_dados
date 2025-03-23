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

/**
 *
 * @author Luis Fernando
 */

public class No {
    
    private Palavras dado;
    private No esquerda;
    private No direita;
    private int altura;
    
    public No() {
    }
    
    public No(Palavras dado) {
        this.dado = dado;
        this.altura = 1;
    }
    
    public Palavras getDado() {
        return dado;
    }
    
    public void setDado(Palavras dado) {
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

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    @Override
    public String toString() {
        return "No{" + "texto=" + dado.getTexto() + ", freq=" + dado.getFrequencia() + '}';
    }
}
