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
package model.cliente;

/**
 *
 * @author Spindola
 */
public abstract class Cliente implements IClientes {
    protected int id;
    protected String nome;
    protected String segmento;
    protected String telefone1;
    protected String telefone2;
    protected String email;
    protected String cep;
    protected String endereco;
    protected String numero;
    protected String complemento;
    protected String bairro;
    protected String cidade;
    protected String estado;
    protected String observacoes;
    protected String dataCadastro;
    protected String status;

    public Cliente(int id, String nome, String segmento, String telefone1, String telefone2, String email, 
                   String cep, String endereco, String numero, String complemento, String bairro, 
                   String cidade, String estado, String observacoes, String dataCadastro, String status) {
        this.id = id;
        this.nome = nome;
        this.segmento = segmento;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.observacoes = observacoes;
        this.dataCadastro = dataCadastro;
        this.status = status;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public abstract void editar();
}
