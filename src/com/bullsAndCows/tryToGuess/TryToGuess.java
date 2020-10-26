package com.bullsAndCows.tryToGuess;

import java.io.IOException;

import java.util.Scanner;

/**
 * 3) После этого пользователю предлагает ввести свою отгадку последовательности.
 * Валидной попыткой считается последовательность различных цифр правильной длины
 * (например, 1234). Невалидные попытки отклоняются.
 * 6) Если после попытки пользователь не угадал последовательность,
 * то ему предлагается сделать следующую попытку.
 * 7) В качестве попытки пользователь может напечатать «сдаюсь».
 * Тогда ему будет выведена загаданная последовательность и игра завершится.
 *
 *
 * Здесь я считываем отгадку с помощью Scanner в String
 * (если делать через int то при вводе допустим 028 при приобразовании
 * в масив сохраниться 28 работа будет несовсем корректна)
 * Если на вход буде слово "сдаюсь" то мы прерываем цикл и
 * возвращаем массив чар "сдаюсь" для дальнейшей обработки;
 * <p>
 * Далее привел int[] array к String numArrayComp - для сравнения длинны
 * загаданного компьютером значения с входными данными String numSt
 * <p>
 * Нужно вернуть значения в char[] для дальнейшего удобства сравнения результатов
 * для этого я сооздал массив char[] toChar с символами из входного String numSt
 * <p>
 * Если длина загаданного компьютером значения с входными данными String numSt равна, то
 * возврасщаем char[] toChar который хранит в себе входное значение
 * <p>
 * Иначе выводим сообщение.
 * Все это запускаем в while
 *
 * перед блоком if
 * int numInt = Integer.parseInt(numSt); без этой записии на вход спокойно принемает "ааа"
 * при заданой длине 3 (работает как блокатор стринга на вход)
 */
public class TryToGuess {

    Scanner scanner = new Scanner(System.in);

    public char[] validNumGuess(int[] array) throws IOException {
        String no = "сдаюсь";
        char[] surrender = no.toCharArray();

        while (true) {
            try {

                String numSt = scanner.nextLine();
                if(numSt.equalsIgnoreCase("сдаюсь")){
                    break;
                }

                String numArrayComp = "";
                for (int j = 0; j < array.length; j++) {
                    numArrayComp += Integer.toString(array[j]);
                }

                char[] toChar = numSt.toCharArray();

                int numInt = Integer.parseInt(numSt);
                if (numArrayComp.length() == numSt.length()) {
                    return toChar;
                } else {
                    System.out.println("Длинна отгадки больше или меньше длины загадки.");
                    System.out.println("Введите снова:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некоректный ввод\nВведите снова:");
            }

        }
        return surrender;
    }

}