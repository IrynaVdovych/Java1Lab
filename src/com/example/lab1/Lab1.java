//оголошення пакету
package com.example.lab1;

//імпорт обʼєкта scanner для зчитування тексту з консолі
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
        //створюємо екземпляр класу LucasNumbers
        LucasNumbers LN = new LucasNumbers();
        System.out.println("1. Test 1");
        System.out.print("Вкажіть номер числа Люка: ");
        //зчитуємо ціле число з консолі у змінну n
        int n = sc.nextInt();
        System.out.print(String.valueOf(n) + " число Люка: ");
        //за допомогою методу getLucasNumber визначаємо n-те число Люка і виводимо в консоль
        System.out.println(LN.getLucasNumber(n));
        System.out.println("\n2. Test 2");
        System.out.print("Вкажіть кількість чисел Люка для тесту: ");
        //зчитуємо ціле число з консолі у змінну n
        n = sc.nextInt();
        System.out.println("Числа Люка серед перших " + String.valueOf(n) + ", які є кубами:");
        //у масив цілих чисел cubes за допомогою методу get lucas cube numbers записуємо масив чисел люка,
        // які є точними кубами
        int cubes[] = LN.getLucasCubeNumbers(n);

        //ітеруємось індексом k по елементах масива cubes і виводимо на екран
        for(int k = 0; k < cubes.length; k++) {
            System.out.print(" ");
            System.out.println(cubes[k]);
        }
    }
}
