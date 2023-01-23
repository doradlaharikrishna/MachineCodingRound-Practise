package com.harikrishna.snakeladdergame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InitializeBoardProperties customInitializeBoardProperties = new CustomInitializeBoardProperties(scanner);
        InitializeBoardProperties defaultInitializeBoardProperties = new DefaultInitializeBoardProperties(scanner);
        Game game = new Game(defaultInitializeBoardProperties, scanner);
        game.startGame();
    }
}
