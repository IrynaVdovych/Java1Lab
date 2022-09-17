//оголошення пакету
package com.example.lab1;

//імпорт математичної бібліотеки
import java.lang.Math;

/**
 * class for operate with Lucas numbers
 */
public class LucasNumbers {
    /**
     * this is a simple constructor
     * @author Vdovych Iryna
     */

    public LucasNumbers() {
    }
    /**
     *
     * @param n number of sequence(start from 0)
     * @return value of n-th Lucas numbers
     */
    //метод повертає значення n-того числа Люка
    public int getLucasNumber(int n) {
        //захист від некоректного значення
        if (n < 0) return 0;
        //змінні для обчислення трьох послідовних чисел Люка
        int lpprev = 2;  //нульове число
        int lprev = 1; //перше число
        int lcur = lpprev + lprev; //друге число
        //цикл обчислення наступних членів послідовності чисел люка
        for (int k = 0; k < n; k++) {
            lpprev = lprev; //к-те число
            lprev = lcur; //к+1 число
            lcur = lprev + lpprev; //к+2 число
        }
        return lpprev; //повертаємо n-те число люка
    }

    /**
     * @param n number
     * @return is it a cube
     */

    //привтаний метод пеервіряє чи є число параметр кубом якогось цілого числа
    private boolean testCube(int n) {
        //корінь третьої степені із числа n
        double r = Math.pow(n, 1. / 3);
        //заокруглюємо результат до найближчого цілого числа
        int ir = (int) Math.round(r);
        //якщо куб цього числа є числом n, то повертаємо істину, інакше хибність
        if (n == ir*ir*ir) return true;
        else return false;
    }

    /**
     * @param n number of sequence(start from 0)
     * @return array of cubes among first n lucas numbers
     */

    //повертає масив перших n чисел люка, які є точними кубами
    public int[] getLucasCubeNumbers(int n) {
        //захист від некоректного значення
        if (n < 0) return new int[0];
        //масив цілих чисел для збереження результатів пошуку
        int tmpArr[] = new int[n + 1];
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

    /**
     * @param arr array to resize
     * @param n new size of array
     * @return resized array
     */
    private int[] resize(int[] arr, int n) {
        int newArr[] = new int[n];
        //ітеруємося по перших елементах масиву arr
        for(int k = 0; k < n; k++)
            //копіюємо значення масиву arr в масив newarr
            newArr[k] = arr[k];
        return newArr;
    }
}
