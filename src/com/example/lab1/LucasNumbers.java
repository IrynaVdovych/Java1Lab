package com.example.lab1;

import java.lang.Math;

/**
 * class for operate with Lucas numbers
 */
public class LucasNumbers {
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
        if (n < 0) return 0;
        int lcur = l1 + l0;
        int lprev = l1;
        int lpprev = l0;
        for (int k = 0; k < n; k++) {
            lpprev = lprev;
            lprev = lcur;
            lcur = lprev + lpprev;
        }
        return lpprev;
    }

    /**
     * @param n number
     * @return is it a cube
     */
    private boolean testCube(int n) {
        double r = Math.pow(n, 1 / 3);
        int ir = (int) Math.round(r);
        if (n == ir*ir*ir) return true;
        else return false;
    }

    /**
     * @param n number of sequence(start from 0)
     * @return array of cubes among first n lucas numbers
     */
    public int[] getLucasCubeNumbers(int n) {
        int tmpArr[] = new int[n + 1];
        int nmbCubes = 0;
        for (int k = 0; k <= n; k++) {
            int lucas = getLucasNumber(k);
            if (testCube(lucas)) {
                tmpArr[nmbCubes] = lucas;
                nmbCubes++;
            }
        }

        int cubeArr[] = new int[nmbCubes];
        for(int k = 0; k < nmbCubes; k++)
            cubeArr[k] = tmpArr[k];
        return cubeArr;
    }
}
