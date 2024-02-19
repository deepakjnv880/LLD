package lld.SnakeAndLadder;

import java.util.HashMap;
import java.util.Map;

public class Snakes {
    private final Map<Integer, Integer> snakes = new HashMap<>();

    public void addSnake(int mouth, int tail) {
        if (tail >= mouth) throw new RuntimeException("Invalid Snake");
        snakes.put(mouth, tail);
    }

    public int isSnakePresent(int pos) {
        return (snakes.get(pos) != null) ? snakes.get(pos) : 0;
    }
}
