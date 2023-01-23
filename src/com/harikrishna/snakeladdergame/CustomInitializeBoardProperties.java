package com.harikrishna.snakeladdergame;

import java.util.Scanner;

public class CustomInitializeBoardProperties implements InitializeBoardProperties {

    Scanner scanner;

    public CustomInitializeBoardProperties(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void initializeSnakeAndLadderProperties(Board board) {
        System.out.println("Enter no of Snakes to add");
        board.numberOfSnakes = scanner.nextInt();
        System.out.println("Enter no of Ladders to add");
        board.numberOfLadders = scanner.nextInt();
    }

    @Override
    public void initializeSnakes(Board board) {
        if (board.numberOfSnakes == 0) {
            System.out.println("No Snakes to add.");
            return;
        }

        int totalSnakesAdded = 0;
        while (totalSnakesAdded < board.numberOfSnakes) {
            System.out.println("Enter " + (totalSnakesAdded + 1) + "snake head and tail positions with space");
            int head = scanner.nextInt();
            int tail = scanner.nextInt();

            try {
                SnakeJump snakeJump = new SnakeJump(head, tail);
                if (board.cells[head-1].getAdditionalJump() == null) {
                    board.cells[head-1].setAdditionalJump(snakeJump);
                } else {
                    System.out.println("Already a snake or ladder is present starting at board position. " +
                            "Choose different position and Try Again.");
                }

                totalSnakesAdded++;
            } catch (Exception ex) {
                System.out.println("Snake positions are invalid. try again");
                System.out.println(ex);
            }
        }

        System.out.println("All Snakes added Successfully");
    }

    @Override
    public void initializeLadders(Board board) {
        int totalLaddersAdded = 0;
        if (board.numberOfLadders == 0) {
            System.out.println("No Ladders to add.");
            return;
        }

        while (totalLaddersAdded < board.numberOfLadders) {
            System.out.println("Enter " + (totalLaddersAdded + 1) + "ladder bottom and top positions with space");
            int bottom = scanner.nextInt();
            int top = scanner.nextInt();

            try {
                LadderJump ladderJump = new LadderJump(bottom, top);
                if (board.cells[bottom - 1].getAdditionalJump() == null) {
                    board.cells[bottom - 1].setAdditionalJump(ladderJump);
                } else {
                    System.out.println("Already a snake or ladder is present starting at board position. " +
                            "Choose different position and Try Again.");
                }

                totalLaddersAdded++;
            }  catch (Exception ex) {
                System.out.println("Ladder positions are invalid. try again");
                System.out.println(ex);
            }
        }

        System.out.println("All Ladders added Successfully");
    }
}
