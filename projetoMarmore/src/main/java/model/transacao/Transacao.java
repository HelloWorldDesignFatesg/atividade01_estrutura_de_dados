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
package model.transacao;

import java.time.LocalDateTime;
import java.util.List;
import model.cliente.Cliente;

/**
 *
 * @author Spindola
 */
public abstract class Transacao {
    protected int id;
    protected Cliente cliente;
    protected List<ItemProduto> itensProduto;
    protected List<ItemServico> itensServico;
    protected LocalDateTime dataHoraCriacao;
    protected double valorTotal;
    protected double descontoAVista;
    protected int tempoEntregaDias;
    protected Parcelamento parcelamento;
}
