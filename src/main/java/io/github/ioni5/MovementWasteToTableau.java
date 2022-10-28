package io.github.ioni5;

public class MovementWasteToTableau extends MovementOriginToTarget {

    public MovementWasteToTableau(Board board) {
        super(board, "De Descarte a Columna.");
    }
    
    @Override
    public void execute() {
        origin = board.getWaste();
        target = board.getTableau("A");
        super.execute();
    }
    
}
