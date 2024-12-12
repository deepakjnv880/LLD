package lld.TicTacToe.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Player {
    final private String id;
    final private String name;
    final private char symbol;

    public Player(String name, char symbol) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "[ id = `" + id + "` , name = `" + name + "` , symbol = `" + symbol + "` ]";
    }
}
