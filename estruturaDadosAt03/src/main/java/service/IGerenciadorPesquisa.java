/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Palavras;

/**
 *
 * @author Spindola
 */
public interface IGerenciadorPesquisa {
    public void processarArquivo(String arquivo);
    public List<Palavras> getPalavrasLimpas();
    public String informacaoSobreArquivoTxt();
    public List<Palavras> getPalavrasLimpasUnicas();
}
