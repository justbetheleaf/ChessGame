

package tec.chessgame;

/**
 * Elaborado por 
**/


public class ChessGame {
    private static ChessGame instance;
    private Player whitePlayer;
    private Player blackPlayer;
    private final ChessBoard board;
    private GameState gameState;

    private ChessGame() {
        this.board = new ChessBoard();
        this.gameState = GameState.IN_PROCESS;
    }

    public static ChessGame getInstance() {
        if (instance == null) {
            instance = new ChessGame();
        }
        return instance;
    }
    
    public static void main(String[] args){
        Player white = new Player("Player 1", Color.WHITE);        
        Player black = new Player("Player 2", Color.BLACK);
        ChessGame game = new ChessGame();        
        game.startGame(white, black);
        
        game.makeMove(game.board.getCell(1, 0), game.board.getCell(2, 0));
        
        Cell[][] board = game.board.getBoard();
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col].getPiece() + " ");
            }
            System.out.println();
        }
        
    }
    
    //Empieza partida
    public void startGame(Player white, Player black) {
        this.whitePlayer = white;
        this.blackPlayer = black;
        this.board.setupBoard();
        this.gameState = GameState.IN_PROCESS;
    }

    public boolean makeMove(Cell start, Cell end) {
        Piece piece = start.getPiece();
        if (piece != null && piece.isValidMove(start, end, board)) {
            end.setPiece(piece);
            start.setPiece(null);
            return true;
        }
        return false;
    }
    
  //Verificar estado del juego
    public GameState checkGameState() {
        if (isCheckmate(whitePlayer)) {
            return GameState.CHECKMATE;
        } else if (isCheckmate(blackPlayer)) {
            return GameState.CHECKMATE;
        } else if (isStalemate(whitePlayer)) {
            return GameState.STALEMATE;
        } else if (isStalemate(blackPlayer)) {
            return GameState.STALEMATE;
        } else if (isCheck(whitePlayer)) {
            return GameState.CHECK;
        } else if (isCheck(blackPlayer)) {
            return GameState.CHECK;
        } else {
            return GameState.IN_PROCESS;
        }
    }

    public boolean isCheck(Player player) {
        King king = getKing(player);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell cell = board.getCell(i, j);
                if (cell.isOccupied() && cell.getPiece().getColor()!= player.getColor()) {
                    if (cell.getPiece().isValidMove(cell, king.getCell(), board)) {
                        return true;
                    } else {
                    }
                }
            }
        }
        return false;
    }

    //Verificar jaque mate
    public boolean isCheckmate(Player player) {
        King king = getKing(player);
        if (isCheck(player)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Cell cell = board.getCell(i, j);
                    if (cell.isOccupied() && cell.getPiece().getColor() == player.getColor()) {
                        for (Cell move : cell.getPiece().getMovePath(cell, board)) {
                            if (move.equals(king.getCell())) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean isStalemate(Player player) {
        King king = getKing(player);
        if (!isCheck(player)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Cell cell = board.getCell(i, j);
                    if (cell.isOccupied() && cell.getPiece().getColor() == player.getColor()) {
                        if (!cell.getPiece().getMovePath(cell, board).isEmpty()) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    // Verificar hacer un enroque
    public boolean castle(Player player, boolean kingside) {
        King king = getKing(player);
        Rook rook;
        if (kingside) {
            rook = getRook(player, true);
        } else {
            rook = getRook(player, false);
        }
        if (rook!= null && king.getCell().getCol() == rook.getCell().getCol() + (kingside? 1 : -1)) {
            for (int i = Math.min(king.getCell().getCol(), rook.getCell().getCol()); i <= Math.max(king.getCell().getCol(), rook.getCell().getCol()); i++) {
                Cell cell = board.getCell(king.getCell().getRow(), i);
                if (cell.isOccupied() || isCheck(player)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    //
    private King getKing(Player player) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell cell = board.getCell(i, j);
                if (cell.isOccupied() && cell.getPiece() instanceof King && cell.getPiece().getColor() == player.getColor()) {
                    return (King) cell.getPiece();
                }
            }
        }
        return null;
    }
   
    //Hace el Enroque
    private Rook getRook(Player player, boolean kingside) {
        int row = (player.getColor() == Color.WHITE) ? 0 : 7;
        int col = (kingside) ? 7 : 0;

        Cell cell = board.getCell(row, col);
        if (cell.isOccupied() && cell.getPiece() instanceof Rook && cell.getPiece().getColor() == player.getColor()) {
            return (Rook) cell.getPiece();
        }
        return null;
    }
}