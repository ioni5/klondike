package io.github.ioni5;

public class MovementTableauToFoundation extends MovementOriginToTarget {

    public MovementTableauToFoundation(Board board) {
        super(board, "De Columna a Palo.");
    }
    
    @Override
    public void execute() {
        origin = board.getTableau("De");
        target = board.getFoundation("A");
        super.execute();
    }
    
}
