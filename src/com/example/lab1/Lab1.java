package com.example.lab1;

import java.util.Scanner;

/**
 * main class of the package
 */
public class Lab1 {
    /**
     * @param args array of string parameters
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        LucasNumbers LN = new LucasNumbers();
        System.out.println("1. Test 1");
        System.out.print("Вкажіть номер числа Люка: ");
        int n = sc.nextInt();
        System.out.print(String.valueOf(n) + " число Люка: ");
        System.out.println(LN.getLucasNumber(n));
        System.out.println("\n2. Test 2");
        System.out.print("Вкажіть кількість чисел Люка для тесту: ");
        n = sc.nextInt();
        System.out.println("Числа Люка серед перших " + String.valueOf(n) + ", які є кубами:");
        int cubes[] = LN.getLucasCubeNumbers(n);
        for(int k = 0; k < cubes.length; k++) {
            System.out.print(" ");
            System.out.println(cubes[k]);
        }
    }
}
