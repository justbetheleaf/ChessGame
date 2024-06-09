package tec.chessgame;

import java.util.List;

/**
 *
 * @author Dayron
 */
public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }
    @Override
    public List<Cell> getMovePath(Cell actualPos, ChessBoard board){
        return movePath;
    }
}
