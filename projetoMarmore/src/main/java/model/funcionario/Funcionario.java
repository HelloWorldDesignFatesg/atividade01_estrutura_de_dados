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
package model.funcionario;

/**
 *
 * @author Spindola
 */
public class Funcionario implements IFuncionarios {
    private int id;
    private String nome;
    private String cadastro;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String rg;
    private String telefone1;
    private String telefone2;
    private String complemento;
    private String email;
    private String observacoes;

    public Funcionario(int id, String nome, String cadastro, String endereco, String bairro, String cidade, 
                       String uf, String cep, String rg, String telefone1, String telefone2, String complemento, 
                       String email, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.cadastro = cadastro;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.rg = rg;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.complemento = complemento;
        this.email = email;
        this.observacoes = observacoes;
    }

    @Override
    public void editar() {
    }

    @Override
    public int getId() {
        return id;
    }
}
