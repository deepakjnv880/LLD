package lld.TicTacToe.model;

import lld.TicTacToe.Exception.InvalidInputException;
import lombok.Getter;

@Getter
public class Board {
    private final int size;
    private final char[][] matrix;

    public Board(int size) {
        this.size = size;
        matrix = new char[size][size];
    }

    public void updateBoard(int row, int col, char ch) throws InvalidInputException {
        if (this.matrix[row][col] != '\0')
            throw new InvalidInputException("Entered row and column is already occupied");
        this.matrix[row][col] = ch;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            System.out.print("\t");
            for (int j = 0; j < size; j++) {
                System.out.print("|");
                System.out.print(matrix[i][j] == '\0' ? " " : matrix[i][j]);
            }
            System.out.println("|");
        }
        System.out.println();
    }
}
