//оголошення пакету
package com.example.lab1;

//імпорт математичної бібліотеки
import java.lang.Math;

/**
 * class for operate with Lucas numbers
 */
public class LucasNumbers {
    //приватні поля, які містять початкові значення послідовності чисел Люка
    private int l0 = 2;
    private int l1 = 1;

    /**
     * this is a constructor
     */
    //конструктор
    public LucasNumbers() {
    }

    /**
     * @param n number of sequence(start from 0)
     * @return value of n-th Lucas numbers
     */
    //метод повертає значення n-того числа Люка
    public int getLucasNumber(int n) {
        //захист від некоректного значення
        if (n < 0) return 0;
        //змінні для обчислення трьох послідовних чисел Люка
        int lcur = l1 + l0; //друге число
        int lprev = l1; //перше число
        int lpprev = l0;  //нульове число
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
        //масив цілих чисел для збереження результатів пошуку
        int tmpArr[] = new int[n + 1];
        //лічильник знайдених кубів
        int nmbCubes = 0;
        //цикл по індексах від 0 до n включно
        for (int k = 0; k <= n; k++) {
            //обчислюємо k-те число Люка
            int lucas = getLucasNumber(k);
            //якщо воно є кубом
            if (testCube(lucas)) {
                //додаємо його до масиву
                tmpArr[nmbCubes] = lucas;
                //збільшуємо лічильник
                nmbCubes++;
            }
        }

        //масив цілих чисел в якому зберігаємо результат пошуку(без зайвих нулів)
        int cubeArr[] = new int[nmbCubes];
        //ітеруємося по знайдених nmbcubes перших елементах масиву tmparr
        for(int k = 0; k < nmbCubes; k++)
            //копіюємо значення масиву tmparr в масив cubearr
            cubeArr[k] = tmpArr[k];
        return cubeArr;
    }
}
