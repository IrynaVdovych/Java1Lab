package com.example.lab1;

/**
 * class is container of Lucas number
 */
public class LucasNumber {
    private int orderNumber;
    private int value;

    /**
     * constructor of class LucasNumber
     *
     * @param orderNumber order number in sequence
     * @param value value
     */
    public LucasNumber(int orderNumber, int value) {
        this.orderNumber = orderNumber;
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    /**
     * method checks if number is a cube
     *
     * @return is it a cube
     */

    //метод пеервіряє чи є число Люкаса кубом якогось цілого числа
    public boolean isCube() {
        //корінь третьої степені із числа n
        double r = Math.pow(value, 1. / 3);
        //заокруглюємо результат до найближчого цілого числа
        int ir = (int) Math.round(r);
        //якщо куб цього числа є значенням, то повертаємо істину, інакше хибність
        if (value == ir*ir*ir) return true;
        else return false;
    }
}
