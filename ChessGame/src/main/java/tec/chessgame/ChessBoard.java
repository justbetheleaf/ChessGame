
package tec.chessgame;

public class ChessBoard {
    private Cell[][] board;

    public ChessBoard() {
        board = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Cell(i, j);
            }
        }
    }

    public void setupBoard() {
        // Implementar configuración inicial del tablero
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }
}
