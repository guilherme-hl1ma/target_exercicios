package org.example.exercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int nTermos;
        int n; // número que será buscado na sequência

        do {
            System.out.print("Digite a quantidade termos: ");
            Scanner scanner = new Scanner(System.in);
            nTermos = scanner.nextInt();
            if (nTermos <= 0) {
                System.out.println("\nNúmero inválido. Deve ser positivo e maior que zero.");
            }
        } while(nTermos <= 0);

        int[] fibonacci = new int[nTermos];

        Main.montarFibonacci(nTermos, fibonacci);
        Main.printarFibonacci(nTermos, fibonacci);

        do {
            System.out.print("\nDigite o número que deseja ser encontrado: ");
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            if (n < 0) {
                System.out.println("\nNúmero inválido. Deve ser positivo.");
            }
        } while(n < 0);

        if (Main.isNoFibonacci(fibonacci, n, 0, nTermos)) {
            System.out.printf("\n%d está na Sequência", n);
        } else {
            System.out.printf("\n%d não está na Sequência", n);
        }
    }

    /**
     * Função com a lógica para montar a Sequência de Fibonacci
     * */
    public static void montarFibonacci(int n,int[] fibonacci) {
        int anterior = 0;
        int atual = 1;

        fibonacci[0] = anterior;

        if (n > 1) {
            fibonacci[1] = atual;

            for (int i = 2; i < n; i++) {
                fibonacci[i] = anterior + atual;
                anterior = atual;
                atual = fibonacci[i];
            }
        }
    }

    /**
     * Função para mostrar a sequência
     * */
    public static void printarFibonacci(int n, int[] fibonacci) {
        for (int i = 0; i < n; i++) {
            System.out.printf(" %d", fibonacci[i]);
        }
    }

    /**
     * Função para verificar se o número n está na sequência
     * */
    public static boolean isNoFibonacci(int[] fibonacci, int elemento, int inicio, int fim) {
        try {
            if (inicio <= fim) {
                int meio;
                meio = (inicio + fim) / 2;

                if (fibonacci[meio] == elemento) return true;

                if (elemento < fibonacci[meio])
                    return isNoFibonacci(fibonacci, elemento, inicio, meio - 1);
                else
                    return isNoFibonacci(fibonacci, elemento, meio + 1, fim);
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }
}