package lld.SnakeAndLadder.service;

import lld.SnakeAndLadder.model.*;

import java.util.*;

//@AllArgsConstructor
public class GameService {
    List<Player> players;
    Board board;
    DiceService diceService;

    public GameService(List<Player> players) {
        this.players = players;
        this.board = loadBoard();
        int noOfDice = 2;
        //default dice from 1..6
        Dice dice = new Dice();
        this.diceService = new DiceService(noOfDice, dice);
    }

    private Board loadBoard() {
        //dimension and boardSize=dimension*dimension
        int dimension = 10;

        //jumps
        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(10, 23));
        ladders.add(new Ladder(30, 40));
        ladders.add(new Ladder(45, 53));
        ladders.add(new Ladder(60, 80));
        ladders.add(new Ladder(77, 96));
        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(33, 11));
        snakes.add(new Snake(42, 19));
        snakes.add(new Snake(56, 8));
        snakes.add(new Snake(90, 12));
        snakes.add(new Snake(99, 57));
        List<Jump> jumps = new ArrayList<>();
        jumps.addAll(ladders);
        jumps.addAll(snakes);
        Map<Integer, Jump> jumpMap = new HashMap<>();
        jumps.forEach(jump -> jumpMap.put(jump.getStart(), jump));

        //we can add some basic check to validate these snakes and ladders are not colliding.
        return new Board(dimension, jumpMap);
    }

    public void launch() throws InterruptedException {
        Map<String, Integer> pos = new HashMap<>();
        Queue<Player> playerQueue = new LinkedList<>(this.players);
        Queue<Player> winnerQueue = new LinkedList<>();
        System.out.println("=======Starting the GAME with following players:=======");
        for (Player player : this.players) {
            pos.put(player.getId(), 1);
            System.out.println("( Id = " + player.getId() + " , Name = " + player.getName() + " , Pos = " + player.getPosition() + " )");
        }
        System.out.println("=======================================================");
        System.out.println();
        System.out.println("========Lets start==============");

        while (playerQueue.size() > 1) {
            Player curPlayer = playerQueue.poll();
            System.out.println(curPlayer.getName() + " turn");
            System.out.println("\tRolling dice...");
            int move = this.diceService.rollDice();
            System.out.println("\tDice gave " + move);
            int nextPos = pos.get(curPlayer.getId()) + move;
            System.out.println("\tReached " + nextPos);
            Jump jump = this.board.isSnakeOrLadderPresent(nextPos);
            if (jump != null) {
                jump.getEncounterMessage();
                nextPos = jump.getEnd();
            }

            int boardEnd = this.board.getDimension() * this.board.getDimension();
            if (nextPos == boardEnd) {
                System.out.println("\tFinally at " + nextPos);
                System.out.println("\t=========== HURRAY WON ==============");
                winnerQueue.add(curPlayer);
                continue;
            } else if (nextPos < boardEnd) {
                pos.put(curPlayer.getId(), nextPos);
                System.out.println("\tFinally at " + nextPos);
            }
            playerQueue.add(curPlayer);
            Thread.sleep(1000);
        }
        winnerQueue.add(playerQueue.poll());

        System.out.println("\n\n#################RESULT###################");
        int count = 0;
        while (!winnerQueue.isEmpty()) System.out.println((++count) + " -> " + winnerQueue.poll().getName());
        System.out.println("##########################################\n\n");
    }
}
