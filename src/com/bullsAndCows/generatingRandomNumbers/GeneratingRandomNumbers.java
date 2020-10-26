package com.bullsAndCows.generatingRandomNumbers;

import java.util.Random;

/**
 * 2) После определения сложности игры,
 * программа генерирует случайную последовательность цифр,
 * при чем все цифры должны быть разными(например, 0247).
 *
 *
 * Заполняем массив случайными, уникальными числами от 0 до 9;
 * Создал два булева значения и цикл wile т.к.
 * без него после проверки на повтор значения, random может выдать еще раз тоже число
 * и будет повтор значения.
 */
public class GeneratingRandomNumbers {

    public void packArrayRandom (int [] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int value = random.nextInt(10);
            boolean repeated = true;
            while (repeated) {
                boolean again = false;
                for (int j = 0; j < i; j++) {
                    if (value != array[j]) {
                        continue;
                    } else {
                        value = random.nextInt(10);
                        again = true;
                        break;
                    }
                }
                if (!again) {
                    repeated = false;
                    array[i] = value;
                }

            }

        }

    }

}
