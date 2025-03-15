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
public interface IAnalisadorDesempenho {
    public void medirTempo(IEstruturaDeDados estrutura, List<Palavras> palavras);
    public void incrementarComparacoes();
    public void incrementarAtribuicoes();
    public long getTempoGasto();
    public Integer getComparacoes();
    public Integer getAtribuicoes();
}
