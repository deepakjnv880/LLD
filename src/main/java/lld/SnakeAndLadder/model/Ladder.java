package lld.SnakeAndLadder.model;

public class Ladder extends Jump {
    public Ladder(int foot, int top) {
        super(foot, top);
        validateInput(foot, top);
    }

    @Override
    public void getEncounterMessage() {
        System.out.println("\t:) Hurray, You got a ladder from " + getStart() + " to " + getEnd());
    }

    @Override
    void validateInput(int foot, int head) {
        if (foot >= head) throw new RuntimeException("\tInvalid Ladder");
    }
}
