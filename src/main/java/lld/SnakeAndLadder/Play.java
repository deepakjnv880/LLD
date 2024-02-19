package lld.SnakeAndLadder;

import java.util.*;

public class Play {
    private static Board loadBoard() {
        int boardSize = 100;
        List<Player> playerList = new ArrayList<>(Arrays.asList(
                new Player(1, "Deepak".toUpperCase()),
                new Player(2, "nikhil".toUpperCase()),
                new Player(3, "Manjay".toUpperCase()),
                new Player(4, "Vinay".toUpperCase()))
        );
        Dice dice = new Dice(2);
        Ladders ladders = new Ladders();
        ladders.addLadder(10, 23);
        ladders.addLadder(30, 40);
        ladders.addLadder(45, 53);
        ladders.addLadder(60, 80);
        ladders.addLadder(77, 96);
        Snakes snakes = new Snakes();
        snakes.addSnake(33, 11);
        snakes.addSnake(42, 19);
        snakes.addSnake(56, 8);
        snakes.addSnake(90, 12);
        snakes.addSnake(99, 57);
        //we can add some basic check to validate these snakes and ladders are not coincides.
        Board board = new Board(boardSize, playerList, dice, ladders, snakes);
        return board;
    }

    public static void main(String[] args) throws InterruptedException {
        Board board = loadBoard();
        Map<Integer, Integer> pos = new HashMap<>();
        Queue<Player> playerQueue = new LinkedList<>(board.getPlayerList());
        Queue<Player> winnerQueue = new LinkedList<>();
        System.out.print("Starting the GAME with ");
        for (Player player : board.getPlayerList()) {
            pos.put(player.getId(), 1);
            System.out.print(player.getName() + " ");
        }
        System.out.println(". All players are at position 1.");
        System.out.println("========Lets start==============");

        while (playerQueue.size() > 1) {
            Player curPlayer = playerQueue.poll();
            System.out.println(curPlayer.getName()+" turn");
            System.out.println("\tRolling dice...");
            int move = board.getDice().rollDice();
            System.out.println("\tDice gave "+move);
            int nextPos = pos.get(curPlayer.getId()) + move;
            System.out.println("\tReached "+nextPos);
            int temp = board.getSnakes().isSnakePresent(nextPos);
            if (temp != 0) {
                System.out.println("\t:( Ouch snakes bitten you :(");
                nextPos = temp;
            }
            temp = board.getLadders().isLadderPresent(nextPos);
            if (temp != 0) {
                System.out.println("\t:) Hurray you got ladder :)");
                nextPos = temp;
            }
            if (nextPos == loadBoard().getBoardSize()) {
                System.out.println("\tFinally at " + nextPos);
                System.out.println("\t=========== HURRAY WON ==============");
                winnerQueue.add(curPlayer);
                continue;
            } else if (nextPos < loadBoard().getBoardSize()) {
                pos.put(curPlayer.getId(), nextPos);
                System.out.println("\tFinally at " + nextPos);
            }
            playerQueue.add(curPlayer);
            Thread.sleep(1000);
        }
        winnerQueue.add(playerQueue.poll());

        System.out.println("\n\n#################RESULT###################");
        int count = 0;
        while (!winnerQueue.isEmpty())System.out.println((++count) + " -> " + winnerQueue.poll().getName());
        System.out.println("##########################################\n\n");
    }
}
