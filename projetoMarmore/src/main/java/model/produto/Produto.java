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
package model.produto;

/**
 *
 * @author Spindola
 */
public class Produto implements IProdutos {
    private int id;
    private int referencia;
    private String descricao;
    private int idUnidadeMedida;
    private int idMarca;
    private int idCategoria;
    private int estoqueMinimo;
    private int estoqueAtual;
    private String dataAtualizada;
    private double valorCusto;
    private double valorVenda;
    private int idFornecedor;
    private String dataCadastro;

    public Produto(int id, int referencia, String descricao, int idUnidadeMedida, int idMarca, int idCategoria, 
                   int estoqueMinimo, int estoqueAtual, String dataAtualizada, double valorCusto, 
                   double valorVenda, int idFornecedor, String dataCadastro) {
        this.id = id;
        this.referencia = referencia;
        this.descricao = descricao;
        this.idUnidadeMedida = idUnidadeMedida;
        this.idMarca = idMarca;
        this.idCategoria = idCategoria;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueAtual = estoqueAtual;
        this.dataAtualizada = dataAtualizada;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
        this.idFornecedor = idFornecedor;
        this.dataCadastro = dataCadastro;
    }

    @Override
    public void editar() {
        
    }

    @Override
    public int getId() {
        return id;
    }
}
