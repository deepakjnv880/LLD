package lld.TicTacToe;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Play {
    private static int start(Board board, Player player1, Player player2) {
        System.out.println("=======Start=======");
        board.printBoard();
        Scanner scanner = new Scanner(System.in);
        boolean firstPlayerMove = true;
        int result;
        while ((result = board.result(player1, player2)) == -1) {
            Player curPlayer = (firstPlayerMove) ? player1 : player2;
            System.out.println("Player" + curPlayer + " pls make a move.");
            System.out.print("Choose a row: ");
            int row = scanner.nextInt();
            System.out.print("Choose a col: ");
            int col = scanner.nextInt();
            //checking input extra can be done latter
            board.updateBoard(row, col, curPlayer.getSymbol());
            System.out.println();
            System.out.println("Board after marking [" + row + " ," + col + " ," + curPlayer.getSymbol() + "]");
            board.printBoard();
            firstPlayerMove = !firstPlayerMove;
        }
        scanner.close();
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Assuming two player are playing!!!");
        List<Player> players = Arrays.asList(new Player(1, "Deepak", 'O'), new Player(2, "Vineet", 'X'));
        Player player1 = players.get(0);
        Player player2 = players.get(1);
        Board board = new Board(3);
        System.out.println("Awesome!!! Player1 is " + player1 + " And Player2 is " + player2);
        int result = start(board, player1, player2);
        System.out.println("=========================");
        System.out.print("RESULT: ");
        if (result == 0) {
            System.out.println("DRAW");
        } else {
            System.out.println(((result == 1) ? player1 : player2) + " WIN");
        }
        System.out.println("=========================");
    }
}
