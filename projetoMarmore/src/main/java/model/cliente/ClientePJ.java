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
public class ClientePJ extends Cliente {
    private String cnpj;

    public ClientePJ(int id, String nome, String segmento, String telefone1, String telefone2, String email, 
                     String cep, String endereco, String numero, String complemento, String bairro, 
                     String cidade, String estado, String observacoes, String dataCadastro, String status, 
                     String cnpj) {
        super(id, nome, segmento, telefone1, telefone2, email, cep, endereco, numero, complemento, 
              bairro, cidade, estado, observacoes, dataCadastro, status);
        this.cnpj = cnpj;
    }

    @Override
    public void editar() {

    }
}
