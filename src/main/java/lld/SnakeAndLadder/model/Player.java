package lld.SnakeAndLadder.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
public class Player {

    @ToString.Exclude
    final private String id;
    final private String name;
    @Setter
    private int position;

    public Player(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.position = 1;
    }

    public int rollDice(Dice dice) {
        return dice.rollDice();
    }
}
