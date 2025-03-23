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
package model.servico;

/**
 *
 * @author Spindola
 */
public class Servico implements IServicos {
    private int id;
    private String nome;
    private String descricao;
    private double preco;

    public Servico(int id, String nome, String descricao, double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public void editar() {
        // Lógica para editar o serviço
        System.out.println("Editando Serviço com ID: " + id);
    }

    @Override
    public int getId() {
        return id;
    }
}
