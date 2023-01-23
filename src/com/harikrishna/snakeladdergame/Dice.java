package com.harikrishna.snakeladdergame;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int numberOfDice;
    int minValueOfDice;
    int maxValueOfDice;

    public Dice(Scanner scanner) {
        System.out.println("Enter no of dices you wanna play with");
        this.numberOfDice = scanner.nextInt();
        System.out.println("Enter min value of dice");
        this.minValueOfDice = scanner.nextInt();
        System.out.println("Enter max value of dice");
        this.maxValueOfDice = scanner.nextInt();
    }

    public int rollDice() {
        int totalRollDiceCount = 0;
        int totalDiceRolled = 0;

        while (totalDiceRolled < numberOfDice) {
            totalRollDiceCount += ThreadLocalRandom.current().nextInt(minValueOfDice, maxValueOfDice + 1);
            totalDiceRolled++;
        }

        return totalRollDiceCount;
    }
}
