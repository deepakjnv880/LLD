package lld.SnakeAndLadder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Jump {
    private final int start;
    private final int end;

    abstract public void getEncounterMessage();
    abstract void validateInput(int start, int end);
}
