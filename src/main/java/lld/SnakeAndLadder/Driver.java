package lld.SnakeAndLadder;

import lld.SnakeAndLadder.model.*;
import lld.SnakeAndLadder.service.GameService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * NOTE:
 * If we think about game we need board with snake ladders printed over it, dice and motivated players.
 * DiceService can be user when more dynamic dice required apart from default else we can use dice strategy as well that we will pass to player rollDice method
 * <p>
 * - Design Principles and Patterns Used:
 * <p>
 * Single Responsibility Principle:
 * Each class (Player, Board, Dice, GameService, Jump) has a distinct responsibility.
 * <p>
 * Encapsulation:
 * Data and behavior are encapsulated within their respective classes.
 * <p>
 * Open/Closed Principle:
 * The Board can easily extend functionality by adding new game elements like new snake.
 * <p>
 * Strategy Pattern (Optional):
 * If needed, the dice logic can be replaced with different rolling strategies.
 */
public class Driver {

    public static void main(String[] args) throws InterruptedException {

        List<Player> playerList = Arrays.asList(new Player("Deepak"), new Player("Nikhil"), new Player("Manjay"), new Player("Priya"), new Player("Vineet"));
        Dice dice = new Dice();
        Board board = getBoard();

        GameService gameService = new GameService(playerList, board, dice);

        System.out.println("=======Starting the GAME with following players:=======");
        for (Player player : playerList) {
            System.out.println(player);
        }
        System.out.println("=======================================================");
        System.out.println();
        System.out.println("====================GAME START=========================\n");
        gameService.launch();
        System.out.println("===============GAME END===================");
    }

    private static Board getBoard() {
        List<Jump> ladders = List.of(
                new Ladder(10, 23),
                new Ladder(30, 40),
                new Ladder(45, 53),
                new Ladder(60, 80),
                new Ladder(77, 96)
        );
        List<Jump> snakes = List.of(new Snake(33, 11),
                new Snake(42, 19),
                new Snake(56, 8),
                new Snake(90, 12),
                new Snake(99, 57)
        );
        List<Jump> jumps = new ArrayList<>();
        jumps.addAll(ladders);
        jumps.addAll(snakes);
        Map<Integer, Jump> jumpMap = jumps.stream().collect(Collectors.toMap(Jump::getStart, Function.identity()));

        return new Board(10, jumpMap);
    }
}
