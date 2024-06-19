package lld.SnakeAndLadder.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Player {
    final private String id;
    final private String name;
    final private int position;

    public Player(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.position = 0;
    }
}
