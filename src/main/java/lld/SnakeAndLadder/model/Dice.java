package lld.SnakeAndLadder.model;

import lombok.Getter;

import java.util.Random;

@Getter
public class Dice {
    private final int min = 1;
    private final int max = 6;

    public int rollDice() {
        return new Random().nextInt(min, max + 1);
    }
}
