package lld.SnakeAndLadder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Dice {
    private int noOfDice;

    public int rollDice() {
        return (int) (Math.random() * (5 * noOfDice) + noOfDice);
    }
}
