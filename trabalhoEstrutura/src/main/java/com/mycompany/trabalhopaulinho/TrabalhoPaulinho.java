package com.mycompany.trabalhopaulinho;

import javax.swing.JOptionPane;
public class TrabalhoPaulinho {

    public static void main(String[] args) {
        int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho do vetor:"));
        int[] vetor = new int[tamanho];

        String elementos = JOptionPane.showInputDialog("Informe os elementos do vetor (separados por espaço - ex: 1 2 3):");
        String[] elementosArray = elementos.split(" ");
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = Integer.parseInt(elementosArray[i]);
        }

        exibirVetor("Vetor original:", vetor);

        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("MENU DE OPÇÕES\n"
                    + "1 - Ordenação por Inserção\n"
                    + "2 - Ordenação por Seleção\n"
                    + "3 - Ordenação por Bolha\n"
                    + "4 - Pesquisar um número\n"
                    + "5 - Sair\n"
                    + "Escolha uma opção:"));

            switch (opcao) {
                case 1:
                    int[] vetorOrdenadoInsercao = ordenarPorInsercao(vetor.clone());
                    exibirVetorOrdenado("Ordenação por Inserção:", vetorOrdenadoInsercao);
                    break;
                case 2:
                    int[] vetorOrdenadoSelecao = ordenarPorSelecao(vetor.clone());
                    exibirVetorOrdenado("Ordenação por Seleção:", vetorOrdenadoSelecao);
                    break;
                case 3:
                    int[] vetorOrdenadoBolha = ordenarPorBolha(vetor.clone());
                    exibirVetorOrdenado("Ordenação por Bolha:", vetorOrdenadoBolha);
                    break;
                case 4:
                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um número para pesquisar:"));
                    pesquisarNumero(vetor, numero);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 5);
    }

    public static void exibirVetor(String mensagem, int[] vetor) {
        StringBuilder sb = new StringBuilder();
        sb.append(mensagem).append(" ");
        for (int num : vetor) {
            sb.append(num).append(" ");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static void exibirVetorOrdenado(String mensagem, int[] vetorOrdenado) {
        exibirVetor(mensagem, vetorOrdenado);
        JOptionPane.showMessageDialog(null, "Tempo de execução: " + vetorOrdenado.length + " iterações.");
    }

    public static int[] ordenarPorInsercao(int[] vetor) {
        int n = vetor.length;

        for (int i = 1; i < n; i++) {
            int chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }

            vetor[j + 1] = chave;
        }

        return vetor;
    }

    public static int[] ordenarPorSelecao(int[] vetor) {
        int n = vetor.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < n; j++) {
                if (vetor[j] < vetor[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            int temp = vetor[indiceMinimo];
            vetor[indiceMinimo] = vetor[i];
            vetor[i] = temp;
        }

        return vetor;
    }

    public static int[] ordenarPorBolha(int[] vetor) {
        int n = vetor.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }

        return vetor;
    }

    public static void pesquisarNumero(int[] vetor, int numero) {
        boolean encontrado = false;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numero) {
                JOptionPane.showMessageDialog(null, "Número encontrado na posição " + i);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Número não encontrado na lista.");
        }
    }
}
