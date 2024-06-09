package tec.chessgame;

import java.util.List;


public abstract class Piece {
    protected Color color;
    List<Cell> movePath;
    public Piece(Color color) {
        this.color = color;
    }
    public Color getColor() {
        return color;
    }
    public boolean isValidMove(Cell start, Cell end, ChessBoard board){
        start = board.getCell(start.getRow(), start.getCol());
        end = board.getCell(end.getRow(), end.getCol());
        if (start.getPiece().getColor() == Color.WHITE ){
            return (!end.isOccupied() || end.getPiece().getColor() == Color.BLACK && movePath.contains(end));
        }
        return (!end.isOccupied() || end.getPiece().getColor() == Color.WHITE && movePath.contains(end));
    };
    public boolean isValidCapture(Cell start, Cell end, ChessBoard board){
        return isValidMove(start, end, board);
    }
    public abstract List<Cell> getMovePath(Cell actualPos, ChessBoard board);
}