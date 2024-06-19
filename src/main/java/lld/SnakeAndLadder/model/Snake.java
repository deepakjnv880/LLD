package lld.SnakeAndLadder.model;

public class Snake extends Jump {
    public Snake(int mouth, int tail) {
        super(mouth, tail);
        validateInput(mouth, tail);
    }

    @Override
    public void getEncounterMessage() {
        System.out.println("\t:( Oouch, You encounter a snake bite");
    }

    @Override
    void validateInput(int mouth, int tail) {
        if (tail >= mouth) throw new RuntimeException("\tInvalid Snake");
    }
}
