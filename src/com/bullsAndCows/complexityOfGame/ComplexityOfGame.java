package com.bullsAndCows.complexityOfGame;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 1) Вначале пользователю предлагается ввести сложность игры – 3, 4 или 5.
 * Сложность игры – длина загадываемой программой последовательности цифр (0-9).
 * При вводе некоректной сложности игра завершается.
 *
 *
 * Заполняем массив по уровню сложности т.е. только длинна
 * Делаю проверку на ввод (только числа от 3 до 5).
 * Если числа коректны, создаю массив
 * Иначе выводим соответсвующее сообщение сообщение и просим ввести снова.
 *
 */
public class ComplexityOfGame {

    public int[] createArray () {
        System.out.println("Введите сложность игры – 3, 4 или 5:");
        while (true) {
            try {

                Scanner scanner = new Scanner(System.in);
                int scannerRes = scanner.nextInt();

                if (scannerRes >= 3 && scannerRes <= 5) {
                    int[] array = new int[scannerRes];
                    return array;
                } else {
                    System.out.println("Некоректный ввод.\nВвести сложность игры – 3, 4 или 5.");
                }

            } catch (InputMismatchException e){
                System.out.println("Это не число.\nВвести сложность игры – 3, 4 или 5.");
            }
        }

    }

}
