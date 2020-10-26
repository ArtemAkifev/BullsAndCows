package com.bullsAndCows.resultOfTheMatch;

import com.bullsAndCows.print.Print;
import java.util.Arrays;

/**
 * 4) Для валидной попытки программа должна выдать пользователю
 * результат совпадения – 2 числа:
 * ✓ 1 число – «коровы» – число угаданных цифр,которые находятся на неправильных позициях;
 * ✓ 2 число – «быки» - число угаданных цифр, которые находятся на правильных позициях;
 * 5) Если после попытки пользователь полностью правильно угадал загаданную последовательность,
 * то ему выводится сообщение об успехе, значение загаданной последовательности и количество попыток.
 * Игра завершается.
 * 7) В качестве попытки пользователь может напечатать «сдаюсь».
 * Тогда ему будет выведена загаданная последовательность и игра завершится.
 *
 *
 * Здесь я создал две переменные быки и коровы .
 * В метод result мы передаем два масива arrayСomp and arrayUser
 * С помощью for перебираем arrayComp
 * Если есть совпадения (значения по ячейкам) c arrayUser то bulls++
 * Иначе открываем второй цикл и смотрим совпадения на неправильных позициях
 * Счетчик int score
 * Если у нас полное совпадение то мы выводим сообщение-поздравление=)
 * Проверяем нехранит ли наш char[] arrayUser значение "сдаюсь"
 * Если тру то выводим спец сообщение и ставим влаг true тем саммым завершая программу
 */
public class ResultOfTheMatch {
    Print print;
    {
        print = new Print();
    }

    private int score = 0;
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    private int cows = 0;
    private int bulls = 0;
    public int getCows() {
        return cows;
    }
    public int getBulls() {
        return bulls;
    }
    public void setCows(int cows) {
        this.cows = cows;
    }
    public void setBulls(int bulls) {
        this.bulls = bulls;
    }

    public boolean result(char[] arrayComp, char[] arrayUser) {
        score++;

        for (int i = 0; i < arrayComp.length; i++) {
            if (arrayComp[i] == arrayUser[i]) {
                bulls++;
            } else {
                for (int j = 0; j < arrayComp.length; j++) {
                    if (arrayComp[i] == arrayUser[j]) {
                        cows++;
                        break;
                    }
                }
            }

            if (Arrays.equals(arrayComp,arrayUser)) {
                System.out.println("Успех!!!\nПоздравляю вы угадали");
                System.out.println("Количество попыток: " + score);
                System.out.print("Значение загаданной последовательности: ");
                setBulls(arrayComp.length);
                System.out.println(arrayComp);
                return true;
            }

        }

        String surrender = "сдаюсь";
        String a = new String(arrayUser);
        if (surrender.equalsIgnoreCase(a)){
            System.out.println("Вы сдались");
            print.print(arrayComp);
            return true;
        }
        return false;
    }

}
