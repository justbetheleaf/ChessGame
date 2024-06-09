package tec.chessgame;

import java.util.List;

/**
 *
 * @author Dayron
 */
public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }
    public Cell getCell() {
        Cell cell = null;
        return cell;
    }    
    
    @Override
    public List<Cell> getMovePath(Cell actualPos, ChessBoard board) {
        this.movePath.clear();
        Cell temp = new Cell(0, 0);
        //Capturar linea derecha
        for(int i = actualPos.getCol()+1; !temp.isOccupied() && i < 8; i++){
            temp = board.getCell(actualPos.getRow(),i);
            this.movePath.add(temp);
        }
        temp = new Cell(0, 0);
        //Capturar linea izquierda
        for(int i = actualPos.getCol()-1; !temp.isOccupied() && i >= 0; i--){
            temp = board.getCell(actualPos.getRow(), i);
            this.movePath.add(temp);
        }
        temp = new Cell(0, 0);
        //Capturar linea superior
        for(int i = actualPos.getRow()+1; !temp.isOccupied() && i < 8; i++){
            temp = board.getCell(i, actualPos.getCol());
            this.movePath.add(temp);
        }
        temp = new Cell(0, 0);
        //Capturar linea inferior
        for(int i = actualPos.getRow()-1; !temp.isOccupied() && i >= 0; i--){
            temp = board.getCell(i, actualPos.getCol());
            this.movePath.add(temp);
        }
        return this.movePath;
    }
}
