package tec.chessgame;

import java.util.List;

/**
 *
 * @author Dayron
 */
public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }
    @Override
    public List<Cell> getMovePath(Cell actualPos, ChessBoard board){
        return movePath;
    }
}
