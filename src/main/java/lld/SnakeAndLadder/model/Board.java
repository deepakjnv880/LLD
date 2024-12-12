package lld.SnakeAndLadder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class Board {
    private int dimension;
    private Map<Integer, Jump> jumpMap;

    public Jump isSnakeOrLadderPresent(int pos) {
        return jumpMap.getOrDefault(pos, null);
    }
}
