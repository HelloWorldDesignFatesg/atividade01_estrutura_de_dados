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
package model.marca;

/**
 *
 * @author Spindola
 */
public class Marca implements IMarcas {
    private int id;
    private String nome;

    public Marca(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public void editar() {
        System.out.println("Editando Marca com ID: " + id);
    }

    @Override
    public int getId() {
        return id;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
