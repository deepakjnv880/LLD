package lld.SnakeAndLadder.service;

import lld.SnakeAndLadder.model.Dice;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DiceService {
    private final int noOfDice;
    private final Dice dice;

    public int rollDice(){
        return (int) ((Math.random()*(dice.getMax()-dice.getMin())*noOfDice)+noOfDice);
    }
}
