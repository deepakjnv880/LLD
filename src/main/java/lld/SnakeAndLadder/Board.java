package lld.SnakeAndLadder;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Board {
    private int boardSize;
    private List<Player> playerList;
    private Dice dice;
    private Ladders ladders;
    private Snakes snakes;
}
