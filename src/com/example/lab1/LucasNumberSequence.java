package com.example.lab1;

import java.util.ArrayList;

/**
 * class describes sequence of Lucas numbers
 */
public class LucasNumberSequence {
    private ArrayList<LucasNumber> sequence;

    public LucasNumberSequence() {
        sequence = new ArrayList<LucasNumber>();
    }

    /**
     * method fills sequence with first n Lucas numbers
     *
     * @param n number of elements
     */
    public void fillSequence(int n) {
        //захист від некоректного значення
        if (n < 0) return;
        //очистимо усі значення в списку
        sequence.clear();

        //змінні для обчислення трьох послідовних чисел Люка
        int lpprev = 2;  //нульове число
        int lprev = 1; //перше число
        int lcur = lpprev + lprev; //друге число

        //цикл обчислення наступних членів послідовності чисел люка
        for (int k = 0; k < n; k++) {
            lpprev = lprev; //к-те число
            lprev = lcur; //к+1 число
            lcur = lprev + lpprev; //к+2 число

            sequence.add(new LucasNumber(k, lpprev));
        }
    }

    /**
     * method returns all cubes in the sequence
     *
     * @return array list of lucas number 
     */
    //для повернення усіх кубів із послідовності
    public ArrayList<LucasNumber> getCubes() {
        ArrayList<LucasNumber> resultArray = new ArrayList<LucasNumber>();
        for(LucasNumber ln : sequence)
            if(ln.isCube())
                resultArray.add(ln);
        return resultArray;
    }
}
