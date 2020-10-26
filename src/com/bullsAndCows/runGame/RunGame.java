package com.bullsAndCows.runGame;

import com.bullsAndCows.arrayInChar.ArrayInChar;
import com.bullsAndCows.complexityOfGame.ComplexityOfGame;
import com.bullsAndCows.generatingRandomNumbers.GeneratingRandomNumbers;
import com.bullsAndCows.print.Print;
import com.bullsAndCows.resultOfTheMatch.ResultOfTheMatch;
import com.bullsAndCows.tryToGuess.TryToGuess;


import java.io.IOException;

/**
 * Класс для запуска игры
 */

public class RunGame {
    private ComplexityOfGame complexityOfGame;
    private GeneratingRandomNumbers generatingRandomNumbers;
    private TryToGuess tryToGuess;
    private ResultOfTheMatch resultOfTheMatch;
    private Print print;
    private ArrayInChar arrayInChar;

    public RunGame() {
        complexityOfGame = new ComplexityOfGame();
        generatingRandomNumbers = new GeneratingRandomNumbers();
        tryToGuess = new TryToGuess();
        resultOfTheMatch = new ResultOfTheMatch();
        print = new Print();
        arrayInChar = new ArrayInChar();

    }

    public void startGame () throws IOException {
        System.out.println("IT Factory begins!");

        int[] arrayComp = complexityOfGame.createArray();
        generatingRandomNumbers.packArrayRandom(arrayComp);
        print.print(arrayComp);

        System.out.println("Ввести свою отгадку последовательности согласно уровню сложности\n" +
                "(например: 0474)\n" + "В качестве попытки введите \"сдаюсь\", игра завершится\n" + "Ввод: ");

        boolean success = false;
        while (!success) {
            char[] arrayUserCh = tryToGuess.validNumGuess(arrayComp);
            char[] arrayCompCh = arrayInChar.convertingArrToChar(arrayComp);

            success = resultOfTheMatch.result(arrayCompCh, arrayUserCh);

            print.printResult(resultOfTheMatch.getCows(), resultOfTheMatch.getBulls(), resultOfTheMatch.getScore());
            resultOfTheMatch.setCows(0);
            resultOfTheMatch.setBulls(0);
        }
    }
}
