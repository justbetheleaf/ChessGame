package tec.chessgame;

import java.util.List;

/**
 *
 * @author Dayron
 */
public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
    }
    @Override
    public List<Cell> getMovePath(Cell actualPos, ChessBoard board){
        movePath.clear();
        Cell temp = new Cell(0, 0);
        //Capturar linea derecha
        for(int i = actualPos.getCol()+1; !temp.isOccupied() && i < 8; i++){
            temp = board.getCell(actualPos.getRow(),i);
            movePath.add(temp);
        }
        temp = new Cell(0, 0);
        //Capturar linea izquierda
        for(int i = actualPos.getCol()-1; !temp.isOccupied() && i >= 0; i--){
            temp = board.getCell(actualPos.getRow(), i);
            movePath.add(temp);
        }
        temp = new Cell(0, 0);
        //Capturar linea superior
        for(int i = actualPos.getRow()+1; !temp.isOccupied() && i < 8; i++){
            temp = board.getCell(i, actualPos.getCol());
            movePath.add(temp);
        }
        temp = new Cell(0, 0);
        //Capturar linea inferior
        for(int i = actualPos.getRow()-1; !temp.isOccupied() && i >= 0; i--){
            temp = board.getCell(i, actualPos.getCol());
            movePath.add(temp);
        }
        temp = new Cell(0, 0);
        //Capturar diagonal superior derecha
        for(int i = actualPos.getCol()+1, j = actualPos.getRow()+1; !temp.isOccupied() && i < 8 && j<8; i++, j++){
            temp = board.getCell(j, i);
            movePath.add(temp);
        }
        temp = new Cell(0, 0);
        //Capturar diagonal superior izquierda
        for(int i = actualPos.getCol()-1, j = actualPos.getRow()+1; !temp.isOccupied() && i >=0 && j<8; i--, j++){
            temp = board.getCell(j, i);
            movePath.add(temp);
        }
        temp = new Cell(0, 0);
        //Capturar diagonal inferior derecha
        for(int i = actualPos.getCol()+1, j = actualPos.getRow()-1; !temp.isOccupied() && i < 8 && j>=0; i++, j--){
            temp = board.getCell(j, i);
            movePath.add(temp);
        }
        temp = new Cell(0, 0);
        //Capturar diagonal inferior izquierda
        for(int i = actualPos.getCol()-1, j = actualPos.getRow()-1; !temp.isOccupied() && i >= 0 && j>=0; i--, j--){
            temp = board.getCell(j, i);
            movePath.add(temp);
        }
        return movePath;
    }
}
