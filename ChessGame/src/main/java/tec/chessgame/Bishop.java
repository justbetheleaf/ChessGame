package tec.chessgame;

import java.util.List;

/**
 *
 * @author Dayron
 */
public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }
    @Override
    public List<Cell> getMovePath(Cell actualPos, ChessBoard board){
        Cell temp = new Cell(0, 0);
        //Capturar diagonal superior derecha
        for(int i = actualPos.getCol()+1, j = actualPos.getRow()+1; !temp.isOccupied() && i < 8 && j<8; i++, j++){
            temp = board.getCell(j, i);
            this.movePath.add(temp);
        }
        temp = new Cell(0, 0);
        //Capturar diagonal superior izquierda
        for(int i = actualPos.getCol()-1, j = actualPos.getRow()+1; !temp.isOccupied() && i >=0 && j<8; i--, j++){
            temp = board.getCell(j, i);
            this.movePath.add(temp);
        }
        temp = new Cell(0, 0);
        //Capturar diagonal inferior derecha
        for(int i = actualPos.getCol()+1, j = actualPos.getRow()-1; !temp.isOccupied() && i < 8 && j>=0; i++, j--){
            temp = board.getCell(j, i);
            this.movePath.add(temp);
        }
        temp = new Cell(0, 0);
        //Capturar diagonal inferior izquierda
        for(int i = actualPos.getCol()-1, j = actualPos.getRow()-1; !temp.isOccupied() && i >= 0 && j>=0; i--, j--){
            temp = board.getCell(j, i);
            this.movePath.add(temp);
        }
        return this.movePath;
    }
}
