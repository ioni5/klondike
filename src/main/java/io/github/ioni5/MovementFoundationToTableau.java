package io.github.ioni5;

public class MovementFoundationToTableau extends MovementOriginToTarget {

    public MovementFoundationToTableau(Board board) {
        super(board, "De Palo a Columna.");
    }

    @Override
    public void execute() {
        origin = board.getFoundation("De");
        target = board.getTableau("A");
        super.execute();
    }
}
