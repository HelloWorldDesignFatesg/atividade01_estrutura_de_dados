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
package service;

import java.util.ArrayList;
import java.util.List;
import model.Palavras;

/**
 *
 * @author Spindola
 */
public class GerenciadorPesquisa implements IGerenciadorPesquisa {
    private List<Palavras> palavrasLimpas; 
    private List<Palavras> palavrasLimpasUnicas;
    private List<String> stopwords;
    private LeitorArquivo leitor;
    private Integer palavrasExcluidas;
    private Integer quantidadeDeCaracteresOriginal;
    
    public GerenciadorPesquisa() {
        this.palavrasLimpas = new ArrayList<>();
        this.palavrasLimpasUnicas = new ArrayList<>();
        this.stopwords = new ArrayList<>();
        this.leitor = new LeitorArquivo();
        this.palavrasExcluidas = 0;
        carregarStopwords();
    }
    
    @Override
    public void processarArquivo(String arquivo) {
        if (arquivo == null) {
            System.err.println("Não foi possível processar o arquivo.");
            return;
        }
        palavrasLimpasUnicas.clear();
        palavrasLimpas.clear();
        palavrasExcluidas = 0;
        processarTexto(arquivo);
        palavrasLimpasUnicas = adicionarPalavrasUnicas();
        System.err.println("Processar o arquivo.");
    }
    
    @Override
    public String informacaoSobreArquivoTxt(){
        return "Informação sobre o arquivo:" + 
                "\n--- --- --- --- ---" +
                "\nQuantidade de carcteres original: " + quantidadeDeCaracteresOriginal +
                "\nQuantidade de palavras: " + (palavrasLimpas.size() + palavrasExcluidas) +
                "\nQuantidade de palavras excluidas no StopWords: " + palavrasExcluidas +
                "\nQuantidade de palavras aceita: " + palavrasLimpas.size() +
                "\nQuantidade de palavras unica: " + palavrasLimpasUnicas.size() +
                "\n--- --- --- --- ---\n\n";
    }
    
    private List<Palavras> adicionarPalavrasUnicas() {
        
        List<Palavras> palavrasLimpasUnicasTemp = new ArrayList<>();

        for (Palavras palavra : palavrasLimpas) {
            boolean encontrada = false;

            // Verifica se a palavra já existe na lista palavrasLimpasUnicas
            for (Palavras p : palavrasLimpasUnicasTemp) {
                if (p.getTexto().equals(palavra.getTexto())) {
                    encontrada = true;
                    break;
                }
            }

            if (!encontrada) {
                palavrasLimpasUnicasTemp.add(palavra);
            }
        }
        return palavrasLimpasUnicasTemp;
    }


    private void processarTexto(String texto) {
        quantidadeDeCaracteresOriginal = texto.length();
        String textoSemPontuacao = texto.replaceAll("[^a-zA-Z0-9À-ÿ ]", " ");

        String[] palavras = textoSemPontuacao.split("\\s+");

        palavrasLimpas.clear();
        for (String palavra : palavras) {
            palavra = palavra.toLowerCase();

            if (!palavra.isEmpty()) {
                if (!stopwords.contains(palavra)) {
                    palavrasLimpas.add(new Palavras(palavra));
                } else {
                    palavrasExcluidas++;
                }
            }
        }
    }

    private void carregarStopwords() {
        String conteudoStopwords = leitor.lerStopwords("src\\main\\resources\\files\\stopwords.txt");
        if (conteudoStopwords == null) {
            System.err.println("Não foi possível carregar stopwords.");
            return;
        }

        String[] palavrasStop = conteudoStopwords.split("\\r?\\n");
        for (String stopword : palavrasStop) {
            if (!stopword.trim().isEmpty()) {
                stopwords.add(stopword.trim());
            }
        }
    }
    
    @Override
    public List<Palavras> getPalavrasLimpas() {
        return palavrasLimpas;
    }

    public int getPalavrasExcluidas() {
        return palavrasExcluidas;
    }
    
    @Override
    public List<Palavras> getPalavrasLimpasUnicas() {
        return palavrasLimpasUnicas;
    }

    public void setPalavrasLimpasUnicas(List<Palavras> palavrasLimpasUnicas) {
        this.palavrasLimpasUnicas = palavrasLimpasUnicas;
    }
    
    
}
