package lld.SnakeAndLadder.service;

import lld.SnakeAndLadder.model.Board;
import lld.SnakeAndLadder.model.Dice;
import lld.SnakeAndLadder.model.Jump;
import lld.SnakeAndLadder.model.Player;
import lombok.AllArgsConstructor;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@AllArgsConstructor
public class GameService {
    private final List<Player> players;
    private final Board board;
    private final Dice dice;

    public void launch() throws InterruptedException {
        Deque<Player> playerQueue = new LinkedList<>(players);
        Queue<Player> winnerQueue = new LinkedList<>();

        while (playerQueue.size() > 1) {
            Player curPlayer = playerQueue.pollFirst();
            System.out.println(curPlayer + " turn");
            System.out.println("\tRolling dice...");
            int move = curPlayer.rollDice(dice);
            System.out.println("\tDice gave " + move);
            int nextPos = curPlayer.getPosition() + move;
            System.out.println("\tReached " + nextPos);
            Jump jump = this.board.isSnakeOrLadderPresent(nextPos);
            if (jump != null) {
                jump.getEncounterMessage();
                nextPos = jump.getEnd();
            }

            int boardEnd = this.board.getDimension() * this.board.getDimension();
            if (nextPos == boardEnd) {
                System.out.println("\tFinally at " + nextPos);
                System.out.println("\t:) HURRAY WON");
                curPlayer.setPosition(nextPos);
                winnerQueue.add(curPlayer);
                continue;
            } else if (nextPos < boardEnd) {
                curPlayer.setPosition(nextPos);
                System.out.println("\tFinally at " + nextPos);
            }

            if (move == dice.getMax()) {
                System.out.println("\tGot chance again");
                playerQueue.addFirst(curPlayer);
            } else {
                playerQueue.addLast(curPlayer);
            }

//            Thread.sleep(100);
        }

        winnerQueue.add(playerQueue.pollFirst());
        printResult(winnerQueue);
    }

    private void printResult(Queue<Player> winnerQueue) {
        System.out.println("\n\n#################RESULT###################");
        int count = 0;
        while (!winnerQueue.isEmpty()) System.out.println((++count) + " -> " + winnerQueue.poll().getName());
        System.out.println("##########################################\n");
    }
}
