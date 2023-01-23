package com.harikrishna.snakeladdergame;

public class Cell {

    int cellNumber;
    AdditionalJump additionalJump;

    public Cell(int cellNumber) {
        this.cellNumber = cellNumber;
        this.additionalJump = null;
    }

    public AdditionalJump getAdditionalJump() {
        return additionalJump;
    }

    public void setAdditionalJump(AdditionalJump additionalJump) {
        this.additionalJump = additionalJump;
    }
}
