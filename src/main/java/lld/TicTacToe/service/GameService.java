package lld.TicTacToe.service;

import lld.TicTacToe.Exception.InvalidInputException;
import lld.TicTacToe.model.Board;
import lld.TicTacToe.model.Player;
import lld.TicTacToe.model.Result;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class GameService {

    Board board;
    Player firstPlayer;
    Player secondPlayer;

    public void launch() throws InvalidInputException {
        System.out.println("==================Starting the GAME with following players:==================");
        System.out.println(firstPlayer);
        System.out.println(secondPlayer);
        System.out.println("=============================================================================");
        System.out.println();
        System.out.println("=============================Lets start===================================");
        Scanner scanner = new Scanner(System.in);
        boolean isFirstPlayerTurn = true;
        Result result = Result.NO_RESULT_YET;
        while (result == Result.NO_RESULT_YET) {
            Player curPlayer = isFirstPlayerTurn ? firstPlayer : secondPlayer;
            System.out.println(curPlayer.getName() + " ( symbol = " + curPlayer.getSymbol() + " ) turn");
            System.out.println("\tMake a move by choosing cell..");
            System.out.print("\tPlease enter row: ");
            int r = scanner.nextInt();
            System.out.print("\tPlease enter col: ");
            int c = scanner.nextInt();
            this.board.updateBoard(r, c, curPlayer.getSymbol());
            this.board.printBoard();
            isFirstPlayerTurn = !isFirstPlayerTurn;
            result = checkResult();
        }
        scanner.close();
        printResult(result);
    }

    public Result checkResult() {
        String[] rowString = new String[this.board.getSize()];
        String[] colString = new String[this.board.getSize()];
        String[] diagonalString = new String[2];

        StringBuilder winStringFirstPlayer = new StringBuilder();
        StringBuilder winStringSecondPlayer = new StringBuilder();

        Arrays.fill(rowString, "");
        Arrays.fill(colString, "");
        Arrays.fill(diagonalString, "");

        for (int i = 0; i < this.board.getSize(); i++) {
            for (int j = 0; j < this.board.getSize(); j++) {
                rowString[i] += this.board.getMatrix()[i][j];
                colString[j] += this.board.getMatrix()[i][j];
            }
            winStringFirstPlayer.append(firstPlayer.getSymbol());
            winStringSecondPlayer.append(secondPlayer.getSymbol());
        }

        for (int i = 0; i < this.board.getSize(); i++) {
            diagonalString[0] += this.board.getMatrix()[i][i];
            diagonalString[1] += this.board.getMatrix()[i][this.board.getSize() - 1 - i];
        }

        List<String> all = new ArrayList<>();
        all.addAll(Arrays.asList(rowString));
        all.addAll(Arrays.asList(colString));
        all.addAll(Arrays.asList(diagonalString));

        boolean isAnyStringWithAllSymbolUnique = false;
        for (String str : all) {
            if (winStringFirstPlayer.toString().equals(str)) return Result.FIRST_PLAYER_WON;
            if (winStringSecondPlayer.toString().equals(str)) return Result.SECOND_PLAYER_WON;
            if (!isAnyStringWithAllSymbolUnique) {
                isAnyStringWithAllSymbolUnique = isAllSymbolUnique(str);
            }

        }
        return isAnyStringWithAllSymbolUnique ? Result.NO_RESULT_YET : Result.TIE;
    }

    private boolean isAllSymbolUnique(String str) {
        if (str == null || str.isEmpty()) return true;
        StringBuilder strWithoutBackSlashZero = new StringBuilder();
        for (char ch : str.toCharArray()) if (ch != '\0') strWithoutBackSlashZero.append(ch);
        if (strWithoutBackSlashZero.toString().isEmpty()) return true;
        char firstChar = strWithoutBackSlashZero.charAt(0);
        for (char ch : strWithoutBackSlashZero.toString().toCharArray()) {
            if (ch != firstChar) return false;
        }
        return true;
    }

    private void printResult(Result result) {
        System.out.println("=========================================================================================");
        System.out.print("RESULT: ");
        if (result == Result.TIE) {
            System.out.println("DRAW");
        } else {
            System.out.println(((result == Result.FIRST_PLAYER_WON) ? firstPlayer : secondPlayer) + " WIN");
        }
        System.out.println("=========================================================================================");
    }
}
