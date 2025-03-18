/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author Spindola
 */
public interface IEstruturaDeDados {
    public void inserir(Palavras palavra, IAnalisadorDesempenho desempenho);
    public Palavras buscar(String palavra);
    public List ordenar();
    public String NomeEstrutra();
}
