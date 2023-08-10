package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int[] myArray = {1,2,1,3,3,1,2,1,5,1};

    public static void main(String[] args) {
        // Crear un mapa para almacenar la frecuencia de los números
        Map<Integer, Integer> varNum1 = new HashMap<>();

        // Contar la frecuencia de los números en el arreglo
        Arrays.stream(myArray).forEach(num -> varNum1.put(num, varNum1.getOrDefault(num, 0) + 1));

        // Imprimir el histograma
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + ": ");
            int count = varNum1.getOrDefault(i, 0);
            for (int j = 0; j < count; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}