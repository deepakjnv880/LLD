package lld.SnakeAndLadder.model;

public class Ladder extends Jump {
    public Ladder(int foot, int head) {
        super(foot, head);
        validateInput(foot, head);
    }

    @Override
    public void getEncounterMessage() {
        System.out.println("\t:) Hurray, You got a ladder");
    }

    @Override
    void validateInput(int foot, int head) {
        if (foot >= head) throw new RuntimeException("\tInvalid Ladder");
    }
}
