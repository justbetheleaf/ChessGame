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
        actualPos = board.getCell(actualPos.getRow(), actualPos.getCol());
        //Se capturan los movimientos superiores
        if(actualPos.getRow()+2 <8){
            if(actualPos.getCol()+1 < 8){
                this.movePath.add(board.getCell(actualPos.getRow()+2, actualPos.getCol()+1));
            }
            if(actualPos.getCol()-1>=0){
                this.movePath.add(board.getCell(actualPos.getRow()+2, actualPos.getCol()-1));
            }
        }
        //Se capturan los movimientos inferiores
        if(actualPos.getRow()-2 >=0){
            if(actualPos.getCol()+1 < 8){
                this.movePath.add(board.getCell(actualPos.getRow()-2, actualPos.getCol()+1));
            }
            if(actualPos.getCol()-1>=0){
                this.movePath.add(board.getCell(actualPos.getRow()-2, actualPos.getCol()-1));
            }
        }
        //Se capturan los movimientos derechos
        if(actualPos.getCol()+2 <8){
            if(actualPos.getRow()+1 < 8){
                this.movePath.add(board.getCell(actualPos.getRow()+1, actualPos.getCol()+2));
            }
            if(actualPos.getRow()-1>=0){
                this.movePath.add(board.getCell(actualPos.getRow()-1, actualPos.getCol()+2));
            }
        }
        //Se capturan los movimientos izquierdos
        if(actualPos.getRow()-2 >=0){
            if(actualPos.getRow()+1 < 8){
                this.movePath.add(board.getCell(actualPos.getRow()+1, actualPos.getCol()-2));
            }
            if(actualPos.getRow()-1>=0){
                this.movePath.add(board.getCell(actualPos.getRow()-1, actualPos.getCol()-2));
            }
        }
        return this.movePath;
    }
}
