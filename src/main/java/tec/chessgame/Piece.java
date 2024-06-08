package tec.chessgame;


public abstract class Piece {
    protected Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract boolean isValidMove(Cell start, Cell end, ChessBoard board);
}

/**
public class King extends Piece {
    public King(Color color) {
        super(color);
    }


    @Override
    public boolean isValidMove(Cell start, Cell end, ChessBoard board) {
        // Implementar lógica de movimiento del Rey
        return true;
    }
}

**/