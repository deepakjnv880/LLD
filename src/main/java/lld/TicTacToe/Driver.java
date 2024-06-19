package lld.TicTacToe;

import lld.TicTacToe.Exception.InvalidInputException;
import lld.TicTacToe.model.Board;
import lld.TicTacToe.model.Player;
import lld.TicTacToe.service.GameService;

public class Driver {
    public static void main(String[] args) throws InvalidInputException {
        GameService gameService = new GameService(new Board(3), new Player("Nikhil", 'O'), new Player("Deepak", 'X'));
        gameService.launch();
    }
}
