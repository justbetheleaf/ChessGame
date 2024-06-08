

package tec.chessgame;

/** Elaborado por 
**/


public class ChessGame {
    private static ChessGame instance;
    private Player whitePlayer;
    private Player blackPlayer;
    private ChessBoard board;
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
        
        return this.gameState;
        
    }
    
   // Verificar  un jaque
    public boolean isCheck() {
        
        return false;
    }
    
    //Verificar jaque mate
    public boolean isCheckmate(Player player) {
       
        return false;
    }
    // Verificar ahogado
    public boolean isStalemate(Player player) {
        // lgica para verificar ahogado
        return false;
    }

    // Verificar hacer un enroque
    public boolean castle(Player player, boolean kingside) {
        
        return false;
    }

    public boolean requestDraw() {
       
        return false;
    }
}
