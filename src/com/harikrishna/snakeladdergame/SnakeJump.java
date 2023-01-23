package com.harikrishna.snakeladdergame;

public class SnakeJump implements AdditionalJump {

    int head;
    int tail;

    public SnakeJump(int head, int tail) {
        validatePosition(head, tail);
        this.head = head;
        this.tail = tail;
        System.out.println("Snake added from cell" + head + " to cell " + tail);
    }

    @Override
    public void performJump(Player player) {
        player.setCurrentPosition(this.tail);
        System.out.println("Snake Jump done from " + this.head + " to " + this.tail);
    }

    public void validatePosition(int head, int tail) throws RuntimeException {
        if (head < tail) {
            System.out.println("Head position is less than Tail. Invalid Input. Change Input and Try Again");
            throw new RuntimeException("Head position is less than Tail. Invalid Input. Change Input and Try Again");
        }
    }
}
