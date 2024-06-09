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
        //Se captura la casilla de en frente depende del color y captura 2 casillas al frente si es el primer movimiento
        Cell cell = board.getCell(actualPos.getRow(), actualPos.getCol());
        if (cell.getPiece().getColor() == Color.WHITE){
            if(cell.getRow() == 1)
                this.movePath.add(board.getCell(actualPos.getRow()+2, actualPos.getCol()));
            this.movePath.add(board.getCell(actualPos.getRow()+1, actualPos.getCol()));
            if(cell.getCol() < 7 && actualPos.getRow()+1<8)
                this.movePath.add(board.getCell(actualPos.getRow()+1, actualPos.getCol()+1));
            if(cell.getCol() > 0 && actualPos.getRow()+1<8)
                this.movePath.add(board.getCell(actualPos.getRow()+1, actualPos.getCol()-1));
        }else{
            //Se captura la casilla de en frente depende del color y captura 2 casillas al frente si es el primer movimiento
            if(cell.getRow() == 6)
                this.movePath.add(board.getCell(actualPos.getRow()-2, actualPos.getCol()));
            if(cell.getRow()-1>=0 && !board.getCell(actualPos.getRow()-1, actualPos.getCol()).isOccupied())
                this.movePath.add(board.getCell(actualPos.getRow()-1, actualPos.getCol()));
            if(cell.getCol() < 7 && actualPos.getRow()-1>=0)
                this.movePath.add(board.getCell(actualPos.getRow()+1, actualPos.getCol()+1));
            if(cell.getCol() > 0 && actualPos.getRow()-1>=0)
                this.movePath.add(board.getCell(actualPos.getRow()+1, actualPos.getCol()-1));
        }
        return this.movePath;
    }
    public boolean isValidEnPassant(Cell start, Cell end, ChessBoard board){
        start = board.getCell(start.getRow(),start.getCol());
        end = board.getCell(end.getRow(),end.getCol());
        int lineaInicial = 3;
        Color tempColor = Color.WHITE;
        if (start.getPiece().getColor() == Color.WHITE){
            lineaInicial += 1;
            tempColor = Color.BLACK;
        }
        return(start.getRow() == lineaInicial&&isValidMove(start, end, board) && board.getCell(start.getRow(), end.getCol()).getPiece().getColor() == tempColor);
    }
}
