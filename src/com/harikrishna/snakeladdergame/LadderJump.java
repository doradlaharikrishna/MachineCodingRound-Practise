package com.harikrishna.snakeladdergame;

public class LadderJump implements AdditionalJump {

    int bottom;
    int top;

    public LadderJump(int bottom, int top) {
        validatePosition(bottom, top);
        this.bottom = bottom;
        this.top = top;
        System.out.println("Ladder added from cell" + bottom + " to cell " + top);
    }

    @Override
    public void performJump(Player player) {
        player.setCurrentPosition(this.top);
        System.out.println("Ladder Jump done from " + this.bottom + " to " + this.top);
    }

    public void validatePosition(int bottom, int top) throws RuntimeException {
        if (top < bottom) {
            System.out.println("Top position is less than Bottom. Invalid Input. Change Input and Try Again");
            throw new RuntimeException("Top position is less than Bottom. Invalid Input. Change Input and Try Again");
        }
    }
}
