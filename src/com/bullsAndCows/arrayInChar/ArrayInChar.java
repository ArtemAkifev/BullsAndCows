package com.bullsAndCows.arrayInChar;
/**
 * Трансформация Массива типа инт в Массив типа Чар
 */
public class ArrayInChar {

    public char[] convertingArrToChar(int[] array){
        String numArrayComp = "";
        for (int j = 0; j < array.length; j++) {
            numArrayComp += Integer.toString(array[j]);
        }
        char[] arrayCh = numArrayComp.toCharArray();
        return arrayCh;
    }
}
