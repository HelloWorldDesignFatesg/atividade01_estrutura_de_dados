package model;

import java.util.ArrayList;
import java.util.List;

public class ListaOrdenada implements IEstruturaDeDados {
    private List<Palavras> lista;

    public ListaOrdenada(String nome) {
        this.lista = new ArrayList<>();
    }

    @Override
    public void inserir(Palavras palavra, IAnalisadorDesempenho desempenho) {
        int posicao = 0;

        // Encontrar a posição correta para inserção (ordem alfabética)
        for (int i = 0; i < lista.size(); i++) {
            desempenho.incrementarComparacoes(); // Conta cada comparação
            String textoAtual = lista.get(i).getTexto();
            int comparacao = textoAtual.compareTo(palavra.getTexto());

            if (comparacao == 0) {
                // Palavra já existe, apenas incrementar frequência
                lista.get(i).incrementarFrequencia();
                return; // Sai do método, não insere duplicata
            } else if (comparacao > 0) {
                posicao = i; // Encontrou a posição onde inserir
                break;
            }
            posicao = i + 1; // Se maior, continua avançando
        }

        // Inserir a nova palavra na posição correta
        lista.add(posicao, new Palavras(palavra.getTexto())); // Cria nova instância
        desempenho.incrementarAtribuicoes(); // Conta a atribuição
    }

    @Override
    public Palavras buscar(String palavra) {
        // Busca linear (poderia ser binária, mas mantive simples para lista)
        for (Palavras p : lista) {
            if (p.getTexto().equals(palavra)) {
                return p; // Retorna o objeto Palavras encontrado
            }
        }
        return null; // Não encontrado
    }

    @Override
    public List<Palavras> ordenar() {
        // A lista já está ordenada pelo método inserir, então apenas retorna
        return new ArrayList<>(lista); // Retorna uma cópia para evitar modificações externas
    }

    @Override
    public String NomeEstrutra() {
        return "Lista Ordenada";
    }

    // Método auxiliar para depuração (opcional)
    public List<Palavras> getLista() {
        return new ArrayList<>(lista);
    }
}