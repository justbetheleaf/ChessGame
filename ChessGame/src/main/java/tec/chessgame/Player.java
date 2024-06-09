package tec.chessgame;

public class Player {
    private String name;
    private final Color color;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public boolean makeMove(Cell start, Cell end) {
        return ChessGame.getInstance().makeMove(start, end);
    }
}
