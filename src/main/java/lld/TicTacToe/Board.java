package lld.TicTacToe;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class Board {
    private final int size;
    private final char[][] matrix;

    public Board(int size) {
        this.size = size;
        matrix = new char[size][size];
    }

    public void updateBoard(int row, int col, char ch) {
        this.matrix[row][col] = ch;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("|");
                System.out.print(matrix[i][j] == '\0' ? " " : matrix[i][j]);
            }
            System.out.println("|");
        }
    }

    public static void main(String[] args) {
        Board b = new Board(3);
        b.printBoard();
    }

    public int result(Player player1, Player player2) {
        String[] rowString = new String[this.size];
        String[] colString = new String[this.size];
        String[] diagonalString = new String[2];
        StringBuilder winStringPlayer1 = new StringBuilder();
        StringBuilder winStringPlayer2 = new StringBuilder();

        Arrays.fill(rowString, "");
        Arrays.fill(colString, "");
        Arrays.fill(diagonalString, "");

        for (int i = 0; i < this.size; i++) {
            winStringPlayer1.append(player1.getSymbol());
            winStringPlayer2.append(player2.getSymbol());
            for (int j = 0; j < this.size; j++) {
                if (this.matrix[i][j] != '\0') rowString[i] += this.matrix[i][j];
                if (this.matrix[i][j] != '\0') colString[j] += this.matrix[i][j];
            }
        }

        for (int i = 0; i < this.size; i++) {
            if (this.matrix[i][i] != '\0') diagonalString[0] += this.matrix[i][i];
            if (this.matrix[i][this.size - 1 - i] != '\0') diagonalString[1] += this.matrix[i][this.size - 1 - i];
        }

        List<String> all = new ArrayList<>();
        all.addAll(Arrays.asList(rowString));
        all.addAll(Arrays.asList(colString));
        all.addAll(Arrays.asList(diagonalString));
        boolean isAllSymbolUnique = false;
        for (String str : all) {
            if (winStringPlayer1.toString().equals(str)) return 1;
            if (winStringPlayer2.toString().equals(str)) return 2;
            if (!isAllSymbolUnique) {
                isAllSymbolUnique = isAllUnique(str);
            }

        }
        return isAllSymbolUnique ? -1 : 0;
    }

    private boolean isAllUnique(String str) {
        if (str == null) return true;
        char pre = '\0';
        for (char ch : str.toCharArray()) {
            if (ch != '\0' && pre == '\0') {
                pre = ch;
            } else if (pre != ch) return false;
        }
        return true;
    }

}
