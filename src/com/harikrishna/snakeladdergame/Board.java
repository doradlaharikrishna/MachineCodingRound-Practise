package com.harikrishna.snakeladdergame;

import java.util.Scanner;

public class Board {
    Cell[] cells;
    int numberOfSnakes;
    int numberOfLadders;
    Scanner scanner;
    InitializeBoardProperties initializeBoardProperties;

    public Board(int size, Scanner scanner, InitializeBoardProperties initializeBoardProperties1) {
        this.initializeBoardProperties = initializeBoardProperties1;
        this.scanner = scanner;
        this.cells = new Cell[size*size];
        initializeSnakeAndLadderProperties();
        initializeCells(size);
        initializeSnakes();
        initializeLadders();
    }

    private void initializeCells(int size) {
        int cellValue = 1;
        for (int i = 0; i < (size * size); i++) {
            Cell cell = new Cell(cellValue);
            this.cells[i] = cell;
            cellValue++;
        }
    }

    private void initializeSnakeAndLadderProperties() {
        this.initializeBoardProperties.initializeSnakeAndLadderProperties(this);
    }

    private void initializeSnakes() {
        this.initializeBoardProperties.initializeSnakes(this);
    }

    private void initializeLadders() {
        this.initializeBoardProperties.initializeLadders(this);
    }
}
