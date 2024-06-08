

package tec.chessgame;

/**
 * Elaborado por Dayron Porras, Armando y Amanda Ramirez
 * 
 */


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
        // lógica de movimiento
        return true;
    }

    public GameState checkGameState() {
        // lógica para verificar estado del juego
        return this.gameState;
    }

    public boolean isCheck() {
        // lógica para un jaque
        return false;
    }

    public boolean isCheckmate(Player player) {
        // lógica para verificar jaque mate
        return false;
    }

    public boolean isStalemate(Player player) {
        // lgica para verificar ahogado
        return false;
    }

    public boolean castle(Player player, boolean kingside) {
        // lógica para enroque
        return false;
    }

    public boolean requestDraw() {
        //lógica para requestdraw
        return false;
    }
}
