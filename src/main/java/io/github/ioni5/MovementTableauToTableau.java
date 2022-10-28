package io.github.ioni5;

public class MovementTableauToTableau extends MovementOriginToTarget {

    public MovementTableauToTableau(Board board) {
        super(board, "De Columna a Columna.");
    }
    
    @Override
    public void execute() {
        origin = board.getTableau("De");
        target = board.getTableau("A");
        super.execute();
    }
    
}
