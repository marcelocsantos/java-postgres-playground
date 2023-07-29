package com.example;

import java.util.Arrays;

public class AppArrays{
    /**
     * @param args
     */
    public static void main(String[] args) {
        double vetorDouble[] = {10, 20, 30};

        double matriz[][] = new double[3][4];

        //System.out.println(Arrays.toString(vetor));

        for(int i = 0; i < 3; i++){
            System.out.println(vetorDouble[i]);   
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = i * j * 10;                
            }
            
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
               System.out.print(matriz[i][j] + " ");                
            }
            System.out.println();

        }
    }
}