package lld.SnakeAndLadder;

import lld.SnakeAndLadder.model.Player;
import lld.SnakeAndLadder.service.GameService;

import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        List<Player> playerList = Arrays.asList(new Player("Deepak"), new Player("Nikhil"), new Player("Manjay"), new Player("Priya"), new Player("Vineet"));
        GameService gameService = new GameService(playerList);
        gameService.launch();
    }
}
