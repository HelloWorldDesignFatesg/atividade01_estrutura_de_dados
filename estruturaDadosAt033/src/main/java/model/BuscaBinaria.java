/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Spindola
 */

public class BuscaBinaria implements IEstruturaDeDados {
    private List<Palavras> vetor;
    private String nome;
    
    public BuscaBinaria(String nome) {
        this.vetor = new ArrayList<>();
        this.nome = nome;
    }
    
    @Override
    public String NomeEstrutra(){
        return nome;
    };

    @Override
    public void inserir(Palavras palavra, IAnalisadorDesempenho desempenho) {
        int posicao = 0;

        // Verificar se a palavra já existe antes de inserir
        for (Palavras p : vetor) {
            if (p.getTexto().equals(palavra.getTexto())) {
                // Se a palavra já existe, não insira e apenas incremente a frequência
                p.incrementarFrequencia(); // Incrementa a frequência da palavra existente
                desempenho.incrementarAtribuicoes(); // Conta a atribuição
                return; // Sai do método, pois não é necessário inserir novamente
            }
        }

        // Se a palavra não existe, realiza a busca binária para encontrar a posição
        if (!vetor.isEmpty()) {
            int inicio = 0;
            int fim = vetor.size() - 1;

            while (inicio <= fim) {
                int meio = (inicio + fim) / 2;
                String textoAtual = vetor.get(meio).getTexto();
                desempenho.incrementarComparacoes(); // Conta cada comparação
                int comparacao = textoAtual.compareTo(palavra.getTexto());

                if (comparacao < 0) {
                    inicio = meio + 1;
                    posicao = inicio;
                } else {
                    fim = meio - 1;
                    posicao = meio;
                }
            }
        }
        vetor.add(posicao, palavra); // Insere na posição correta
        desempenho.incrementarAtribuicoes(); // Conta a atribuição
    }


    @Override
    public Palavras buscar(String palavra) {
        int inicio = 0;
        int fim = vetor.size() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            String textoAtual = vetor.get(meio).getTexto();
            int comparacao = textoAtual.compareTo(palavra);

            if (comparacao == 0) {
                return vetor.get(meio);
            } else if (comparacao < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return null;
    }

    public List<Palavras> getVetor() {
        return vetor;
    }
    
    @Override
    public List ordenar() {
        return vetor;
    }
}
