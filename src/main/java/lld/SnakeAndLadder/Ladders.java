package lld.SnakeAndLadder;

import java.util.HashMap;
import java.util.Map;

public class Ladders {
    private final Map<Integer, Integer> ladders = new HashMap<>();

    public void addLadder(int bottom, int top) {
        if (bottom >= top) throw new RuntimeException("Invalid Ladder");
        ladders.put(bottom, top);
    }

    public int isLadderPresent(int pos) {
        return (ladders.get(pos) != null) ? ladders.get(pos) : 0;
    }
}
