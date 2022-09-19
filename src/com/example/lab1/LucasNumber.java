//оголошення пакету
package com.example.lab1;

import java.util.Scanner;

/**
 * main class of the package
 */
public class LucasNumber {
    /**
     * @param args array of string parameters
     */
    public static void main(String args[]) {
        //створюємо екземпляр класу scanner
        Scanner sc = new Scanner(System.in);
        System.out.print("Вкажіть кількість чисел Люка для тесту: ");
        //зчитуємо ціле число з консолі у змінну n
        int n = sc.nextInt();
        System.out.println("Числа Люка серед перших " + n + ", які є кубами:");
        //у масив цілих чисел cubes за допомогою методу get lucas cube numbers записуємо масив чисел люка,
        // які є точними кубами
        int[] cubes = getLucasCubeNumbers(n);

        //ітеруємось індексом k по елементах масива cubes і виводимо на екран
        for (int cube : cubes) {
            System.out.print(" ");
            System.out.println(cube);
        }
    }

    /**
     * method checks if n is a cube
     *
     * @param n number
     * @return is it a cube
     */

    //привтаний метод пеервіряє чи є число параметр кубом якогось цілого числа
    private static boolean testCube(int n) {
        //корінь третьої степені із числа n
        double r = Math.pow(n, 1. / 3);
        //заокруглюємо результат до найближчого цілого числа
        int ir = (int) Math.round(r);
        //якщо куб цього числа є числом n, то повертаємо істину, інакше хибність
        if (n == ir*ir*ir) return true;
        else return false;
    }

    /**
     * method returns an array with first elements of param array
     *
     * @param arr array to resize
     * @param n new size of array
     * @return resized array
     */
    private static int[] resize(int[] arr, int n) {
        int newArr[] = new int[n];
        //ітеруємося по перших елементах масиву arr
        for(int k = 0; k < n; k++)
            //копіюємо значення масиву arr в масив newarr
            newArr[k] = arr[k];
        return newArr;
    }

    /**
     * method returns all Lucas Numbers that are cubes
     *
     * @param n number of sequence(start from 0)
     * @return array of cubes among first n lucas numbers
     */

    //повертає масив перших n чисел люка, які є точними кубами
    public static int[] getLucasCubeNumbers(int n) {
        //захист від некоректного значення
        if (n < 0) return new int[0];
        //масив цілих чисел для збереження результатів пошуку
        int[] tmpArr = new int[n + 1];
        //лічильник знайдених кубів
        int nmbCubes = 0;

        //змінні для обчислення трьох послідовних чисел Люка
        int lpprev = 2;  //нульове число
        int lprev = 1; //перше число
        int lcur = lpprev + lprev; //друге число

        //цикл обчислення наступних членів послідовності чисел люка
        for (int k = 0; k < n; k++) {
            lpprev = lprev; //к-те число
            lprev = lcur; //к+1 число
            lcur = lprev + lpprev; //к+2 число
            //якщо k-те число є кубом
            if (testCube(lpprev)) {
                //додаємо його до масиву
                tmpArr[nmbCubes] = lpprev;
                //збільшуємо лічильник
                nmbCubes++;
            }
        }
        return resize(tmpArr, nmbCubes);
    }

}


