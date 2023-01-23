package com.harikrishna.snakeladdergame;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DefaultInitializeBoardProperties implements InitializeBoardProperties {

    Scanner scanner;

    public DefaultInitializeBoardProperties(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void initializeSnakeAndLadderProperties(Board board) {
        board.numberOfSnakes = ThreadLocalRandom.current().nextInt(1, 7);
        System.out.println("Number of Snakes: " + board.numberOfSnakes);
        board.numberOfLadders = ThreadLocalRandom.current().nextInt(1, 7);
        System.out.println("Number of Snakes: " + board.numberOfLadders);
    }

    @Override
    public void initializeSnakes(Board board) {
        int numberOfSnakes = board.numberOfSnakes;
        while(numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1,board.cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,board.cells.length-1);
            if(snakeTail >= snakeHead) {
                continue;
            }

            SnakeJump snakeJump = new SnakeJump(snakeHead, snakeTail);
            if (board.cells[snakeHead-1].getAdditionalJump() == null) {
                board.cells[snakeHead-1].setAdditionalJump(snakeJump);
            }

            numberOfSnakes--;
        }

        System.out.println("Snakes " + board.numberOfSnakes + " added Successfully");
    }

    @Override
    public void initializeLadders(Board board) {
        int numberOfLadders = board.numberOfLadders;
        while(numberOfLadders > 0) {
            int ladderBottom = ThreadLocalRandom.current().nextInt(1,board.cells.length-1);
            int ladderTop = ThreadLocalRandom.current().nextInt(1,board.cells.length-1);
            if(ladderBottom >= ladderTop) {
                continue;
            }

            LadderJump ladderJump = new LadderJump(ladderBottom, ladderTop);
            if (board.cells[ladderBottom-1].getAdditionalJump() == null) {
                board.cells[ladderBottom-1].setAdditionalJump(ladderJump);
            }

            numberOfLadders--;
        }

        System.out.println("Ladders " + board.numberOfLadders + " added Successfully");
    }
}
