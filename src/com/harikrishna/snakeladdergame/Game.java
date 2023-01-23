package com.harikrishna.snakeladdergame;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {

    Deque<Player> players;
    Board board;
    Dice dice;
    Scanner scanner;
    Player winner;

    public Game(InitializeBoardProperties initializeBoardProperties, Scanner scanner) {
        this.scanner = scanner;
        this.players = new LinkedList<>();
        addPlayers();
        this.board = new Board(10, scanner, initializeBoardProperties);
        this.dice = new Dice(scanner);
    }

    private void addPlayers() {
        System.out.println("Enter no of players");
        int playerCount = scanner.nextInt();
        while (playerCount > 0) {
            Player player = new Player(String.valueOf(playerCount), 0);
            players.addFirst(player);
            playerCount--;
        }
    }

    public void startGame() {
        int winnerCount = 0;
        StringBuilder gameStats = new StringBuilder();

        while (players.size() > 1) {
            this.winner = null;

            while (this.winner == null) {
                Player currentPlayer = findPlayerTurn();
                System.out.println("player turn is:" + currentPlayer.id + " current position is: " + currentPlayer.getCurrentPosition());

                int rollDiceCount = dice.rollDice();
                System.out.println("Current Player:" + currentPlayer.id + " rolled dice. Dice Count: " + rollDiceCount);
                int playerNewPosition = currentPlayer.getCurrentPosition() + rollDiceCount;

                updatePlayerPosition(currentPlayer, playerNewPosition);
                System.out.println("player turn is:" + currentPlayer.id + " new Position is: " + currentPlayer.getCurrentPosition());

                if (currentPlayer.getCurrentPosition() == board.cells.length) {
                    this.winner = currentPlayer;
                    winnerCount++;
                    players.remove(currentPlayer);
                    System.out.println("WINNER no " + winnerCount + " IS:" + winner.id);
                    gameStats.append("WINNER no " + winnerCount + " IS:" + winner.id).append("\n");
                }
            }
        }

        gameStats.append("LOOSER is "+ players.getFirst().id);
        System.out.println(gameStats);
    }

    private Player findPlayerTurn() {
        Player playerTurn = players.removeFirst();
        players.addLast(playerTurn);
        return playerTurn;
    }

    private void updatePlayerPosition(Player currentPlayer, int playerNewPosition) {
        if (playerNewPosition > board.cells.length) {
            currentPlayer.setCurrentPosition(currentPlayer.getCurrentPosition());
            return;
        }

        if (board.cells[playerNewPosition - 1].getAdditionalJump() != null) {
            board.cells[playerNewPosition - 1].getAdditionalJump().performJump(currentPlayer);
        } else {
            currentPlayer.setCurrentPosition(playerNewPosition);
        }
    }
}
