package lld.TicTacToe;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private int id;
    private String name;
    private char symbol;

    @Override
    public String toString() {
        return "[name=`" + name + "`, symbol=`" + symbol + "`]";
    }
}
