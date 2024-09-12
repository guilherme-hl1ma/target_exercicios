package org.example.exercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static String caracteres = null;

    public static void main(String[] args) throws IOException {
        int count = 0;

        try {
            System.out.print("Digite uma sequência de caracteres: ");
            caracteres = null;
            caracteres = bufferedReader.readLine();
        } catch (IOException e){}

        for (int i = 0; i < caracteres.length(); i++) {
            if (caracteres.charAt(i) == 'a' || caracteres.charAt(i) == 'A') count++;
        }

        if (count < 0) System.out.println("A sequência de caracteres não possui a letra A");

        System.out.println("A letra 'A' aparece: " + count);
    }
}
