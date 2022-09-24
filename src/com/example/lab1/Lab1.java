//оголошення пакету
package com.example.lab1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * main class of the package
 */
public class Lab1 {
    /**
     * @param args array of string parameters
     */
    public static void main(String args[]) {
        //створюємо екземпляр класу scanner
        Scanner sc = new Scanner(System.in);
        System.out.print("Вкажіть кількість чисел Люка для тесту: ");
        //зчитуємо ціле число з консолі у змінну n
        int n = sc.nextInt();
        //створюємо екземпляр класу - послідовність чисел Люка
        LucasNumberSequence lns = new LucasNumberSequence();
        //обчислюємо перші n елементів і зберігаємо в послідовності
        lns.fillSequence(n);
        //отримуємо всі числа послідовності, що є кубами
        ArrayList<LucasNumber> cubes = lns.getCubes();

        System.out.println("Числа Люка серед перших " + n + ", які є кубами:");
        //у масив цілих чисел cubes за допомогою методу get lucas cube numbers записуємо масив чисел люка,

        //ітеруємось по елементах списка cubes і виводимо на екран
        for (LucasNumber cube : cubes) {
            System.out.print(" ");
            System.out.println(cube);
        }
    }
}

