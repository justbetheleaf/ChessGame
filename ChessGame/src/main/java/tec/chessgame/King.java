package tec.chessgame;

import java.util.List;

/**
 *
 * @author Dayron
 */
public class King extends Piece {
    public King(Color color) {
        super(color);
    }
    public Cell getCell() {
        Cell cell = null;
        return cell;
    }
    
    @Override
    public List<Cell> getMovePath(Cell actualPos, ChessBoard board){
        //capturar casilla derecha
        if (actualPos.getCol()+1 < 8)
            this.movePath.add(board.getCell(actualPos.getRow(),actualPos.getCol()+1));
        //capturar casilla izquierda
        if (actualPos.getCol()-1 >= 0)
            this.movePath.add(board.getCell(actualPos.getRow(),actualPos.getCol()-1));
        //capturar casilla superior
        if (actualPos.getRow()+1 < 8)
            this.movePath.add(board.getCell(actualPos.getRow()+1,actualPos.getCol()));
        //capturar casilla inferior
        if (actualPos.getRow()-1 >= 0)
            this.movePath.add(board.getCell(actualPos.getRow()-1,actualPos.getCol()));  
        //capturar casilla superior derecha
        if (actualPos.getCol()+1 < 8 && actualPos.getRow()+1 < 8)
            this.movePath.add(board.getCell(actualPos.getRow()+1,actualPos.getCol()+1));
        //capturar casilla superior izquierda
        if (actualPos.getCol()-1 >= 0 && actualPos.getRow()+1 < 8)
            this.movePath.add(board.getCell(actualPos.getRow()+1,actualPos.getCol()-1));
        //capturar casilla inferior derecha 
        if (actualPos.getCol()+1 < 8 && actualPos.getRow()-1 >= 0)
            this.movePath.add(board.getCell(actualPos.getRow()-1,actualPos.getCol()+1));
        //capturar casilla inferior izquierda
        if (actualPos.getCol()-1 >= 0 && actualPos.getRow()-1 >= 0)
            this.movePath.add(board.getCell(actualPos.getRow()-1,actualPos.getCol()-1));
        return this.movePath;
    }

}