
package tec.chessgame;

public class ChessBoard {
    private final Cell[][] board;

    public ChessBoard() {
        board = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Cell(i, j);
            }
        }
    }
    // Coloca piezas iniciales en el tablero
    public void setupBoard() {
        
        for (int i = 0; i < 8; i++) {
            board[1][i].setPiece(PieceFactory.createPiece(PieceType.PAWN, Color.WHITE));
            board[6][i].setPiece(PieceFactory.createPiece(PieceType.PAWN, Color.BLACK));
        }

        board[0][0].setPiece(PieceFactory.createPiece(PieceType.ROOK, Color.WHITE));
        board[0][7].setPiece(PieceFactory.createPiece(PieceType.ROOK, Color.WHITE));
        board[7][0].setPiece(PieceFactory.createPiece(PieceType.ROOK, Color.BLACK));
        board[7][7].setPiece(PieceFactory.createPiece(PieceType.ROOK, Color.BLACK));

        // Agregar piezas adicionales (caballos, alfiles, reinas y reyes)
        board[0][1].setPiece(PieceFactory.createPiece(PieceType.KNIGHT, Color.WHITE));
        board[0][6].setPiece(PieceFactory.createPiece(PieceType.KNIGHT, Color.WHITE));
        board[7][1].setPiece(PieceFactory.createPiece(PieceType.KNIGHT, Color.BLACK));
        board[7][6].setPiece(PieceFactory.createPiece(PieceType.KNIGHT, Color.BLACK));

        board[0][2].setPiece(PieceFactory.createPiece(PieceType.BISHOP, Color.WHITE));
        board[0][5].setPiece(PieceFactory.createPiece(PieceType.BISHOP, Color.WHITE));
        board[7][2].setPiece(PieceFactory.createPiece(PieceType.BISHOP, Color.BLACK));
        board[7][5].setPiece(PieceFactory.createPiece(PieceType.BISHOP, Color.BLACK));

        board[0][3].setPiece(PieceFactory.createPiece(PieceType.QUEEN, Color.WHITE));
        board[0][4].setPiece(PieceFactory.createPiece(PieceType.KING, Color.WHITE));
        board[7][3].setPiece(PieceFactory.createPiece(PieceType.QUEEN, Color.BLACK));
        board[7][4].setPiece(PieceFactory.createPiece(PieceType.KING, Color.BLACK));
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }
    
    public Cell[][] getBoard(){
        return board;
    }
}
